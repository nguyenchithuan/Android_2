package edu.poly.baithithiapplicatontixoa1.fragment;

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

import edu.poly.baithithiapplicatontixoa1.R;
import edu.poly.baithithiapplicatontixoa1.dao.DulieuDao;
import edu.poly.baithithiapplicatontixoa1.objects.DuLieu;

public class GhiChuFragment extends Fragment {

    public static GhiChuFragment newInstance() {
        GhiChuFragment fragment = new GhiChuFragment();
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
        return inflater.inflate(R.layout.fragment_ghi_chu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText edNoiDung = view.findViewById(R.id.edNoiDung);
        EditText edThoiGian = view.findViewById(R.id.edThoiGian);
        Button btnThem = view.findViewById(R.id.btnThem);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DuLieu duLieu = new DuLieu();
                duLieu.setNoiDung(edNoiDung.getText().toString());
                duLieu.setThoiGian(edThoiGian.getText().toString());

                if(edNoiDung.getText().toString().isEmpty() == true) {
                    Toast.makeText(getActivity(), "Hãy nhập nội dung", Toast.LENGTH_SHORT).show();
                } else if(edThoiGian.getText().toString().isEmpty() == true) {
                    Toast.makeText(getActivity(), "Hãy nhập thời gian", Toast.LENGTH_SHORT).show();
                } else {
                    DulieuDao dao = new DulieuDao(getActivity());
                    dao.insert(duLieu);
                    Toast.makeText(getActivity(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}