package edu.poly.assignment.khoangchi.tablayout;

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

import java.util.ArrayList;

import edu.poly.assignment.AdapterFragment.KhoanChiAdapter;
import edu.poly.assignment.DAO.DaoKhoanChi;
import edu.poly.assignment.DTO.KhoanChi;
import edu.poly.assignment.R;
import edu.poly.assignment.khoangchi.KhoangChiFragment;
import edu.poly.assignment.khoangthu.KhoangThuFragment;

public class TabKhoangChiFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<KhoanChi> list;
    private DaoKhoanChi dao;
    private KhoanChiAdapter adapter;

    public static TabKhoangChiFragment newInstance() {
        TabKhoangChiFragment fragment = new TabKhoangChiFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab_khoang_chi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView_khoanChi);
        dao = new DaoKhoanChi(getContext());
        list = dao.selectAll();

        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

        adapter = new KhoanChiAdapter(getContext(), dao);
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