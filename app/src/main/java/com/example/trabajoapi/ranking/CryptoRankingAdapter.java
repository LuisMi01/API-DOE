package com.example.trabajoapi.ranking;

import android.content.Context;
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
import com.example.trabajoapi.resultadosBuscadores.resultadoCrypto.ResultadoCrypto;

import java.util.List;

public class CryptoRankingAdapter extends RecyclerView.Adapter<CryptoRankingViewHolder>{


    private List<Coin> dataList;

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

        holder.boton_favorito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Verificar si el objeto está en favoritos
                boolean esFavorito = isFavorite(item.getName(), view.getContext());
                // Actualizar la base de datos y cambiar el color del botón en consecuencia
                if (esFavorito) {
                    removeFromFavorites(item.getName(), view.getContext());
                    // Cambiar el fondo del botón a verde (o cualquier otro color)
                    holder.boton_favorito.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.colorBotonFavorito));
                    holder.boton_favorito.setText("Añadir\na favoritos");
                } else {
                    addToFavorites(item.getName(), view.getContext());
                    // Cambiar el fondo del botón a rojo (o cualquier otro color)
                    holder.boton_favorito.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.colorBotonNoFavorito));
                    holder.boton_favorito.setText("Eliminar\nde favoritos");
                }
            }
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


