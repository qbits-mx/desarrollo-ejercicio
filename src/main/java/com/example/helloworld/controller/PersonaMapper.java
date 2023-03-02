package com.example.helloworld.controller;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class PersonaMapper {
    public List<Persona> getAll() {
        return null;
    }
    public void insert(Persona p) {
        // ir a la base e insertar
    }
    public void update(Persona p) {
        // ir a la base y actualizar
    }
    public void delete(int idPersona) {
        // ir a la base y borrar a la persona que tenga el id dado
    }
    public Persona getById(int id) {
        return new Persona(id, "gus", "tavo","hola", 111.11f, true);
    }
}
