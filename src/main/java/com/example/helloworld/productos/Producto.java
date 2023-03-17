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
  private String nuevo;
  private int vendidos;
  private int resenas;
  private double totalStars;
  private String nombre;
  private int precio;
  private int meses;
  private int abono;
  private int productosNuevos;
  private int productosUsados;
  private int oferta;
  private String entrega;
  private String full;
  private String llegada;
  private String vendedor;
  private int ventas;
  private String disponibilidad;
  private int garantiaDias;
  private int garantiaTiempo;
  private int anios;
  private int puntos;

}
