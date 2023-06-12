package edu.poly.giaodienapplication.Bai3.spiner;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import edu.poly.giaodienapplication.Bai3.spiner.adapterSpnTag.AdapterSpnTag;
import edu.poly.giaodienapplication.Bai3.spiner.data.DataSpn;
import edu.poly.giaodienapplication.R;

public class SpinerFragment extends Fragment {
    Spinner spnTag;

    public static SpinerFragment newInstance() {
        SpinerFragment fragment = new SpinerFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_spiner, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        spnTag = view.findViewById(R.id.spnTag);

        List<DataSpn> list = new ArrayList<>();
        list.add(new DataSpn(R.drawable.vietnam, "Việt Nam"));
        list.add(new DataSpn(R.drawable.italia, "Italia"));
        list.add(new DataSpn(R.drawable.argentina, "Argentina"));
        list.add(new DataSpn(R.drawable.nhatban, "Nhật Bản"));
        list.add(new DataSpn(R.drawable.hanquoc, "Hàn Quốc"));

        AdapterSpnTag adapter = new AdapterSpnTag(getActivity(), list, R.layout.item_spinner_tag);

        spnTag.setAdapter(adapter);
    }
}