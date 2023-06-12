package edu.poly.baithithiapplicatontixoa1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import edu.poly.baithithiapplicatontixoa1.objects.DuLieu;

public class ChiTietActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);

        TextView noidung = findViewById(R.id.tvThongTinNoidung);
        TextView thoigian = findViewById(R.id.tvThongTinThoiGian);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            DuLieu duLieu = (DuLieu) bundle.getSerializable("dulieu");
            noidung.setText(duLieu.getNoiDung());
            thoigian.setText(duLieu.getThoiGian());
        }

    }
}