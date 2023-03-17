package com.example.helloworld.productos.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ResultadoConsultaCompras {
    private ProductoRes productoRes;
    private DetallesCompras detalle;
}
