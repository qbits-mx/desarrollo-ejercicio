package com.example.helloworld.chambea.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DatosAlta {

    private int id;
    private String DescripcionCorta;
    private String DescripcionLarga;
    private long fechaCarga;
    private long cp;
    private long TelTrabajo;
    private String Negocio;
    private String Link;
    private boolean activo;

}
