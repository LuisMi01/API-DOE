package com.example.trabajoapi.ranking;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.trabajoapi.APIClient;
import com.example.trabajoapi.R;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Ranking extends AppCompatActivity {

    private RecyclerView recyclerView;

    private CryptoRankingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        recyclerView = (RecyclerView) findViewById(R.id.cajon_moneda);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new CryptoRankingAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);
        fetchCryptoRanking();

    }

    private void fetchCryptoRanking() {
        CoinGekoApi apiService = APIClient.getRetrofit().create(CoinGekoApi.class);
        Call<CoinGeckoResponse> call = apiService.getCoins();
        call.enqueue(new Callback<CoinGeckoResponse>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(Call<CoinGeckoResponse> call, Response<CoinGeckoResponse> response) {
                if (response.isSuccessful()) {
                    CoinGeckoResponse coinGeckoResponse = response.body();
                    List<CryptoRankingPOJO> cryptoRankings = coinGeckoResponse.getCoins();
                    // Procesa y muestra los datos en la interfaz de usuario utilizando tu adaptador
                    adapter = new CryptoRankingAdapter(cryptoRankings);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                } else {
                    Log.e("MAINACTIVITY_CONSUMOAPI", "Error en la respuesta: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<CoinGeckoResponse> call, Throwable t) {
                // Maneja errores de la solicitud

                Toast.makeText(Ranking.this, "Error en la petición", Toast.LENGTH_LONG).show();
            }
        });

    }
}
