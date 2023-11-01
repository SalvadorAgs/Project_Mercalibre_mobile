package com.example.prueba_mercado_libre.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.prueba_mercado_libre.Activities.DetailProductActivity;
import com.example.prueba_mercado_libre.Domain.CategoryItems;
import com.example.prueba_mercado_libre.Domain.ListProducts;
import com.example.prueba_mercado_libre.R;

import java.util.ArrayList;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder> {
  ArrayList<CategoryItems> items;
  Context context;

  public CategoryListAdapter(ArrayList<CategoryItems> items) {
    this.items = items;
  }

  @NonNull
  @Override
  public CategoryListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    context= parent.getContext();
    View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category,parent,false);
    return new ViewHolder(inflate);
  }

  @Override
  public void onBindViewHolder(@NonNull CategoryListAdapter.ViewHolder holder, int position) {
    holder.nameProduct.setText(items.get(position).getName());
    RequestOptions requestOptions = new RequestOptions();
    requestOptions=requestOptions.transform(new CenterCrop(), new RoundedCorners(30));
   requestOptions
      .placeholder(R.mipmap.ic_launcher_round)
      .error(R.mipmap.ic_launcher_round);

   /* Glide.with(context)
      .load(items.getResults().get(position).getThumbnail())
      .into(holder.pic);*/
  // String url = items.getResults().get(position).getThumbnail()

   // Glide.with(context).load(items.get(position).getThumbnail()).apply(requestOptions).into(holder.pic);


    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(holder.itemView.getContext(), DetailProductActivity.class);
        intent.putExtra("id",items.get(position).getId());
        context.startActivity(intent);

      }
    });


  }

  @Override
  public int getItemCount() {
    return items != null ? items.size() : 0;
  }

  public class ViewHolder extends RecyclerView.ViewHolder{
    TextView nameProduct;
    ImageView pic;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      nameProduct= itemView.findViewById(R.id.TvtitleCategory);
     // pic = itemView.findViewById(R.id.ivProductReal);


    }
  }
}
