package edu.poly.giaodienapplication.Bai3.gridview;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import edu.poly.giaodienapplication.Bai3.gridview.adapterGridViewTag.AdapterGridViewTag;
import edu.poly.giaodienapplication.Bai3.gridview.data.DataGv;
import edu.poly.giaodienapplication.R;
import edu.poly.giaodienapplication.bai2.Model.SanPham;

public class GridViewFragment extends Fragment {
    GridView gvTag;

    public static GridViewFragment newInstance() {
        GridViewFragment fragment = new GridViewFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_grid_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gvTag = view.findViewById(R.id.gvTag);

        List<DataGv> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new DataGv(R.drawable.apple, "Apple"));
            list.add(new DataGv(R.drawable.android, "Android"));
            list.add(new DataGv(R.drawable.facebook, "FaceBook"));
            list.add(new DataGv(R.drawable.dell, "Dell"));
        }

        AdapterGridViewTag adapter = new AdapterGridViewTag(getActivity(), list, R.layout.item_grid_view);
        gvTag.setAdapter(adapter);
    }
}