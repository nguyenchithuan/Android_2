package edu.poly.assignment.khoangthu.taglayout;

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

import edu.poly.assignment.AdapterFragment.LoaiThuAdapter;
import edu.poly.assignment.DAO.DaoKhoanThu;
import edu.poly.assignment.DAO.DaoLoaiThu;
import edu.poly.assignment.DTO.KhoanThu;
import edu.poly.assignment.DTO.LoaiThu;
import edu.poly.assignment.R;

public class TabLoaiThuFragment extends Fragment {
    private RecyclerView recyclerView;
    private LoaiThuAdapter adapter;
    private ArrayList<LoaiThu> list;
    private DaoLoaiThu dao;
    private DaoKhoanThu daoKhoanThu;
    private ArrayList<KhoanThu> listKhoanThu;
    public static int index = 0;

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

        daoKhoanThu = new DaoKhoanThu(getContext());
        listKhoanThu = daoKhoanThu.selectAll();

        recyclerView = view.findViewById(R.id.recyclerView_loaiThu);
        dao = new DaoLoaiThu(getContext());
        list = dao.selectAll();

        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);


        adapter = new LoaiThuAdapter(getActivity(), dao);
        adapter.setData(list);
        adapter.setDataDao(listKhoanThu);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        listKhoanThu = daoKhoanThu.selectAll();
        list = dao.selectAll();
        adapter.setData(list);
        adapter.setDataDao(listKhoanThu);
        index = 2;
        adapter.notifyDataSetChanged();
    }
}