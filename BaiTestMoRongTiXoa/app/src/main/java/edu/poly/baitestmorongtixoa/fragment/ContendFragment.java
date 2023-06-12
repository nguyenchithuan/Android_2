package edu.poly.baitestmorongtixoa.fragment;

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

import java.util.ArrayList;

import edu.poly.baitestmorongtixoa.DataBase.WorkDataBase;
import edu.poly.baitestmorongtixoa.R;
import edu.poly.baitestmorongtixoa.UpdateActivity;
import edu.poly.baitestmorongtixoa.adapter.WorkAdapter;
import edu.poly.baitestmorongtixoa.objects.Work;

public class ContendFragment extends Fragment implements WorkAdapter.InterfaceItem {
    private RecyclerView recyclerView;
    private WorkAdapter adapter;
    private ArrayList<Work> list = new ArrayList<>();

    public static ContendFragment newInstance() {
        ContendFragment fragment = new ContendFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contend, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView);

        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

        adapter = new WorkAdapter(getContext(), this);
        loadData();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    public void loadData() {
        list = (ArrayList<Work>) WorkDataBase.getInstance(getActivity()).workDao().selectAll();
        adapter.setData(list);
    }

    @Override
    public void onclickDelete(Work work) {
        WorkDataBase.getInstance(getActivity()).workDao().delete(work);
        list = (ArrayList<Work>) WorkDataBase.getInstance(getActivity()).workDao().selectAll();
        adapter.setData(list);
    }


//    Gửi dữ liệu đi rồi gửi dữ liệu lại

    @Override
    public void onclickUpdate(Work work) {
        Intent intent = new Intent(getContext(), UpdateActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object", work);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}