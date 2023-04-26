package com.example.helloworld.oficios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistroAnunciante {
    private int id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String telefonoPersonal;
    private String fechaNacimiento;
    private String oficio;
    private String codigoPostal;


}