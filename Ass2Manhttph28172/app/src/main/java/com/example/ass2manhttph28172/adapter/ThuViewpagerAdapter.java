package com.example.ass2manhttph28172.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.ass2manhttph28172.fragment.TabKhoanThuFragment;
import com.example.ass2manhttph28172.fragment.TabLoaiThuFragment;

public class ThuViewpagerAdapter extends FragmentStatePagerAdapter {
    private int count = 2;
    public ThuViewpagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return  new TabLoaiThuFragment();
            case 1:
                return new TabKhoanThuFragment();
            default:
                return new TabLoaiThuFragment();
        }
    }

    @Override
    public int getCount() {
        return count;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title="";
        switch (position) {
            case 0:
                title = "Loại Thu";
                break;
            case 1:
                title = "Khoản Thu";
                break;
        }
        return title;
    }
}

