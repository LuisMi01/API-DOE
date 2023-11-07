package com.example.trabajoapi.buscadores.buscadorNft;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabajoapi.R;

public  class NftViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewTitle;
        public TextView textViewSimbolo;
        public TextView textViewContract;
        public TextView textViewPlatform;
        public Button masDetalles;

        public NftViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.id_buscador_nft);
            textViewSimbolo = itemView.findViewById(R.id.simbolo_buscador_nft);
            textViewContract = itemView.findViewById(R.id.contract_address_buscador_nft);
            textViewPlatform = itemView.findViewById(R.id.asset_platform_buscador_nft);
            masDetalles = itemView.findViewById(R.id.boton_buscador_nft);

        }

}
