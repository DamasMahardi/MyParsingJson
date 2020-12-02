package com.example.mympvpjson.controller.homepage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mympvpjson.R;
import com.example.mympvpjson.model.WisataItem;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {
    private Context context;
    private List<WisataItem> list;
    public MainAdapter(Context context, List<WisataItem> list){
        this.context = context;
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_wisata_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        WisataItem wisataItem = list.get(position);
        Picasso.get().load(wisataItem.getGambarUrl()).error(R.drawable.ic_wisata).into(holder.ivAvatar);
        holder.tvNama.setText(wisataItem.getNama());
        holder.tvKategori.setText(wisataItem.getKategori());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_Avatar)
        ImageView ivAvatar;
        @BindView(R.id.tv_Nama)
        TextView tvNama;
        @BindView(R.id.tv_Kategori)
        TextView tvKategori;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this.itemView);
        }
    }
}
