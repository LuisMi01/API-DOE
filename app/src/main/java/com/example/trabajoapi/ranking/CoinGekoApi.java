package com.example.trabajoapi.ranking;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CoinGekoApi {
    @GET("search/trending")
    Call<CryptoDataResponse> getTrendingCryptos();
}
