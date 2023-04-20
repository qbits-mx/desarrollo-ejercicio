package com.example.helloworld.chambea.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class DatosTgc {
    private int id;
    private boolean Activo;
    private String Nombre;
    private int NumeroDeTarjeta;
    private String Vencimiento;



}
