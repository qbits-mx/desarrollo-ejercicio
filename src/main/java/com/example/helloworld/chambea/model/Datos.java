package com.example.helloworld.chambea.model;

import lombok.*;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class Datos {
    private int idUsuario;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private int cp;
    private String email;
    private int telPersonal;
    private String nickName;
}
