package com.example.trabajoapi.resultadosBuscadores.resultadoNft.nftDetalle;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NftDetalleApi {

    @GET("nfts/{nft_id}")
    Call<NftDetallePOJO> getNftDetalle(@Path("nft_id") String nftId);

}
