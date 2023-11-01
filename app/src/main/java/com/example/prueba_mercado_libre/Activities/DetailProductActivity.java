package com.example.prueba_mercado_libre.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.prueba_mercado_libre.Adapters.AccesorioListAdapter;
import com.example.prueba_mercado_libre.Adapters.ProductListAdapter;
import com.example.prueba_mercado_libre.Domain.DetailProduct.DetailProduct;
import com.example.prueba_mercado_libre.Domain.ListProducts;
import com.example.prueba_mercado_libre.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DetailProductActivity extends AppCompatActivity {
    private RequestQueue mRequestQueue ;
    private StringRequest mStringRequest;
    private ProgressBar progressBarDetailProduct;
    private TextView titleText,priceProduct,wishListProduct,productSummaryInfo, productDesc;
    private String idProduct;
    private ImageView pic2,backImg;
    private RecyclerView.Adapter adaptadorAccesorios, adaptadorTelevision;
    private RecyclerView recyclerViewAccesorios, recyclerViewTelevision;
    private NestedScrollView scrollView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail_product);

    idProduct= getIntent().getStringExtra("id");
    initView();
    sendRequestSProductsSamsung();
    sendRequest();
    sendRequestSProductsSimilares();
  }

  private void sendRequest() {
    mRequestQueue= Volley.newRequestQueue(this);
    progressBarDetailProduct.setVisibility(View.VISIBLE);
    scrollView.setVisibility(View.GONE);

    mStringRequest= new StringRequest(Request.Method.GET, "https://api.mercadolibre.com/items?ids=".concat(idProduct), new Response.Listener<String>() {
      @Override
      public void onResponse(String response) {
        Gson gson= new Gson();
        progressBarDetailProduct.setVisibility(View.GONE);
        scrollView.setVisibility(View.VISIBLE);
        DetailProduct items = new Gson().fromJson(response,DetailProduct.class );

        Glide.with(DetailProductActivity.this)
          .load(items.getBody().getPictures().get(0).getUrl())
          .into(pic2);

        titleText.setText(items.getBody().getTitle());
        priceProduct.setText(items.getBody().getPrice());
        wishListProduct.setText(items.getBody().getAvailableQuantity());
        productSummaryInfo.setText(items.getBody().getCurrencyId());
        productDesc.setText(items.getBody().getCondition());
        if (items.getBody().getCondition() !=null){
          List<String> images = new ArrayList<String>();
          images.addAll(Collections.singleton(items.getBody().getPictures().get(0).getId()));
          //  adaptadorAccesorios = new AccesorioListAdapter(images);
        }

      }
    }, new Response.ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {
        progressBarDetailProduct.setVisibility(View.GONE);

      }
    });
    mRequestQueue.add(mStringRequest);
  }

  private void sendRequestSProductsSimilares() {
    mRequestQueue= Volley.newRequestQueue(this);
    progressBarDetailProduct.setVisibility(View.VISIBLE);
    scrollView.setVisibility(View.GONE);

    mStringRequest= new StringRequest(Request.Method.GET, "https://api.mercadolibre.com/sites/MLA/search?q=smartv%20G6", new Response.Listener<String>() {
      @Override
      public void onResponse(String response) {
        ListProducts items = new Gson().fromJson(response,ListProducts.class );
        // Toast.makeText(Dashboard.this,response,Toast.LENGTH_LONG);
        //  Log.i("Dash",response.toString());
        adaptadorAccesorios =new ProductListAdapter(items);
        recyclerViewAccesorios.setAdapter(adaptadorAccesorios);
      }
    }, new Response.ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {

      }
    });
    mRequestQueue.add(mStringRequest);
  }

  private void sendRequestSProductsSamsung() {
    mRequestQueue= Volley.newRequestQueue(this);
    progressBarDetailProduct.setVisibility(View.VISIBLE);
    scrollView.setVisibility(View.GONE);

    mStringRequest= new StringRequest(Request.Method.GET, "https://api.mercadolibre.com/sites/MLA/search?q=samsung%20G6", new Response.Listener<String>() {
      @Override
      public void onResponse(String response) {
        ListProducts items = new Gson().fromJson(response,ListProducts.class );
        adaptadorTelevision =new ProductListAdapter(items);
        recyclerViewTelevision.setAdapter(adaptadorTelevision0);
      }
    }, new Response.ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {

      }
    });
    mRequestQueue.add(mStringRequest);
  }


  private void initView() {
    titleText = findViewById(R.id.etNameProduct);
    progressBarDetailProduct =findViewById(R.id.progressBarDetail);
    scrollView = findViewById(R.id.scrollView2);
    pic2= findViewById(R.id.ivDetailProduct);
    priceProduct = findViewById(R.id.etProductPrice);
    wishListProduct = findViewById(R.id.startProduct);
    productSummaryInfo = findViewById(R.id.tvDetailSummary);
    productDesc = findViewById(R.id.tv19);
    backImg = findViewById(R.id.backDetail);
    recyclerViewAccesorios = findViewById(R.id.rvDetailProduct);
    recyclerViewAccesorios.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    recyclerViewTelevision = findViewById(R.id.imagesRecycler);
    recyclerViewTelevision.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

    backImg.setOnClickListener(view -> {
      finish();
    });

  }
}