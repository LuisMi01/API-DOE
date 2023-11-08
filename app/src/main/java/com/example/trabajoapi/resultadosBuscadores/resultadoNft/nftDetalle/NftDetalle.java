package com.example.trabajoapi.resultadosBuscadores.resultadoNft.nftDetalle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.trabajoapi.APIClient;
import com.example.trabajoapi.Buscador;
import com.example.trabajoapi.dataBase.Favoritos;
import com.example.trabajoapi.MainActivity;
import com.example.trabajoapi.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NftDetalle extends AppCompatActivity {
    private TextView nombreNft;
    private TextView assetPlatformNft;
    private TextView descripcionNft;
    private TextView addressNft;
    private TextView symbolNft;
    private TextView precioNft;
    private ImageView imagenNft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_nft);

        obtenerNftDetalle();

        findViewById(R.id.boton_home).setOnClickListener(view -> {
             Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.boton_buscador).setOnClickListener(view -> {
            Intent intent = new Intent(this, Buscador.class);
            startActivity(intent);
        });
        findViewById(R.id.boton_favoritos).setOnClickListener(view -> {
            Intent intent = new Intent(this, Favoritos.class);
            startActivity(intent);
        });

    }

    public void obtenerNftDetalle() {

        nombreNft = findViewById(R.id.titulo_resultado_nft);
        assetPlatformNft = findViewById(R.id.resultado_asset_platform_nft);
        descripcionNft = findViewById(R.id.resultado_description_nft);
        addressNft = findViewById(R.id.resultado_contract_address_nft);
        symbolNft = findViewById(R.id.resultado_symbol_nft);
        precioNft = findViewById(R.id.resultado_precio_usd_nft);
        imagenNft = findViewById(R.id.resultado_imagen_nft);


            NftDetalleApi apiService = APIClient.getRetrofit().create(NftDetalleApi.class);
            String nftId = getIntent().getStringExtra("nft_id");
            Log.d("NftDetalle", nftId);
            Call<NftDetallePOJO> call = apiService.getNftDetalle(nftId);
            Log.d("NftDetalle", call.request().url().toString());
            call.enqueue(new Callback<NftDetallePOJO>() {
                @Override
                public void onResponse(Call<NftDetallePOJO> call, Response<NftDetallePOJO> response) {
                    if (response.isSuccessful()) {
                        NftDetallePOJO nftDetallePOJO = response.body();
                        FloorPrice floorPrice = nftDetallePOJO.getFloor_price();
                        nombreNft.setText(nftDetallePOJO.getName());
                        assetPlatformNft.setText("Plataforma:\n" + nftDetallePOJO.getAsset_platform_id());
                        descripcionNft.setText("Descripcion:\n" + nftDetallePOJO.getDescription());
                        addressNft.setText("Direccion del contrato:\n" + nftDetallePOJO.getContract_address());
                        symbolNft.setText("Símbolo:\n" + nftDetallePOJO.getSymbol());

                        precioNft.setText("Precio (USD):\n" + floorPrice.getUsd() + " $");

                        if (imagenNft != null) {
                            Imagen imagen = nftDetallePOJO.getImage();
                            String urlImagen = imagen.getSmall();
                            Glide.with(NftDetalle.this).load(urlImagen).override(525, 525).into(imagenNft);
                        }
                    } else {
                        Log.e("NftDetalle", response.errorBody().toString());
                    }
                }

                @Override
                public void onFailure(Call<NftDetallePOJO> call, Throwable t) {
                    Log.e("NftDetalle", t.toString());
                }
            });
        }
    }


