package com.example.mskir.hw8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    GridView gridview;
    GridAdapter gridAdapter;
    ArrayList<Fruit> fruit = new ArrayList<Fruit>();
    int imglist[] = {R.drawable.abocado,R.drawable.banana,R.drawable.orange,R.drawable.kiwi,R.drawable.cherry,R.drawable.cranberry};
    AddFruit addFruit;
    CheckBox showPrice;
    int positional = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridview = (GridView)findViewById(R.id.gridview);
        showPrice = (CheckBox)findViewById(R.id.showPrice);

        fruit.add(new Fruit("Abocado",imglist[0],"10000"));
        fruit.add(new Fruit("Banana",imglist[1],"5000"));
        fruit.add(new Fruit("Orage",imglist[2],"4000"));
        fruit.add(new Fruit("Kiwi",imglist[3],"8000"));
        fruit.add(new Fruit("Cherry",imglist[4],"2000"));
        fruit.add(new Fruit("Cranberry",imglist[5],"6000"));

        gridAdapter = new GridAdapter(fruit,this);
        gridview.setAdapter(gridAdapter);

        addFruit = (AddFruit)findViewById(R.id.add);
        addFruit.setOnAddListener(new AddFruit.OnAddListener() {
            @Override
            public void onAdd(String name, int imageno, String price) {
                Toast.makeText(getApplicationContext(),name + ","+ imageno + "," + price,Toast.LENGTH_SHORT).show();
                gridAdapter.addFruit(new Fruit(name,imageno,price));
                gridAdapter.refresh();
            }

            @Override
            public void onEdit(String name, int imageno, String price) {
                gridAdapter.editFruit(name,imageno,price,positional);
                gridAdapter.refresh();
                addFruit.buttonChange(true);
            }
        });

        showPrice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                gridAdapter.setVisible(isChecked);
                gridAdapter.refresh();
            }
        });

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                positional = position;
                addFruit.buttonChange(false);
                addFruit.setEditFruit((gridAdapter.getItem(position)));
            }
        });

    }
}
