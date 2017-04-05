package com.example.mskir.fragmenthw;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by mskir on 2017-04-05.
 */

public class FragmentA extends Fragment {
    static String[] LIST_TABLE = {"사과","포도","키위","자몽"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_a,null);
        ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,LIST_TABLE);

        ListView listView = (ListView)view.findViewById(R.id.listView);
        listView.setAdapter(adapter);

        return view;
    }
}
