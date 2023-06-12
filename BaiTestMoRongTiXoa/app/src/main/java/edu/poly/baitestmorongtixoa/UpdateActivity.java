package edu.poly.baitestmorongtixoa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.poly.baitestmorongtixoa.DataBase.WorkDataBase;
import edu.poly.baitestmorongtixoa.objects.Work;

public class UpdateActivity extends AppCompatActivity {
    private EditText edContend;
    private EditText edTime;
    private Button btnUpdate;
    private Work work;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        edContend = findViewById(R.id.ed_update_contend);
        edTime = findViewById(R.id.ed_update_time);
        btnUpdate = findViewById(R.id.btn_update);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contend = edContend.getText().toString().trim();
                String time = edTime.getText().toString().trim();
                if(contend.isEmpty() || time.isEmpty()) {
                    Toast.makeText(getBaseContext(), "Mời nhập dữ liệu", Toast.LENGTH_SHORT).show();
                    return;
                }

                work.setContend(contend);
                work.setTime(time);
                WorkDataBase.getInstance(getBaseContext()).workDao().update(work);
                Toast.makeText(getBaseContext(), "Update thành công!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            work = (Work) bundle.getSerializable("object");
            edContend.setText(work.getContend());
            edTime.setText(work.getTime());
        }

    }
}