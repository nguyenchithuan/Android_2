package edu.poly.giaodienapplication.Bai3.listview;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.poly.giaodienapplication.Bai3.listview.adapterListViewTag.AdapterListViewTag;
import edu.poly.giaodienapplication.Bai3.listview.data.DataLv;
import edu.poly.giaodienapplication.R;

public class ListViewFragment extends Fragment {
    ListView lvTag;

    public static ListViewFragment newInstance() {
        ListViewFragment fragment = new ListViewFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lvTag = view.findViewById(R.id.lvTag);

        List<DataLv> data = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            data.add(new DataLv(R.drawable.hancock, "hancock", 18));
            data.add(new DataLv(R.drawable.shank, "shank", 35));
        }

        AdapterListViewTag adater = new AdapterListViewTag(getActivity(), data, R.layout.item_listview_tag);

        lvTag.setAdapter(adater);

        lvTag.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "hihi", Toast.LENGTH_SHORT).show();
            }
        });

    }
}