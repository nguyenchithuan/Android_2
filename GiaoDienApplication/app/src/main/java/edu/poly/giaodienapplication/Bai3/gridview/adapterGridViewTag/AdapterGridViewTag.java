package edu.poly.giaodienapplication.Bai3.gridview.adapterGridViewTag;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import edu.poly.giaodienapplication.Bai3.gridview.data.DataGv;
import edu.poly.giaodienapplication.R;

public class AdapterGridViewTag extends BaseAdapter {
    private Context context;
    private List<DataGv> list;
    private int layout;

    public AdapterGridViewTag(Context context, List<DataGv> list, int layout) {
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
        private ImageView img;
        private TextView name;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder = null;

        if(view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.item_grid_view, null);
            viewHolder.img = view.findViewById(R.id.img_anh);
            viewHolder.name = view.findViewById(R.id.tv_tenUngDung);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.img.setImageResource(list.get(position).getImg());
        viewHolder.name.setText(list.get(position).getName());

        return view;
    }
}
