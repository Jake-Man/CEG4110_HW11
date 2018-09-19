package com.example.jacob.ceg4110_hw11;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int red = 0;
    int green = 0;
    int blue = 0;
    Button colorChange;
    EditText editText;
    TextView outputRGB;
    Button part2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText =(EditText) findViewById(R.id.editText);

        editText = (EditText) findViewById(R.id.editText);
        colorChange = (Button) findViewById(R.id.colorChange);
        outputRGB = (TextView) findViewById(R.id.outputRGB);
        part2 = (Button) findViewById(R.id.part2);

        colorChange.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Random r = new Random();
                red = r.nextInt(256);
                green = r.nextInt(256);
                blue = r.nextInt(256);
                editText.setTextColor(Color.rgb(red, green, blue));
                outputRGB.setText("COLOR: "+ red +"r, " + green +"g, "+ blue+ "b, #" + Integer.toString(red, 16)
                        + ""+ Integer.toString(green,16) + ""+ Integer.toString(blue,16));
            }



        });

    }

    public void goToPart2(View view) {
        Intent intent = new Intent(this, ActivityPart2.class);
        startActivity(intent);
    }
}
