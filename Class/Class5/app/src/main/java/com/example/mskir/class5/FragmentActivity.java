package com.example.mskir.class5;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FragmentActivity extends AppCompatActivity {
    private boolean isexmaple2 = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        ExampleFragment exampleFragment = new ExampleFragment();
        FragmentManager fm = getSupportFragmentManager(); // 주의!!!!!! 에러날경우 getFragmentManager() -> getSupportFragmentMager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.framelayout,new ExampleFragment2());
        fragmentTransaction.commit();

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment();
            }
        });

        ExampleFragment fragment = (ExampleFragment)getSupportFragmentManager().findFragmentById(R.id.fragment1);

    }

    public void switchFragment(){
        Fragment fr;

        if(isexmaple2){
            fr = new ExampleFragment2();
        }else{
            fr = new ExampleFragment();
        }

        isexmaple2 = (isexmaple2) ? false : true;

        FragmentManager fx = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fx.beginTransaction();
        fragmentTransaction.add(R.id.framelayout,fr);
        fragmentTransaction.commit();
    }
}
