package com.example.trabajoapi.ranking;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.trabajoapi.R;
import com.example.trabajoapi.dataBase.DataBaseHelper;
import java.util.List;

public class CryptoRankingAdapter extends RecyclerView.Adapter<CryptoRankingViewHolder>{


    private final List<Coin> dataList;

    private DataBaseHelper db;


    public CryptoRankingAdapter(List<Coin> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public CryptoRankingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_tarjeta_ranking_monedas, parent, false);
        return new CryptoRankingViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CryptoRankingViewHolder holder, int position) {
        Coin coin = dataList.get(position);
        Item item = coin.getItem();

        holder.nombre_moneda.setText("Nombre\n" + item.getName());
        holder.score_moneda.setText("Ranking\n#" + item.getScore());
        holder.precio_moneda.setText("Precio\n" + item.getPrice_btc() + " BTC");

        Glide.with(holder.itemView.getContext())
                .load(item.getSmall())
                .apply(RequestOptions.circleCropTransform()).override(400, 400)
                .into(holder.imagen_moneda);


        final boolean[] esFavorito = {isFavorite(item.getName(), holder.itemView.getContext())};

        // Cambiar el fondo del botón y el texto en consecuencia
        if (esFavorito[0]) {
            holder.boton_favorito.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(holder.itemView.getContext(), R.color.colorBotonNoFavorito)));
            holder.boton_favorito.setText("Eliminar de favoritos");
        } else {
            holder.boton_favorito.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(holder.itemView.getContext(), R.color.colorBotonFavorito)));
            holder.boton_favorito.setText("Añadir a favoritos");
        }

        // Configurar el clic del botón
        holder.boton_favorito.setOnClickListener(view -> {
            // Actualizar la base de datos y cambiar el color del botón y el texto en consecuencia
            if (esFavorito[0]) {
                removeFromFavorites(item.getName(), view.getContext());
                holder.boton_favorito.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(view.getContext(), R.color.colorBotonFavorito)));
                holder.boton_favorito.setText("Añadir a favoritos");
                Toast.makeText(view.getContext(), "Eliminado de favoritos", Toast.LENGTH_SHORT).show();
            } else {
                addToFavorites(item.getName(), view.getContext());
                holder.boton_favorito.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(view.getContext(), R.color.colorBotonNoFavorito)));
                holder.boton_favorito.setText("Eliminar de favoritos");
                Toast.makeText(view.getContext(), "Añadido a favoritos", Toast.LENGTH_SHORT).show();
            }
            // Actualizar el estado de esFavorito después de hacer clic
            esFavorito[0] = !esFavorito[0];
        });
    }

    private void removeFromFavorites(String nombreMoneda, Context context) {
        DataBaseHelper baseDatos = new DataBaseHelper(context);

        // Quitar de favoritos
        baseDatos.unmarkAsFavorite(nombreMoneda);
        baseDatos.close();

        // Mostrar un Toast o mensaje de confirmación si lo deseas
        Toast.makeText(context, "Eliminado de favoritos", Toast.LENGTH_SHORT).show();
        Log.d("Database", "Objeto eliminado de favoritos: " + nombreMoneda);
    }

    private boolean isFavorite(String nombreMoneda, Context context) {
        // Verificar si el objeto está en favoritos utilizando tu método isFavorite en DatabaseAPI
        DataBaseHelper baseDatos = new DataBaseHelper(context);
        boolean esFavorito = baseDatos.isFavorite(nombreMoneda);
        baseDatos.close();
        return esFavorito;

    }

    private void addToFavorites(String nombreMoneda, Context context) {
        DataBaseHelper baseDatos = new DataBaseHelper(context);

        // Añadir a favoritos
        baseDatos.markAsFavorite(nombreMoneda);
        baseDatos.close(); // Cerrar la base de datos

        // Puedes mostrar un Toast u otra retroalimentación aquí si lo deseas
        Toast.makeText(context, "Añadido a favoritos", Toast.LENGTH_SHORT).show();
        Log.d("Database", "Objeto añadido a favoritos: " + nombreMoneda);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}


