package com.example.trabajoapi;

import com.example.trabajoapi.ranking.CoinGeckoResponse;

import java.lang.ref.Cleaner;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MainActivityAPI {
   @GET("ping")
   Call<MainActivityPOJO> getPing();

}
