package edu.poly.baithithuapplicationtixoa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import edu.poly.baithithuapplicationtixoa.objects.WorkObject;

public class ChiTietActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);
        TextView noidung = findViewById(R.id.tvThongTinNoiDung);
        TextView thoigian = findViewById(R.id.tvThongTinThoiGian);

        Bundle bundle = getIntent().getExtras();
//        Bundle bundle = getIntent().getBundleExtra("dulieu");
        if(bundle != null) {
            WorkObject object = (WorkObject) bundle.getSerializable("doituong");
            noidung.setText(object.getContend());
            thoigian.setText(object.getTime());
        }
    }
}