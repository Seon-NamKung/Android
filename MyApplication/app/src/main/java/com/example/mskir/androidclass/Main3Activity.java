package com.example.mskir.androidclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    Button b1,b2;
    EditText t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("나이 계산기");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
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
                String birth_year = t1.getText().toString();
                int result = 2018 - Integer.parseInt(birth_year);

                Toast toast = Toast.makeText(getApplicationContext(),"Age is " + result,Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String age = t2.getText().toString();
                int result = 2018 - Integer.parseInt(age);

                Toast toast = Toast.makeText(getApplicationContext(),"Birth year is " + result,Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
