package edu.poly.giaodienapplication.Bai3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import edu.poly.giaodienapplication.Bai3.adapter.ViewpagerAdapter;
import edu.poly.giaodienapplication.R;

public class Bai3Fragment extends Fragment {
    private TabLayout mTabLayout;
    private ViewPager2 mViewPager2;
    private ViewpagerAdapter mViewpagerAdapter;

    public static Bai3Fragment newInstance() {
        Bai3Fragment fragment = new Bai3Fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bai3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTabLayout = view.findViewById(R.id.id_tablayout);

        mViewPager2 = view.findViewById(R.id.id_viewpager);
        mViewpagerAdapter = new ViewpagerAdapter(getActivity());
        mViewPager2.setAdapter(mViewpagerAdapter);

        // liên kết taglayout với pager2
        TabLayoutMediator mediator = new TabLayoutMediator(mTabLayout, mViewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("ListView");
                        break;
                    case 1:
                        tab.setText("GridView");
                        break;
                    case 2:
                        tab.setText("Spinner");
                        break;
                }
            }
        });
        mediator.attach();
    }
}