package com.example.ass2manhttph28172.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.ass2manhttph28172.R;
import com.example.ass2manhttph28172.adapter.ThuViewpagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class ThuFragment extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    ThuViewpagerAdapter adapter;
    public ThuFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_thu, container, false);
        tabLayout = view.findViewById(R.id.tablayout_thu);
        viewPager = view.findViewById(R.id.viewpager_thu);
        adapter= new ThuViewpagerAdapter(getActivity().getSupportFragmentManager());
        //set adapter cho viewpager
        viewPager.setAdapter(adapter);
        //set viewpager vao tablayout
        tabLayout.setupWithViewPager(viewPager);
        return view;

    }
}