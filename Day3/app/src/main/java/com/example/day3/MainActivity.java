package com.example.day3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.imag);
        TextView  textView = findViewById(R.id.C);
        Random rand = new Random();
        int upperbound = 40;
        int randnum = rand.nextInt(upperbound);
        if(randnum>=0&&randnum<10)
        {
           imageView.setImageResource(R.drawable.winter);
           textView.setText(String.valueOf(randnum));
        }
        else if(randnum>=10&&randnum<20)
        {
            imageView.setImageResource(R.drawable.spring);
            textView.setText(String.valueOf(randnum));


        }
        else
        {
            imageView.setImageResource(R.drawable.summer);
            textView.setText(String.valueOf(randnum));

        }
    }
}
