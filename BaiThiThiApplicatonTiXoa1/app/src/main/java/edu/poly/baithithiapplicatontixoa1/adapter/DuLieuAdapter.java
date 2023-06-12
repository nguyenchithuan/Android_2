package edu.poly.baithithiapplicatontixoa1.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;

import edu.poly.baithithiapplicatontixoa1.ChiTietActivity;
import edu.poly.baithithiapplicatontixoa1.InterfaceDelete;
import edu.poly.baithithiapplicatontixoa1.R;
import edu.poly.baithithiapplicatontixoa1.dao.DulieuDao;
import edu.poly.baithithiapplicatontixoa1.objects.DuLieu;

public class DuLieuAdapter extends RecyclerView.Adapter<DuLieuAdapter.DulieuViewHolder> {
    private Context context;
    private ArrayList<DuLieu> list;
    private InterfaceDelete interfaceDelete;


    public DuLieuAdapter(Context context, InterfaceDelete interfaceDelete) {
        this.context = context;
        this.interfaceDelete = interfaceDelete;
    }

    public void setData(ArrayList<DuLieu> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DulieuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item_recyclecview, parent, false);
        return new DulieuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DulieuViewHolder holder, int position) {
        DuLieu duLieu = list.get(position);
        int index = position;
        if(duLieu == null) {
            return;
        }

        holder.tvNoiDung.setText(duLieu.getNoiDung());
        holder.tvThoiGian.setText(duLieu.getThoiGian());
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Cách 1: xóa cả dao và list
//                DulieuDao dao;
//                dao = new DulieuDao(context);
//                dao.delete(duLieu);
//                list.remove(index);
//                notifyDataSetChanged();

//                Cách 2: nén nó ra ngoài để sử lý băng inteface
                interfaceDelete.onClickDeleteListioner(duLieu);

                Toast.makeText(context, "Xóa thành công!", Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ChiTietActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("dulieu",  duLieu);
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

    public class DulieuViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNoiDung;
        private TextView tvThoiGian;
        private ImageView imgDelete;

        public DulieuViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNoiDung = itemView.findViewById(R.id.tvNoiDung);
            tvThoiGian = itemView.findViewById(R.id.tvThoiGian);
            imgDelete = itemView.findViewById(R.id.imgDelete);
        }
    }
}
