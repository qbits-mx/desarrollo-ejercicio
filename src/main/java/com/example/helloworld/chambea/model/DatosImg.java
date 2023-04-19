package com.example.helloworld.chambea.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class DatosImg {
    private int id;
    private boolean activo;
    private int idUsuario;
    private String NombreDeLaImagen;



}
