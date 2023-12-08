package com.example.netflix;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Pelicula extends SQLiteOpenHelper {


    public Pelicula(Context context) {
        super(context, "netfflix", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("Create table pelicula(codigo text primary key, nombre text, director text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("drop table if exists pelicula");
        onCreate(sqLiteDatabase);

    }


    public void guardarpeli(String codigo, String nombre,String director){
        SQLiteDatabase bd=getWritableDatabase();
        if(bd!=null){
            bd.execSQL("Insert into pelicula values('"+codigo+"','"+nombre+"','"+director+"')");
            bd.close();
        }
    }

    /* Buscar un dato especifico.
=====================================================
*/
    public void buscarpeli(ModeloPelicula pelicula, String codigo){
        SQLiteDatabase bd=getReadableDatabase();
        Cursor cursor=bd.rawQuery("select *from pelicula where codigo='"+codigo+"'",null);
        if(cursor.moveToFirst()){
            do {
                pelicula.setCodigo(cursor.getString(0));
                pelicula.setNombre(cursor.getString(1));
                pelicula.setDirector(cursor.getString(2));

            }while(cursor.moveToNext());
        }
    }

    /* Eliminar datos.
=====================================================
*/
    public void eliminarpeli(String codigo){
        SQLiteDatabase bd=getWritableDatabase();
        if(bd!=null)
        {
            bd.delete("pelicula", "codigo=" + codigo, null);
            bd.close();
        }
    }



}

