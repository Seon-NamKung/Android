package com.example.mskir.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Button calculate;
    EditText price, number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
    }

    void init(){
        calculate = (Button)findViewById(R.id.button);
        price = (EditText)findViewById(R.id.price);
        number = (EditText)findViewById(R.id.number);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String priceString = price.getText().toString(); // 입력한 텍스트를 가져옵니다.
                String numberString = number.getText().toString();
                int result = Integer.parseInt(priceString) * Integer.parseInt(numberString); // 정수로 변환

                Toast toast = Toast.makeText(getApplicationContext(),"Total Price is "+result+" won",Toast.LENGTH_SHORT); // 팝업 생성
                toast.show(); //팝업 표시
            }
        });
    }
}
