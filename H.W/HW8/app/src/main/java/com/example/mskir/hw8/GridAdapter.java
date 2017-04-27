package com.example.mskir.hw8;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by mskir on 2017-04-27.
 */

public class GridAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Fruit> fruit;
   private boolean isVisible = true;

    public GridAdapter(ArrayList<Fruit> fruit,Context context){
        this.fruit = fruit;
        this.context = context;
    }

    @Override
    public int getCount() {
        return fruit.size();
    }

    @Override
    public Fruit getItem(int position) {
        return fruit.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = new GridItem(context);

        ((GridItem)convertView).setData(fruit.get(position));
        if(isVisible)
            ((GridItem) convertView).setVisible();
        else
            ((GridItem) convertView).setInvisible();

        return convertView;
    }

    public void addFruit(Fruit fruit){
        this.fruit.add(fruit);
    }
    public void refresh(){
        notifyDataSetChanged();
    }

    public void setVisible(Boolean visibility){
        if(visibility)
            isVisible = false;
        else
            isVisible = true;
    }

    public void editFruit(String name, int imageno, String price, int position){
        Fruit temp = new Fruit(name,imageno,price);
        this.fruit.set(position,temp);
    }
}
