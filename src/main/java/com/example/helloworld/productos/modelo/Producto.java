package com.example.helloworld.productos.modelo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    private int id;
    private String estado;
    private String nombre;
    private double precio;
    private int meses;
    private int mensualidad;
    private String interes;
    private int dias;
    private String periodo;
    private int disponibles;
    private int puntos;
    private String descripcion;
    private boolean activa;
    private String nombreImagenPrincipal;
}
