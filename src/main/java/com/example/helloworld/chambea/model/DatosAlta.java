package com.example.helloworld.chambea.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DatosAlta {

    private int id;
    private boolean activo;
    private int fechaCarga;
    private String DescripcionCorta;
    private String DescripcionLarga;
    private int cp;
    private int TelTrabajo;
    private String Negocio;
    private String Link;
    public static Object stream() {
        // TODO Auto-generated method stub
        return null;
    }
}
