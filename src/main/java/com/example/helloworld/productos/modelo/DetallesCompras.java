package com.example.helloworld.productos.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor

public class DetallesCompras {
    private int id;
    private int idUsuario;
    private int idProducto;
    private String fechaCompra;
    private String statusEnvio;
    private String statusEntrega;
    private String llegoStatus;
    private int unidadesTotal;
}
