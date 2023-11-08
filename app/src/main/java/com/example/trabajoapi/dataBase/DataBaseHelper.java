package com.example.trabajoapi.dataBase;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "base_favoritos_app.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_FAVORITES = "favorites";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_IS_FAVORITE = "is_favorite";

    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_FAVORITES + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_IS_FAVORITE + " INTEGER)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FAVORITES);
        onCreate(db);
    }

    public void markAsFavorite(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DataBaseHelper.COLUMN_NAME, name);
        values.put(DataBaseHelper.COLUMN_IS_FAVORITE, 1); // 1 para favorito, 0 para no favorito
        db.insert(DataBaseHelper.TABLE_FAVORITES, null, values);
        db.close();
    }

    public void unmarkAsFavorite(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DataBaseHelper.TABLE_FAVORITES,
                DataBaseHelper.COLUMN_NAME + " = ?",
                new String[]{name});
        db.close();
    }

    //metodo para saber si es favorito o no
    @SuppressLint("Range")
    public boolean isFavorite(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + DataBaseHelper.TABLE_FAVORITES +
                " WHERE " + DataBaseHelper.COLUMN_NAME + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{name});
        boolean isFavorite = false;
        if (cursor.moveToFirst()) {
            isFavorite = cursor.getInt(cursor.getColumnIndex(DataBaseHelper.COLUMN_IS_FAVORITE)) == 1;
        }
        cursor.close();
        db.close();
        return isFavorite;
    }

    /*public List<String> getFavorites() {
        List<String> favoritesList = new ArrayList<>();
        SQLiteDatabase db = this.getRedableDataBase();

        Cursor cursor = db.query(DataBaseHelper.TABLE_FAVORITES,
                new String[]{DataBaseHelper.COLUMN_NAME},
                DataBaseHelper.COLUMN_IS_FAVORITE + " = ?",
                new String[]{"1"}, // Obtener solo los favoritos
                null,
                null,
                null);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COLUMN_NAME));
                favoritesList.add(name);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return favoritesList;
    }*/
}
