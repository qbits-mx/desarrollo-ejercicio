package com.example.helloworld.productos.modelo;

import java.util.List;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultadoConsulta {
    private Producto producto;
    private List<String> imagenes;
    private List<String> caracteristicas;
}