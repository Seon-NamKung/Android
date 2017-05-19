package com.example.mskir.hw11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MyCanvas myCanvas;
    CheckBox stamp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myCanvas = (MyCanvas)findViewById(R.id.canvas);
        stamp = (CheckBox)findViewById(R.id.stamp);

        stamp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    myCanvas.onStamp(isChecked);
            }
        });
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.eraser:
                myCanvas.clear();
                break;
            case R.id.open:
                myCanvas.read(getFilesDir() + "hw10.jpg");
                break;
            case R.id.save:
                myCanvas.save(getFilesDir() + "hw10.jpg");
                break;
            case R.id.rotate:
                stamp.setChecked(true);
                myCanvas.onStamp(true);
                myCanvas.rotate();
                break;
            case R.id.move:
                stamp.setChecked(true);
                myCanvas.onStamp(true);
                myCanvas.move();
                break;
            case R.id.scale:
                stamp.setChecked(true);
                myCanvas.onStamp(true);
                myCanvas.scale();
                break;
            case R.id.skew:
                stamp.setChecked(true);
                myCanvas.onStamp(true);
                myCanvas.skew();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.blur:
                if(!item.isChecked()){
                    item.setChecked(true);
                    myCanvas.blur(true);
                }else{
                    item.setChecked(false);
                    myCanvas.blur(false);
                }
                break;
            case R.id.color:
                if(!item.isChecked()){
                    item.setChecked(true);
                    myCanvas.color(true);
                }else{
                    item.setChecked(false);
                    myCanvas.color(false);
                }
                break;
            case R.id.bigPen:
                if(!item.isChecked()){
                    item.setChecked(true);
                    myCanvas.isBig(true);
                }else{
                    item.setChecked(false);
                    myCanvas.isBig(false);
                }
                break;
            case R.id.redPen:
                myCanvas.penColor("RED");
                break;
            case R.id.bluePen:
                myCanvas.penColor("BLUE");
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
