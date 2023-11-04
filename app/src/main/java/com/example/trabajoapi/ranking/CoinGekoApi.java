package com.example.trabajoapi.ranking;

import com.example.trabajoapi.ranking.CryptoRankingPOJO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CoinGekoApi {
    @GET("search/trending")
    Call<CryptoDataResponse> getTrendingCryptos();
}
