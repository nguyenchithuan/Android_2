package edu.poly.slideimageauto.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

import java.util.List;

import edu.poly.slideimageauto.R;
import edu.poly.slideimageauto.objects.Photo;

public class PhotoAdapter extends PagerAdapter {
    private Context mContext;
    private List<Photo> mList;

    public PhotoAdapter(Context mContext, List<Photo> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public int getCount() {
        if(mList != null) {
            return mList.size();
        }
        return 0;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_layout_viewpager_circleindicator_glide, container, false);

        ImageView imageView = view.findViewById(R.id.img_item);

        Photo photo = mList.get(position);

        if (photo != null) {
            Glide.with(mContext).load(photo.getResourseId()).into(imageView);
        }

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
