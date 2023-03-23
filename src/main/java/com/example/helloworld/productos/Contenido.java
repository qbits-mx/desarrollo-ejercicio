package com.example.helloworld.productos;

import lombok.Data;

@Data
public class Contenido {
    private String user;
    private long exp;
    private boolean pago; 
    private String rol;
    
    public String toString() {
        return user + exp + rol + pago;
    }
}
