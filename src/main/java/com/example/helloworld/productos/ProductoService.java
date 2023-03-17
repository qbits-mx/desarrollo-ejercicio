package com.example.helloworld.productos;

import java.util.List;

public interface ProductoService {
  List<Producto> tomaTodos();
  Producto tomaPorId(int id);
  void cambia(Producto producto);
  void asesina(int id);
}

