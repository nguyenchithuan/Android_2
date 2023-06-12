package edu.poly.assignment.khoangchi;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import edu.poly.assignment.DAO.DaoKhoanChi;
import edu.poly.assignment.DAO.DaoLoaiChi;
import edu.poly.assignment.DTO.KhoanChi;
import edu.poly.assignment.DTO.KhoanThu;
import edu.poly.assignment.DTO.LoaiChi;
import edu.poly.assignment.R;
import edu.poly.assignment.khoangchi.pageradapter.PagerAdapter;
import edu.poly.assignment.khoangchi.tablayout.TabKhoangChiFragment;
import edu.poly.assignment.khoangthu.KhoangThuFragment;
import edu.poly.assignment.khoangthu.taglayout.TabKhoanThuFragment;

public class KhoangChiFragment extends Fragment implements View.OnClickListener{
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private FloatingActionButton fabKhoanChi;
    private DaoKhoanChi daoKhoanChi;
    private DaoLoaiChi daoLoaiChi;

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
        daoKhoanChi = new DaoKhoanChi(getContext());
        daoLoaiChi = new DaoLoaiChi(getContext());

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
                int index = TabKhoangChiFragment.newInstance().getIndex();
                if(index == 1) {
                    Dialog dialog = new Dialog(getContext());
                    dialog.setContentView(R.layout.layout_update_data);
                    EditText edKhoanChi = dialog.findViewById(R.id.ed_update_khoan);
                    Button btnCancel = dialog.findViewById(R.id.btn_update_cancel);
                    Button btnSave = dialog.findViewById(R.id.btn_update_save);
                    TextView tvName = dialog.findViewById(R.id.update_name);
                    tvName.setText("Thêm Name");
                    KhoanChi khoanChi = new KhoanChi();

                    Window window = dialog.getWindow();
                    window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                    window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                    btnSave.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            khoanChi.setKhoanChi(edKhoanChi.getText().toString());
                            daoKhoanChi.insert(khoanChi);
                            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.id_frameLayout, KhoangChiFragment.newInstance());
                            transaction.commit();
//                            Toast.makeText(getActivity(), "Thêm thành công!", Toast.LENGTH_SHORT).show();

                            Toast toast = new Toast(getActivity());
                            View view = LayoutInflater.from(getActivity()).inflate(R.layout.layout_custom_toast, null);
                            TextView tvName = view.findViewById(R.id.tv_name_custom);
                            tvName.setText("Thêm thành công!");
                            toast.setView(view);
                            toast.show();

                            dialog.cancel();

                        }
                    });

                    btnCancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.cancel();
                        }
                    });

                    dialog.show();
                } else {
                    Dialog dialog = new Dialog(getContext());
                    dialog.setContentView(R.layout.layout_them_moi_data);
                    TextView tvKhoanChi = dialog.findViewById(R.id.ed_add_khoan);
                    Spinner spnLoaiChi = dialog.findViewById(R.id.spiner_dulieu);
                    Button btnSave = dialog.findViewById(R.id.btn_them_save);
                    Button btnCancal = dialog.findViewById(R.id.btn_them_cancel);

                    Window window = dialog.getWindow();
                    window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                    window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                    TextView tvName = dialog.findViewById(R.id.tv_name_them);
                    tvName.setText("Thêm Chi");

                    ArrayList<String> duLieuSpinner = new ArrayList<>();

                    ArrayList<KhoanChi> listKhoanChi = daoKhoanChi.selectAll();

                    for (int i = 0; i < listKhoanChi.size(); i++) {
                        duLieuSpinner.add(listKhoanChi.get(i).getKhoanChi());
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, duLieuSpinner);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spnLoaiChi.setAdapter(adapter);

                    LoaiChi loaiChi = new LoaiChi();

                    btnSave.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            loaiChi.setKhoanChi(tvKhoanChi.getText().toString());
                            loaiChi.setLoaiChi(duLieuSpinner.get(spnLoaiChi.getSelectedItemPosition()));
                            String time = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
                            loaiChi.setThoiGian(time);
                            daoLoaiChi.insert(loaiChi);

                            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.id_frameLayout, KhoangChiFragment.newInstance());
                            transaction.commit();

//                            Toast.makeText(getActivity(), "Update thành công!", Toast.LENGTH_SHORT).show();
                            Toast toast = new Toast(getActivity());
                            View view = LayoutInflater.from(getActivity()).inflate(R.layout.layout_custom_toast, null);
                            TextView tvName = view.findViewById(R.id.tv_name_custom);
                            tvName.setText("Thêm thành công!");
                            toast.setView(view);
                            toast.show();
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
                }
                break;
        }
    }
}