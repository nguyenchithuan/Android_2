package edu.poly.assignment.AdapterFragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.poly.assignment.DAO.DaoKhoanChi;
import edu.poly.assignment.DTO.KhoanChi;
import edu.poly.assignment.R;

public class LoaiChiAdapter extends RecyclerView.Adapter<LoaiChiAdapter.LoaiChiViewHolder>{
    private Context context;
    private DaoKhoanChi dao;
    private ArrayList<KhoanChi> list;

    public LoaiChiAdapter(Context context, DaoKhoanChi dao) {
        this.context = context;
        this.dao = dao;
    }

    public void setData(ArrayList<KhoanChi> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LoaiChiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item_thu_chi, parent, false);
        return new LoaiChiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoaiChiViewHolder holder, int position) {
        int index = position;
        KhoanChi loaiChi = list.get(position);
        if(loaiChi == null) {
            return;
        }
        holder.loaiChi.setText(loaiChi.getLoaiChi());

        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Thông báo!");
                builder.setMessage("Bạn có muốn xóa hay không ?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dao.delete(loaiChi.getStt());
                        list.remove(index);
                        notifyDataSetChanged();
                        Toast.makeText(context, "Xóa thành công!", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });

        holder.imgUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.layout_update_data);
                EditText ed_update = dialog.findViewById(R.id.ed_update_khoan);
                Button btnCancel = dialog.findViewById(R.id.btn_update_cancel);
                Button btnSive = dialog.findViewById(R.id.btn_update_save);
                TextView tvNameUpdate = dialog.findViewById(R.id.update_name);
                tvNameUpdate.setText("Update Loại Chi");
                ed_update.setText(loaiChi.getLoaiChi());

                btnSive.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        loaiChi.setLoaiChi(ed_update.getText().toString());
                        dao.update(loaiChi);
                        notifyDataSetChanged();
                        Toast.makeText(context, "Update thành công!", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });

                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });

                dialog.show();
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

    public class LoaiChiViewHolder extends RecyclerView.ViewHolder {
        private TextView loaiChi;
        private ImageView imgUpdate;
        private ImageView imgDelete;

        public LoaiChiViewHolder(@NonNull View itemView) {
            super(itemView);
            loaiChi = itemView.findViewById(R.id.tvName_ThuChi);
            imgUpdate = itemView.findViewById(R.id.imgEdit_ThuChi);
            imgDelete = itemView.findViewById(R.id.imgDelete_ThuChi);
        }
    }
}
