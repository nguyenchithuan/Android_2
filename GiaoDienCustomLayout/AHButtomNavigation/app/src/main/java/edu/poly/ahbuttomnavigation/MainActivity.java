package edu.poly.ahbuttomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import edu.poly.ahbuttomnavigation.adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView nav;
    private ViewPager2 viewPager2;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nav = findViewById(R.id.bottomNav);
        viewPager2 = findViewById(R.id.viewPager2);
        adapter = new ViewPagerAdapter(this);

        viewPager2.setAdapter(adapter);

        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        viewPager2.setCurrentItem(0);
                        break;
                    case R.id.favorite:
                        viewPager2.setCurrentItem(1);
                        break;
                    case R.id.user:
                        viewPager2.setCurrentItem(2);
                        break;
                }
                return true;
            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                switch (position) {
                    case 0:
                        nav.getMenu().findItem(R.id.menu_home).setChecked(true);
                        break;
                    case 1:
                        nav.getMenu().findItem(R.id.favorite).setChecked(true);
                        break;
                    case 2:
                        nav.getMenu().findItem(R.id.user).setChecked(true);
                        break;
                }
            }
        });


    }
}