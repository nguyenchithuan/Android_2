package edu.poly.assignment.AdapterFragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.poly.assignment.DAO.DaoKhoanThu;
import edu.poly.assignment.DTO.KhoanThu;
import edu.poly.assignment.R;

public class ThongKeThuAdapter extends RecyclerView.Adapter<ThongKeThuAdapter.ThongKeThuViewHolder>{
    private Context context;
    private DaoKhoanThu dao;
    private ArrayList<KhoanThu> list;
    private String nam = "All";

    public ThongKeThuAdapter(Context context, DaoKhoanThu dao) {
        this.context = context;
        this.dao = dao;
    }

    public void setData(ArrayList<KhoanThu> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    @NonNull
    @Override
    public ThongKeThuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item_thongke_thu, parent, false);
        return new ThongKeThuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThongKeThuViewHolder holder, int position) {
        KhoanThu thongKeThu = list.get(position);
        if(thongKeThu == null) {
            return;
        }

        holder.thoiGian.setText(thongKeThu.getThoiGian());

        // kiểm tra xem minh click vào đâu
        if(nam.equalsIgnoreCase(holder.thoiGian.getText().toString().substring(6))) {
            holder.khoanThu.setText(thongKeThu.getKhoanThu());
            holder.loaiThu.setText(thongKeThu.getLoaiThu());
            holder.thoiGian.setText(thongKeThu.getThoiGian());
        } else {
            holder.khoanThu.setText(null);
            holder.loaiThu.setText(null);
            holder.thoiGian.setText(null);
        }

        // nếu là all thì hiển thị tất của
        if(nam.equalsIgnoreCase("All")) {
            holder.khoanThu.setText(thongKeThu.getKhoanThu());
            holder.loaiThu.setText(thongKeThu.getLoaiThu());
            holder.thoiGian.setText(thongKeThu.getThoiGian());
        }
    }

    @Override
    public int getItemCount() {
        if(list != null) {
            return list.size();
        }
        return 0;
    }

    public class ThongKeThuViewHolder extends RecyclerView.ViewHolder {
        private TextView khoanThu;
        private TextView loaiThu;
        private TextView thoiGian;

        public ThongKeThuViewHolder(@NonNull View itemView) {
            super(itemView);
            khoanThu = itemView.findViewById(R.id.tv_thongKe_khoan);
            loaiThu = itemView.findViewById(R.id.tv_thongKe_loai);
            thoiGian = itemView.findViewById(R.id.tv_thongKe_thoigian);
        }
    }
}
