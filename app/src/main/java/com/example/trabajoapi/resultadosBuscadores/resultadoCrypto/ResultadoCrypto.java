package com.example.trabajoapi.resultadosBuscadores.resultadoCrypto;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.trabajoapi.APIClient;
import com.example.trabajoapi.R;
import com.example.trabajoapi.ranking.CoinGeckoResponse;
import com.example.trabajoapi.ranking.CoinGekoApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ResultadoCrypto extends AppCompatActivity {
    private TextView nameTextView;
    private TextView genesisDateTextView;
    private TextView descriptionTextView;
    private TextView currentPriceTextView;
    private TextView homepageUrlTextView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_crypto);

        nameTextView = findViewById(R.id.titulo_buscador_crypto);
        genesisDateTextView = findViewById(R.id.fecha_salida_crypto);
        descriptionTextView = findViewById(R.id.descripcion_crypto);
        currentPriceTextView = findViewById(R.id.valor_moneda_crypto);
        homepageUrlTextView = findViewById(R.id.link_web_crypto);
        imageView = findViewById(R.id.imagen_id_crypto);

        // Configura Retrofit
        CryptoApi apiService = APIClient.getRetrofit().create(CryptoApi.class);
        Call<List<CryptoBuscadorPOJO>> call = apiService.detallesMonedaBuscador();

        // Realiza la solicitud a la API
        call.enqueue(new Callback<List<CryptoBuscadorPOJO>>() {
            @Override
            public void onResponse(Call<List<CryptoBuscadorPOJO>> call, Response<List<CryptoBuscadorPOJO>> response) {
                if (response.isSuccessful()) {
                   List<CryptoBuscadorPOJO> cryptoCurrency = response.body();

                    // Muestra los datos en las vistas
                    nameTextView.setText(cryptoCurrency);
                    genesisDateTextView.setText(cryptoCurrency.getGenesisDate());
                    descriptionTextView.setText(cryptoCurrency.getDescription());
                    currentPriceTextView.setText("$" + cryptoCurrency.getCurrentPrice());
                    homepageUrlTextView.setText(cryptoCurrency.getHomepageUrl());

                    // Carga la imagen con Glide
                    String imageUrl = cryptoCurrency.getImageUrl();
                    Glide.with(ResultadoCrypto.this)
                            .load(imageUrl)
                            .into(imageView);
                } else {
                    // Manejo de errores de la API

                }
            }

            @Override
            public void onFailure(Call<List<CryptoBuscadorPOJO>> call, Throwable t) {
                // Manejo de errores de red
            }
        });
    }
}
