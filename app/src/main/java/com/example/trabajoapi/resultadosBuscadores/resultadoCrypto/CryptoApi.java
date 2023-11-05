package com.example.trabajoapi.resultadosBuscadores.resultadoCrypto;

import com.example.trabajoapi.ranking.CoinGeckoResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CryptoApi {
    @GET("coins/")
    Call<CryptoBuscadorPOJO> getCoins();
}
