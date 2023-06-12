package edu.poly.giaodienapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import edu.poly.giaodienapplication.Bai3.Bai3Fragment;
import edu.poly.giaodienapplication.Bai5.Context_Popup_Menu_Fragment;
import edu.poly.giaodienapplication.Bai6.DialogDemoFragment;
import edu.poly.giaodienapplication.bai1.Bai1Fragment;
import edu.poly.giaodienapplication.bai2.Bai2Fragment;
import edu.poly.giaodienapplication.bai4.RecycleViewFragment;
import edu.poly.giaodienapplication.home.HomeFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private FrameLayout frameLayout;
    private NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.id_drawerlayout);
        toolbar = findViewById(R.id.id_toolbar); // add toolBar vào ứng dụng
        setSupportActionBar(toolbar); // thêm toolbar vào ứng dụng(tên ứng dụng)
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0);

        toggle.syncState();

        navigationView = findViewById(R.id.id_NavView);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.home) {
            replaceFragment(HomeFragment.newInstance());
        } else if(id == R.id.bai1) {
            replaceFragment(Bai1Fragment.newInstance());
        } else if(id == R.id.bai2) {
            replaceFragment(Bai2Fragment.newInstance());
        } else if(id == R.id.bai3) {
            replaceFragment(Bai3Fragment.newInstance());
        } else if(id == R.id.bai4) {
            replaceFragment(RecycleViewFragment.newInstance());
        } else if(id == R.id.bai5) {
            replaceFragment(Context_Popup_Menu_Fragment.newInstance());
        } else if(id == R.id.bai6) {
            replaceFragment(DialogDemoFragment.newInstance());
        }
        drawerLayout.closeDrawer(navigationView); // đóng navigationView
        return false;
    }

//    @Override
//    public void onBackPressed() {
//        if(drawerLayout.isDrawerOpen(navigationView)) {
//            drawerLayout.closeDrawer(navigationView);
//        } else {
//            super.onBackPressed();
//        }
//    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            if(drawerLayout.isDrawerOpen(navigationView)) {
                drawerLayout.closeDrawer(navigationView);
            } else {
                finish();
            }
        }
        return true;
    }

    public void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.id_frameLayout, fragment); // thay thế fragment vào frameLayout
        transaction.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        // gom các item thành một view
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.tiengAnh:
                Toast.makeText(this, "Tiếng Anh", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tiengPhap:
                Toast.makeText(this, "Tiếng Pháp", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tiengTrung:
                Toast.makeText(this, "Tiếng Trung", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tiengViet:
                Toast.makeText(this, "Tiếng Việt", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}