package com.example.mskir.class11;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by mskir on 2017-05-18.
 */

public class MyCanvas extends View {
    Rect rect;
    String operation = "";
    public MyCanvas(Context context) {
        super(context);
        this.setLayerType(View.LAYER_TYPE_SOFTWARE,null);
    }

    public MyCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setLayerType(View.LAYER_TYPE_SOFTWARE,null);
    }

    /*@Override
    protected void onDraw(Canvas canvas) {
        rect = new Rect(10,10,100,100);
        int width = canvas.getWidth()/2 -45;
        int height = canvas.getHeight()/2 -45;

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        canvas.drawRect(10,10,100,100,paint);
        //모서리로부터 10,10만큼 거리에서 90,90만큼 그림

        paint.setColor(Color.MAGENTA);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);
        canvas.drawRect(width,height,width+90,height+90,paint);

        paint.setTextSize(70);
        canvas.drawText("Click Me !!",300,300,paint);

        Bitmap img = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        canvas.drawBitmap(img,300,350,paint);
        canvas.drawBitmap(img,400,350,paint);

        Bitmap smallimg = Bitmap.createScaledBitmap(img, img.getWidth()/2,img.getHeight()/2,false);
        canvas.drawBitmap(smallimg,500,350,paint);

        Bitmap bigimg = Bitmap.createScaledBitmap(img, img.getWidth()*2,img.getHeight()*2,false);
        canvas.drawBitmap(bigimg,900,350,paint);
        img.recycle();
    }*/

    float startX = -1, startY = -1, stopX = -1, stopY = -1;
    int x = 45;

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
/*        if(startX>0)
            canvas.drawRect(startX,startY,stopX,stopY,paint);*/

        Bitmap img = BitmapFactory.decodeResource(getResources(),R.drawable.flower);
        Bitmap bigimg = Bitmap.createScaledBitmap(img,img.getWidth()*2,img.getHeight()*2,false);

        int cenx = (this.getWidth() - bigimg.getWidth())/2;
        int ceny = (this.getHeight() - bigimg.getHeight())/2;
        if(operation.equals("rotate")) {
            canvas.rotate(x, this.getWidth() / 2, this.getHeight() / 2);
            x += 45;
        }
        if(operation.equals("BLUR")) {
            BlurMaskFilter blur = new BlurMaskFilter(1000, BlurMaskFilter.Blur.NORMAL); // NORMAL,INNER,OUTER,SOLID
            paint.setMaskFilter(blur);
        }

        /*float[] array = {
                2,0,0,0,-25f,
                0,2,0,0,-25f,
                0,0,2,0,-25f,
                0,0,0,2,0
        };*/

        /*ColorMatrix colorMatrix = new ColorMatrix(array);
        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(colorMatrix);
        paint.setColorFilter(filter);
        */

        canvas.drawBitmap(bigimg,cenx,ceny,paint);

    }

    public void setOperation(String operation){
        this.operation = operation;
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int)event.getX();
        int y = (int)event.getY();
        /*if(rect.contains(x,y))
        if(x >= 10 && x<=100 && y>=10 && y<=100){
            Toast.makeText(getContext(),"RED BUTTON",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getContext(),"BACK GROUND",Toast.LENGTH_SHORT).show();
        }*/
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            startX = event.getX(); startY = event.getY();
        }else if(event.getAction() == MotionEvent.ACTION_MOVE){
            /*stopX = event.getX(); stopY = event.getY();
            invalidate(); //화면을 무효화하여 onDraw() 재 호출*/
        }else if(event.getAction() == MotionEvent.ACTION_UP){
            stopX = event.getX(); stopY = event.getY();
            invalidate(); //화면을 무효화하여 onDraw() 재 호출
        }
        return true;
    }
}
