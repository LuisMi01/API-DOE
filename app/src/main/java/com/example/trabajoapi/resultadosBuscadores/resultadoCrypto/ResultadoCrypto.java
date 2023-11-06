package com.example.trabajoapi.resultadosBuscadores.resultadoCrypto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
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
    private TextView nombbreCrypto;
    private TextView fechaCreacion;
    private CryptoApi apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_crypto);

        obtenerDatosCrypto();

    }
    public void obtenerDatosCrypto() {
        nombbreCrypto = findViewById(R.id.titulo_buscador_crypto);
        fechaCreacion = findViewById(R.id.fecha_salida_crypto);
        // Configura Retrofit

        apiService = APIClient.getRetrofit().create(CryptoApi.class);

        // Realizar una solicitud a la API
        String CryptoResultadoID = "bitcoin";
        Call<CryptoBuscadorPOJO> call = apiService.detallesMonedaBuscador(CryptoResultadoID);
        call.enqueue(new Callback<CryptoBuscadorPOJO>() {
            @Override
            public void onResponse(Call<CryptoBuscadorPOJO> call, Response<CryptoBuscadorPOJO> response) {
                if (response.isSuccessful()) {
                    CryptoBuscadorPOJO datosCrypto = response.body();
                    if (datosCrypto != null) {
                        nombbreCrypto.setText(datosCrypto.getName());
                        fechaCreacion.setText("Fecha de creacion:\n" + datosCrypto.getGenesis_date());
                    }
                } else {
                    nombbreCrypto.setText("Error en la solicitud.");
                }

            }

            @Override
            public void onFailure(Call<CryptoBuscadorPOJO> call, Throwable t) {
                Log.e("ERROR", t.getMessage());
            }
        });
    }

}
