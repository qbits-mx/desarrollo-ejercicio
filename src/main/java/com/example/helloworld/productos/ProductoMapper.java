package com.example.helloworld.productos;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


import com.example.helloworld.productos.modelo.Producto;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;

@Repository

public interface ProductoMapper {
    @Results(
            id="ProductoMap", 
            value = {
                @Result(property = "totalVentas",column = "total_ventas"),
                @Result(property = "especDia",column = "especdia"),

        })
    @Select("SELECT * FROM producto")
    List<Producto> getAll();
    
    @ResultMap("ProductoMap") 
    @Select("SELECT * FROM producto WHERE id = #{id}")
    Producto selectById(int id);
    
    @ResultMap("ProductoMap") 
    @Select("SELECT * FROM producto WHERE id = #{id} and activa=true")
    Producto selectActiveById(int id);
    
    @ResultMap("ProductoMap") 
    @Select("SELECT * FROM producto WHERE activa=true")
    Producto selectAllActive();
    
    @Insert("insert into Producto values(#{id}, #{nombre},  #{estrellas}, #{vendidas}, #{precio}, #{mensualidad}, #{minutos}, #{direccion},  #{totalProd}, #{Existencia}, #{tienda}, #{totalVentas}, #{meses}, #{especdia}")
    void insert(Producto producto);
    
    @Update("update Producto set nombre=#{nombre},estrellas=#{estrellas}, vendidas=#{vendidas}, precio=#{precio}, mensaulidad=#{mensualidad}, minutos=#{minutos}, direccion=#{direccion}, totalProd=#{totalProd}, Existencia=#{Existencia}, tienda=#{tienda}, totalVentas=#{totalVentas}, meses=#{meses}, especDia=#{especdia}  WHERE id=#{id}")
    void update(Producto producto);
    
    @Delete("delete from Producto where id=#{id}")
    void delete(int id);
    
    @Select("select nombreImagen from imagen_producto where idProducto=#{idProducto} and activo=true")
    List<String> getAllImagesForProducto(int idProducto);

    @Select("select descripcion from caracteristica_producto where idProducto=#{idProducto} and activa=true")
    List<String> getAllCaractForProducto(int idProducto);
    
}


