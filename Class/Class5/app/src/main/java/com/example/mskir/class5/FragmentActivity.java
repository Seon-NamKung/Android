package com.example.mskir.class5;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FragmentActivity extends AppCompatActivity {
    private boolean exmaple2 = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        ExampleFragment exampleFragment = new ExampleFragment();
        FragmentManager fm = getSupportFragmentManager(); // 주의!!!!!! 에러날경우 getFragmentManager() -> getSupportFragmentMager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.framelayout,new ExampleFragment2());
        fragmentTransaction.commit();

    }

}
