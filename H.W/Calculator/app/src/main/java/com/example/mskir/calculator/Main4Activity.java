package com.example.mskir.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
    EditText birth,age;
    Button calBirth, calAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        init();
    }

    void init(){
        calAge = (Button)findViewById(R.id.calAge);
        calBirth = (Button)findViewById(R.id.calBirth);
        birth = (EditText)findViewById(R.id.birth);
        age = (EditText)findViewById(R.id.age);

        calAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String birth_year = birth.getText().toString();
                int result = 2018 - Integer.parseInt(birth_year);

                Toast toast = Toast.makeText(getApplicationContext(),"Age is " + result,Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        calBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String current_age = age.getText().toString();
                int result = 2018 - Integer.parseInt(current_age);

                Toast toast = Toast.makeText(getApplicationContext(),"Birth year is " + result,Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
