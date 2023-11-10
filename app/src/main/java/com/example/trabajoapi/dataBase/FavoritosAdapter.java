package com.example.trabajoapi.dataBase;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.trabajoapi.R;
import com.example.trabajoapi.resultadosBuscadores.resultadoCrypto.ResultadoCrypto;
import java.util.List;

public class FavoritosAdapter extends RecyclerView.Adapter<FavoritosViewHolder>{
    private final List<FavoritosPOJO> favoritosList;

    public FavoritosAdapter(List<FavoritosPOJO> favoritosList) {
        this.favoritosList = favoritosList;
    }

    @NonNull
    @Override
    public FavoritosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_tarjeta_favorito, parent, false);
        return new FavoritosViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull FavoritosViewHolder holder, int position) {
        FavoritosPOJO favoritos = favoritosList.get(position);
        holder.nombreBaseDatos.setText(favoritos.getName());
        holder.botonBaseDatos.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), ResultadoCrypto.class);
            intent.putExtra("cryptoId", favoritos.getName().toLowerCase());
            view.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return favoritosList.size();
    }
}