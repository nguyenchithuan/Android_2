package edu.poly.adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SimpleAdapterActivity extends AppCompatActivity {
    private ListView lvSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter);
        lvSimple = findViewById(R.id.lvSimple);

        String[] from = {"imng", "name", "age"};

        int[] to = {R.id.imgAnh, R.id.tvName, R.id.tvAge};

        List<HashMap<String, Object>> data = new ArrayList<>();

        HashMap<String, Object> hashMap1 = new HashMap<>();
        hashMap1.put("imng", R.drawable.apple);
        hashMap1.put("age", 18);
        hashMap1.put("name", "Apple");

        HashMap<String, Object> hashMap2 = new HashMap<>();
        hashMap2.put("imng", R.drawable.facebook);
        hashMap2.put("age", 21);
        hashMap2.put("name", "Facebook");

        HashMap<String, Object> hashMap3 = new HashMap<>();
        hashMap3.put("imng", R.drawable.dell);
        hashMap3.put("age", 44);
        hashMap3.put("name", "Dell");

        data.add(hashMap1);
        data.add(hashMap2);
        data.add(hashMap3);

        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.listview_item, from, to);

        lvSimple.setAdapter(adapter);

    }
}