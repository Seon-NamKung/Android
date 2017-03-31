package com.example.mskir.class5;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {
    Button normal,center,custom,snackbar;
    EditText x_offset,y_offset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        normal = (Button)findViewById(R.id.normal);
        center = (Button)findViewById(R.id.center);
        custom = (Button)findViewById(R.id.custom);
        snackbar = (Button)findViewById(R.id.snackbar);

        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"일반 메세지 창입니다.",Toast.LENGTH_SHORT).show();
            }
        });

        center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toastView = Toast.makeText(getApplicationContext(), "위치지정 메세지 입니다.", Toast.LENGTH_SHORT);

                toastView.setGravity(Gravity.LEFT|Gravity.TOP,10,20);
                toastView.show();
            }
        });

        custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = getLayoutInflater().inflate(R.layout.mytoast,null);
                TextView tv = (TextView)view.findViewById(R.id.txtmsg);
                tv.setText("레이아웃으로 만든 토스트 창 입니다.");

                Toast toastView = new Toast(getApplicationContext());

                toastView.setDuration(Toast.LENGTH_SHORT);
                toastView.setGravity(Gravity.CENTER,0,100);
                toastView.setView(view);
                toastView.show();
            }
        });

        snackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"SnackBar로 보여주는 메세지 입니다.",Snackbar.LENGTH_SHORT)
                        .setAction("OK", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        }).show();
            }
        });

    }
}
