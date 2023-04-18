package com.example.helloworld.chambeaya;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Credito {
  private int id;
  private int idUser;
  private String icono;
  private String tipoPago;
  private String NumeroTarjeta;
}
