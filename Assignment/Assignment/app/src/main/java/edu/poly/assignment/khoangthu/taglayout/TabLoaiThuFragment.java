package edu.poly.assignment.khoangthu.taglayout;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import edu.poly.assignment.AdapterFragment.LoaiThuAdapter;
import edu.poly.assignment.DAO.DaoKhoanThu;
import edu.poly.assignment.DTO.KhoanThu;
import edu.poly.assignment.R;

public class TabLoaiThuFragment extends Fragment {
    private RecyclerView recyclerView;
    private LoaiThuAdapter adapter;
    private ArrayList<KhoanThu> list;
    private DaoKhoanThu dao;

    public static TabLoaiThuFragment newInstance() {
        TabLoaiThuFragment fragment = new TabLoaiThuFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab_loai_thu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView_loaiThu);
        dao = new DaoKhoanThu(getContext());
        list = dao.selectAll();

        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);


        adapter = new LoaiThuAdapter(getActivity(), dao);
        adapter.setData(list);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onResume() {
        super.onResume();
        list = dao.selectAll();
        adapter.setData(list);
        adapter.notifyDataSetChanged();

    }
}