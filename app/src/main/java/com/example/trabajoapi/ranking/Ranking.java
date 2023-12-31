package com.example.trabajoapi.ranking;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.trabajoapi.APIClient;
import com.example.trabajoapi.Buscador;
import com.example.trabajoapi.dataBase.Favoritos;
import com.example.trabajoapi.MainActivity;
import com.example.trabajoapi.R;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Ranking extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CryptoRankingAdapter adapter;
    private List<CryptoRankingPOJO> dataList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

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

        recyclerView = findViewById(R.id.recycler_lista_ranking);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        obtenerRanking();
    }

    public void obtenerRanking() {
        CoinGekoApi apiService = APIClient.getRetrofit().create(CoinGekoApi.class);
        Call<CryptoRankingPOJO> call = apiService.getRankingCoins();
        call.enqueue(new Callback<CryptoRankingPOJO>() {
            @Override
            public void onResponse(@NonNull Call<CryptoRankingPOJO> call, @NonNull Response<CryptoRankingPOJO> response) {
                CryptoRankingPOJO cryptoRankingPOJO = response.body();
                if (cryptoRankingPOJO != null) {
                    List<Coin> coinList = cryptoRankingPOJO.getCoins();
                    adapter = new CryptoRankingAdapter(coinList);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(@NonNull Call<CryptoRankingPOJO> call, @NonNull Throwable t) {
                Log.e("CryptoRankingResponse: ", Objects.requireNonNull(t.getMessage()));
            }
        });
    }
}
