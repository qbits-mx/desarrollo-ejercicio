package com.example.helloworld.productos.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor

public class ProductoRes {
    private String nombre;
    private String nombreImagenPrincipal;
    private String nombreVendedor;
}
