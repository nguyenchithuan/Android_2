package edu.poly.assignment.AdapterFragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
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
import edu.poly.assignment.DAO.DaoLoaiChi;
import edu.poly.assignment.DTO.KhoanChi;
import edu.poly.assignment.DTO.LoaiChi;
import edu.poly.assignment.R;

public class KhoanChiAdapter extends RecyclerView.Adapter<KhoanChiAdapter.KhoanChiViewHolder>{
    private Context context;
    private DaoKhoanChi dao;
    private ArrayList<KhoanChi> list;
    private LoaiChiAdapter loaiChiAdapter;

    public KhoanChiAdapter(Context context, DaoKhoanChi dao) {
        this.context = context;
        this.dao = dao;
    }

    public void setData(ArrayList<KhoanChi> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void setDataAdapter(LoaiChiAdapter loaiChiAdapter) {
        this.loaiChiAdapter = loaiChiAdapter;
    }

    @NonNull
    @Override
    public KhoanChiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item_thu_chi, parent, false);
        return new KhoanChiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KhoanChiViewHolder holder, int position) {
        int index = position;
        KhoanChi khoanChi = list.get(position);
        if(khoanChi == null) {
            return;
        }
        holder.khoanChi.setText(khoanChi.getKhoanChi());

        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Thông báo!");
                builder.setMessage("Bạn có muốn xóa hay không ?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dao.delete(khoanChi.getStt());
                        list.remove(index);
                        loaiChiAdapter.removeName(khoanChi.getKhoanChi());
                        loaiChiAdapter.notifyDataSetChanged();
                        notifyDataSetChanged();
//                        Toast.makeText(context, "Xóa Thành Công!", Toast.LENGTH_SHORT).show();

                        Toast toast = new Toast(context);
                        View view = LayoutInflater.from(context).inflate(R.layout.layout_custom_toast, null);
                        TextView tvName = view.findViewById(R.id.tv_name_custom);
                        tvName.setText("Xóa Thành Công!");
                        toast.setView(view);
                        toast.show();
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
                tvNameUpdate.setText("Update khoản chi");
                ed_update.setText(khoanChi.getKhoanChi());

                Window window = dialog.getWindow();
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                btnSive.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        khoanChi.setKhoanChi(ed_update.getText().toString());
                        dao.update(khoanChi);
                        notifyDataSetChanged();

//                        Toast.makeText(context, "Update thành công!", Toast.LENGTH_SHORT).show();
                        Toast toast = new Toast(context);
                        View view = LayoutInflater.from(context).inflate(R.layout.layout_custom_toast, null);
                        TextView tvName = view.findViewById(R.id.tv_name_custom);
                        tvName.setText("Update thành công!");
                        toast.setView(view);
                        toast.show();


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

    public class KhoanChiViewHolder extends RecyclerView.ViewHolder {

        private TextView khoanChi;
        private ImageView imgUpdate;
        private ImageView imgDelete;

        public KhoanChiViewHolder(@NonNull View itemView) {
            super(itemView);
            khoanChi = itemView.findViewById(R.id.tvName_ThuChi);
            imgUpdate = itemView.findViewById(R.id.imgEdit_ThuChi);
            imgDelete = itemView.findViewById(R.id.imgDelete_ThuChi);
        }
    }
}
