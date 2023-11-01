package com.example.prueba_mercado_libre.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.prueba_mercado_libre.Domain.SliderItems;
import com.example.prueba_mercado_libre.R;

import java.util.List;

public class SliderAdapters extends RecyclerView.Adapter<SliderAdapters.SliderViewHolder> {
  private List<SliderItems> sliderItemsList;
  private ViewPager2 viewPager2;
  private Context context;


  public SliderAdapters(List<SliderItems> sliderItemsList, ViewPager2 viewPager2) {
    this.sliderItemsList = sliderItemsList;
    this.viewPager2 = viewPager2;
  }

  @NonNull
  @Override
  public SliderAdapters.SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    context = parent.getContext();
    return new SliderViewHolder(LayoutInflater.from(parent.getContext()).inflate(
      R.layout.slide_item_container,parent,false

    ));
  }

  @Override
  public void onBindViewHolder(@NonNull SliderAdapters.SliderViewHolder holder, int position) {
    holder.setImageView(sliderItemsList.get(position));

      if (position==sliderItemsList.size()-2){
        viewPager2.post(runnable);
      }
  }

  @Override
  public int getItemCount() {
    return sliderItemsList.size();
  }

  public class SliderViewHolder extends  RecyclerView.ViewHolder{
    private ImageView imageView;
    public SliderViewHolder(@NonNull View itemView) {
      super(itemView);
      imageView= itemView.findViewById(R.id.imageSlide);

    }
    void  setImageView(SliderItems sliderItems){

      RequestOptions requestOptions= new RequestOptions();
      requestOptions= requestOptions.transforms(new CenterCrop(),new RoundedCorners(60));

      Glide.with(context)
        .load(sliderItems.getImage())
        .apply(requestOptions)
        .into(imageView);
    }

  }


  private Runnable runnable = new Runnable() {
    @Override
    public void run() {
      sliderItemsList.addAll(sliderItemsList);
      notifyDataSetChanged();
    }
  };
}
