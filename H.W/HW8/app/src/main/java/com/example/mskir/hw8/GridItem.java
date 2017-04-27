package com.example.mskir.hw8;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by mskir on 2017-04-27.
 */

public class GridItem extends LinearLayout{
    TextView tvprice;
    TextView tvname;
    ImageView img;

    public GridItem(Context context) {
        super(context);
        init(context);
    }


    public void init(Context context){
        View view = LayoutInflater.from(context).inflate(R.layout.item,this);
        tvname = (TextView)view.findViewById(R.id.tvname);
        tvprice = (TextView)view.findViewById(R.id.tvprice);
        img = (ImageView)view.findViewById(R.id.img);
    }

    public void setData(Fruit fruit){
        tvname.setText(fruit.name);
        tvprice.setText(fruit.price);
        img.setImageResource(fruit.image);
    }

    public void setInvisible(){
        tvprice.setVisibility(INVISIBLE);
    }

    public void setVisible(){
        tvprice.setVisibility(VISIBLE);
    }
}
