package com.example.helloworld.controller;

public class PersonaServiceImpl implements PersonaService {
    public Persona calcula(String ua, String col, String v1, String v2, String v3) {
        Persona p = null;
        if(ua.toLowerCase().contains("postman")) {
            p = new Persona(1, v1+col, ua, v3, 888.32F, true);
        } else {
            p = new Persona(1, v1+col, ua, v3, 888.32F, true);
        }
        return p;
    }
}
