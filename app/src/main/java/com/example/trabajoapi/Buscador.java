package com.example.trabajoapi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trabajoapi.buscadores.BuscadorCrypto;
import com.example.trabajoapi.buscadores.BuscadorExchanges;
import com.example.trabajoapi.buscadores.buscadorNft.BuscadorNft;

public class Buscador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscador);

        Spinner spinner = findViewById(R.id.spinner);

        // Define un adaptador para el Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.opciones_spinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Configura el Listener para el Spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Obtén la opción seleccionada
                String opcionSeleccionada = parentView.getItemAtPosition(position).toString();

                // Redirige a la actividad correspondiente
                if (opcionSeleccionada.equals("Crypto")) {
                    Intent intent = new Intent(Buscador.this, BuscadorCrypto.class);
                    startActivity(intent);
                } else if (opcionSeleccionada.equals("Exchanges")) {
                    Intent intent = new Intent(Buscador.this, BuscadorExchanges.class);
                    startActivity(intent);
                } else if (opcionSeleccionada.equals("NFTs")) {
                    Intent intent = new Intent(Buscador.this, BuscadorNft.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });

        findViewById(R.id.boton_home).setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        Button botonBuscador = findViewById(R.id.boton_buscador);
        botonBuscador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Muestra un Toast cuando se pulsa el botón
                Toast.makeText(Buscador.this, "Ya se encuentra en la pantalla del buscador", Toast.LENGTH_LONG).show();
            }
        });
        findViewById(R.id.boton_favoritos).setOnClickListener(view -> {
            Intent intent = new Intent(this, Favoritos.class);
            startActivity(intent);
        });

    }
}
