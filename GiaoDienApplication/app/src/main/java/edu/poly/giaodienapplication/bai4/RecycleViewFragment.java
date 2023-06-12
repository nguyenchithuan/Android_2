package edu.poly.giaodienapplication.bai4;

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
import java.util.List;

import edu.poly.giaodienapplication.R;
import edu.poly.giaodienapplication.bai4.adapter.RecycleviewAdapter;
import edu.poly.giaodienapplication.bai4.object.UserObject;

public class RecycleViewFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecycleviewAdapter adapter;

    public static RecycleViewFragment newInstance() {
        RecycleViewFragment fragment = new RecycleViewFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycle_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.id_recyclerView);
        // để hiển thị được phải xây dựng layoutmenager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecycleviewAdapter(getActivity());
        adapter.setData(createData());
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<UserObject> createData() {
        ArrayList<UserObject> list = new ArrayList<>();
        list.add(new UserObject("android", R.drawable.android));
        list.add(new UserObject("apple", R.drawable.apple));
        list.add(new UserObject("dell", R.drawable.dell));
        list.add(new UserObject("chrome", R.drawable.chrome));
        list.add(new UserObject("facebook", R.drawable.facebook));
        list.add(new UserObject("blogger", R.drawable.blogger));
        list.add(new UserObject("android", R.drawable.android));
        list.add(new UserObject("apple", R.drawable.apple));
        list.add(new UserObject("dell", R.drawable.dell));
        list.add(new UserObject("chrome", R.drawable.chrome));
        list.add(new UserObject("facebook", R.drawable.facebook));
        list.add(new UserObject("blogger", R.drawable.blogger));
        list.add(new UserObject("android", R.drawable.android));
        list.add(new UserObject("apple", R.drawable.apple));
        list.add(new UserObject("dell", R.drawable.dell));
        list.add(new UserObject("chrome", R.drawable.chrome));
        list.add(new UserObject("facebook", R.drawable.facebook));
        list.add(new UserObject("blogger", R.drawable.blogger));
        return list;
    }
}