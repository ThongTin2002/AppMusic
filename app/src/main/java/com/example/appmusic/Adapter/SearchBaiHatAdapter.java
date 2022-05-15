package com.example.appmusic.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmusic.Activity.PlayNhacActivity;
import com.example.appmusic.Model.Baihat;
import com.example.appmusic.R;
import com.example.appmusic.Service.APIService;
import com.example.appmusic.Service.Dataservice;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchBaiHatAdapter extends RecyclerView.Adapter<SearchBaiHatAdapter.ViewHolder> {
    Context context;
    ArrayList<Baihat> mangbaihat;

    public SearchBaiHatAdapter(Context context, ArrayList<Baihat> mangbaihat) {
        this.context = context;
        this.mangbaihat = mangbaihat;
    }

    @NonNull
    @Override
    //anh xa va gan lai moi dong layout trong item
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        //dinh nghia du lieu tung dong
        View view = inflater.inflate(R.layout.dong_search_bai_hat, parent, false);
        return new ViewHolder(view);
    }

    @Override
    //tra du lieu gan cho moi view
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Baihat baihat = mangbaihat.get(position);
        holder.txtTenbaihat.setText(baihat.getTenBaiHat());
        holder.txtCasi.setText(baihat.getCaSi());
        Picasso.with(context).load(baihat.getHinhBaiHat()).into(holder.imgbaihat);
    }

    @Override
    public int getItemCount() {
        return mangbaihat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTenbaihat, txtCasi;
        ImageView imgbaihat, imgluotthich;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTenbaihat = itemView.findViewById(R.id.textviewsearchtenbaihat);
            txtCasi = itemView.findViewById(R.id.textviewsearchcasi);
            imgbaihat = itemView.findViewById(R.id.imageviewSearchbaihat);
            imgluotthich = itemView.findViewById(R.id.imageviewsearchluotthich);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, PlayNhacActivity.class);
                    intent.putExtra("cakhuc", mangbaihat.get(getPosition()));
                    context.startActivity(intent);
                }
            });
            imgluotthich.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imgluotthich.setImageResource(R.drawable.iconloved);
                    //server cap nhat lai luot thich
                    Dataservice dataservice = APIService.getService();
                    Call<String> callback = dataservice.UpdateLuotThich("1", mangbaihat.get(getPosition()).getIdBaiHat());
                    callback.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            String ketqua = response.body();
                            if (ketqua.equals("Success")) {
                                Toast.makeText(context, "Da thich", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(context, "loi", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {

                        }
                    });
                    imgluotthich.setEnabled(false);
                }
            });
        }
    }
}
