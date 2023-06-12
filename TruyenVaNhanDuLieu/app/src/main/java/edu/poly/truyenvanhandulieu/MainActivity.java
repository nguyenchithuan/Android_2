package edu.poly.truyenvanhandulieu;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText edGui;
    private Button btnGui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edGui = findViewById(R.id.ed_gui);
        btnGui = findViewById(R.id.btnGui);

        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String duLieu = edGui.getText().toString().trim();
                truyenDuLieu(duLieu);
            }
        });
    }

    private void truyenDuLieu(String duLieu) {
        Intent intent = new Intent(this, ManHinhNhanActivity.class);
        intent.putExtra("dulieutruyendi", duLieu);
        activityResultLauncher.launch(intent);
    }

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode() == RESULT_OK) {
                Intent intent = result.getData();
                String dulieu = intent.getStringExtra("truyenlaidulieu");
                edGui.setText(dulieu);
            }
        }
    });
}