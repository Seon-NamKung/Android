package com.example.mskir.fragmenthw;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;

import java.util.ArrayList;

/**
 * Created by mskir on 2017-04-05.
 */

public class FragmentA extends Fragment {
    ArrayList<String> lists = new ArrayList<String>();
    ListView listView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       startTable();
        View view = inflater.inflate(R.layout.fragment_a,container,false);



        final ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,lists);
        listView = (ListView)view.findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                customOnClickListener.onClicked(position);
            }
        });
        return view;
    }


    public interface CustomOnClickListener{
        public void onClicked(int id);
    }

    private CustomOnClickListener customOnClickListener;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        customOnClickListener = (CustomOnClickListener) context;
    }

    void setLists(int position){
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

    void clearLists(int position){
        switch (position){
            case 0:
                lists.set(position,"사과 Table(비어있음)");
                break;
            case 1:
                lists.set(position,"포도 Table(비어있음)");
                break;
            case 2:
                lists.set(position,"키위 Table(비어있음)");
                break;
            case 3:
                lists.set(position,"자몽 Table(비어있음)");
                break;
        }
    }

    void startTable(){
        lists.add("사과 Table(비어있음)");
        lists.add("포도 Table(비어있음)");
        lists.add("키위 Table(비어있음)");
        lists.add("자몽 Table(비어있음)");
    }

}
