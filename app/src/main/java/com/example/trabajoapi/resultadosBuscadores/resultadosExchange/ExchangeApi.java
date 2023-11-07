package com.example.trabajoapi.resultadosBuscadores.resultadosExchange;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ExchangeApi {
    @GET("exchanges/{id}")
    Call<ExchangeBuscadorPOJO> detallesExchangeBuscador(@Path("id") String id);
}
