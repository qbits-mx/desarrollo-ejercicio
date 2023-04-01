package com.example.helloworld.personas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class Persona {
    private int id;
    private String nombre;
    private String apPat;
    private String apMaterno;
    private float sueldo;
    private boolean genero;
}
