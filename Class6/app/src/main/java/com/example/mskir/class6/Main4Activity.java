package com.example.mskir.class6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {

    ArrayList<String> data = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    EditText et1;
    Button bt1;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        setListView();
    }

    public void onClick(View v){
        data.add(et1.getText().toString());
        adapter.notifyDataSetChanged();
    }

    public void setListView(){
        et1 = (EditText)findViewById(R.id.et1);
        listView = (ListView)findViewById(R.id.listview);

        data.add("사과");
        data.add("포도");
        data.add("복숭아");

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                data.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
