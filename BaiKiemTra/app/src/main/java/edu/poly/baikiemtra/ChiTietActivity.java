package edu.poly.baikiemtra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import edu.poly.baikiemtra.objects.GiaoVien;

public class ChiTietActivity extends AppCompatActivity {

    private TextView tvName;
    private TextView tvTime;
    private TextView tvChuyennganh;
    private GiaoVien giaoVien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);

        tvName = findViewById(R.id.tvChiTietName);
        tvTime = findViewById(R.id.tvChiTietTime);
        tvChuyennganh = findViewById(R.id.tvChiTietChuyenNganh);


        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            giaoVien = (GiaoVien) bundle.getSerializable("object");
            tvName.setText(giaoVien.getName());
            tvTime.setText(giaoVien.getTime());
            tvChuyennganh.setText(giaoVien.getChuyennganh());
        }
    }
}