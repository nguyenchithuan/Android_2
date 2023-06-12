package edu.poly.customspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.id_spinner);

        DataAdapter adapter = new DataAdapter(this, dulieu());

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, dulieu().get(position).getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private ArrayList<Data> dulieu() {
        ArrayList<Data> list = new ArrayList<>();

        list.add(new Data("Chào các bạn"));
        list.add(new Data("Mình là"));
        list.add(new Data("Học sinh mới"));
        list.add(new Data("Đến đây"));

        return list;
    }
}