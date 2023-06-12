package edu.poly.bottomnavigationbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;

import edu.poly.bottomnavigationbar.adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView navigationView;
    ViewPager2 viewPager2;
    ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.bottom_nav);
        viewPager2 = findViewById(R.id.viewpager2);
        adapter = new ViewPagerAdapter(this);
        viewPager2.setAdapter(adapter);


        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        navigationView.getMenu().findItem(R.id.ic_home).setChecked(true);
                        break;
                    case 1:
                        navigationView.getMenu().findItem(R.id.ic_favorite).setChecked(true);
                        break;
                    case 2:
                        navigationView.getMenu().findItem(R.id.ic_account).setChecked(true);
                        break;
                }
            }
        });


        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_home:
                        viewPager2.setCurrentItem(0);
                        break;
                    case R.id.ic_favorite:
                        viewPager2.setCurrentItem(1);
                        break;
                    case R.id.ic_account:
                        viewPager2.setCurrentItem(2);
                        break;
                }
                return true; // chuyển về true để hiển thị màu
            }
        });

    }
}