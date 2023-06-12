package edu.poly.baikiemtra.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.poly.baikiemtra.ChiTietActivity;
import edu.poly.baikiemtra.R;
import edu.poly.baikiemtra.UpdateActivity;
import edu.poly.baikiemtra.objects.GiaoVien;

public class GiaoVienAdapter extends RecyclerView.Adapter<GiaoVienAdapter.GiaoVienViewHolder> {

    private Context context;
    private ArrayList<GiaoVien> list;
    private InterfaceItem interfaceItem;

    public GiaoVienAdapter(Context context, InterfaceItem interfaceItem) {
        this.context = context;
        this.interfaceItem = interfaceItem;
    }

    public void setData(ArrayList<GiaoVien> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public interface InterfaceItem {
        void onclickDelete(GiaoVien giaoVien);
        void onclickUpdate(GiaoVien giaoVien);
    }

    @NonNull
    @Override
    public GiaoVienViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item_rcv, parent, false);
        return new GiaoVienViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GiaoVienViewHolder holder, int position) {
        GiaoVien giaoVien = list.get(position);
        if(giaoVien == null) {
            return;
        }

        holder.tvName.setText(giaoVien.getName());
        holder.tvTime.setText(giaoVien.getTime());
        holder.tvChuyenNganh.setText(giaoVien.getChuyennganh());

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaceItem.onclickDelete(giaoVien);
            }
        });

        holder.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaceItem.onclickUpdate(giaoVien);
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ChiTietActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("object", giaoVien);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        if(list != null) {
            return list.size();
        }
        return 0;
    }

    public class GiaoVienViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvTime;
        private TextView tvChuyenNganh;
        private ImageView btnDelete;
        private ImageView btnUpdate;

        public GiaoVienViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvTime = itemView.findViewById(R.id.tv_time);
            tvChuyenNganh = itemView.findViewById(R.id.tv_chuyennganh);
            btnDelete = itemView.findViewById(R.id.imgDelete);
            btnUpdate = itemView.findViewById(R.id.imgUpdate);
        }
    }
}

