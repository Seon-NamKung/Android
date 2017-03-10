package com.example.mskir.androidclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Main5Activity extends AppCompatActivity {
    EditText t1,t2,t3;
    CheckBox c1;
    Button b1;
    TextView v1,v2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("레스토랑 메뉴 주문");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        init();
    }

    void init(){
        b1 = (Button)findViewById(R.id.button);
        t1 = (EditText)findViewById(R.id.editText1);
        t2 = (EditText)findViewById(R.id.editText2);
        t3 = (EditText)findViewById(R.id.editText3);
        c1 = (CheckBox)findViewById(R.id.checkBox1);
        v1 = (TextView)findViewById(R.id.textView5);
        v2 = (TextView)findViewById(R.id.textView7);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean is = c1.isChecked();
                if(is){
                    String pizza = t1.getText().toString();
                    String spagetti = t2.getText().toString();
                    String salad = t3.getText().toString();
                    double temp;

                    int price = 15000*Integer.parseInt(pizza) + 13000*Integer.parseInt(spagetti) + 9000*Integer.parseInt(salad);
                    temp = price*0.9;
                    price = (int)temp;

                    int number = Integer.parseInt(pizza) + Integer.parseInt(spagetti) + Integer.parseInt(salad);

                    v1.setText(Double.toString(price)+ " 원");
                    v2.setText(Integer.toString(number)+" 개");
                }
                else{
                    String pizza = t1.getText().toString();
                    String spagetti = t2.getText().toString();
                    String salad = t3.getText().toString();

                    int price = 15000*Integer.parseInt(pizza) + 13000*Integer.parseInt(spagetti) + 9000*Integer.parseInt(salad);

                    int number = Integer.parseInt(pizza) + Integer.parseInt(spagetti) + Integer.parseInt(salad);

                    v1.setText(Integer.toString(price)+" 원");
                    v2.setText(Integer.toString(number)+" 개");

                }
            }
        });
    }
}
