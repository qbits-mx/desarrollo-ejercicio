package com.example.helloworld.oficios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarjeta {
    private int id;
    private int idAnunciante;
    private String nombreTitular;
    private String tarjeta;
    private String expira;
    private String verificacion;
}