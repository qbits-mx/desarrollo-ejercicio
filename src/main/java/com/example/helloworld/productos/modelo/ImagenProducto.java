package com.example.helloworld.productos.modelo;

import lombok.*;

@Data
@NoArgsConstructor
public class ImagenProducto {
    private int id;
    private int idProducto;
    private String nombre;
    private boolean activa;
}

