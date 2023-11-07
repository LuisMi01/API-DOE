package com.example.trabajoapi.buscadores.buscadorNft;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.trabajoapi.APIClient;
import com.example.trabajoapi.Buscador;
import com.example.trabajoapi.Favoritos;
import com.example.trabajoapi.MainActivity;
import com.example.trabajoapi.R;
import java.util.List;
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
        recyclerView = findViewById(R.id.recycler_lista_nft);

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

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        obtenerNfts();
    }

    public void obtenerNfts() {
        NftApi apiService = APIClient.getRetrofit().create(NftApi.class);
        Call<List<NftPOJO>> call = apiService.getNfts();
        call.enqueue(new Callback<List<NftPOJO>>() {
            @Override
            public void onResponse(Call<List<NftPOJO>> call, Response<List<NftPOJO>> response) {
                dataList = response.body();
                // Inicializa el adaptador y establece los datos aquí.
                adapter = new NftAdapter(dataList);
                recyclerView.setAdapter(adapter);
                // Notifica al adaptador que los datos han cambiado.
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<NftPOJO>> call, Throwable t) {
                Log.d("NftApi", t.getMessage());
            }
        });
    }
}
