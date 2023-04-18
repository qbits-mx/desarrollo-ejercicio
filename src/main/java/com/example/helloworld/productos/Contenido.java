package com.example.helloworld.productos;

import lombok.Data;

@Data
public class Contenido {
  private String user;
  private long exp;
  private String rol;
  private boolean pago;
}
