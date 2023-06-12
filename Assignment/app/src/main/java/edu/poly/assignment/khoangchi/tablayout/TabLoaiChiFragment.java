package edu.poly.assignment.khoangchi.tablayout;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import edu.poly.assignment.AdapterFragment.LoaiChiAdapter;
import edu.poly.assignment.DAO.DaoKhoanChi;
import edu.poly.assignment.DAO.DaoLoaiChi;
import edu.poly.assignment.DTO.KhoanChi;
import edu.poly.assignment.DTO.LoaiChi;
import edu.poly.assignment.R;

public class TabLoaiChiFragment extends Fragment {
    private RecyclerView recyclerView;
    private DaoLoaiChi dao;
    private ArrayList<LoaiChi> list;
    private LoaiChiAdapter adapter;
    private DaoKhoanChi daoKhoanChi;
    private ArrayList<KhoanChi> listKhoanChi;
    public static int index = 0;

    public static TabLoaiChiFragment newInstance() {
        TabLoaiChiFragment fragment = new TabLoaiChiFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab_loai_chi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        daoKhoanChi = new DaoKhoanChi(getContext());
        listKhoanChi = daoKhoanChi.selectAll();

        recyclerView = view.findViewById(R.id.recyclerView_loaiChi);
        dao = new DaoLoaiChi(getContext());
        list = dao.selectAll();

        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);


        adapter = new LoaiChiAdapter(getContext(), dao);
        adapter.setData(list);
        adapter.setDataDao(listKhoanChi);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        listKhoanChi = daoKhoanChi.selectAll();
        list = dao.selectAll();
        adapter.setData(list);
        adapter.setDataDao(listKhoanChi);
        index = 2;
        adapter.notifyDataSetChanged();

    }
}