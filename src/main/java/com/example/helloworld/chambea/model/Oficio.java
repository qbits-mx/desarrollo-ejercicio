package com.example.helloworld.chambea.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Oficio {
    private int id;
    private String oficios;
    private boolean Activo;
}
