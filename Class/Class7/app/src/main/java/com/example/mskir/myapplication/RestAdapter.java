package com.example.mskir.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by mskir on 2017-04-13.
 */

public class RestAdapter extends BaseAdapter {
    ArrayList<RestInfo> data = new ArrayList<RestInfo>();
    Context context;

    public RestAdapter(Context context, ArrayList<RestInfo> arr){
        this.context = context;
        this.data = arr;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item,null);
            viewHolder.title = (TextView)convertView.findViewById(R.id.tvname);
            viewHolder.tel = (TextView)convertView.findViewById(R.id.call);
            convertView.setTag(viewHolder);
        }else viewHolder = (ViewHolder)convertView.getTag();


        RestInfo one = data.get(position);
        viewHolder.title.setText(one.getName());
        viewHolder.tel.setText(one.getTel());

        return convertView;
    }

    Comparator<RestInfo> nameAsc = new Comparator<RestInfo>() {
        @Override
        public int compare(RestInfo o1, RestInfo o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };
    final  static int NAME_ASC = 0;
    final static  int NAME_DESC = 1;
    public void setSort(int x){
        if(x == NAME_ASC) {
            Collections.sort(data, nameAsc);
            this.notifyDataSetChanged();
        }
    }

    class ViewHolder{
        TextView title;
        TextView tel;
        TextView imgno;
    }
}
