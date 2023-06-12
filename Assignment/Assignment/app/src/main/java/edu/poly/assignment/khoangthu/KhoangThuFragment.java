package edu.poly.assignment.khoangthu;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import edu.poly.assignment.AdapterFragment.KhoanThuAdapter;
import edu.poly.assignment.AdapterFragment.LoaiThuAdapter;
import edu.poly.assignment.DAO.DaoKhoanThu;
import edu.poly.assignment.DTO.KhoanThu;
import edu.poly.assignment.R;
import edu.poly.assignment.khoangthu.PagerAdapter.PagerAdapter;
import edu.poly.assignment.khoangthu.taglayout.TabKhoanThuFragment;

public class KhoangThuFragment extends Fragment implements View.OnClickListener{
    private TabLayout id_tabLayout;
    private ViewPager2 id_viewPager2;
    private FloatingActionButton fabKhoanThu;
    private DaoKhoanThu dao;

    public static KhoangThuFragment newInstance() {
        KhoangThuFragment fragment = new KhoangThuFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_khoang_thu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        id_tabLayout = view.findViewById(R.id.id_tabLayout);
        id_viewPager2 = view.findViewById(R.id.id_viewPager2);
        fabKhoanThu = view.findViewById(R.id.fab_khoanThu);


        dao = new DaoKhoanThu(getContext());

        PagerAdapter adapter = new PagerAdapter(getActivity());
        id_viewPager2.setAdapter(adapter);
        TabLayoutMediator mediator = new TabLayoutMediator(id_tabLayout, id_viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("Khoản thu");
                        break;
                    case 1:
                        tab.setText("Loại thu");
                        break;
                }
            }
        });
        mediator.attach();

        fabKhoanThu.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_khoanThu:
                Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.layout_them_moi_data);

                Button btnSave = dialog.findViewById(R.id.btn_them_save);
                Button btnCancal = dialog.findViewById(R.id.btn_them_cancel);
                TextView  ed_khoan= dialog.findViewById(R.id.ed_add_khoan);
                TextView  ed_loai= dialog.findViewById(R.id.ed_add_loai);
                TextView tvName = dialog.findViewById(R.id.tv_name_them);
                tvName.setText("Thêm khoản thu");
                KhoanThu khoanThu = new KhoanThu();


                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        khoanThu.setKhoanThu(ed_khoan.getText().toString());
                        khoanThu.setLoaiThu(ed_loai.getText().toString());
                        // lấy thời gian hiện tại
                        String time = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
                        khoanThu.setThoiGian(time);
                        dao.insert(khoanThu);

                        // nhảy lại vào chính nó và hiền thị dữ liệu mới
                        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.id_frameLayout, KhoangThuFragment.newInstance());
                        transaction.commit();

                        Toast.makeText(getActivity(), "Thêm thành công!", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });

                btnCancal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });

                dialog.show();
                break;
        }
    }
}