package edu.poly.baithithuapplicationtixoa.adapter;

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

import edu.poly.baithithuapplicationtixoa.ChiTietActivity;
import edu.poly.baithithuapplicationtixoa.InterfaceDelete;
import edu.poly.baithithuapplicationtixoa.R;
import edu.poly.baithithuapplicationtixoa.objects.WorkObject;

public class WorkAdapter extends RecyclerView.Adapter<WorkAdapter.WorkViewHolder> {
    private Context context;
    private ArrayList<WorkObject> list;
    private InterfaceDelete interfaceDelete;

    public WorkAdapter(Context context, InterfaceDelete interfaceDelete) {
        this.context = context;
        this.interfaceDelete = interfaceDelete;
    }

    public void setData(ArrayList<WorkObject> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public WorkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycleview, parent, false);
        return new WorkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkViewHolder holder, int position) {
        WorkObject object = list.get(position);
        if(object == null) {
            return;
        }

        holder.tvContend.setText(object.getContend());
        holder.tvTime.setText(object.getTime());

        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // thường dung interface ném nó ra ngoài lớp dùng đến nó để cho thao tác
                interfaceDelete.onclickDeleteListiner(object);
                Toast.makeText(context, "Xóa thành công!", Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ChiTietActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("doituong", object);
                intent.putExtras(bundle);
//                intent.putExtra("dulieu", bundle);
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

    public class WorkViewHolder extends RecyclerView.ViewHolder {
        private TextView tvContend;
        private TextView tvTime;
        private ImageView imgDelete;

        public WorkViewHolder(@NonNull View itemView) {
            super(itemView);
            tvContend = itemView.findViewById(R.id.tvContend);
            tvTime = itemView.findViewById(R.id.tvTimeDate);
            imgDelete = itemView.findViewById(R.id.imgDelete);
        }
    }
}
