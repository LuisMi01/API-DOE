package com.example.trabajoapi.dataBase;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.trabajoapi.R;
import com.example.trabajoapi.buscadores.buscadorNft.NftPOJO;
import com.example.trabajoapi.resultadosBuscadores.resultadoNft.nftDetalle.NftDetalle;

import java.util.List;

public class FavoritosAdapter extends RecyclerView.Adapter<FavoritosViewHolder>{
    private List<FavoritosPOJO> dataList;

    public FavoritosAdapter(List<FavoritosPOJO> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public FavoritosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_tarjeta_favorito, parent, false);
        return new FavoritosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritosViewHolder holder, int position) {
        FavoritosPOJO data = dataList.get(position);
        holder.nombreBaseDatos.setText("Nombre:\n" + data.getName());
        holder.precioBaseDatos.setText("Precio:\n"+data.getPrice() + " $");
        Glide.with(holder.itemView.getContext())
                .load(data.getImage())
                .apply(RequestOptions.circleCropTransform()).override(100, 100)
                .into(holder.imagenBaseDatos);
        holder.botonBaseDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //eliminar de favoritos
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}


