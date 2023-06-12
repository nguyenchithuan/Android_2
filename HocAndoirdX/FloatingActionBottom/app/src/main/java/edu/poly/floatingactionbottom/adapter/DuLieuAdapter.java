package edu.poly.floatingactionbottom.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.poly.floatingactionbottom.R;
import edu.poly.floatingactionbottom.objects.DuLieu;

public class DuLieuAdapter extends RecyclerView.Adapter<DuLieuAdapter.DuLieuViewHolder> {

    private Context context;
    private ArrayList<DuLieu> list;

    public DuLieuAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<DuLieu> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DuLieuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recyclerview, parent, false);
        return new DuLieuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DuLieuViewHolder holder, int position) {
        DuLieu duLieu = list.get(position);
        if(duLieu == null) {
            return;
        }

        holder.content.setText(duLieu.getContent());
    }

    @Override
    public int getItemCount() {
        if(list != null) {
            return list.size();
        }
        return 0;
    }

    public class DuLieuViewHolder extends RecyclerView.ViewHolder {
        private TextView content;

        public DuLieuViewHolder(@NonNull View itemView) {
            super(itemView);
            content = itemView.findViewById(R.id.tvContent);
        }
    }
}
