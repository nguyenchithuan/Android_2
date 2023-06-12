package edu.poly.assignment.AdapterFragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.poly.assignment.DAO.DaoKhoanChi;
import edu.poly.assignment.DTO.KhoanChi;
import edu.poly.assignment.R;

public class ThongKeChiAdapter extends RecyclerView.Adapter<ThongKeChiAdapter.ThongKeChiViewHolder>{
    private Context context;
    private DaoKhoanChi dao;
    private ArrayList<KhoanChi> list;
    private String nam = "All";

    public ThongKeChiAdapter(Context context, DaoKhoanChi dao) {
        this.context = context;
        this.dao = dao;
    }

    public void setData(ArrayList<KhoanChi> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    @NonNull
    @Override
    public ThongKeChiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item_thongke_thu, parent, false);
        return new ThongKeChiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThongKeChiViewHolder holder, int position) {

        KhoanChi thongKe = list.get(position);
        if(thongKe == null) {
            return;
        }

        holder.thoiGian.setText(thongKe.getThoiGian());
        // kiểm tra xem minh click vào đâu
        if(nam.equalsIgnoreCase(holder.thoiGian.getText().toString().substring(6))) {
            holder.khoanChi.setText(thongKe.getKhoanChi());
            holder.loaiChi.setText(thongKe.getLoaiChi());
            holder.thoiGian.setText(thongKe.getThoiGian());
        } else {
            holder.khoanChi.setText(null);
            holder.loaiChi.setText(null);
            holder.thoiGian.setText(null);
        }

        // nếu là all thì hiển thị tất của
        if(nam.equalsIgnoreCase("All")) {
            holder.khoanChi.setText(thongKe.getKhoanChi());
            holder.loaiChi.setText(thongKe.getLoaiChi());
            holder.thoiGian.setText(thongKe.getThoiGian());
        }
    }

    @Override
    public int getItemCount() {
        if(list != null) {
            return list.size();
        }
        return 0;
    }

    public class ThongKeChiViewHolder extends RecyclerView.ViewHolder {
        private TextView khoanChi;
        private TextView loaiChi;
        private TextView thoiGian;

        public ThongKeChiViewHolder(@NonNull View itemView) {
            super(itemView);
            khoanChi = itemView.findViewById(R.id.tv_thongKe_khoan);
            loaiChi = itemView.findViewById(R.id.tv_thongKe_loai);
            thoiGian = itemView.findViewById(R.id.tv_thongKe_thoigian);
        }
    }
}
