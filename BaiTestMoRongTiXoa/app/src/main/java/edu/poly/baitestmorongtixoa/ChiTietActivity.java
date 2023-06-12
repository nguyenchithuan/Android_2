package edu.poly.baitestmorongtixoa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import edu.poly.baitestmorongtixoa.objects.Work;

public class ChiTietActivity extends AppCompatActivity {
    private TextView tvNoidung;
    private TextView tvTime;
    private Work work;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);

        tvNoidung = findViewById(R.id.tvChiTietND);
        tvTime = findViewById(R.id.tvChiTietTime);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            work = (Work) bundle.getSerializable("object");
            tvNoidung.setText(work.getContend());
            tvTime.setText(work.getTime());
        }
    }
}