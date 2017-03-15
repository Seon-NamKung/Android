package com.example.mskir.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main6Activity extends AppCompatActivity {
    EditText number1,number2;
    Button add,substract,multiply,divide;
    int whichButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        init();
    }

    void init(){
        add = (Button) findViewById(R.id.add);
        substract = (Button) findViewById(R.id.substract);
        multiply = (Button) findViewById(R.id.multiply);
        divide = (Button) findViewById(R.id.divide);
        number1 = (EditText) findViewById(R.id.number1);
        number2 = (EditText) findViewById(R.id.number2);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whichButton = 1;
                String num_1;
                String num_2;
                num_1 = number1.getText().toString();
                num_2 = number2.getText().toString();
                calculator(num_1,num_2);
            }
        });

        substract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whichButton = 2;
                String num_1;
                String num_2;
                num_1 = number1.getText().toString();
                num_2 = number2.getText().toString();
                calculator(num_1,num_2);
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whichButton = 3;
                String num_1;
                String num_2;
                num_1 = number1.getText().toString();
                num_2 = number2.getText().toString();
                calculator(num_1,num_2);
            }
        });
        divide.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whichButton = 4;
                String num_1;
                String num_2;
                num_1 = number1.getText().toString();
                num_2 = number2.getText().toString();
                calculator(num_1,num_2);
            }
        }));

    }

    int calculator(String num_1, String num_2) {  // Calculator Method
        if (!num_2.equals("") && !num_1.equals("")) {
            int result;
            double d_result;

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
                        d_result = Double.parseDouble(num_1) / Double.parseDouble(num_2); // calculare by double
                        result = (int)d_result;
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
