package com.example.helloworld.productos;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.*;

import com.example.helloworld.productos.modelo.CaracteristicaProducto;
import com.example.helloworld.productos.modelo.ImagenProducto;
import com.example.helloworld.productos.modelo.Producto;
@Repository
public interface ProductoMapper {

  @Results(
        id="ProductoMap", 
        value = {
            @Result(property = "totalStars",            column = "total_stars"),
            @Result(property = "productosNuevos",       column = "productos_nuevos"),
            @Result(property = "productosUsados",       column = "productos_usados"),
            @Result(property = "garantiaDias",          column = "garantia_dias"),
            @Result(property = "garantiaTiempo",        column = "garantia_tiempo"),
            @Result(property = "nombreImagenPrincipal", column = "nombre_imagen_principal"),
    })
  @Select("select * from producto")
  List<Producto> getAll();
  
  @ResultMap("ProductoMap")
  @Select("select * from producto WHERE id =#{id}")
  Producto selectById(int id);

  @ResultMap("ProductoMap")
  @Select("select * from producto WHERE id =#{id} and activa=true")
  Producto selectActiveById(int id);

  @ResultMap("ProductoMap")
  @Select("select * from producto WHERE activa=true")
  Producto selectAllActive();

  @Insert("insert into producto values(#{id},#{nuevo},#{vendidos},#{resenas},#{totalStars},#{nombre},#{precio},#{meses},#{abono},#{productosNuevos},#{productosUsados},#{oferta},#{entrega},#{full},#{llegada},#{vendedor},#{ventas},#{disponibilidad},#{garantiaDias},#{garantiaTiempo},#{anios},#{puntos})")
  void insert(Producto producto);

  @Update("update producto set nuevo=#{nuevo},vendidos=#{vendidos},resenas=#{resenas},totalStars=#{totalStars},nombre=#{nombre},precio=#{precio},meses=#{meses},abono=#{abono},productosNuevos=#{productosNuevos},productosUsados=#{productosUsados},oferta=#{oferta},entrega=#{entrega},full=#{full},llegada=#{llegada},vendedor=#{vendedor},ventas=#{ventas},disponibilidad=#{disponibilidad},garantiaDias=#{garantiaDias},garantiaTiempo=#{garantiaTiempo},anios=#{anios},puntos=#{puntos}, WHERE id=#{id}")
  void update(Producto producto);

  @Delete("delete from producto where id=#{id}")
  void delete(int id);

  //@Results(value = {
  //          @Result(property = "idProducto", column = "id_producto")})
    @Select("select nombre from imagen_producto where id_producto=#{idProducto} and activa=true")
    List<String> getAllImagesForProducto(int idProducto);

  //  @Results(value = {
  //          @Result(property = "idProducto", column = "id_producto")})
    @Select("select descripcion from caracteristica_producto where id_producto=#{idProducto} and activa=true")
    List<String> getAllCaractForProducto(int idProducto);
}
