package com.example.mskir.class11;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by mskir on 2017-05-18.
 */

public class MyPaint extends View {
    Bitmap mBitmap;
    Canvas mCanvas;
    Paint mPaint = new Paint();

    public MyPaint(Context context) {
        super(context);
        mPaint.setColor(Color.RED);
    }

    public MyPaint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint.setColor(Color.RED);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {

        super.onSizeChanged(w, h, oldw, oldh);
        mBitmap = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas();

        mCanvas.setBitmap(mBitmap);
        mCanvas.drawColor(Color.WHITE);

        drawStamp();
    }

    private void drawStamp(){
        Bitmap img = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        mCanvas.drawBitmap(img,10,10,mPaint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(mBitmap != null)
            canvas.drawBitmap(mBitmap,0,0,null);
    }
    int oldX = -1, oldY = -1;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int X = (int)event.getX();
        int Y = (int)event.getY();
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            oldX = X;
            oldY = Y;
        }else if(event.getAction() == MotionEvent.ACTION_MOVE){
            if(oldX != -1) {
                mCanvas.drawLine(oldX, oldY, X, Y, mPaint);
                invalidate();
                oldX = X;
                oldY = Y;
            }
        }else if(event.getAction() == MotionEvent.ACTION_UP){
            if(oldX != -1) {
                mCanvas.drawLine(oldX, oldY, X, Y, mPaint);
                invalidate();
            }
            oldX = -1;
            oldY = -1;
        }
        return true;
    }
}
