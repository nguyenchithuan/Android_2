package edu.poly.baikiemtra.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import edu.poly.baikiemtra.Data.GVDatabase;
import edu.poly.baikiemtra.R;
import edu.poly.baikiemtra.UpdateActivity;
import edu.poly.baikiemtra.adapter.GiaoVienAdapter;
import edu.poly.baikiemtra.objects.GiaoVien;

public class DSGiaoVienFragment extends Fragment implements GiaoVienAdapter.InterfaceItem {
    private RecyclerView recyclerView;
    private ArrayList<GiaoVien> list = new ArrayList<>();
    private GiaoVienAdapter adapter;


    public static DSGiaoVienFragment newInstance() {
        DSGiaoVienFragment fragment = new DSGiaoVienFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_d_s_giao_vien, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycleView);

        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

        adapter = new GiaoVienAdapter(getContext(), this);

        downLoad();

        recyclerView.setAdapter(adapter);
    }

    public void downLoad() {
        list = (ArrayList<GiaoVien>) GVDatabase.getInstance(getActivity()).giaoVienDao().selectAll();
        adapter.setData(list);
    }

    @Override
    public void onResume() {
        super.onResume();
        downLoad();
    }

    @Override
    public void onclickDelete(GiaoVien giaoVien) {
        GVDatabase.getInstance(getActivity()).giaoVienDao().delete(giaoVien);
        downLoad();
        Toast.makeText(getContext(), "Xóa thành công!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onclickUpdate(GiaoVien giaoVien) {
        Intent intent = new Intent(getContext(), UpdateActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object", giaoVien);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}