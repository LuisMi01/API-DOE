package com.example.trabajoapi.buscadores.buscadorNft;

import android.annotation.SuppressLint;
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

public class BuscadorNft extends AppCompatActivity {
    private RecyclerView recyclerView;
    private NftAdapter adapter;
    private List<NftPOJO> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscador_nft);

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

        recyclerView = findViewById(R.id.recycler_lista_nft);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        obtenerNfts();
    }

    public void obtenerNfts() {
        NftApi apiService = APIClient.getRetrofit().create(NftApi.class);
        Call<List<NftPOJO>> call = apiService.getNfts();
        call.enqueue(new Callback<List<NftPOJO>>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(@NonNull Call<List<NftPOJO>> call, @NonNull Response<List<NftPOJO>> response) {
                dataList = response.body();
                adapter = new NftAdapter(dataList);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(@NonNull Call<List<NftPOJO>> call, @NonNull Throwable t) {
                Log.d("NftApi", Objects.requireNonNull(t.getMessage()));
            }
        });
    }
}
