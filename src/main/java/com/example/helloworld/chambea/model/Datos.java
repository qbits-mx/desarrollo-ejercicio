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
    private long cp;
    private String email;
    private long telPersonal;
    private String nickName;
}
