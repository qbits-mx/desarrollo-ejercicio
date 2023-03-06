package com.example.helloworld.muebles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Mueble {
    private int id;
    private String nombre;
    private String color;
    private float precio;
    private boolean agotado;
    
    
}
