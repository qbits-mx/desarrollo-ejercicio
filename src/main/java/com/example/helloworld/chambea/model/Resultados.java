package com.example.helloworld.chambea.model;

import java.util.List;

import com.example.helloworld.productos.model.ResultadoConsulta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resultados {
    private Datos datos;
    private List<String> DatosAlta;
    private List<String> DatosTgc;
}
