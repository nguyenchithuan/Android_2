package edu.poly.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.poly.roomdatabase.database.UserDatabase;
import edu.poly.roomdatabase.objects.User;

public class UpdateActivity extends AppCompatActivity {
    private EditText edUsername;
    private EditText edAddress;
    private Button btnUpdateUser;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        edUsername = findViewById(R.id.ed_username);
        edAddress = findViewById(R.id.ed_address);
        btnUpdateUser = findViewById(R.id.btn_update_user);

        btnUpdateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultUpdate();
            }
        });

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            user = (User) bundle.getSerializable("objects");
            edUsername.setText(user.getUsername());
            edAddress.setText(user.getAddress());
        }
    }

    private void resultUpdate() {
        String strUsername = edUsername.getText().toString().trim();
        String strAddress = edAddress.getText().toString().trim();

        if(strAddress.isEmpty() || strUsername.isEmpty()) {
            Toast.makeText(this, "Dữ liệu null!", Toast.LENGTH_SHORT).show();
            return;
        }

        user.setUsername(strUsername);
        user.setAddress(strAddress);

        UserDatabase.getInstance(this).userDao().update(user);
        Toast.makeText(this, "Update thành công", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, MainActivity.class);
        setResult(RESULT_OK, intent);
        finish();
    }
}