package edu.poly.truyenvanhandulieu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ManHinhNhanActivity extends AppCompatActivity {
    private EditText edNhan;
    private Button btnNhan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_nhan);

        edNhan = findViewById(R.id.ed_nhan);
        btnNhan = findViewById(R.id.btnNhan);

        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dulieu = edNhan.getText().toString().trim();
                truyenLaiDuLieu(dulieu);
            }
        });

        String text = getIntent().getStringExtra("dulieutruyendi");
        edNhan.setText(text);
    }

    private void truyenLaiDuLieu(String dulieu) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("truyenlaidulieu", dulieu);
        setResult(RESULT_OK, intent);
        finish();
    }
}