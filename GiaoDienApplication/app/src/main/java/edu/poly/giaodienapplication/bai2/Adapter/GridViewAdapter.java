package edu.poly.giaodienapplication.bai2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import edu.poly.giaodienapplication.bai2.Model.SanPham;
import edu.poly.giaodienapplication.R;

public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private List<SanPham> list;
    private int layout;

    public GridViewAdapter(Context context, List<SanPham> list, int layout) {
        this.context = context;
        this.list = list;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder {
        private ImageView img_anh;
        private TextView tenUngDung;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder mViewHolder = null;

        if(view == null) {
            mViewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(layout, null);

            mViewHolder.img_anh = view.findViewById(R.id.img_anh);
            mViewHolder.tenUngDung = view.findViewById(R.id.tv_tenUngDung);
            view.setTag(mViewHolder); // như một cái túi đựng dữ liệu
        } else {
            mViewHolder = (ViewHolder) view.getTag();
        }

        mViewHolder.img_anh.setImageResource(list.get(position).getAnh());
        mViewHolder.tenUngDung.setText(list.get(position).getTenUngDung());

        return view;
    }
}
