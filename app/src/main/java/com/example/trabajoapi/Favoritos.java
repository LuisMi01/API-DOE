package com.example.trabajoapi;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Favoritos extends AppCompatActivity {

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
                    // Muestra un Toast cuando se pulsa el botón
                    Toast.makeText(Favoritos.this, "Ya se encuentra en la pantalla de favoritos", Toast.LENGTH_LONG).show();
                }
            });
        }
}
