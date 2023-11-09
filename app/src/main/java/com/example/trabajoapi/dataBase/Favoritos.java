package com.example.trabajoapi.dataBase;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.trabajoapi.Buscador;
import com.example.trabajoapi.MainActivity;
import com.example.trabajoapi.R;
import java.util.List;

public class Favoritos extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FavoritosAdapter favoritosAdapter;

    private List<FavoritosPOJO> favoritosList;
    private DataBaseHelper db;


        @Override
        protected void onCreate(android.os.Bundle savedInstanceState) {
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

            // Inicializa la base de datos
            db = new DataBaseHelper(this);

            // Inicializa la RecyclerView y su adaptador
            recyclerView = findViewById(R.id.recycle_view_favoritos);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            favoritosList = db.favoritosList();
            favoritosAdapter = new FavoritosAdapter(favoritosList);
            recyclerView.setAdapter(favoritosAdapter);

        }

}
