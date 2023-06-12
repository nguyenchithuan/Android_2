package edu.poly.baithithuapplicationtixoa.fragment;

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

import edu.poly.baithithuapplicationtixoa.InterfaceDelete;
import edu.poly.baithithuapplicationtixoa.R;
import edu.poly.baithithuapplicationtixoa.RoomDB.RoomDB;
import edu.poly.baithithuapplicationtixoa.adapter.WorkAdapter;
import edu.poly.baithithuapplicationtixoa.objects.WorkObject;

public class DanhSachFragment extends Fragment implements InterfaceDelete{
    RecyclerView recyclerView;
    ArrayList<WorkObject> arrayList = new ArrayList<>();
    WorkAdapter adapter;

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
        recyclerView = view.findViewById(R.id.recycleView);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        adapter = new WorkAdapter(getActivity(), this::onclickDeleteListiner);
        arrayList = (ArrayList<WorkObject>) RoomDB.getInstance(getContext()).workDao().selectAll();
        adapter.setData(arrayList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        arrayList = (ArrayList<WorkObject>) RoomDB.getInstance(getContext()).workDao().selectAll();
        adapter.setData(arrayList);
    }

    @Override
    public void onclickDeleteListiner(WorkObject object) {
        RoomDB.getInstance(getContext()).workDao().delete(object);
        arrayList = (ArrayList<WorkObject>) RoomDB.getInstance(getContext()).workDao().selectAll();
        adapter.setData(arrayList);
    }
}