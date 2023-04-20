package com.example.helloworld.oficios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Anuncio {
    private int id;
    private int idAnunciante;
    private String titulo;
    private String anuncio;
    private String codigoPostal;
    private String oficio;
    private String email;
    private String telefono;

}