package com.example.netflix;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText codigo,nombre,director;
    Button guardar,borrar,modificar,buscar,limpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Pelicula base= new Pelicula(getApplication());



        codigo=findViewById(R.id.codigo);
        nombre=findViewById(R.id.nombre);
        director=findViewById(R.id.director);
        guardar=findViewById(R.id.guardar);
        borrar=findViewById(R.id.borrar);
        modificar=findViewById(R.id.modificar);
        buscar=findViewById(R.id.buscar);
        limpiar=findViewById(R.id.limpiar);




        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                base.guardarpeli(codigo.getText().toString(),nombre.getText().toString(),director.getText().toString());
                Toast.makeText(MainActivity.this, "guardado", Toast.LENGTH_SHORT).show();
                limpiando();

            }

        });

        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                limpiando();

            }
        });

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ModeloPelicula peliculax=new ModeloPelicula();

                base.buscarpeli(peliculax,codigo.getText().toString());

                nombre.setText(peliculax.nombre);
                director.setText(peliculax.director);

            }
        });

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ModeloPelicula dueños=new ModeloPelicula();
                base.eliminarpeli(codigo.getText().toString());
                Toast.makeText(MainActivity.this, "eliminado", Toast.LENGTH_SHORT).show();
                limpiando();


            }
        });




    }


    private void limpiando() {

        codigo.setText("");
        nombre.setText("");
        director.setText("");

    }
}