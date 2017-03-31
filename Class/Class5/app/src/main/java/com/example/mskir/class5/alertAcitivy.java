package com.example.mskir.class5;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class alertAcitivy extends AppCompatActivity {
    Button basic,radio,checkbox,custom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_acitivy);

        basic = (Button)findViewById(R.id.basic);
        radio = (Button)findViewById(R.id.radio);
        checkbox = (Button)findViewById(R.id.checkbox);
        custom = (Button)findViewById(R.id.custom);

        basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(alertAcitivy.this);

                dlg.setTitle("기본대화상자");
                dlg.setIcon(R.mipmap.ic_launcher);
                dlg.setMessage("이것은 기본 대화상자입니다.");
                dlg.setNegativeButton("닫기",null);
                dlg.setPositiveButton("확인",null); // null 대신 onClickListener 생성 가능

                dlg.show();
            }
        });

        radio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] data = {"치킨","스파게티"}; //final 로 해야지 접근가능
                AlertDialog.Builder dlg  = new AlertDialog.Builder(alertAcitivy.this);
                final String[] whichItem = {null};
                dlg.setTitle("라디오 대화상자");
                dlg.setIcon(R.mipmap.ic_launcher);
                dlg.setSingleChoiceItems(data, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        whichItem[0] = data[which];
                    }
                });
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), whichItem[0] + "선택하셨습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
            }
        });

        checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String checkstr[] = {"피아노", "독서", "영화보기", "코딩하기"};
                final boolean checked[] = {false,true,false,true};

                AlertDialog.Builder dlg = new AlertDialog.Builder(alertAcitivy.this);
                dlg.setTitle("취미를 고르세요");
                dlg.setMultiChoiceItems(checkstr, checked, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        //Toast.makeText(getApplicationContext(),which,Toast.LENGTH_SHORT).show();
                        Log.d("Debug","asdfsadfsdf" + Integer.toString(which));
                        checked[which] = isChecked;
                    }
                });
                dlg.setPositiveButton("선택완료", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String str = "";
                        for(int i = 0; i<checked.length;i++){
                            if(checked[i]) {
                                str = str + "," + checkstr[i];
                            }
                        }
                        Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
            }
        });

        custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View dlgview = View.inflate(alertAcitivy.this, R.layout.dialog,null);
                final EditText editText = (EditText)dlgview.findViewById(R.id.editText);

                AlertDialog.Builder dlg = new AlertDialog.Builder(alertAcitivy.this);
                dlg.setPositiveButton("확인",null);
                dlg.setTitle("사용자 정의 대화상자");
                dlg.setView(dlgview);
                dlg.show();
            }
        });

    }
}
