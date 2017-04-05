package com.example.mskir.fragmenttask;

import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.zip.Inflater;

import static com.example.mskir.fragmenttask.R.id.noHave;
import static com.example.mskir.fragmenttask.R.id.numOfSpa;

/**
 * Created by mskir on 2017-04-06.
 */
public class FragmentA extends Fragment{
    ArrayList<String> lists = new ArrayList<String>();
    Button newOrder,editInfo,reset;
    ListView listView;
    TextView tableName,entranceTime,l_spagetti,l_pizza,l_membership,price;
    Information apple,grape,kiwi,grapefruit;
    EditText numofspa,numofpizza;
    int whichTable;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        startTable();
        setTable();
        View view = inflater.inflate(R.layout.fragment_a,container,false);

        init(view);
        final ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,lists);
        listView = (ListView)view.findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        setLists(apple);
                        if(apple.getCost() == 0)
                            Toast.makeText(getActivity(),"비어있는 테이블 입니다.",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        setLists(grape);
                        if(grape.getCost() == 0)
                            Toast.makeText(getActivity(),"비어있는 테이블 입니다.",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        setLists(kiwi);
                        if(kiwi.getCost() == 0)
                            Toast.makeText(getActivity(),"비어있는 테이블 입니다.",Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        setLists(grapefruit);
                        if(grapefruit.getCost() == 0)
                            Toast.makeText(getActivity(),"비어있는 테이블 입니다.",Toast.LENGTH_SHORT).show();
                        break;
                    default:{
                        break;
                    }
                }
                whichTable = position;
            }
        });

        newOrder.setOnClickListener(new View.OnClickListener() {
            int spa,piz,membership;
            @Override
            public void onClick(final View v) {
                View dlgview = View.inflate(getActivity(), R.layout.box, null);
                numofpizza = (EditText) dlgview.findViewById(R.id.numOfPizza);
                numofspa = (EditText) dlgview.findViewById(R.id.numOfSpa);
                final RadioButton noHave = (RadioButton) dlgview.findViewById(R.id.noHave);
                final RadioButton normal = (RadioButton) dlgview.findViewById(R.id.normal);
                final RadioButton vip = (RadioButton) dlgview.findViewById(R.id.vip);

                AlertDialog.Builder dlg = new AlertDialog.Builder(getActivity());

                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(whichTable<4 && 0<= whichTable){
                        Snackbar.make(v, "정보가 입력되었습니다.", Snackbar.LENGTH_SHORT)
                                .setAction("OK", null).show();
                        spa = Integer.parseInt(numofspa.getText().toString());
                        piz = Integer.parseInt(numofpizza.getText().toString());

                        if(noHave.isChecked())
                            membership = 0;
                        else if(normal.isChecked())
                            membership = 1;
                        else if(vip.isChecked())
                            membership = 2;

                        SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                        String time = sdfNow.format(new Date(System.currentTimeMillis()));

                        switch (whichTable){
                            case 0:
                                apple.setSpagetti(spa);
                                apple.setPizza(piz);
                                apple.setMembership(membership);
                                apple.setTime(time);
                                setLists(apple);
                                useLists(0);
                                break;
                            case 1:
                                grape.setSpagetti(spa);
                                grape.setPizza(piz);
                                grape.setMembership(membership);
                                grape.setTime(time);
                                setLists(grape);
                                useLists(1);
                                break;
                            case 2:
                                kiwi.setSpagetti(spa);
                                kiwi.setPizza(piz);
                                kiwi.setMembership(membership);
                                kiwi.setTime(time);
                                setLists(kiwi);
                                useLists(2);
                                break;
                            case 3:
                                grapefruit.setSpagetti(spa);
                                grapefruit.setPizza(piz);
                                grapefruit.setMembership(membership);
                                grapefruit.setTime(time);
                                setLists(grapefruit);
                                useLists(3);
                                break;
                        }
                        }else{
                            Snackbar.make(v, "테이블을 선택하세요.", Snackbar.LENGTH_SHORT)
                                    .setAction("OK", null).show();
                        }
                    }
                });
                dlg.setNegativeButton("취소",null);
                dlg.setTitle("새 주문");
                dlg.setView(dlgview);
                dlg.show();

            }
        });

        editInfo.setOnClickListener(new View.OnClickListener() {
            int spa,piz,membership;
            @Override
            public void onClick(final View v) {
                View dlgview = View.inflate(getActivity(), R.layout.box, null);
                numofpizza = (EditText) dlgview.findViewById(R.id.numOfPizza);
                numofspa = (EditText) dlgview.findViewById(R.id.numOfSpa);
                final RadioButton noHave = (RadioButton) dlgview.findViewById(R.id.noHave);
                final RadioButton normal = (RadioButton) dlgview.findViewById(R.id.normal);
                final RadioButton vip = (RadioButton) dlgview.findViewById(R.id.vip);

                AlertDialog.Builder dlg = new AlertDialog.Builder(getActivity());

                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(whichTable<4 && 0<= whichTable){
                            Snackbar.make(v, "정보가 수정되었습니다.", Snackbar.LENGTH_SHORT)
                                    .setAction("OK", null).show();
                            spa = Integer.parseInt(numofspa.getText().toString());
                            piz = Integer.parseInt(numofpizza.getText().toString());

                            if(noHave.isChecked())
                                membership = 0;
                            else if(normal.isChecked())
                                membership = 1;
                            else if(vip.isChecked())
                                membership = 2;

                            switch (whichTable){
                                case 0:
                                    apple.setSpagetti(spa);
                                    apple.setPizza(piz);
                                    apple.setMembership(membership);
                                    setLists(apple);
                                    useLists(0);
                                    break;
                                case 1:
                                    grape.setSpagetti(spa);
                                    grape.setPizza(piz);
                                    grape.setMembership(membership);
                                    setLists(grape);
                                    useLists(1);
                                    break;
                                case 2:
                                    kiwi.setSpagetti(spa);
                                    kiwi.setPizza(piz);
                                    kiwi.setMembership(membership);
                                    setLists(kiwi);
                                    useLists(2);
                                    break;
                                case 3:
                                    grapefruit.setSpagetti(spa);
                                    grapefruit.setPizza(piz);
                                    grapefruit.setMembership(membership);
                                    setLists(grapefruit);
                                    useLists(3);
                                    break;
                            }
                        }else{
                            Snackbar.make(v, "테이블을 선택하세요.", Snackbar.LENGTH_SHORT)
                                    .setAction("OK", null).show();
                        }
                    }
                });
                dlg.setNegativeButton("취소",null);
                dlg.setTitle("정보 수정");
                dlg.setView(dlgview);
                dlg.show();

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (whichTable){
                    case 0:
                        clear(apple,whichTable);
                        setLists(apple);
                        break;
                    case 1:
                        clear(grape,whichTable);
                        setLists(grape);
                        break;
                    case 2:
                        clear(kiwi,whichTable);
                        setLists(kiwi);
                        break;
                    case 3:
                        clear(grapefruit,whichTable);
                        setLists(grapefruit);
                        break;

                }
                adapter.notifyDataSetChanged();
            }
        });


        return view;
    }

    void setLists(Information info){
        tableName.setText(info.getName());
        entranceTime.setText(info.getTime());
        l_spagetti.setText(Integer.toString(info.getSpagetti()));
        l_pizza.setText(Integer.toString(info.getPizza()));
        l_membership.setText(info.getMembership());
        price.setText(Integer.toString(info.getCost()));
    }

    void init(View view){
        newOrder = (Button)view.findViewById(R.id.newOrder);
        editInfo = (Button)view.findViewById(R.id.editInfo);
        reset = (Button)view.findViewById(R.id.reset);
        tableName = (TextView)view.findViewById(R.id.tableName);
        entranceTime = (TextView)view.findViewById(R.id.entranceTime);
        l_spagetti = (TextView)view.findViewById(R.id.l_spagetti);
        l_pizza = (TextView)view.findViewById(R.id.l_pizza);
        l_membership = (TextView)view.findViewById(R.id.l_membership);
        price = (TextView)view.findViewById(R.id.price);
    }

    void clear(Information info,int which){
        clearLists(which);
        info.setTime(null);
        info.setSpagetti(0);
        info.setPizza(0);
        info.setMembership(0);
    }

    void startTable(){
        lists.add("사과 Table(비어있음)");
        lists.add("포도 Table(비어있음)");
        lists.add("키위 Table(비어있음)");
        lists.add("자몽 Table(비어있음)");
    }

    void setTable(){
        apple = new Information("사과 테이블",null,0,0,0);
        grape = new Information("포도 테이블",null,0,0,0);
        kiwi = new Information("키위 테이블",null,0,0,0);
        grapefruit = new Information("자몽 테이블",null,0,0,0);
    }

    void clearLists(int position){
        switch (position){
            case 0:
                lists.set(0,"사과 Table(비어있음)");
                break;
            case 1:
                lists.set(1,"포도 Table(비어있음)");
                break;
            case 2:
                lists.set(2,"키위 Table(비어있음)");
                break;
            case 3:
                lists.set(2,"자몽 Table(비어있음)");
                break;
        }
    }

    void useLists(int position){
        switch (position){
            case 0:
                lists.set(position,"사과 Table");
                break;
            case 1:
                lists.set(position,"포도 Table");
                break;
            case 2:
                lists.set(position,"키위 Table");
                break;
            case 3:
                lists.set(position,"자몽 Table");
                break;
        }
    }
}
