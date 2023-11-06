package com.example.trabajoapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    private static final String BASE_URL = "https://api.coingecko.com/api/v3/";
    private static Retrofit retrofit;

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL) // URL base de la API
                    .addConverterFactory(GsonConverterFactory.create()) // Conversor de JSON
                    .build();
        }
        return retrofit;
    }

}
