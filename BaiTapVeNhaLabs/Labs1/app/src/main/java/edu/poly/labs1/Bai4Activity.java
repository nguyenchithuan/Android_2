package edu.poly.labs1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class Bai4Activity extends AppCompatActivity {
    private FrameLayout frameLayout;
    private int[] mang = {R.drawable.a1, R.drawable.a2, R.drawable.a1, R.drawable.a2, R.drawable.a1, R.drawable.a2, R.drawable.a1, R.drawable.a2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        frameLayout = findViewById(R.id.framelayout);

        for (int i = 0; i < mang.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(mang[i]);

            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );

            params.leftMargin = i * 60;

            imageView.setLayoutParams(params);

            frameLayout.addView(imageView);

        }
    }
}