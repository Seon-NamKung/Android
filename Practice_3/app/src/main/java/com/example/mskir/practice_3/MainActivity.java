package com.example.mskir.practice_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText korean,math,english;
    Button calculate,clear;
    TextView average,total;
    ImageView grade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("학점 계산기");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }


    void init(){
        korean = (EditText)findViewById(R.id.korean);
        math = (EditText)findViewById(R.id.math);
        english = (EditText)findViewById(R.id.english);

        calculate = (Button)findViewById(R.id.calculate);
        clear = (Button)findViewById(R.id.clear);

        average = (TextView)findViewById(R.id.average);
        total = (TextView)findViewById(R.id.total);

        grade = (ImageView)findViewById(R.id.grade);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kr = korean.getText().toString();
                String mm = math.getText().toString();
                String eng = english.getText().toString();

                if(kr.getBytes().length == 0 || mm.getBytes().length == 0|| eng.getBytes().length == 0)
                {
                    Toast.makeText(getApplicationContext(), "값을 입력하세요.",Toast.LENGTH_SHORT).show();
                }else{
                    int totalScore = Integer.parseInt(kr) + Integer.parseInt(mm) + Integer.parseInt(eng);
                    int averageScore = totalScore/3;

                    total.setText(Integer.toString(totalScore));
                    average.setText(Integer.toString(averageScore));

                    if(averageScore > 90 ){
                        grade.setImageResource(R.drawable.a);
                    }else if(averageScore > 80){
                        grade.setImageResource(R.drawable.b);
                    }else if(averageScore >70){
                        grade.setImageResource(R.drawable.c);
                    }else{
                        grade.setImageResource(R.drawable.f);
                        }
                    }
                }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                korean.setText(null);
                math.setText(null);
                english.setText(null);

                total.setText("0");
                average.setText("0");
                grade.setImageResource(0);
                Toast.makeText(getApplicationContext(),"초기화 되었습니다.",Toast.LENGTH_SHORT);
            }
        });
    }
}
