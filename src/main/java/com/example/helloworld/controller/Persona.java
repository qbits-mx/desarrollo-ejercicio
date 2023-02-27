package com.example.helloworld.controller;

public class Persona {
    private int id;
    private String nombre;
    private String apPat;
    private String apMaterno;
    private float sueldo;
    private boolean genero;
    
    /*
    En realidad, si una clase no tiene ningun constructor, java le asigna
    de manera automática un constructor que no recibe parámetros 
    y que además NO efectúa ninguna operación especial. O sea,
    lo equivalente (en esta clase, a lo siguiente:)
    
    public Persona() {}

    Si la calse tiene AL MENOS 1 constructor creado por el programador,
    entonces java se olvida deque existe el constructor vacio mostrado 
    en el comentario anterior y sólo considera al (o a los) constructores
    creados por el programador.

    */
    
    public Persona() {
        System.out.println("hola " + toString());
    }
    public Persona(int numero) {
        System.out.println(numero);
    }
    public Persona(int id, String nombre, String apPat, String apMaterno, float sueldo, boolean genero) {
        this.id = id;
        this.nombre = nombre;
        this.apPat = apPat;
        this.apMaterno = apMaterno;
        this.sueldo = sueldo;
        this.genero = genero;
    }
    public String toString() {
        return "adios";
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApPat() {
        return apPat;
    }
    public void setApPat(String apPat) {
        this.apPat = apPat;
    }
    public String getApMaterno() {
        return apMaterno;
    }
    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }
    public float getSueldo() {
        return sueldo;
    }
    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }
    public boolean isGenero() {
        return genero;
    }
    public void setGenero(boolean genero) {
        this.genero = genero;
    }
    
    
}
