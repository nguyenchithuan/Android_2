package edu.poly.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class TableLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_layout);
        // stretchColumns phần đề các row
    }

    public void sukien(View view) {
        TextView tv = (TextView) view;
        Toast.makeText(this, tv.getText().toString(), Toast.LENGTH_SHORT).show();
    }
}