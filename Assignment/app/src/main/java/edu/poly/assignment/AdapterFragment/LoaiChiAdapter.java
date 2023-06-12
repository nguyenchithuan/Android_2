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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
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

public class LoaiChiAdapter extends RecyclerView.Adapter<LoaiChiAdapter.LoaiChiViewHolder>{
    private Context context;
    private DaoLoaiChi dao;
    private ArrayList<LoaiChi> list;
    private ArrayList<KhoanChi> listKhoanChi;

    public LoaiChiAdapter(Context context, DaoLoaiChi dao) {
        this.context = context;
        this.dao = dao;
    }

    public void setData(ArrayList<LoaiChi> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void setDataDao(ArrayList<KhoanChi> listKhoanChi) {
        this.listKhoanChi = listKhoanChi;
    }

    @NonNull
    @Override
    public LoaiChiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_loai_thuchi, parent, false);
        return new LoaiChiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoaiChiViewHolder holder, int position) {
        int index = position;
        LoaiChi loaiChi = list.get(position);
        if(loaiChi == null) {
            return;
        }

        holder.khoanChi.setText(loaiChi.getKhoanChi());
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
//                        Toast.makeText(context, "Xóa thành công!", Toast.LENGTH_SHORT).show();

                        Toast toast = new Toast(context);
                        View view = LayoutInflater.from(context).inflate(R.layout.layout_custom_toast, null);
                        TextView tvName = view.findViewById(R.id.tv_name_custom);
                        tvName.setText("Xóa thành công!");
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
                dialog.setContentView(R.layout.layout_them_moi_data);
                TextView tvKhoanChi = dialog.findViewById(R.id.ed_add_khoan);
                Spinner spnLoaiChi = dialog.findViewById(R.id.spiner_dulieu);
                Button btnSave = dialog.findViewById(R.id.btn_them_save);
                Button btnCancal = dialog.findViewById(R.id.btn_them_cancel);

                Window window = dialog.getWindow();
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                TextView tvName = dialog.findViewById(R.id.tv_name_them);
                tvName.setText("Update Chi");

                tvKhoanChi.setText(loaiChi.getKhoanChi());

                ArrayList<String> duLieuSpinner = new ArrayList<>();

                for (int i = 0; i < listKhoanChi.size(); i++) {
                    duLieuSpinner.add(listKhoanChi.get(i).getKhoanChi());
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, duLieuSpinner);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spnLoaiChi.setAdapter(adapter);

                // chọn dữ liệu spinner
                for (int i = 0; i < duLieuSpinner.size(); i++) {
                    // kiểm tra spinner chọn và dữ liệu spinner
                    if(duLieuSpinner.get(i).equalsIgnoreCase(loaiChi.getLoaiChi())) {
                        spnLoaiChi.setSelection(i);
                    }
                }

                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        loaiChi.setKhoanChi(tvKhoanChi.getText().toString());
                        loaiChi.setLoaiChi(duLieuSpinner.get(spnLoaiChi.getSelectedItemPosition()));
                        dao.update(loaiChi);
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


                btnCancal.setOnClickListener(new View.OnClickListener() {
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
        private TextView khoanChi;
        private TextView loaiChi;
        private ImageView imgUpdate;
        private ImageView imgDelete;

        public LoaiChiViewHolder(@NonNull View itemView) {
            super(itemView);
            khoanChi = itemView.findViewById(R.id.tvName_khoan);
            loaiChi = itemView.findViewById(R.id.tvName_loai);
            imgUpdate = itemView.findViewById(R.id.imgEdit_loai);
            imgDelete = itemView.findViewById(R.id.imgDelete_loai);
        }
    }

    public void removeName(String name) {
        for (int j = 0; j < list.size(); j++) {
            if(list.get(j).getLoaiChi().equalsIgnoreCase(name)) {
                dao.delete(list.get(j).getStt());
            }
        }
    }
}
