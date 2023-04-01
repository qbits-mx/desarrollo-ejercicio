package com.example.helloworld.personas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
    
    public Persona() {
        log.info("hola " + toString());
    }
    public Persona(int numero) {
        log.info(String.valueOf(numero));
    }
    public String toString() {
        return "adios";
    }
    
}
