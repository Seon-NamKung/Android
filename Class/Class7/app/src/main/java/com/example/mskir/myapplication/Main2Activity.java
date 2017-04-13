package com.example.mskir.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    ArrayList<RestInfo> data = new ArrayList<RestInfo>();
    ListView listView;
    RestAdapter restAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        data.add(new RestInfo("BBQ","01011112222",0));
        data.add(new RestInfo("KC","01044442222",1));
        data.add(new RestInfo("BHC","01033332222",2));

        restAdapter = new RestAdapter(this,data);
        listView = (ListView)findViewById(R.id.list1);
        listView.setAdapter(restAdapter);
    }

    public void onClick(View v){
        if(v.getId() == R.id.b1){
            restAdapter.setSort(RestAdapter.NAME_ASC);
        }
    }
}
