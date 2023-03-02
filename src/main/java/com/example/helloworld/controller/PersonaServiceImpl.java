package com.example.helloworld.controller;

import org.springframework.stereotype.Service;

@Service(value = "primeraImplementacionXXX")
public class PersonaServiceImpl implements PersonaService {
    private PersonaMapper personaMapper;
    
    public PersonaServiceImpl(PersonaMapper personaMapper) {
        this.personaMapper = personaMapper;
    }
    public Persona calcula(String ua, String col, String v1, String v2, String v3) {
        return personaMapper.getById(7534);
    }
}
