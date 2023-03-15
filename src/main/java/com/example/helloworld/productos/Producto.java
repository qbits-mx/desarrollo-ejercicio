package com.example.helloworld.productos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Producto {
    private int id;
    private String nombre;
    private double totalStars;
    private int votosTotales;
    private int vendidas;
    private double precio;
    private int mensualidad;
    private int minutos;
    private String direccion;
    private int numVentas;
    private int totalProd;
    private int unidades;
    private String tienda;
    private int totalVentas;
    private int meses;
    private String especDia;
    
}

