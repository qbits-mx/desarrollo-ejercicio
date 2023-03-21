package com.example.helloworld.productos;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import com.example.helloworld.productos.modelo.ImagenProducto;
import com.example.helloworld.productos.modelo.Producto;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;

@Repository
public interface ProductoMapper {
    @Results(id = "ProductoMapper", value = {
            @Result(property = "nombreImagenPrincipal", column = "nombre_imagen_principal") })
    @Select("select * from producto")
    List<Producto> getAll();

    @ResultMap("ProductoMapper")
    @Select("select * from producto where id=#{id}")
    Producto selectById(int id);

    @ResultMap("ProductoMapper")
    @Select("select * from producto where id=#{id} and activa=true")
    Producto selectActiveById(int id);

    @ResultMap("ProductoMapper")
    @Select("select * from producto where activa=true")
    Producto selectAllActive();

    @Insert("insert into producto values(#{id}, #{estado}, #{nombre}, #{precio}, #{meses}, #{mensualidad}, #{interes}, #{dias}, #{periodo}, #{disponibles}, #{puntos}, #{descripcion}, #{activa}, #{nombreImagenPrincipal})")
    void insert(Producto producto);

    @Update("update producto set estado=#{estado}, nombre=#{nombre}, precio=#{precio}, meses=#{meses}, mensualidad=#{mensualidad}, interes=#{interes}, dias=#{dias}, periodo=#{periodo}, disponibles=#{disponibles}, puntos=#{puntos}, descripcion=#{descripcion}, activa=#{activa}, nombreImagenPrincipal=#{nombreImagenPrincipal} where id=#{id}")
    void update(Producto producto);

    @Delete("delete from producto where id=#{id}")
    void delete(int id);

    @Select("select nombre from imagen_producto where id_producto=#{idProducto} and activa=true")
    List<String> getAllImagesForProducto(int idProducto);
}
