package com.example.mskir.androidclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
    Button b1,b2;
    EditText t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        init();
    }

    void init(){
        b1 = (Button)findViewById(R.id.button1);
        b2 = (Button)findViewById(R.id.button2);
        t1 = (EditText)findViewById(R.id.editText1);
        t2 = (EditText)findViewById(R.id.editText2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String c_temp = t1.getText().toString();
                double result = Integer.parseInt(c_temp) * 1.8 + 32;

                Toast toast = Toast.makeText(getApplicationContext(),"화씨 온도는 " + result +" 입니다.",Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String f_temp = t2.getText().toString();
                double result = (Integer.parseInt(f_temp)-32)/1.8;

                Toast toast = Toast.makeText(getApplicationContext(),"섭씨 온도는 " + result +" 입니다.",Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
