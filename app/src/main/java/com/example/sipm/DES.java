package com.example.sipm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.sipm.entities.Articulos;

public class DES extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.des);
        Articulos articulos = (Articulos) getIntent().getSerializableExtra("Articulos");


        TextView Nombre = (TextView) findViewById(R.id.nom);
        TextView Precio = (TextView) findViewById(R.id.pre);
        TextView Marca = (TextView) findViewById(R.id.mar);
        TextView Descri = (TextView) findViewById(R.id.des);


        Log.i("LOGCAT", articulos.getNombre());

        Nombre.setText(articulos.getNombre());
        Precio.setText("$" +articulos.getPrecio());
        Marca.setText(articulos.getMarca());
        Descri.setText(articulos.getDescripcion());
    }
}
