package com.example.trabajoapi.resultadosBuscadores.resultadoCrypto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CryptoApi {
    @GET("coins/{id}")
    Call<CryptoBuscadorPOJO> detallesMonedaBuscador(@Path("id") String id);
}
