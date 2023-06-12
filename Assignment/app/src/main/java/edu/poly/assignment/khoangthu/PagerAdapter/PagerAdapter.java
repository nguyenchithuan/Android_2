package edu.poly.assignment.khoangthu.PagerAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import edu.poly.assignment.khoangthu.taglayout.TabLoaiThuFragment;
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
                fragment = new TabKhoanThuFragment().newInstance();
                break;
            case 1:
                fragment = new TabLoaiThuFragment().newInstance();
                break;
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
