package com.example.mskir.fragmenthw;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by mskir on 2017-04-05.
 */

public class FragmentB extends Fragment {

    TextView tableName,entranceTime,l_spagetti,l_pizza,l_membership,price;
    Button newOrder,editInfo,reset;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        start();
        View view = inflater.inflate(R.layout.fragment_b,container,false);
        tableName = (TextView)view.findViewById(R.id.tableName);
        entranceTime = (TextView)view.findViewById(R.id.entranceTime);
        l_spagetti = (TextView)view.findViewById(R.id.l_spagetti);
        l_pizza = (TextView)view.findViewById(R.id.l_pizza);
        l_membership = (TextView)view.findViewById(R.id.l_membership);
        price = (TextView)view.findViewById(R.id.price);

        newOrder = (Button)view.findViewById(R.id.newOrder);
        editInfo = (Button)view.findViewById(R.id.editInfo);
        reset = (Button)view.findViewById(R.id.reset);

//        newOrder.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(final View v) {
//                final String[] data = {"없음","기본","VIP"}; //final 로 해야지 접근가능
//                final String[] whichItem = {null};
//                View dlgview = View.inflate(getContext(),R.layout.box,null);
//                AlertDialog.Builder dlg = new AlertDialog.Builder(getContext());
//
//                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Snackbar.make(v,"SnackBar로 보여주는 메세지 입니다.",Snackbar.LENGTH_SHORT)
//                                .setAction("OK", null).show();
//                    }
//                });
//                dlg.setTitle("새 주문");
//                dlg.setView(dlgview);
//                dlg.show();
//            }
//        });

        return view;
    }

    void setTableName(String string){
        this.tableName.setText(string);
    }

    void setEntranceTime(String string){
        this.entranceTime.setText((string));
    }

    void setL_spagetti(int x){
        l_spagetti.setText(Integer.toString(x));
    }

    void setL_pizza(int x){
        l_pizza.setText(Integer.toString(x));
    }

    void setL_membership(int x){
        l_membership.setText(Integer.toString(x));
    }

    void setPrice()

    public void setText(Information info){
        tableName.setText(info.getName());
        entranceTime.setText(info.getTime());



        price.setText(Integer.toString(info.getCost()));
    }

    public void setTable(int id) {
        if (id == 0) {
            tableName.setText(apple.getName());
            entranceTime.setText(apple.getTime());
            l_spagetti.setText(Integer.toString(apple.getSpagetti()));
            l_pizza.setText(Integer.toString(apple.getPizza()));
            l_membership.setText(Integer.toString(apple.getMembership()));
            price.setText(Integer.toString(apple.getCost()));
        } else if (id == 1) {
            tableName.setText(grape.getName());
            entranceTime.setText(grape.getTime());
            l_spagetti.setText(Integer.toString(grape.getSpagetti()));
            l_pizza.setText(Integer.toString(grape.getPizza()));
            l_membership.setText(Integer.toString(grape.getMembership()));
            price.setText(Integer.toString(grape.getCost()));
        } else if (id == 2) {
            tableName.setText(kiwi.getName());
            entranceTime.setText(kiwi.getTime());
            l_spagetti.setText(Integer.toString(kiwi.getSpagetti()));
            l_pizza.setText(Integer.toString(kiwi.getPizza()));
            l_membership.setText(Integer.toString(kiwi.getMembership()));
            price.setText(Integer.toString(kiwi.getCost()));
        }else{
            tableName.setText(grapefruit.getName());
            entranceTime.setText(grapefruit.getTime());
            l_spagetti.setText(Integer.toString(grapefruit.getSpagetti()));
            l_pizza.setText(Integer.toString(grapefruit.getPizza()));
            l_membership.setText(Integer.toString(grapefruit.getMembership()));
            price.setText(Integer.toString(grapefruit.getCost()));
        }
    }
}
