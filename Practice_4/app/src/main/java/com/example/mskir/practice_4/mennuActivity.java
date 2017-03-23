package com.example.mskir.practice_4;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;

public class mennuActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mennu);

        textView = (TextView)findViewById(R.id.textView);
        registerForContextMenu(textView);
    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//       getMenuInflater().inflate(R.menu.menu22,menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if(item.getItemId() == R.id.mnuyellow){}
//        else if(item.getItemId() == R.id.mnublue){}
//        else if(item.getItemId() == R.id.mnuFontSize20){
//            textView.setTextSize(20);
//            item.setChecked(true);
//        }
//        else if(item.getItemId() == R.id.mnuFontSize40){
//            textView.setTextSize(40);
//            item.setChecked(true);
//        }
//        return super.onOptionsItemSelected(item);
//    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if(v == textView){
            menu.setHeaderTitle("메뉴 제목");
            getMenuInflater().inflate(R.menu.menu22,menu);
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.mnublue:
            {
                textView.setBackgroundColor(Color.BLUE);
                break;
            }
        }
        return super.onContextItemSelected(item);
    }
}
