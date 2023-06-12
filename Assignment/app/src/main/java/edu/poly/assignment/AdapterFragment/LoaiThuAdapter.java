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

import edu.poly.assignment.DAO.DaoKhoanThu;
import edu.poly.assignment.DAO.DaoLoaiThu;
import edu.poly.assignment.DTO.KhoanThu;
import edu.poly.assignment.DTO.LoaiThu;
import edu.poly.assignment.R;

public class LoaiThuAdapter extends RecyclerView.Adapter<LoaiThuAdapter.LoaiThuViewHolder>{
    private Context context;
    private DaoLoaiThu dao;
    private ArrayList<LoaiThu> list;
    private ArrayList<KhoanThu> listKhoanThu;


    public LoaiThuAdapter(Context context, DaoLoaiThu dao) {
        this.context = context;
        this.dao = dao;
    }

    public void setData(ArrayList<LoaiThu> list) {
        this.list = list;
    }

    public void setDataDao(ArrayList<KhoanThu> listKhoanThu) {
        this.listKhoanThu = listKhoanThu;
    }


    @NonNull
    @Override
    public LoaiThuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_loai_thuchi, parent, false);
        return new LoaiThuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoaiThuViewHolder holder, int position) {
        LoaiThu loaiThu = list.get(position);
        int index = position;

        if(loaiThu == null) {
            return;
        }

        holder.khoanThu.setText(loaiThu.getKhoanThu());
        holder.loaiThu.setText(loaiThu.getLoaiThu());

        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Thông báo!");
                builder.setMessage("Bạn có muốn xóa hay không ?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dao.delete(loaiThu.getStt());
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
                TextView tvKhoanThu = dialog.findViewById(R.id.ed_add_khoan);
                Spinner spnLoaiThu = dialog.findViewById(R.id.spiner_dulieu);
                Button btnSave = dialog.findViewById(R.id.btn_them_save);
                Button btnCancal = dialog.findViewById(R.id.btn_them_cancel);


                Window window = dialog.getWindow();
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                TextView tvName = dialog.findViewById(R.id.tv_name_them);
                tvName.setText("Update Thu");

                tvKhoanThu.setText(loaiThu.getKhoanThu());

                ArrayList<String> duLieuSpinner = new ArrayList<>();

                for (int i = 0; i < listKhoanThu.size(); i++) {
                    duLieuSpinner.add(listKhoanThu.get(i).getKhoanThu());
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, duLieuSpinner);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spnLoaiThu.setAdapter(adapter);

                // chọn dữ liệu spinner
                for (int i = 0; i < duLieuSpinner.size(); i++) {
                    // kiểm tra spinner chọn và dữ liệu spinner
                    if(duLieuSpinner.get(i).equalsIgnoreCase(loaiThu.getLoaiThu())) {
                        spnLoaiThu.setSelection(i);
                    }
                }
                
                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        loaiThu.setKhoanThu(tvKhoanThu.getText().toString());
                        loaiThu.setLoaiThu(duLieuSpinner.get(spnLoaiThu.getSelectedItemPosition()));
                        dao.update(loaiThu);
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

    public class LoaiThuViewHolder extends RecyclerView.ViewHolder {
        private TextView khoanThu;
        private TextView loaiThu;
        private ImageView imgUpdate;
        private ImageView imgDelete;

        public LoaiThuViewHolder(@NonNull View itemView) {
            super(itemView);
            khoanThu = itemView.findViewById(R.id.tvName_khoan);
            loaiThu = itemView.findViewById(R.id.tvName_loai);
            imgUpdate = itemView.findViewById(R.id.imgEdit_loai);
            imgDelete = itemView.findViewById(R.id.imgDelete_loai);
        }
    }

    public void removeName(String name) {
        for (int j = 0; j < list.size(); j++) {
            if(list.get(j).getLoaiThu().equalsIgnoreCase(name)) {
                dao.delete(list.get(j).getStt());
            }
        }
    }
}
