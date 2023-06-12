package edu.poly.assignment.thongke;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

import edu.poly.assignment.AdapterFragment.ThongKeChiAdapter;
import edu.poly.assignment.AdapterFragment.ThongKeThuAdapter;
import edu.poly.assignment.DAO.DaoLoaiChi;
import edu.poly.assignment.DAO.DaoLoaiThu;
import edu.poly.assignment.DTO.LoaiChi;
import edu.poly.assignment.DTO.LoaiThu;
import edu.poly.assignment.R;

public class ThongKeFragment extends Fragment {
    private Spinner spinner;
    ArrayList<String> listSpinner;
    //--------------Thu-----------------
    private RecyclerView recyclerViewThu;
    private ThongKeThuAdapter adapterThu;
    private ArrayList<LoaiThu> listThu;
    private DaoLoaiThu daoThu;

    //--------------Chi-----------------
    private RecyclerView recyclerViewChi;
    private ThongKeChiAdapter adapterChi;
    private ArrayList<LoaiChi> listChi;
    private DaoLoaiChi daoChi;
    //-----------Spinner-----------




    public static ThongKeFragment newInstance() {
        ThongKeFragment fragment = new ThongKeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_thong_ke, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        spinner = view.findViewById(R.id.spinner_thongKe);
        onSpinner();

        //--------------------------------Thu-----------------------------------
        recyclerViewThu = view.findViewById(R.id.recyclerView_thongKeThu);
        daoThu = new DaoLoaiThu(getContext());
        listThu = daoThu.selectAll();

        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerViewThu.setLayoutManager(manager);

        adapterThu = new ThongKeThuAdapter(getContext(), daoThu);
        adapterThu.setData(listThu);
        recyclerViewThu.setAdapter(adapterThu);



        //--------------------------------Chi-----------------------------------s

        recyclerViewChi = view.findViewById(R.id.recyclerView_thongKeChi);
        daoChi = new DaoLoaiChi(getContext());
        listChi = daoChi.selectAll();

        LinearLayoutManager manager1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerViewChi.setLayoutManager(manager1);

        adapterChi = new ThongKeChiAdapter(getContext(), daoChi);
        adapterChi.setData(listChi);
        recyclerViewChi.setAdapter(adapterChi);
    }


    public void onSpinner() {
        // tọa dữ liệu năm có sẵn ngay lúc đầu
        listSpinner = new ArrayList<>();
        for (int i = 2015; i <= 2022; i++) {
            listSpinner.add(i + "");
        }
        listSpinner.add("All");

        // tạo spinner
        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, listSpinner);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterSpinner);
        // gắp cho nó Trị All ngay lúc đầu
        spinner.setSelection(listSpinner.size() - 1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // sự kiện khi chọn năm thì sẽ set lại adapter
                adapterThu.setNam(listSpinner.get(position));
                adapterThu.notifyDataSetChanged();
                // sự kiện khi chọn năm thì sẽ set lại adapter
                adapterChi.setNam(listSpinner.get(position));
                adapterChi.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        //--------------------Thu------------------
        listThu = daoThu.selectAll();
        adapterThu.setData(listThu);
        adapterThu.notifyDataSetChanged();
        //-------------------Chi-----------------
        listChi = daoChi.selectAll();
        adapterChi.setData(listChi);
        adapterChi.notifyDataSetChanged();
    }

}