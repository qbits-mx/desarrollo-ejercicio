package com.example.helloworld.chambea.model;

import lombok.*;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class Datos {
    private int id;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String cp;
    private long telPersonal;
    private String date;
}
