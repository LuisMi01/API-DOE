package com.example.trabajoapi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MainActivityAPI {
   @GET("ping")
   Call<MainActivityPOJO> getPing();

}
