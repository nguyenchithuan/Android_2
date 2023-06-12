package edu.poly.assignment.khoangthu;

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

import edu.poly.assignment.AdapterFragment.KhoanThuAdapter;
import edu.poly.assignment.AdapterFragment.LoaiThuAdapter;
import edu.poly.assignment.DAO.DaoKhoanThu;
import edu.poly.assignment.DAO.DaoLoaiThu;
import edu.poly.assignment.DTO.KhoanThu;
import edu.poly.assignment.DTO.LoaiThu;
import edu.poly.assignment.R;
import edu.poly.assignment.khoangchi.tablayout.TabKhoangChiFragment;
import edu.poly.assignment.khoangthu.PagerAdapter.PagerAdapter;
import edu.poly.assignment.khoangthu.taglayout.TabKhoanThuFragment;
import edu.poly.assignment.khoangthu.taglayout.TabLoaiThuFragment;

public class KhoangThuFragment extends Fragment implements View.OnClickListener{
    private TabLayout id_tabLayout;
    private ViewPager2 id_viewPager2;
    private FloatingActionButton fabKhoanThu;
    private DaoKhoanThu daoKhoanThu;
    private DaoLoaiThu daoLoaiThu;


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

        daoKhoanThu = new DaoKhoanThu(getContext());
        daoLoaiThu = new DaoLoaiThu(getContext());

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

                int index = TabKhoanThuFragment.newInstance().getIndex();
                if(index == 1) {
                    Dialog dialog = new Dialog(getContext());
                    dialog.setContentView(R.layout.layout_update_data);
                    EditText edKhoanThu = dialog.findViewById(R.id.ed_update_khoan);
                    Button btnCancel = dialog.findViewById(R.id.btn_update_cancel);
                    Button btnSave = dialog.findViewById(R.id.btn_update_save);
                    TextView tvName = dialog.findViewById(R.id.update_name);
                    tvName.setText("Thêm Name");
                    KhoanThu khoanThu = new KhoanThu();

                    Window window = dialog.getWindow();

                    window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                    window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                    btnSave.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            khoanThu.setKhoanThu(edKhoanThu.getText().toString());
                            daoKhoanThu.insert(khoanThu);
                            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.id_frameLayout, KhoangThuFragment.newInstance());
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
                    TextView tvKhoanThu = dialog.findViewById(R.id.ed_add_khoan);
                    Spinner spnLoaiThu = dialog.findViewById(R.id.spiner_dulieu);
                    Button btnSave = dialog.findViewById(R.id.btn_them_save);
                    Button btnCancal = dialog.findViewById(R.id.btn_them_cancel);

                    Window window = dialog.getWindow();
                    window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                    window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                    TextView tvName = dialog.findViewById(R.id.tv_name_them);
                    tvName.setText("Thêm Thu");

                    ArrayList<String> duLieuSpinner = new ArrayList<>();

                    ArrayList<KhoanThu> listKhoanThu = daoKhoanThu.selectAll();

                    for (int i = 0; i < listKhoanThu.size(); i++) {
                        duLieuSpinner.add(listKhoanThu.get(i).getKhoanThu());
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, duLieuSpinner);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spnLoaiThu.setAdapter(adapter);

                    LoaiThu loaiThu = new LoaiThu();

                    btnSave.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            loaiThu.setKhoanThu(tvKhoanThu.getText().toString());
                            loaiThu.setLoaiThu(duLieuSpinner.get(spnLoaiThu.getSelectedItemPosition()));
                            String time = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
                            loaiThu.setThoiGian(time);
                            daoLoaiThu.insert(loaiThu);
                            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.id_frameLayout, KhoangThuFragment.newInstance());
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