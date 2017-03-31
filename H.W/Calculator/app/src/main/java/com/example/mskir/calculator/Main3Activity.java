package com.example.mskir.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    EditText pizza,pasta,salad;
    CheckBox membership;
    Button button;
    TextView price,number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        init();
    }

    void init(){
        pizza = (EditText)findViewById(R.id.pizza);
        pasta = (EditText)findViewById(R.id.pasta);
        salad = (EditText)findViewById(R.id.salad);

        membership = (CheckBox)findViewById(R.id.membership);

        button = (Button)findViewById(R.id.button);

        price = (TextView)findViewById(R.id.price);
        number = (TextView)findViewById(R.id.number);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int totalNumber;
                int result;
                double temp;

                Boolean is = membership.isChecked();

                String pizzaString = pizza.getText().toString();
                String pastaString = pasta.getText().toString();
                String saladString = salad.getText().toString();

                if(is){ //have membership
                    result = 15000*Integer.parseInt(pizzaString) + 13000*Integer.parseInt(pastaString) + 9000*Integer.parseInt(saladString);
                    temp = result * 0.9;
                    result = (int)temp;
                    totalNumber = Integer.parseInt(pizzaString) + Integer.parseInt(pastaString) + Integer.parseInt(saladString);


                }
                else{ // Don't have membership
                    result = 15000*Integer.parseInt(pizzaString) + 13000*Integer.parseInt(pastaString) + 9000*Integer.parseInt(saladString);
                    totalNumber = Integer.parseInt(pizzaString) + Integer.parseInt(pastaString) + Integer.parseInt(saladString);
                }

                price.setText(Integer.toString(result));
                number.setText(Integer.toString(totalNumber));
            }
        });
    }
}
