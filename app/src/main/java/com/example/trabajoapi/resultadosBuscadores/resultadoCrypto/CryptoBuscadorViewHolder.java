package com.example.trabajoapi.resultadosBuscadores.resultadoCrypto;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabajoapi.R;

public class CryptoBuscadorViewHolder extends RecyclerView.ViewHolder{

    TextView titulo_buscador_crypto, fecha_salida_crypto, valor_moneda_crypto, link_web_crypto, descripcion_crypto;
    ImageView imagen_id_crypto;
    Button boton_anadir_favoritos_crypto, boton_compartir_crypto;

    public CryptoBuscadorViewHolder(@NonNull View itemView) {
        super(itemView);
        titulo_buscador_crypto = itemView.findViewById(R.id.titulo_buscador_crypto);
        fecha_salida_crypto = itemView.findViewById(R.id.fecha_salida_crypto);
        valor_moneda_crypto = itemView.findViewById(R.id.valor_moneda_crypto);
        link_web_crypto = itemView.findViewById(R.id.link_web_crypto);
        descripcion_crypto = itemView.findViewById(R.id.descripcion_crypto);
        imagen_id_crypto = itemView.findViewById(R.id.imagen_id_crypto);
        boton_anadir_favoritos_crypto = itemView.findViewById(R.id.boton_anadir_favoritos_crypto);
        boton_compartir_crypto = itemView.findViewById(R.id.boton_compartir_crypto);
    }
}
