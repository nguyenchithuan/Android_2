package edu.poly.assignment.khoangchi;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
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
import java.util.Calendar;

import edu.poly.assignment.AdapterFragment.KhoanChiAdapter;
import edu.poly.assignment.AdapterFragment.KhoanThuAdapter;
import edu.poly.assignment.DAO.DaoKhoanChi;
import edu.poly.assignment.DAO.DaoKhoanThu;
import edu.poly.assignment.DTO.KhoanChi;
import edu.poly.assignment.DTO.KhoanThu;
import edu.poly.assignment.R;
import edu.poly.assignment.khoangchi.pageradapter.PagerAdapter;
import edu.poly.assignment.khoangthu.KhoangThuFragment;
import edu.poly.assignment.thongke.ThongKeFragment;

public class KhoangChiFragment extends Fragment implements View.OnClickListener{
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private FloatingActionButton fabKhoanChi;
    private DaoKhoanChi dao;

    public static KhoangChiFragment newInstance() {
        KhoangChiFragment fragment = new KhoangChiFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_khoang_chi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout = view.findViewById(R.id.tabLayout_khoanChi);
        viewPager2 = view.findViewById(R.id.viewPager2_khoanChi);
        fabKhoanChi = view.findViewById(R.id.fab_khoanChi);

        dao = new DaoKhoanChi(getContext());

        PagerAdapter adapter = new PagerAdapter(getActivity());
        viewPager2.setAdapter(adapter);

        TabLayoutMediator mediator = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch ((position)) {
                    case 0:
                        tab.setText("Khoảng Chi");
                        break;
                    case 1:
                        tab.setText("Loại Chi");
                        break;
                }
            }
        });

        mediator.attach();

        //---------------------------------------

        fabKhoanChi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_khoanChi:
                Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.layout_them_moi_data);

                Button btnSave = dialog.findViewById(R.id.btn_them_save);
                Button btnCancal = dialog.findViewById(R.id.btn_them_cancel);
                TextView ed_khoan= dialog.findViewById(R.id.ed_add_khoan);
                TextView  ed_loai= dialog.findViewById(R.id.ed_add_loai);
                TextView tvName = dialog.findViewById(R.id.tv_name_them);
                TextView tvNameItem1 = dialog.findViewById(R.id.tv_name_item1);
                TextView tvNameItem2 = dialog.findViewById(R.id.tv_name_item2);
                tvNameItem1.setText("Khoản Chi");
                tvNameItem2.setText("Loại Chi");
                tvName.setText("Thêm khoản chi");


                KhoanChi khoanChi = new KhoanChi();


                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        khoanChi.setKhoanChi(ed_khoan.getText().toString());
                        khoanChi.setLoaiChi(ed_loai.getText().toString());
                        // lấy thời gian hiện tại
                        String time = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
                        khoanChi.setThoiGian(time);
                        dao.insert(khoanChi);

                        // nhảy vào chính nó và chạy lại và hiển thị dữ liệu mới
                        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction(); // cho phép giao dịch
                        transaction.replace(R.id.id_frameLayout, KhoangChiFragment.newInstance()); // thay thế fragment vào frameLayout
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