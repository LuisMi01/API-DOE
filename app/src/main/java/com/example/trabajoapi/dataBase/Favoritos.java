package com.example.trabajoapi.dataBase;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.trabajoapi.Buscador;
import com.example.trabajoapi.MainActivity;
import com.example.trabajoapi.R;

import java.util.ArrayList;
import java.util.List;

public class Favoritos extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FavoritosAdapter adapter;
    private List<FavoritosPOJO> favoritosList;
    private DataBaseHelper db;
    private TextView textNoFavorites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        findViewById(R.id.boton_home).setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.boton_buscador).setOnClickListener(view -> {
            Intent intent = new Intent(this, Buscador.class);
            startActivity(intent);
        });

        Button botonBuscador = findViewById(R.id.boton_favoritos);
        botonBuscador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Favoritos.this, "Ya se encuentra en la pantalla de favoritos", Toast.LENGTH_LONG).show();
            }
        });

        textNoFavorites = findViewById(R.id.text_no_favorites);

        db = new DataBaseHelper(this);
        recyclerView = findViewById(R.id.recycle_view_favoritos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        favoritosList = new ArrayList<>();
        adapter = new FavoritosAdapter(favoritosList);
        recyclerView.setAdapter(adapter);

        getFavoritos();

    }

    private void getFavoritos() {
        favoritosList.clear();
        favoritosList.addAll(db.favoritosList());

        if (favoritosList.isEmpty()) {
            textNoFavorites.setVisibility(View.VISIBLE);
        } else {
            textNoFavorites.setVisibility(View.GONE);
        }
    }



}


