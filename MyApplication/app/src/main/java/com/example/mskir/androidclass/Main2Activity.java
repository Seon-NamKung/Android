package com.example.mskir.androidclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Button b1;
    EditText t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("과일 금액 계산기");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
    }

    void init(){
        b1 = (Button)findViewById(R.id.button);
        t1 = (EditText)findViewById(R.id.editText1);
        t2 = (EditText)findViewById(R.id.editText2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price = t1.getText().toString();
                String number = t2.getText().toString();
                int result = Integer.parseInt(price) * Integer.parseInt(number);

                Toast toast = Toast.makeText(getApplicationContext(),"Total Price is "  + result + " won",Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

}
