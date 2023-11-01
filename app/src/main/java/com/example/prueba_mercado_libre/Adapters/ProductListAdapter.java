package com.example.prueba_mercado_libre.Adapters;

import android.annotation.SuppressLint;
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
import com.example.prueba_mercado_libre.Domain.ListProducts;
import com.example.prueba_mercado_libre.R;

public class ProductListAdapter  extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {
  ListProducts items;
  Context context;

  public ProductListAdapter(ListProducts items) {
    this.items = items;
  }

  @NonNull
  @Override
  public ProductListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    context= parent.getContext();
    View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_product,parent,false);
    return new ViewHolder(inflate);
  }

  @Override
  public void onBindViewHolder(@NonNull ProductListAdapter.ViewHolder holder, int position) {
    holder.nameProduct.setText(items.getResults().get(position).getTitle());
    RequestOptions requestOptions = new RequestOptions();
    requestOptions=requestOptions.transform(new CenterCrop(), new RoundedCorners(30));
   requestOptions
      .placeholder(R.mipmap.ic_launcher_round)
      .error(R.mipmap.ic_launcher_round);

   /* Glide.with(context)
      .load(items.getResults().get(position).getThumbnail())
      .into(holder.pic);*/
  // String url = items.getResults().get(position).getThumbnail()

    Glide.with(context).load(items.getResults().get(position).getThumbnail()).apply(requestOptions).into(holder.pic);


    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(holder.itemView.getContext(), DetailProductActivity.class);
        intent.putExtra("id",items.getResults().get(position).getId());
        context.startActivity(intent);

      }
    });


  }

  @Override
  public int getItemCount() {
    return items != null ? items.getResults().size() : 0;
  }

  public class ViewHolder extends RecyclerView.ViewHolder{
    TextView nameProduct;
    ImageView pic;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      nameProduct= itemView.findViewById(R.id.tvNameProductBase);
      pic = itemView.findViewById(R.id.ivProductReal);


    }
  }
}
