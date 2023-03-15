package com.example.helloworld.productos;

import java.util.List;

public interface ProductoService {
    List<Producto> obtenTodosLosProductos();
    Producto obtenProductoPorId(int id);
    void guarda(Producto prodcuto);
    void elimina(int id);
}
