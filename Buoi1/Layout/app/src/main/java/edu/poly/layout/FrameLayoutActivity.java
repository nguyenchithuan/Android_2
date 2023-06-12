package edu.poly.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class FrameLayoutActivity extends AppCompatActivity {
    private FrameLayout layoutframe;
    private int[]arrayImg = {R.drawable.anh1, R.drawable.anh2, R.drawable.anh3, R.drawable.anh4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // move di chuyển các ảnh
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);
        layoutframe = findViewById(R.id.layoutframe);

        for (int i = 0; i < arrayImg.length; i++) {
            ImageView mImageView = new ImageView(this);
            mImageView.setImageResource(arrayImg[i]); // tạo ra ảnh

            FrameLayout.LayoutParams mParams= new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ); // tạo khung ảnh(tạo keo dính)

            mParams.leftMargin = i * 60; // cách theo khung, khoảng cách tăng theo i

            mImageView.setLayoutParams(mParams);// đưa ảnh vào khung(bôi keo vào ảnh)

            layoutframe.addView(mImageView); // dán ảnh vào tường

        }

    }
}