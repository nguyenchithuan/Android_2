package edu.poly.giaodienapplication.bai4.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.poly.giaodienapplication.R;
import edu.poly.giaodienapplication.bai4.object.UserObject;

public class RecycleviewAdapter extends RecyclerView.Adapter<RecycleviewAdapter.UserViewHolder>{  // với thằng này chưa extend ngay phải tạo view holder trước

    private Context mContext;
    private ArrayList<UserObject> arrayList;

    public RecycleviewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(ArrayList<UserObject> objects) {
        this.arrayList = objects;
        notifyDataSetChanged(); // cập nhật lại adapter
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        private ImageView img_avata;
        private TextView tvName;

        public UserViewHolder(@NonNull View itemView) { // trỏ được thông qua item view (Chính là cả một cái item_layout)
            super(itemView);
            img_avata = itemView.findViewById(R.id.img_avata);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_recycleview, parent, false);

        return new UserViewHolder(view); // truyền vào thì cái viewHolder mới có cái mà trỏ
    }


    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        UserObject object = arrayList.get(position);
        if(object == null) {
            return;
        }
        holder.tvName.setText(object.getName());
        holder.img_avata.setImageResource(object.getImg_avata());
    }

    @Override
    public int getItemCount() { // cái này là code chuẩn
        if(arrayList != null) // sau if chỉ có 1 câu thì không cần đóng mở ngoặc
            return  arrayList.size();
        return 0;
    } // còn code kiểu cũ thì chưa chặt chẽ nhỡ list null

}
