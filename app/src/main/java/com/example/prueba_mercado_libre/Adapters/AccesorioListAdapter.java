package com.example.prueba_mercado_libre.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.prueba_mercado_libre.Domain.DetailProduct.Picture;
import com.example.prueba_mercado_libre.R;

import java.util.List;

public class AccesorioListAdapter  extends RecyclerView.Adapter<AccesorioListAdapter.ViewHolder> {
  List<String> images;
  Context context;


  public List<String> getImages() {
    return images;
  }

  public void setImages(List<String> images) {
    this.images = images;
  }

  @NonNull
  @Override
  public AccesorioListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    context = parent.getContext();
    View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_accesorios,parent,false);
    return new ViewHolder(inflate);

  }

  @Override
  public void onBindViewHolder(@NonNull AccesorioListAdapter.ViewHolder holder, int position) {
    Glide.with(context)
      .load(images.get(position))
      .into(holder.pic);
  }

  @Override
  public int getItemCount() {
    return images.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder{
    ImageView pic;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      pic=itemView.findViewById(R.id.ivAccesoriosDetail);

    }
  }
}
