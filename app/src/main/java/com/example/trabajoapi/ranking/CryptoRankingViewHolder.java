package com.example.trabajoapi.ranking;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabajoapi.R;

public class CryptoRankingViewHolder extends RecyclerView.ViewHolder{
    TextView nombre_moneda, score_moneda, precio_moneda;
    ImageView imagen_moneda;
    Button boton_favorito;

    public CryptoRankingViewHolder(@NonNull View itemView) {
        super(itemView);
        nombre_moneda = itemView.findViewById(R.id.nombre_moneda);
        score_moneda = itemView.findViewById(R.id.score_moneda);
        precio_moneda = itemView.findViewById(R.id.precio_moneda);
        imagen_moneda = itemView.findViewById(R.id.imagen_moneda);
        boton_favorito = itemView.findViewById(R.id.boton_favorito);
    }
}
