package edu.poly.giaodienapplication.Bai3.listview.adapterListViewTag;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import edu.poly.giaodienapplication.Bai3.listview.data.DataLv;
import edu.poly.giaodienapplication.R;

public class AdapterListViewTag extends BaseAdapter {
    private Context context;
    private List<DataLv> list;
    private int layout;

    public AdapterListViewTag(Context context, List<DataLv> list, int layout) {
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

    public static class ViewHodel {
        private ImageView img;
        private TextView name;
        private TextView age;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHodel viewHodel = null;

        if(view == null) {
            viewHodel = new ViewHodel();
            view = LayoutInflater.from(context).inflate(layout, null);
            viewHodel.img = view.findViewById(R.id.imgLvTag);
            viewHodel.name = view.findViewById(R.id.tvNameLvTag);
            viewHodel.age = view.findViewById(R.id.tvAgeLvTag);
            view.setTag(viewHodel); // như túi đồ đựng giá trị
        } else {
            viewHodel = (ViewHodel) view.getTag();
        }

        DataLv data = list.get(position);

        viewHodel.img.setImageResource(data.getImg());
        viewHodel.name.setText(data.getName());
        viewHodel.age.setText(data.getAge() + "");

        return view;
    }
}
