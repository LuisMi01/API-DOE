package com.example.trabajoapi.ranking;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabajoapi.R;

public class CryptoRankingViewHolder extends RecyclerView.ViewHolder{
    TextView tv_id_pokemon, tv_pokemonName, tv_type, tv_height, tv_weight, tv_others;

    public CryptoRankingViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_id_pokemon  = itemView.findViewById(R.id.id_pokemon);
        tv_pokemonName = itemView.findViewById(R.id.name);
        tv_type        = itemView.findViewById(R.id.type);
        tv_height      = itemView.findViewById(R.id.height);
        tv_weight      = itemView.findViewById(R.id.weight);
        tv_others      = itemView.findViewById(R.id.others);
    }


}
