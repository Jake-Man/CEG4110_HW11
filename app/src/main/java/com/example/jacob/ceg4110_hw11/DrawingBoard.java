package com.example.jacob.ceg4110_hw11;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.View;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;



public class DrawingBoard extends View {


    private Canvas canvas;
    private Path path;
    private Paint paint;
    private Paint colorPallete;
    private int paintColor = 0xFF000000;
    private Bitmap canvasBitmap;


    public DrawingBoard(Context context, AttributeSet attrs) {
        super(context, attrs);
        drawingSetup();
    }



    private void drawingSetup() {

        path = new Path();
        paint = new Paint();
        paint.setColor(paintColor);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        colorPallete = new Paint(Paint.DITHER_FLAG);
    }

    @Override
    protected void onSizeChanged(int width, int height, int oldWidth, int oldHeight){
        super.onSizeChanged(width, height, oldWidth, oldHeight);
        canvasBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(canvasBitmap);

    }

    @Override
    protected void onDraw(Canvas canvasView){
        //view the drawing
        canvasView.drawBitmap(canvasBitmap, 0, 0, colorPallete);
        canvasView.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent move){

        float touchX = move.getX();
        float touchY = move.getY();
        switch (move.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(touchX, touchY);
                break;

            case MotionEvent.ACTION_MOVE:
                path.lineTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_UP:
                canvas.drawPath(path, paint);
                path.reset();
                break;
            default:
                return false;

        }

        invalidate();
        return true;
    }

    public void setColor(String newColor){
        invalidate();
        paintColor = Color.parseColor(newColor);
        paint.setColor(paintColor);
    }

    public void delete(){
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        invalidate();
    }




}

