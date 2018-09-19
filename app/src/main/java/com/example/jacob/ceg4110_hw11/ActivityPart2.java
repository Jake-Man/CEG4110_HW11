package com.example.jacob.ceg4110_hw11;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class ActivityPart2 extends AppCompatActivity implements View.OnClickListener{


    Button part1;


    private DrawingBoard drawingBoard;


    private ImageButton currPaint;

    private ImageButton delete_btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part2);

        part1 =  findViewById(R.id.part1);
        drawingBoard =  findViewById(R.id.drawingBoard);
        LinearLayout paintLayout = findViewById(R.id.paint_colors);
        currPaint = (ImageButton)paintLayout.getChildAt(0);
        currPaint.setImageDrawable(getDrawable(R.drawable.paint_pressed));


        delete_btn = findViewById(R.id.delete_btn);
        delete_btn.setOnClickListener(this);





    }



    public void goToPart1(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }


    public void paintClicked(View view) {

        if (view != currPaint) {
            ImageButton imgView = (ImageButton) view;
            String color = view.getTag().toString();
            drawingBoard.setColor(color);
            imgView.setImageDrawable(getDrawable(R.drawable.paint_pressed));
            currPaint.setImageDrawable(getDrawable(R.drawable.paint));
            currPaint = (ImageButton) view;

        }
    }



    @Override
    public void onClick(View view){
        if(view.getId()==R.id.delete_btn){
            drawingBoard.delete();
        }





    }











}

