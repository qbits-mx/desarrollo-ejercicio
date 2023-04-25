package com.example.helloworld.chambea.model;

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
    private Oficio oficio;

    
}
