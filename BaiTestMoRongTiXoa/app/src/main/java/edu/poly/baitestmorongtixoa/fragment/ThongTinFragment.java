package edu.poly.baitestmorongtixoa.fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.poly.baitestmorongtixoa.DataBase.WorkDataBase;
import edu.poly.baitestmorongtixoa.R;
import edu.poly.baitestmorongtixoa.objects.Work;

public class ThongTinFragment extends Fragment {
    private EditText edContend;
    private EditText edTime;
    private Button btnAdd;

    public static ThongTinFragment newInstance() {
        ThongTinFragment fragment = new ThongTinFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_thong_tin, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        edContend = view.findViewById(R.id.ed_add_contend);
        edTime = view.findViewById(R.id.ed_add_time);
        btnAdd = view.findViewById(R.id.btn_add);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contend = edContend.getText().toString().trim();
                String time = edTime.getText().toString().trim();
                if(contend.isEmpty() || time.isEmpty()) {
                    Toast.makeText(getActivity(), "Mời nhập dữ liệu", Toast.LENGTH_SHORT).show();
                    return;
                }

                Work work = new Work(contend, time);
                WorkDataBase.getInstance(getActivity()).workDao().inser(work);
                Toast.makeText(getActivity(), "Thêm thành công!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}