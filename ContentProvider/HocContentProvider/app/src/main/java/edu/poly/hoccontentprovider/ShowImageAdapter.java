package edu.poly.hoccontentprovider;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

public class ShowImageAdapter extends BaseAdapter {

    private Context context;
    private List<String> list;

    public ShowImageAdapter(Context context, List<String> list) {
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

    public static class ViewHolder{
        private ImageView imv_them;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        if(view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.layout_item_img, parent, false);

            viewHolder.imv_them = view.findViewById(R.id.img_anh);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.imv_them.setImageBitmap(BitmapFactory.decodeFile(list.get(position)));

        return view;
    }
}
