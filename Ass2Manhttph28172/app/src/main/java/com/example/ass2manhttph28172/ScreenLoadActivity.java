package com.example.ass2manhttph28172;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScreenLoadActivity extends AppCompatActivity {
    //thời gian chờ 3s
    int TIME_OUT=3000;
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_load);
        tv1 =findViewById(R.id.tv1);
        Typeface typeface =Typeface.createFromAsset(getAssets(),"PlayfairDisplayBold.otf");
        tv1.setTypeface(typeface);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(ScreenLoadActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },TIME_OUT);

    }
}