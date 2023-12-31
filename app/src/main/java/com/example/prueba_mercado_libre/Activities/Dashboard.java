package com.example.prueba_mercado_libre.Activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import java.lang.reflect.Type;

import com.example.prueba_mercado_libre.Adapters.CategoryListAdapter;
import com.example.prueba_mercado_libre.Domain.CategoryItems;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.prueba_mercado_libre.Adapters.ProductListAdapter;
import com.example.prueba_mercado_libre.Adapters.SliderAdapters;
import com.example.prueba_mercado_libre.Domain.ListProducts;
import com.example.prueba_mercado_libre.Domain.SliderItems;
import com.example.prueba_mercado_libre.R;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Dashboard extends AppCompatActivity {
  private ViewPager2 viewPager2;
  private Handler slideHandler= new Handler();
  private ImageView ivMicrophone ;
  private EditText edSearchDashboard ;
  private RequestQueue mRequestQueue;
  private StringRequest mStringRequest,mStringRequest2,mStringRequest3;
  private ProgressBar loadingBestProducts, loadingOfertas, loadingCategorias;
  RecyclerView.Adapter adapterBestProducts,adapterOfertas, adapterCategorias;
  private RecyclerView recyclerViewBestProducts, recyclerViewOfertas, recyclerViewCategorias;
  private int RO_SPEECH_REC =102;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_dashboard);


    initView();
    banners();
    sendRequestBestProducts();
    sendRequestOfertas();
    sendRequestCategories();
  }

  private void sendRequestBestProducts() {
    mRequestQueue = Volley.newRequestQueue(this);
    loadingBestProducts.setVisibility(View.VISIBLE);
    mStringRequest = new StringRequest(Request.Method.GET, "https://api.mercadolibre.com/sites/MLA/search?category=MLA1055", new Response.Listener<String>() {
      @Override
      public void onResponse(String response) {
       Gson gson = new Gson();
        loadingBestProducts.setVisibility(View.GONE);
        ListProducts items = new Gson().fromJson(response,ListProducts.class );
       // Toast.makeText(Dashboard.this,response,Toast.LENGTH_LONG);
      //  Log.i("Dash",response.toString());
        adapterBestProducts =new ProductListAdapter(items);
        recyclerViewBestProducts.setAdapter(adapterBestProducts);


      }
    }, error -> {
      loadingBestProducts.setVisibility(View.GONE);
      Toast.makeText(Dashboard.this,error.toString(),Toast.LENGTH_LONG);
      Log.i("Dash",error.toString());
    });

    mRequestQueue.add(mStringRequest);

  }


  private void sendRequestOfertas () {
    mRequestQueue = Volley.newRequestQueue(this);
    loadingOfertas.setVisibility(View.VISIBLE);
    mStringRequest3 = new StringRequest(Request.Method.GET, "https://api.mercadolibre.com/sites/MLA/search?q=Motorola%20G6", new Response.Listener<String>() {
      @Override
      public void onResponse(String response) {
        Gson gson = new Gson();
        loadingOfertas.setVisibility(View.GONE);
        ListProducts items = new Gson().fromJson(response,ListProducts.class );
        // Toast.makeText(Dashboard.this,response,Toast.LENGTH_LONG);
        //  Log.i("Dash",response.toString());
        adapterOfertas =new ProductListAdapter(items);
        recyclerViewOfertas.setAdapter(adapterOfertas);


      }
    }, error -> {
      loadingOfertas.setVisibility(View.GONE);
      Toast.makeText(Dashboard.this,error.toString(),Toast.LENGTH_LONG);
      Log.i("Dash",error.toString());
    });

    mRequestQueue.add(mStringRequest3);

  }

  private void sendRequestCategories () {
    mRequestQueue = Volley.newRequestQueue(this);
    loadingCategorias.setVisibility(View.VISIBLE);
    mStringRequest2 = new StringRequest(Request.Method.GET, "https://api.mercadolibre.com/sites/MLA/categories", new Response.Listener<String>() {
      @Override
      public void onResponse(String response) {
        Gson gson = new Gson();
        loadingCategorias.setVisibility(View.GONE);
       ArrayList<CategoryItems> catList=
         gson.fromJson(response, new TypeToken<ArrayList<CategoryItems>>
           (){}.getType());
        adapterCategorias =new CategoryListAdapter(catList);
        recyclerViewCategorias.setAdapter(adapterCategorias);


      }
    }, error -> {
      loadingCategorias.setVisibility(View.GONE);
      Toast.makeText(Dashboard.this,error.toString(),Toast.LENGTH_LONG);
      Log.i("Dash",error.toString());
    });

    mRequestQueue.add(mStringRequest2);

  }

  private void banners() {
    List<SliderItems> sliderItems = new ArrayList<>();
    sliderItems.add(new SliderItems(R.drawable.banner_iphone));
    sliderItems.add(new SliderItems(R.drawable.oferta_samsung_two));
    sliderItems.add(new SliderItems(R.drawable.oferta_pantallas));
    sliderItems.add(new SliderItems(R.drawable.oferta_adidas));

      viewPager2.setAdapter(new SliderAdapters(sliderItems,viewPager2));
      viewPager2.setClipToOutline(false);
      viewPager2.setClipChildren(false);
      viewPager2.setOffscreenPageLimit(3);
      viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);


    CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
    compositePageTransformer.addTransformer(new MarginPageTransformer(40));
    compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
      @Override
      public void transformPage(@NonNull View page, float position) {
        float r=1-Math.abs(position);
        page.setScaleY(0.85f+r*0.15f);



      }
    });

    viewPager2.setPageTransformer(compositePageTransformer);
    viewPager2.setCurrentItem(1);
    viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
      @Override
      public void onPageSelected(int position) {
        super.onPageSelected(position);
        slideHandler.removeCallbacks(sliderRunnable);
      }
    });
  }

  @Override
  protected void onPause() {
    super.onPause();
    slideHandler.removeCallbacks(sliderRunnable);
  }

  @Override
  protected void onResume() {
    super.onResume();
    slideHandler.postDelayed(sliderRunnable,2000);
  }

  private Runnable sliderRunnable= new Runnable() {
    @Override
    public void run() {
      viewPager2.setCurrentItem(viewPager2.getCurrentItem()+1);
    }
  };

  private void initView() {
    viewPager2= findViewById(R.id.viewPagerSlide);
    recyclerViewBestProducts= findViewById(R.id.rvFavoriteProductsDash);
    recyclerViewBestProducts.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    recyclerViewOfertas= findViewById(R.id.rvDiscountsProductsDash);
    recyclerViewOfertas.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    recyclerViewCategorias= findViewById(R.id.rvCategoriesProductsDash);
    recyclerViewCategorias.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    loadingBestProducts = findViewById(R.id.pbDashBoard);
    loadingOfertas = findViewById(R.id.pbDiscountsDashBoard);
    loadingCategorias = findViewById(R.id.pbCategoryDashBoard);
    ivMicrophone = findViewById(R.id.ivmicrophone);
    edSearchDashboard = findViewById(R.id.edSearchDashboard);

    ivMicrophone.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        try {
          askSpeechInput();
        } catch (URISyntaxException e) {
          e.printStackTrace();
        }
      }
    });
    edSearchDashboard.setOnEditorActionListener(new TextView.OnEditorActionListener() {
      @Override
      public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        Intent intent = new Intent(Dashboard.this, DetailProductActivity.class);
        intent.putExtra("id",edSearchDashboard.getText().toString());
        startActivity(intent);
        return false;


      }
    });







  }

  private void askSpeechInput() throws URISyntaxException {
    if (!SpeechRecognizer.isRecognitionAvailable(this)){
      Toast.makeText(this, "El microfono no se encuentra disponible",Toast.LENGTH_LONG).show();
    }else{
      Intent intentSpeech = Intent.getIntent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
      intentSpeech.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
      intentSpeech.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
      intentSpeech.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say something!");
      startActivity(intentSpeech);


    }
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode== RO_SPEECH_REC && resultCode== Activity.RESULT_OK){
      ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
      edSearchDashboard.setText(result.get(0).toString());
    }
  }
}