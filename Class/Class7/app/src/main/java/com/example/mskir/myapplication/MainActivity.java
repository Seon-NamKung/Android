package com.example.mskir.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    ArrayList<String> data = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    Button button;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView)findViewById(R.id.listView);
        editText = (EditText)findViewById(R.id.editText);

        data.add("apple");
        data.add("bread");
        data.add("cat");
        data.add("apolo");
        data.add("bag");
        data.add("carrot");
        data.add("apartment");
        data.add("bed");
        data.add("coat");
        data.add("aaaaa");
        data.add("boom");
        data.add("cook");
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,data);

        listview.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listview.setAdapter(adapter);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String search = s.toString();
                if(search.length()>0) {
                    listview.setFilterText(search);
                }else{
                    listview.clearTextFilter();
                }

            }
        });


    }

    public void onClick(View v){
        if(v.getId() == R.id.sort){
            Collections.sort(data,nameAsc);
            adapter.notifyDataSetChanged();
        }else {
            data.add(editText.getText().toString());
            adapter.notifyDataSetChanged();
        }
    }
    Comparator<String> nameAsc = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o2.compareTo(o1);
        }
    };

}