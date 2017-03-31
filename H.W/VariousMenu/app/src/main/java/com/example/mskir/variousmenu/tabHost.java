package com.example.mskir.variousmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;

public class tabHost extends AppCompatActivity {
    TabHost tabHost;
    TextView t1_text, t2_result;
    Button t2_sTop,t2_pTos,t1_result;
    EditText t1_weight,t1_height,t2_input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_host);
        setTitle("각종 계산기");
        init();
    }

    void init(){
        tabHost = (TabHost)findViewById(R.id.tabHost);
        tabHost.setup();

        tabHost.addTab(tabHost.newTabSpec("A").setContent(R.id.tab1).setIndicator("BMI 계산기"));
        tabHost.addTab(tabHost.newTabSpec("B").setContent(R.id.tab2).setIndicator("면적 계산기"));



        //Tab 1

        t1_height = (EditText)findViewById(R.id.t1_height);
        t1_weight = (EditText)findViewById(R.id.t1_weight);
        t1_result = (Button)findViewById(R.id.t1_result);
        t1_text = (TextView)findViewById(R.id.t1_text);

        t1_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weight = t1_weight.getText().toString();
                String height = t1_height.getText().toString();

                double bmi = Double.parseDouble(weight) / (Double.parseDouble(height)*Double.parseDouble(height)/10000);

                if(bmi < 18.5){
                    t1_text.setText("체중 부족 입니다.");
                }else if(18.5 <= bmi && bmi<23.0){
                    t1_text.setText("정상 입니다.");
                }else if(23.0 <= bmi && bmi<25){
                    t1_text.setText("과체중 입니다.");
                }else{
                    t1_text.setText("비만 입니다.");
                }
            }
        });

        //Tab 2

        t2_result = (TextView)findViewById(R.id.t2_result);
        t2_sTop = (Button)findViewById(R.id.t2_sTop);
        t2_pTos = (Button)findViewById(R.id.t2_pTos);
        t2_input = (EditText)findViewById(R.id.t2_input);


        t2_sTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = t2_input.getText().toString();
                Double d_input = Double.parseDouble(input)/3.3;
                String fixedNumber = String.format("%.2f", d_input);
                d_input = Double.parseDouble(fixedNumber);
                t2_result.setText(d_input + " 평");
            }
        });

        t2_pTos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = t2_input.getText().toString();
                Double d_input = Double.parseDouble(input)*3.3;
                String fixedNumber = String.format("%.2f", d_input);
                d_input = Double.parseDouble(fixedNumber);
                t2_result.setText(d_input + " 제곱미터");
            }
        });

    }
}
