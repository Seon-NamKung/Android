package com.example.mskir.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.ColorUtils;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

/**
 * Created by mskir on 2017-04-04.
 */

public class FragmentA extends Fragment {

    Button button;

    public interface CustomOnClickListener{
        public void onClicked(View v);
    }

    private CustomOnClickListener customOnClickListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a,container,false);

        button = (Button)view.findViewById(R.id.textchange);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(v);
            }
        });

        return view;
    }

    public void buttonClicked(View v){
        customOnClickListener.onClicked(v);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        customOnClickListener = (CustomOnClickListener)context;
    }
}
