package edu.poly.baikiemtra.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.poly.baikiemtra.Data.GVDatabase;
import edu.poly.baikiemtra.R;
import edu.poly.baikiemtra.objects.GiaoVien;

public class ThemDuLieuFragment extends Fragment {
    private EditText name;
    private EditText time;
    private EditText chuyennganh;
    private Button btnThem;
    private Button btnHuy;

    public static ThemDuLieuFragment newInstance() {
        ThemDuLieuFragment fragment = new ThemDuLieuFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_them_du_lieu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        name = view.findViewById(R.id.ed_add_ten);
        time = view.findViewById(R.id.ed_add_time);
        chuyennganh = view.findViewById(R.id.ed_add_chuyennganh);
        btnThem = view.findViewById(R.id.btnThem);
        btnHuy = view.findViewById(R.id.btnHuy);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strName = name.getText().toString().trim();
                String strTime = time.getText().toString().trim();
                String strChuyennganh = chuyennganh.getText().toString().trim();
                if(strName.isEmpty() || strTime.isEmpty() || strChuyennganh.isEmpty()) {
                    Toast.makeText(getActivity(), "Mời nhập dữ liệu", Toast.LENGTH_SHORT).show();
                    return;
                }

                GiaoVien giaoVien = new GiaoVien(strName, strTime, strChuyennganh);
                GVDatabase.getInstance(getActivity()).giaoVienDao().insert(giaoVien);
                Toast.makeText(getActivity(), "Thêm thành công!", Toast.LENGTH_SHORT).show();
            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                time.setText("");
                chuyennganh.setText("");
            }
        });
    }
}