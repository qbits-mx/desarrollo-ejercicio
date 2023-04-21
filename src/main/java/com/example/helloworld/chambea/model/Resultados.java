package com.example.helloworld.chambea.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resultados {
    private Datos datos;
    private DatosAlta datosAlta;
    private DatosTgc datosTgc;
    private List<String> Datos;
    private List<String> DatosAlta;
    private List<String> DatosTgc;
}
