package com.example.helloworld.productos.model;

import java.util.List;

import com.example.helloworld.chambea.model.Datos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultadoConsulta {
    private Datos datos;
    private List<String> caracteristicas;
    private List<String> imagenes;
}
