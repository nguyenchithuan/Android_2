package edu.poly.baikiemtra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.poly.baikiemtra.Data.GVDatabase;
import edu.poly.baikiemtra.objects.GiaoVien;

public class UpdateActivity extends AppCompatActivity {

    private EditText name;
    private EditText time;
    private EditText chuyennganh;
    private Button btnHoaTat;
    private GiaoVien giaoVien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        name = findViewById(R.id.ed_add_ten);
        time = findViewById(R.id.ed_add_time);
        chuyennganh = findViewById(R.id.ed_add_chuyennganh);
        btnHoaTat = findViewById(R.id.btnHoanTat);


        btnHoaTat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strName = name.getText().toString().trim();
                String strTime = time.getText().toString().trim();
                String strChuyennganh = chuyennganh.getText().toString().trim();
                if(strName.isEmpty() || strTime.isEmpty() || strChuyennganh.isEmpty()) {
                    Toast.makeText(getBaseContext(), "Mời nhập dữ liệu", Toast.LENGTH_SHORT).show();
                    return;
                }

                giaoVien.setName(strName);
                giaoVien.setTime(strTime);
                giaoVien.setChuyennganh(strChuyennganh);
                GVDatabase.getInstance(getBaseContext()).giaoVienDao().update(giaoVien);
                Toast.makeText(getBaseContext(), "Update thành công!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            giaoVien = (GiaoVien) bundle.getSerializable("object");
            name.setText(giaoVien.getName());
            time.setText(giaoVien.getTime());
            chuyennganh.setText(giaoVien.getChuyennganh());
        }

    }
}