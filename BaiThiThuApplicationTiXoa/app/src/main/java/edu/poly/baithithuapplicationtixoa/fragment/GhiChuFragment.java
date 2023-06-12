package edu.poly.baithithuapplicationtixoa.fragment;

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

import edu.poly.baithithuapplicationtixoa.R;
import edu.poly.baithithuapplicationtixoa.RoomDB.RoomDB;
import edu.poly.baithithuapplicationtixoa.objects.WorkObject;

public class GhiChuFragment extends Fragment {
    private EditText edContend;
    private EditText edTime;
    private Button btnThem;

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
        return inflater.inflate(R.layout.fragment_ghi_chu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        edContend = view.findViewById(R.id.edContend);
        edTime = view.findViewById(R.id.edTimeDate);
        btnThem = view.findViewById(R.id.btnThem);


        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WorkObject workObject = new WorkObject();
                workObject.setContend(edContend.getText().toString());
                workObject.setTime(edTime.getText().toString());

                if(edContend.getText().toString().isEmpty() == true) {
                    Toast.makeText(getActivity(), "Contend null!", Toast.LENGTH_SHORT).show();
                } else if(edTime.getText().toString().isEmpty() == true) {
                    Toast.makeText(getActivity(), "Time null!", Toast.LENGTH_SHORT).show();
                } else {
                    RoomDB.getInstance(getActivity()).workDao().insert(workObject);
                    Toast.makeText(getActivity(), "Thêm thành công!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}