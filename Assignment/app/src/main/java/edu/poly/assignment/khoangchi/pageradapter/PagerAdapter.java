package edu.poly.assignment.khoangchi.pageradapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import edu.poly.assignment.khoangchi.KhoangChiFragment;
import edu.poly.assignment.khoangchi.tablayout.TabKhoangChiFragment;
import edu.poly.assignment.khoangchi.tablayout.TabLoaiChiFragment;
import edu.poly.assignment.khoangthu.taglayout.TabKhoanThuFragment;

public class PagerAdapter extends FragmentStateAdapter {
    public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = TabKhoangChiFragment.newInstance();
                break;
            case 1:
                fragment = TabLoaiChiFragment.newInstance();
                break;
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
