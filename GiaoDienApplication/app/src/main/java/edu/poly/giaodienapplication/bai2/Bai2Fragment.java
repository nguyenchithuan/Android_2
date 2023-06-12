package edu.poly.giaodienapplication.bai2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import edu.poly.giaodienapplication.bai2.Adapter.GridViewAdapter;
import edu.poly.giaodienapplication.bai2.Model.SanPham;
import edu.poly.giaodienapplication.R;

public class Bai2Fragment extends Fragment {

    public static Bai2Fragment newInstance() {
        Bai2Fragment fragment = new Bai2Fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bai2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        GridView gridView = view.findViewById(R.id.id_gridView);
        List<SanPham> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new SanPham(R.drawable.apple, "Apple"));
            list.add(new SanPham(R.drawable.android, "Android"));
            list.add(new SanPham(R.drawable.facebook, "FaceBook"));
            list.add(new SanPham(R.drawable.dell, "Dell"));
        }
        GridViewAdapter adapter = new GridViewAdapter(getActivity(), list, R.layout.item_grid_view);
        gridView.setAdapter(adapter);
    }
}