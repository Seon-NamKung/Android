package com.example.mskir.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {
    Button calFah, calCel;
    EditText fahrenheit, celsius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        init();
    }

    void init(){
        calCel = (Button)findViewById(R.id.calCel);
        calFah = (Button)findViewById(R.id.calFah);

        fahrenheit = (EditText)findViewById(R.id.fahrenheit);
        celsius = (EditText)findViewById(R.id.celsius);

        calFah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String c_temp = celsius.getText().toString();
                double result = Double.parseDouble(c_temp) * 1.8 + 32;
                String strNumber = String.format("%.2f", result);

                Toast toast = Toast.makeText(getApplicationContext(),"화씨 온도는 " + strNumber +" 입니다.",Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        calCel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String f_temp = fahrenheit.getText().toString();
                double result = (Double.parseDouble(f_temp)-32)/1.8;
                String strNumber = String.format("%.2f", result);

                Toast toast = Toast.makeText(getApplicationContext(),"섭씨 온도는 " + strNumber +" 입니다.",Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }
}
