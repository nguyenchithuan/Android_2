package edu.poly.adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

import java.util.ArrayList;

import edu.poly.adapter.Adapter.Adapter;
import edu.poly.adapter.Model.UngDung;

public class SpinnerActivity extends AppCompatActivity {
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        spinner = findViewById(R.id.id_spinner);

        ArrayList<UngDung> list = new ArrayList<>();
        list.add(new UngDung(R.drawable.apple, "Apple"));
        list.add(new UngDung(R.drawable.facebook, "Facebook"));
        list.add(new UngDung(R.drawable.dell, "Deel"));
        list.add(new UngDung(R.drawable.apple, "Apple"));
        list.add(new UngDung(R.drawable.apple, "Apple"));

        Adapter adapter = new Adapter(this, list);

        spinner.setAdapter(adapter);

    }
}