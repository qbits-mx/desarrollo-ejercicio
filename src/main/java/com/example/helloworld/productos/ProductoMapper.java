package com.example.helloworld.productos;

import java.util.List;

public interface ProductoMapper {
  List<Producto> getAll();
  Producto selectById(int id);
  void insert(Producto producto);
  void update(Producto producto);
  void delete(int id);
}
