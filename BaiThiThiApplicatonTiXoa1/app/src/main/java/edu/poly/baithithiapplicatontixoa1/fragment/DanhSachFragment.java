package edu.poly.baithithiapplicatontixoa1.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

import edu.poly.baithithiapplicatontixoa1.InterfaceDelete;
import edu.poly.baithithiapplicatontixoa1.R;
import edu.poly.baithithiapplicatontixoa1.adapter.DuLieuAdapter;
import edu.poly.baithithiapplicatontixoa1.dao.DulieuDao;
import edu.poly.baithithiapplicatontixoa1.objects.DuLieu;

public class DanhSachFragment extends Fragment implements InterfaceDelete {
    private RecyclerView recyclerView;
    private DuLieuAdapter adapter;
    private ArrayList<DuLieu> list;
    private DulieuDao dao;

    public static DanhSachFragment newInstance() {
        DanhSachFragment fragment = new DanhSachFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_danh_sach, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dao = new DulieuDao(getActivity());
        list = dao.seletionAll();

        recyclerView = view.findViewById(R.id.recycleView);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);


        adapter = new DuLieuAdapter(getActivity(), this::onClickDeleteListioner);
        adapter.setData(list);

        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();

        list = dao.seletionAll();
        adapter.setData(list);
    }

    @Override
    public void onClickDeleteListioner(DuLieu duLieu) {
        dao.delete(duLieu);
        list = dao.seletionAll();
        adapter.setData(list);
    }
}