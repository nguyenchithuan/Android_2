package edu.poly.giaodienapplication.Bai3.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import edu.poly.giaodienapplication.Bai3.gridview.GridViewFragment;
import edu.poly.giaodienapplication.Bai3.listview.ListViewFragment;
import edu.poly.giaodienapplication.Bai3.spiner.SpinerFragment;

public class ViewpagerAdapter extends FragmentStateAdapter {

    public ViewpagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    } // khởi tạo một adapter truyền vào activity

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = ListViewFragment.newInstance();
                break;
            case 1:
                fragment = GridViewFragment.newInstance();
                break;
            case 2:
                fragment = SpinerFragment.newInstance();
                break;
        }
        return fragment;
    } // trả lại một fragment

    @Override
    public int getItemCount() {
        return 3; // muốn trả bn thì gõ vào đây
    }// trả về số lượng các màn hình

}
