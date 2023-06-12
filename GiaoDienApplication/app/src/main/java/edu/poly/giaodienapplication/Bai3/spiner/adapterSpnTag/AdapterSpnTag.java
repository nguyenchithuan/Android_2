package edu.poly.giaodienapplication.Bai3.spiner.adapterSpnTag;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import edu.poly.giaodienapplication.Bai3.spiner.data.DataSpn;
import edu.poly.giaodienapplication.R;

public class AdapterSpnTag extends BaseAdapter {
    private Context context;
    private List<DataSpn> list;
    private int layout;

    public AdapterSpnTag(Context context, List<DataSpn> list, int layout) {
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
            view = LayoutInflater.from(context).inflate(layout, null);
            viewHolder.img = view.findViewById(R.id.imgSpn);
            viewHolder.name = view.findViewById(R.id.tvNameSpn);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.img.setImageResource(list.get(position).getImg());
        viewHolder.name.setText(list.get(position).getName());

        return view;
    }
}
