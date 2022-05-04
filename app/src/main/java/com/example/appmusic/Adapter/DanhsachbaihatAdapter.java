package com.example.appmusic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmusic.Model.Baihat;
import com.example.appmusic.R;

import java.util.ArrayList;

public class DanhsachbaihatAdapter extends RecyclerView.Adapter<DanhsachbaihatAdapter.ViewHolder> {
    Context context;
    ArrayList<Baihat> mangbaihat;

    public DanhsachbaihatAdapter(Context context, ArrayList<Baihat> mangbaihat) {
        this.context = context;
        this.mangbaihat = mangbaihat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_danh_sach_bai_hat, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Baihat baihat = mangbaihat.get(position);
        holder.txtcasi.setText(baihat.getCaSi());
        holder.txttenbaihat.setText(baihat.getTenBaiHat());
        holder.txtindex.setText(position + 1 + "");

    }

    @Override
    public int getItemCount() {
        return mangbaihat.size();
    }

    //anh xa view trong dong danh sach bai hat xml
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtindex, txttenbaihat, txtcasi;
        ImageView imgluotthich;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtindex = itemView.findViewById(R.id.textviewdanhsachindex);
            txttenbaihat = itemView.findViewById(R.id.textviewtenbaihat);
            txtcasi = itemView.findViewById(R.id.textviewtencasi);
            imgluotthich = itemView.findViewById(R.id.imageviewluotthich);
        }

    }
}
