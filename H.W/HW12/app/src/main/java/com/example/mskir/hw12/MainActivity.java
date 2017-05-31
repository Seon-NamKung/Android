package com.example.mskir.hw12;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    EditText second;
    ImageView imgV;
    int[] imgs  = {R.drawable.forkcutlet,R.drawable.hamburger,R.drawable.kimbab,R.drawable.meat,R.drawable.naengmyeon,
            R.drawable.noodle,R.drawable.sushi};
    int start = R.drawable.play;
    boolean isStop = false;
    MyTask myTask;
    int passTime;
    int curImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        second = (EditText)findViewById(R.id.second);
        tv = (TextView)findViewById(R.id.tv);
        imgV = (ImageView)findViewById(R.id.image);

    }

    public void onClick(View v){
        if(v.getId() == R.id.image){
            if(isStop == true){
                myTask.cancel(true);
                myTask = null;
                isStop = false;
            }else{
                myTask = new MyTask();
                myTask.execute(0);
                isStop = true;
            }
        }else if(v.getId() == R.id.init){
            if(isStop == false){
                imgV.setImageResource(start);
                tv.setVisibility(View.GONE);
                second.setText("");
            }else {
                myTask.cancel(true);
                myTask = null;
                imgV.setImageResource(start);
                tv.setVisibility(View.GONE);
                second.setText("");
                isStop = false;
            }

        }

    }

    class MyTask extends AsyncTask<Integer,Integer,Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            passTime = 0;
            curImg = 0;
            tv.setVisibility(View.VISIBLE);
            tv.setText("시작부터 "+passTime + "초");
            imgV.setImageResource(imgs[0]);
        }

        @Override
        protected Void doInBackground(Integer... params) {
            for(passTime = 1;passTime>=0;passTime++) {
                if (isCancelled() == true) return null;
                try {
                    Thread.sleep(1000);
                    publishProgress(passTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            if(second.getText().toString().equals("")){
                curImg++;
                imgV.setImageResource(imgs[curImg]);
                if(curImg == imgs.length-1) curImg = 0;
            }else{
                int duration = Integer.parseInt(second.getText().toString());
                if(values[0]%duration == 0) {
                    curImg++;
                    imgV.setImageResource(imgs[curImg]);
                    if (curImg == imgs.length - 1) curImg = 0;
                }
            }
            tv.setText("시작부터 "+ values[0] + "초");
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }
    }
}
