package com.example.mskir.practice_5;

import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText x, y;
    Button normal, center, custom, snackbar, button;
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mytoast);
        button = (Button)findViewById(R.id.num2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick2(View v) {
                onClick2(v);
            }
        });
    }

    public void onClick2(View v){
        if(v.getId() == R.id.num1){
            AlertDialog.Builder dig = new AlertDialog.Builder(this);

            dig.setTitle("제목").setMessage("내용").setIcon(R.mipmap.ic_launcher).setPositiveButton("close",null)
                    .setNegativeButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(),"click ok",Toast.LENGTH_SHORT);
                        }
                    }).show();
        }
        else if(v.getId() == R.id.num2){
            AlertDialog.Builder dig = new AlertDialog.Builder(this);
            String data[] = {"chicken","pizza"};
            dig.setTitle("menu").setSingleChoiceItems(data,0,null).setIcon(R.mipmap.ic_launcher).setPositiveButton("close",null)
                    .setNegativeButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(),"click ok",Toast.LENGTH_SHORT);
                        }
                    }).show();
        }
        else {
            if (v.getId() == R.id.num3) {
                AlertDialog.Builder dig = new AlertDialog.Builder(this);
                final String data[] = {"chicken", "pizza", "짜장", "탕슉"};
                final boolean checked[] = {true, false, true, false};
                final String result[] = {"","","",""};
                dig.setTitle("menu").setMultiChoiceItems(data, checked, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checked[which] = isChecked;
                    }
                }).setIcon(R.mipmap.ic_launcher).setPositiveButton("close", null)
                        .setNegativeButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String
                                Toast.makeText(getApplicationContext(), "click ok", Toast.LENGTH_SHORT);
                            }
                        }).show();
            }
            else(v.getId() == R.id.num2){
                View view = View.inflate(this,R.layout.exmaple,null);
                final EditText et = (EditText)view.findViewById(R.id.editText);

                AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                dlg.setTitle("먹고싶은 메뉴는").setView(view)
                        .setView(R.mipmap.ic_launcher)
                        .setPositiveButton("닫기",null)
                        .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(),et.getText().toString() + "",Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        }
    }

    public void onMyClick(View v) {
        if (v.getId() == R.id.button) {
            View view = View.inflate(getApplicationContext(), R.layout.mytoast, null);
            textview = (TextView) view.findViewById(R.id.textview); //view. 을 붙이는 이유는 view의 레이아웃에서 id를 찾아라. 안그러면 다른것

            textview.setText("new toast ");

            Toast tv = new Toast(this);

            tv.setDuration(Toast.LENGTH_SHORT);
            tv.setGravity(Gravity.CENTER, 0, 100);
            tv.setView(view);
            tv.show();
        }
    }

    public void onClick(View v){
        Snackbar.make(v, "Message",1000).setAction("확인", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }).show();
    }
}