package edu.poly.assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import edu.poly.assignment.DAO.DaoLoaiChi;
import edu.poly.assignment.DAO.DaoLoaiThu;
import edu.poly.assignment.DTO.LoaiChi;
import edu.poly.assignment.DTO.LoaiThu;
import edu.poly.assignment.gioithieu.GioiThieuFragment;
import edu.poly.assignment.khoangchi.KhoangChiFragment;
import edu.poly.assignment.khoangthu.KhoangThuFragment;
import edu.poly.assignment.thongke.ThongKeFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout id_drawerLayout;
    private Toolbar toolbar;
    private NavigationView id_navView;
    private DaoLoaiThu daoThu;
    private DaoLoaiChi daoChi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id_drawerLayout = findViewById(R.id.id_drawerlayout);
        toolbar = findViewById(R.id.id_toolBar);
        id_navView = findViewById(R.id.id_navView);
        daoThu = new DaoLoaiThu(this);
        daoChi = new DaoLoaiChi(this);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, id_drawerLayout, toolbar, 0, 0);
        toggle.syncState();

        id_navView.setNavigationItemSelectedListener(this);
        id_navView.setItemIconTintList(null);// set cho nó màu của các item


        // chạy fragment thông kê đầu tiên
        replaceFragment(ThongKeFragment.newInstance());
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.khoangThu) {
            getSupportActionBar().setTitle("Khoản thu");
            replaceFragment(KhoangThuFragment.newInstance());
        } else if(id == R.id.khoangChi) {
            getSupportActionBar().setTitle("Khoản chi");
            replaceFragment(KhoangChiFragment.newInstance());
        } else if(id == R.id.thongKe) {
            getSupportActionBar().setTitle("Thông kế");
            replaceFragment(ThongKeFragment.newInstance());
        } else if(id == R.id.gioiThieu) {
            getSupportActionBar().setTitle("Giới thiệu");
            replaceFragment(GioiThieuFragment.newInstance());
        } else if(id == R.id.thoat) {
            dialogThoat();
        }
        id_drawerLayout.closeDrawer(id_navView);
        return true;
    }

    public void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction(); // cho phép giao dịch
        transaction.replace(R.id.id_frameLayout, fragment); // thay thế fragment vào frameLayout
        transaction.commit();
    }

    public void dialogThoat() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông báo!");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Bạn có muốn thoát không ?");

        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }


    @Override
    public void onBackPressed() {
        if(id_drawerLayout.isDrawerOpen(id_navView)) {
            id_drawerLayout.closeDrawer(id_navView);
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        this.getMenuInflater().inflate(R.menu.item_menu_thao_tac_du_lieu, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.menu_khoanThu:
//
//                Dialog dialog = new Dialog(this);
//                dialog.setContentView(R.layout.layout_them_moi_data);
//
//                Button btnSave = dialog.findViewById(R.id.btn_them_save);
//                Button btnCancal = dialog.findViewById(R.id.btn_them_cancel);
//                TextView ed_khoan= dialog.findViewById(R.id.ed_add_khoan);
//                TextView  ed_loai= dialog.findViewById(R.id.ed_add_loai);
//                TextView tvName = dialog.findViewById(R.id.tv_name_them);
//                tvName.setText("Thêm khoản thu");
//                LoaiThu khoanThu = new LoaiThu();
//
//
//                btnSave.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        khoanThu.setKhoanThu(ed_khoan.getText().toString());
//                        khoanThu.setLoaiThu(ed_loai.getText().toString());
//                        // lấy thời gian hiện tại
//                        String time = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
//                        khoanThu.setThoiGian(time);
//                        daoThu.insert(khoanThu);
//
//                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                        transaction.replace(R.id.id_frameLayout, ThongKeFragment.newInstance());
//                        transaction.commit();
//
//                        Toast.makeText(getBaseContext(), "Thêm thành công!", Toast.LENGTH_SHORT).show();
//                        dialog.cancel();
//                    }
//                });
//
//                btnCancal.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        dialog.cancel();
//                    }
//                });
//
//                dialog.show();
//
//
//
//                break;
//            case R.id.menu_khoanChi:
//                Dialog dialog1 = new Dialog(this);
//                dialog1.setContentView(R.layout.layout_them_moi_data);
//
//                Button btnSave1 = dialog1.findViewById(R.id.btn_them_save);
//                Button btnCancal1 = dialog1.findViewById(R.id.btn_them_cancel);
//                TextView ed_khoan1= dialog1.findViewById(R.id.ed_add_khoan);
//                TextView  ed_loai1= dialog1.findViewById(R.id.ed_add_loai);
//                TextView tvName1 = dialog1.findViewById(R.id.tv_name_them);
//                TextView tvNameItem1 = dialog1.findViewById(R.id.tv_name_item1);
//                TextView tvNameItem2 = dialog1.findViewById(R.id.tv_name_item2);
//                tvNameItem1.setText("Khoản Chi");
//                tvNameItem2.setText("Loại Chi");
//                tvName1.setText("Thêm khoản chi");
//
//                LoaiChi khoanChi = new LoaiChi();
//
//
//                btnSave1.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        khoanChi.setKhoanChi(ed_khoan1.getText().toString());
//                        khoanChi.setLoaiChi(ed_loai1.getText().toString());
//                        // lấy thời gian hiện tại
//                        String time = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
//                        khoanChi.setThoiGian(time);
//                        daoChi.insert(khoanChi);
//
//                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                        transaction.replace(R.id.id_frameLayout, ThongKeFragment.newInstance());
//                        transaction.commit();
//
//                        Toast.makeText(getBaseContext(), "Thêm thành công!", Toast.LENGTH_SHORT).show();
//                        dialog1.cancel();
//                    }
//                });
//
//                btnCancal1.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        dialog1.cancel();
//                    }
//                });
//
//                dialog1.show();
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }

}