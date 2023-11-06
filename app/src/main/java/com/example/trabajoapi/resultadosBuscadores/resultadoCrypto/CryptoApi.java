package com.example.trabajoapi.resultadosBuscadores.resultadoCrypto;

import com.example.trabajoapi.ranking.CoinGeckoResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CryptoApi {
    @GET("coins/bitcoin")
    Call<List<CryptoBuscadorPOJO>> detallesMonedaBuscador();
}
