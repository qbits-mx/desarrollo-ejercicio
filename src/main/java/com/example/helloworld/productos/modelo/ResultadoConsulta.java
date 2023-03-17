package com.example.helloworld.productos.modelo;

import java.util.List;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultadoConsulta {
    private Producto producto;
    private List<String> caracteristicas;
    private List<String> imagenes;
}