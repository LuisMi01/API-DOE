package com.example.trabajoapi.dataBase;

import android.content.Intent;
import android.os.Bundle;
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
        botonBuscador.setOnClickListener(v -> Toast.makeText(Favoritos.this, "Ya se encuentra en la pantalla de favoritos", Toast.LENGTH_LONG).show());

        textNoFavorites = findViewById(R.id.text_no_favorites);

        db = new DataBaseHelper(this);
        RecyclerView recyclerView = findViewById(R.id.recycle_view_favoritos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        favoritosList = new ArrayList<>();
        FavoritosAdapter adapter = new FavoritosAdapter(favoritosList);
        recyclerView.setAdapter(adapter);

        getFavoritos();

        Button botonBorrarFavoritos = findViewById(R.id.boton_borrar_favoritos);
        botonBorrarFavoritos.setOnClickListener(new View.OnClickListener() {
            final Intent intent = new Intent(Favoritos.this, Favoritos.class);
            @Override
            public void onClick(View v) {
                borrarTodosLosFavoritos();
                startActivity(intent);
            }
        });

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

    private void borrarTodosLosFavoritos() {
        if (db != null) {
            db.borrarTodosLosFavoritos();
            Toast.makeText(this, "Se han borrado todos los favoritos", Toast.LENGTH_SHORT).show();
        }
    }

}


