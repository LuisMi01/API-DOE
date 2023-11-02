package com.example.trabajoapi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Ranking extends AppCompatActivity {
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

        }
}
