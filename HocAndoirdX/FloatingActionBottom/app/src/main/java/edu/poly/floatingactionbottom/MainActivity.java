package edu.poly.floatingactionbottom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import edu.poly.floatingactionbottom.adapter.DuLieuAdapter;
import edu.poly.floatingactionbottom.objects.DuLieu;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private DuLieuAdapter adapter;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

        fab = findViewById(R.id.floatingActionBottom);
        fab.setOnClickListener(this);

        adapter = new DuLieuAdapter(this);

        adapter.setData(duLieu());
        recyclerView.setAdapter(adapter);


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if(dy > 0) {
                    fab.setVisibility(View.INVISIBLE);
                } else {
                    fab.setVisibility(View.VISIBLE);
                }
            }
        });


    }

    private ArrayList<DuLieu> duLieu() {
        ArrayList<DuLieu> list = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            list.add(new DuLieu("User name " + i));
        }

        return list;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Thêm thành công!", Toast.LENGTH_SHORT).show();
    }
}