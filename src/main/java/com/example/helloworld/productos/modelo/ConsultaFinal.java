package com.example.helloworld.productos.modelo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaFinal {
    private Producto producto;
    private List<String> imagenes;
    private List<String> caracteristicas;
}
