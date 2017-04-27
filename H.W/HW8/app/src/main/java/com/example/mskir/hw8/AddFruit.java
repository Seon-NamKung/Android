package com.example.mskir.hw8;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by mskir on 2017-04-27.
 */

public class AddFruit extends LinearLayout implements View.OnClickListener {
    int imageno = 0;
    AutoCompleteTextView et;
    EditText f_price;
    ImageView img;
    Button b_next,b_add,b_modify;
    String fruitlist[] = {"Abocado","Banana","Orage","Kiwi","Cherry","Cranverry"};
    int imglist[] = {R.drawable.abocado,R.drawable.banana,R.drawable.orange,R.drawable.kiwi,R.drawable.cherry,R.drawable.cranberry,R.drawable.grape,R.drawable.watermelon};

    public AddFruit(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    void init(Context context){
        LayoutInflater.from(context).inflate(R.layout.fruit_add,this);
        et = (AutoCompleteTextView)findViewById(R.id.f_name);
        f_price = (EditText)findViewById(R.id.f_price);
        img = (ImageView)findViewById(R.id.image);
        b_next = (Button)findViewById(R.id.b_next);
        b_add = (Button)findViewById(R.id.b_add);
        b_modify = (Button)findViewById(R.id.b_modify);
        b_next.setOnClickListener(this);
        b_add.setOnClickListener(this);
        b_modify.setOnClickListener(this);

        et.setAdapter(new ArrayAdapter<String>(context,
                android.R.layout.simple_dropdown_item_1line, fruitlist));


    }

    @Override
    public void onClick(View v) {
       if(v == b_next){
           if(imageno >= 7)
               imageno = 0;
           else
               imageno++;
           img.setImageResource(imglist[imageno]);
       }
       else if(v == b_modify){
           onAddListener.onEdit(et.getText().toString(),imglist[imageno],f_price.getText().toString());
           et.setText(null);
           f_price.setText(null);
       }
       else{
           onAddListener.onAdd(et.getText().toString(),imglist[imageno],f_price.getText().toString());
           et.setText(null);
           f_price.setText(null);
       }
    }

    interface OnAddListener{
        void onAdd(String name, int imageno, String price);
        void onEdit(String name, int imageno, String price);
    }
    public OnAddListener onAddListener;

    public void setOnAddListener(OnAddListener onAddListener){
        this.onAddListener = onAddListener;
    }

    public void buttonChange(Boolean which) {
        if (which) {
            b_add.setVisibility(VISIBLE);
            b_modify.setVisibility(GONE);
        } else {
            b_add.setVisibility(GONE);
            b_modify.setVisibility(VISIBLE);
        }
    }

    public void setEditFruit(Fruit fruit){
        et.setText(fruit.name);
        img.setImageResource(fruit.image);
        f_price.setText(fruit.price);
    }
}
