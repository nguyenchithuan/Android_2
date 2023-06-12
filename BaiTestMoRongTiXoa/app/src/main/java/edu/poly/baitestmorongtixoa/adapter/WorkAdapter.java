package edu.poly.baitestmorongtixoa.adapter;

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

import edu.poly.baitestmorongtixoa.ChiTietActivity;
import edu.poly.baitestmorongtixoa.R;
import edu.poly.baitestmorongtixoa.UpdateActivity;
import edu.poly.baitestmorongtixoa.objects.Work;

public class WorkAdapter extends RecyclerView.Adapter<WorkAdapter.WorkViewHolder> {

    private Context context;
    private ArrayList<Work> list;
    private InterfaceItem interfaceItem;

    public WorkAdapter(Context context, InterfaceItem interfaceItem) {
        this.context = context;
        this.interfaceItem = interfaceItem;
    }

    public void setData(ArrayList<Work> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public interface InterfaceItem {
        void onclickDelete(Work work);
        void onclickUpdate(Work work);
    }

    @NonNull
    @Override
    public WorkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item_rcv, parent, false);
        return new WorkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkViewHolder holder, int position) {
        Work work = list.get(position);
        if(work == null) {
            return;
        }
        holder.tvContend.setText(work.getContend());
        holder.tvTime.setText(work.getTime());

        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaceItem.onclickDelete(work);
            }
        });

        holder.imgUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaceItem.onclickUpdate(work);
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ChiTietActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("object", work);
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

    public class WorkViewHolder extends RecyclerView.ViewHolder {
        private TextView tvContend;
        private TextView tvTime;
        private ImageView imgUpdate;
        private ImageView imgDelete;

        public WorkViewHolder(@NonNull View itemView) {
            super(itemView);

            tvContend = itemView.findViewById(R.id.tvContend);
            tvTime = itemView.findViewById(R.id.tvTime);
            imgUpdate = itemView.findViewById(R.id.imgUpdate);
            imgDelete = itemView.findViewById(R.id.imgDelete);
        }
    }
}
