package com.example.helloworld.productos;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.*;
@Repository
public interface ProductoMapper {

  @Select("select * from producto")
  List<Producto> getAll();

  @Select("select * from producto WHERE id =#{id}")
  Producto selectById(int id);

  @Insert("insert into producto values(#{id},#{nuevo},#{vendidos},#{resenas},#{totalStars},#{nombre},#{precio},#{meses},#{abono},#{productosNuevos},#{productosUsados},#{oferta},#{entrega},#{full},#{llegada},#{vendedor},#{ventas},#{disponibilidad},#{garantiaDias},#{garantiaTiempo},#{anios},#{puntos})")
  void insert(Producto producto);

  @Update("update producto set nuevo=#{nuevo},vendidos=#{vendidos},resenas=#{resenas},totalStars=#{totalStars},nombre=#{nombre},precio=#{precio},meses=#{meses},abono=#{abono},productosNuevos=#{productosNuevos},productosUsados=#{productosUsados},oferta=#{oferta},entrega=#{entrega},full=#{full},llegada=#{llegada},vendedor=#{vendedor},ventas=#{ventas},disponibilidad=#{disponibilidad},garantiaDias=#{garantiaDias},garantiaTiempo=#{garantiaTiempo},anios=#{anios},puntos=#{puntos}, WHERE id=#{id}")
  void update(Producto producto);

  @Delete("delete from producto where id=#{id}")
  void delete(int id);
}
