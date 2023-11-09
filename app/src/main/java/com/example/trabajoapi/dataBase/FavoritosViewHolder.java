package com.example.trabajoapi.dataBase;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabajoapi.R;

public class FavoritosViewHolder extends RecyclerView.ViewHolder {

    TextView nombreBaseDatos;
    Button botonBaseDatos;

    public FavoritosViewHolder(@NonNull View itemView) {
        super(itemView);
        nombreBaseDatos = itemView.findViewById(R.id.nombre_tarjeta_favorito);
        botonBaseDatos = itemView.findViewById(R.id.boton_tarjeta_favorito);
    }
}
