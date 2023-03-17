package com.example.helloworld.productos;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.*;
@Repository
public interface ProductoMapper {
  @Select("SELECT * FROM producto")
  List<Producto> getAll();
  @Select("SELECT * FROM producto where id =#{id}")
  Producto selectById(int id);

  @Insert("INSERT into Producto values(#{id},#{nuevo},#{vendidos},#{resenas},#{totalStars},#{nombre},#{precio},#{meses},#{abono},#{productosNuevos},#{productosUsados},#{oferta},#{entrega},#{full},#{llegada},#{vendedor},#{ventas},#{disponibilidad},#{garantiaDias},#{garantiaTiempo},#{anios},#{puntos})")
  void insert(Producto producto);
  void update(Producto producto);
  void delete(int id);
}
