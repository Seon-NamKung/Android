package com.example.mskir.class6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    EditText et;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        et = (EditText)findViewById(R.id.et1);

        Intent intent = getIntent();
        String name = intent.getStringExtra("msg");
        et.setText(name);

        Student sss = intent.getParcelableExtra("student1");
        String str = sss.toString();
        et.setText(str);

    }

    public void onClick(View v){
        Intent intent = new Intent();
        intent.putExtra("remakemsg",et.getText().toString());
        setResult(RESULT_OK,intent);

        finish();
    }
}
