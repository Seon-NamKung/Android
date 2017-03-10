package com.example.mskir.androidclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main6Activity extends AppCompatActivity {
    Button b1, b2, b3, b4;
    EditText e1, e2;
    int whichButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("계산기");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        init();
    }

    void init() {
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        e1 = (EditText) findViewById(R.id.editText1);
        e2 = (EditText) findViewById(R.id.editText2);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whichButton = 1;
                String num_1;
                String num_2;
                num_1 = e1.getText().toString();
                num_2 = e2.getText().toString();
                calculator(num_1,num_2);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whichButton = 2;
                String num_1;
                String num_2;
                num_1 = e1.getText().toString();
                num_2 = e2.getText().toString();
                calculator(num_1,num_2);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whichButton = 3;
                String num_1;
                String num_2;
                num_1 = e1.getText().toString();
                num_2 = e2.getText().toString();
                calculator(num_1,num_2);
            }
        });
        b4.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whichButton = 4;
                String num_1;
                String num_2;
                num_1 = e1.getText().toString();
                num_2 = e2.getText().toString();
                calculator(num_1,num_2);
            }
        }));

    }

    int calculator(String num_1, String num_2) {
        if (!num_2.equals("") && !num_1.equals("")) {
            int result;

            switch (whichButton) {
                case 1:
                    result = Integer.parseInt(num_1) + Integer.parseInt(num_2);
                    break;
                case 2:
                    result = Integer.parseInt(num_1) - Integer.parseInt(num_2);
                    break;
                case 3:
                    result = Integer.parseInt(num_1) * Integer.parseInt(num_2);
                    break;
                case 4:
                    if (Integer.parseInt(num_2) != 0) {
                        result = Integer.parseInt(num_1) / Integer.parseInt(num_2);
                        break;
                    }
                    else{
                        return -1;
                    }
                default:
                    result = -1;
            }
            Toast toast = Toast.makeText(getApplicationContext(), "결과 : " + result, Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "값을 입력하세요.", Toast.LENGTH_SHORT);
            toast.show();
        }
        whichButton = 0;
        return 1;
    }
}
