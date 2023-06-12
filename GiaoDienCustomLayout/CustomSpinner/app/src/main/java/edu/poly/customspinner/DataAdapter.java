package edu.poly.customspinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DataAdapter extends BaseAdapter  {
    private Context context;
    private ArrayList<Data> list;

    public DataAdapter(Context context, ArrayList<Data> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        if(list != null) {
            return list.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if(view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.layout_item_select, parent, false);
        }

        TextView tvName = view.findViewById(R.id.tvNameSelect);

        Data data = list.get(position);

        tvName.setText(data.getName());

        return view;
    }

    @Override
    public View getDropDownView(int position, View view, ViewGroup parent) {

        if(view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false);
        }

        TextView tvName = view.findViewById(R.id.tvName);

        Data data = list.get(position);

        tvName.setText(data.getName());

        return view;
    }
}
