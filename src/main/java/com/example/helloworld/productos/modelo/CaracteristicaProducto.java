package com.example.helloworld.productos.modelo;

import lombok.*;

@Data
@NoArgsConstructor
public class CaracteristicaProducto {
    private int id;
    private int idProducto;
    private String descripcion;
    private boolean activa;
}
