package com.example.trabajoapi;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

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

                String opcionSeleccionada = parentView.getItemAtPosition(position).toString();
                switch (opcionSeleccionada) {
                    case "Crypto": {
                        Intent intent = new Intent(Buscador.this, BuscadorCrypto.class);
                        startActivity(intent);
                        break;
                    }
                    case "Exchanges": {
                        Intent intent = new Intent(Buscador.this, BuscadorExchanges.class);
                        startActivity(intent);
                        break;
                    }
                    case "Precios": {
                        Intent intent = new Intent(Buscador.this, BuscadorPrecios.class);
                        startActivity(intent);
                        break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // No es necesario implementar nada aquí
            }
        });
    }
}
