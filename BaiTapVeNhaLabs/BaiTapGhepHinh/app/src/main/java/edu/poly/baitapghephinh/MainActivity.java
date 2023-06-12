package edu.poly.baitapghephinh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void suKien(View view) {
        ImageView img_anh = (ImageView)view;

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);

        view.startAnimation(animation);
    }
}