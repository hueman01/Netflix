package com.example.netflix;

public class ModeloPelicula {

    public String codigo;
    public String nombre;
    public String director;


    public ModeloPelicula() {
    }

    public ModeloPelicula(String codigo, String nombre, String director) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.director = director;

    }

    public String codigo() {
        return codigo;
    }

    public ModeloPelicula setCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public String nombre() {
        return nombre;
    }

    public ModeloPelicula setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String director() {
        return director;
    }

    public ModeloPelicula setDirector(String director) {
        this.director = director;
        return this;
    }
}
