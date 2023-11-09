package com.example.trabajoapi.buscadores.buscadorNft;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NftApi {
    @GET("nfts/list?per_page=100&page=1")
    Call<List<NftPOJO>> getNfts();
}
