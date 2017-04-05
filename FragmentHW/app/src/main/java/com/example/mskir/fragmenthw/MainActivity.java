package com.example.mskir.fragmenthw;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity implements FragmentA.CustomOnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public void onClicked(int id) {


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentB fragmentB = (FragmentB)fragmentManager.findFragmentById(R.id.fragment_b);

        fragmentB.setTableName(apple.getName());

    }
}
