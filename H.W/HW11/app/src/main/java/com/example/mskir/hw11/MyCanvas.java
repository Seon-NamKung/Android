package com.example.mskir.hw11;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import static android.R.attr.x;
import static com.example.mskir.hw11.R.id.canvas;

/**
 * Created by mskir on 2017-05-18.
 */

public class MyCanvas extends View {
    Bitmap mBitmap;
    Bitmap img;
    Canvas mCanvas;
    Paint mPaint;
    Bitmap bigimg;
    private boolean stamp;
    private boolean move;
    private boolean scale;
    private boolean skew;
    private boolean blur;
    private boolean color;
    private boolean rotate;
    private boolean isBig;

    public MyCanvas(Context context) {
        super(context);
        this.mPaint = new Paint();
        mPaint.setStrokeWidth(3);
        stamp = false;
        move = false;
        scale = false;
        skew = false;
        blur = false;
        rotate = false;
        isBig = false;
    }

    public MyCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mPaint = new Paint();
        mPaint.setStrokeWidth(3);
        stamp = false;
        move = false;
        scale = false;
        skew = false;
        blur = false;
        rotate = false;
        isBig = false;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mBitmap = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas();

        mCanvas.setBitmap(mBitmap);
        mCanvas.drawColor(Color.WHITE);

    }

    private void drawStamp(int x,int y){
        float[] array = {
                2,0,0,0,-25f,
                0,2,0,0,-25f,
                0,0,2,0,-25f,
                0,0,0,2,0
        };
        img = BitmapFactory.decodeResource(getResources(),R.drawable.pen);
        bigimg = Bitmap.createScaledBitmap(img,img.getWidth()*3/2,img.getHeight()*3/2,false);
        if(blur) {
            BlurMaskFilter blur = new BlurMaskFilter(1000, BlurMaskFilter.Blur.NORMAL); // NORMAL,INNER,OUTER,SOLID
            mPaint.setMaskFilter(blur);
        }else{
            mPaint.setMaskFilter(null);
        }

        if(color){
            ColorMatrix colorMatrix = new ColorMatrix(array);
            ColorMatrixColorFilter filter = new ColorMatrixColorFilter(colorMatrix);
            mPaint.setColorFilter(filter);
        }else{
            mPaint.setColorFilter(null);
        }

        if(move) {
            if(scale)
                mCanvas.drawBitmap(bigimg, x+200, y+200, mPaint);
            else
                mCanvas.drawBitmap(img, x+200, y+200, mPaint);
        }else{
            if(scale)
                mCanvas.drawBitmap(bigimg, x, y, mPaint);
            else
                mCanvas.drawBitmap(img, x, y, mPaint);
        }

        img.recycle();
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(mBitmap != null) {
                canvas.drawBitmap(mBitmap, 0, 0, null);
        }
    }
    int oldX = -1, oldY = -1;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int X = (int)event.getX();
        int Y = (int)event.getY();
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            if (stamp) {
                drawStamp(X, Y);
            }else{
                oldX = X;
                oldY = Y;
            }
        }
        else if(event.getAction() == MotionEvent.ACTION_MOVE){
            if(oldX != -1 && !stamp) {
                mCanvas.drawLine(oldX, oldY, X, Y, mPaint);
                invalidate();
                oldX = X;
                oldY = Y;
            }

        }else if(event.getAction() == MotionEvent.ACTION_UP){
            if(oldX != -1 && !stamp) {
                mCanvas.drawLine(oldX, oldY, X, Y, mPaint);
                invalidate();
                oldX = -1;
                oldY = -1;
            }
        }
        return true;
    }

    public void onStamp(Boolean stamp){
        this.stamp = stamp;
        invalidate();
    }

    public void clear(){
        mBitmap.eraseColor(Color.WHITE);
        invalidate();
    }

    public boolean read(String file_name){
        try{
            FileInputStream in = new FileInputStream(file_name);
            mBitmap = BitmapFactory.decodeStream(in).copy(Bitmap.Config.ARGB_8888,true);
            invalidate();
            mCanvas.setBitmap(mBitmap);
            in.close();
            Toast.makeText(getContext(),"불러왔습니다.",Toast.LENGTH_SHORT).show();
            return true;
        }catch (FileNotFoundException e){
            Log.e("FileNotFoundException",e.getMessage());
        }catch(IOException e){
            Log.e("IOException",e.getMessage());
        }
        return false;
    }

    public boolean save(String file_name){
        try{
            FileOutputStream out = new FileOutputStream(file_name);
            mBitmap.compress(Bitmap.CompressFormat.JPEG,100,out); //100->품질
            out.close();
            Toast.makeText(getContext(),"저장되었습니다.",Toast.LENGTH_SHORT).show();
            return true;
        }catch (FileNotFoundException e){
            Log.e("FileNotFoundException",e.getMessage());

        }catch(IOException e){
            Log.e("IOException",e.getMessage());
        }
        return false;
    }

    public void rotate(){
        if(rotate) {
            mCanvas.rotate(-30, mCanvas.getWidth() / 2, mCanvas.getHeight() / 2);
            rotate = false;
        }else{
            mCanvas.rotate(30, mCanvas.getWidth() / 2, mCanvas.getHeight() / 2);
            rotate = true;
        }
    }

    public void move(){
        if(move){
            move = false;
        }else{
            move = true;
        }
    }

    public void scale(){
        if(scale){
            scale = false;
        }else{
            scale = true;
        }
    }

    public void skew(){
        if(skew) {
            mCanvas = new Canvas();
            mCanvas.setBitmap(mBitmap);
            rotate = false;
            skew = false;
        }else{
            mCanvas.skew(0.2f,0);
            skew = true;
        }
    }

    public void blur(boolean isChecked){
        blur = isChecked;
    }
    public void color(boolean isChecked){
        color = isChecked;
    }
    public void isBig(boolean isChecked){
        isBig = isChecked;
        if(isBig)
            mPaint.setStrokeWidth(10);
        else
            mPaint.setStrokeWidth(3);
    }

    public void penColor(String col){
        if(col.equals("RED")){
            mPaint.setColor(Color.RED);
        }else if(col.equals("BLUE")){
            mPaint.setColor(Color.BLUE);
        }
    }
}
