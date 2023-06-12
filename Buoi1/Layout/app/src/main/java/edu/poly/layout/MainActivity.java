package edu.poly.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edName, edPass;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // dp dùng linh hoạt các màn hình điện thoại

        edName = findViewById(R.id.ed_ten);
        edPass = findViewById(R.id.ed_pass);
        btn = findViewById(R.id.btn);

        // kiểm tra user, pass
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edName.getText().toString();
                String pass = edPass.getText().toString();

                if(name.equalsIgnoreCase("thuan")
                    && pass.equalsIgnoreCase("123")) {

                    Intent intent = new Intent(MainActivity.this , MainActivity2.class);
                    startActivity(intent);

                    Toast.makeText(MainActivity.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(MainActivity.this, "Đăng nhập không thành công!", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}