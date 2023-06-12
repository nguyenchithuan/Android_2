package edu.poly.adapter.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import edu.poly.adapter.Model.UngDung;
import edu.poly.adapter.R;

public class Adapter extends BaseAdapter {
    Context context;
    ArrayList<UngDung> list;

    public Adapter(Context context, ArrayList<UngDung> list) {
        this.context = context;
        this.list = list;
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

    public static class ViewHolder{
        private ImageView imgAnh;
        private TextView tvName;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder = null;

        if(view == null) {
            holder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.item_layout, null);
            holder.imgAnh = view.findViewById(R.id.img_anh);
            holder.tvName = view.findViewById(R.id.tvNameItem);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.imgAnh.setImageResource(list.get(position).getImgAnh());
        holder.tvName.setText(list.get(position).getName());

        return view;
    }
}
