package edu.poly.customtoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn_click);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = new Toast(MainActivity.this);
                View view = LayoutInflater.from(getBaseContext()).inflate(R.layout.layout_custom_toast, findViewById(R.id.layout_custom_toast));
                toast.setView(view);
//                toast.setGravity(Gravity.BOTTOM, 0, 0);
//                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();
            }
        });

    }
}