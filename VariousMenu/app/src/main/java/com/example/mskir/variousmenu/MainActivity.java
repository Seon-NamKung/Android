package com.example.mskir.variousmenu;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Matrix;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    FrameLayout main;
    ImageView image;
    TextView text;
    int degree = 30;
    ClipData.Item chicken,spagetti;
    Drawable temp1,temp2,temp3;

    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("메뉴를 눌러보세요");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main = (FrameLayout)findViewById(R.id.mainlayout);
        image = (ImageView)findViewById(R.id.image);
        text = (TextView)findViewById(R.id.text);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch(item.getItemId()){
            case R.id.switchActivity:
                Intent intent = new Intent(MainActivity.this,tabHost.class);
                startActivity(intent);
                break;
            case R.id.red:
                main.setBackgroundColor(Color.RED);
                break;
            case R.id.blue:
                main.setBackgroundColor(Color.BLUE);
                break;
            case R.id.yellow:
                main.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.chicken:
                degree = 0;
                image.setImageResource(R.drawable.chicken);
                item.setChecked(true);
                text.setText("겁나 맛있는 치킨");
                i=0;
                break;
            case R.id.spagetti:
                degree = 0;
                image.setImageResource(R.drawable.spagetti);
                item.setChecked(true);
                text.setText("불어터진 스파게티");
                i=1;
                break;
            case R.id.viewtitle:
                if(!item.isChecked()) {
                    item.setChecked(true);
                    text.setVisibility(View.VISIBLE);
                }
                else{
                    item.setChecked(false);
                    text.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.zoom:
                if(!item.isChecked()){
                    item.setChecked(true);
                    image.setScaleX(1.4f);
                    image.setScaleY(1.4f);
                }else{
                    image.setScaleX(1.0f);
                    image.setScaleY(1.0f);
                    item.setChecked(false);
                }
                break;
            case R.id.rotate:
                degree += 30;
                if(i==0) {
                    image.setImageBitmap(rotateImage(BitmapFactory.decodeResource(getResources(), R.drawable.chicken), degree));
                }
                if(i==1){
                    image.setImageBitmap(rotateImage(BitmapFactory.decodeResource(getResources(), R.drawable.spagetti), degree));
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public Bitmap rotateImage(Bitmap src, float degree){

        Matrix matrix = new Matrix();

        matrix.postRotate(degree);

        return Bitmap.createBitmap(src,0,0,src.getWidth(),src.getHeight(),matrix,true);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}
