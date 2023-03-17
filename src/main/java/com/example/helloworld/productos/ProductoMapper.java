package com.example.helloworld.productos;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import com.example.helloworld.productos.modelo.DetallesCompras;
import com.example.helloworld.productos.modelo.Producto;
import com.example.helloworld.productos.modelo.ProductoRes;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;

@Repository

public interface ProductoMapper {
    @Results(
            id="ProductoMap", 
            value = {
                @Result(property = "totalStars",        column = "total_stars"),
                @Result(property = "votosTotales",      column = "votos_totales"),
                @Result(property = "totalProd",         column = "total_prod"),
                @Result(property = "totalVentas",       column = "total_ventas"),
                @Result(property = "numVentas",         column = "num_ventas"),
                @Result(property = "idImagenPrincipal", column = "id_imagen_principal"),
                @Result(property = "nombreImagenPrincipal", column = "nombre_imagen_principal"),
                @Result(property = "especDia",          column = "espec_dia"),
                @Result(property = "nombreVendedor",          column = "nombre_vendedor")
        })
    @Select("SELECT * FROM producto")
    List<Producto> getAll();
    
    @ResultMap("ProductoMap") 
    @Select("SELECT * FROM producto WHERE id = #{id}")
    Producto selectById(int id);
    
    @ResultMap("ProductoMap") 
    @Select("SELECT * FROM producto WHERE id = #{id} and activa=true")
    Producto selectActiveById(int id);
    
    @Results(
            id="ProductoMap2", 
            value = {
                @Result(property = "nombreImagenPrincipal", column = "nombre_imagen_principal"),
                @Result(property = "nombreVendedor",          column = "nombre_vendedor")
        }) 
    @Select("SELECT nombre, nombre_imagen_principal, nombre_vendedor FROM producto WHERE id = #{id}")
    ProductoRes selectByIdComprasProducto(int id);
    
    @ResultMap("ProductoMap") 
    @Select("SELECT * FROM producto WHERE activa=true")
    Producto selectAllActive();
    
    @Insert("INSERT INTO producto VALUES(#{id}, #{nombre}, #{totalStars}, #{votosTotales}, #{vendidas}, #{precio}, #{mensualidad}, #{minutos}, #{direccion}, #{numVentas}, #{totalProd}, #{unidades}, #{tienda}, #{totalVentas}, #{meses}, #{especDia}")
    void insert(Producto prodcuto);
    
    @Update("UPDATE producto SET nombre=#{nombre}, total_stars=#{totalStars}, votos_totales=#{votosTotales}, vendidas=#{vendidas}, precio=#{precio}, mensaulidad=#{mensualidad}, minutos=#{minutos}, direccion=#{direccion}, num_ventas=#{numVentas}, total_prod=#{totalProd}, unidades=#{unidades}, tienda=#{tienda}, total_ventas=#{totalVentas}, meses=#{meses}, espec_dia=#{especDia} WHERE id=#{id}")
    void update(Producto prodcuto);
    
    @Delete("DELETE FROM producto WHERE id=#{id}")
    void delete(int id);
    
    @Results(
            id="CompraMap", 
            value = {
                @Result(property = "idUsuario",        column = "id_usuario"),
                @Result(property = "idProducto",      column = "id_producto"),
                @Result(property = "fechaCompra",         column = "fecha_compra"),
                @Result(property = "statusEnvio",       column = "status_envio"),
                @Result(property = "statusEntrega",       column = "status_entrega"),
                @Result(property = "llegoStatus",       column = "llego_status"),
                @Result(property = "unidadesTotal",       column = "unidades_total")
        })
    @Select("SELECT * FROM detalle_compra WHERE id_usuario = #{id} and id = 1")
    DetallesCompras selectByIdComprasUsuario(int id);
    
    @Select("SELECT id FROM detalle_compra WHERE id_usuario = #{id}")
    List<String> selectByIdTodasComprasUsuario(int id);
    
    //@Results(value = {
            //@Result(property = "idProducto", column = "id_producto")})
    @Select("select nombre from imagen_producto where id_producto=#{idProducto} and activa=true")
    List<String> getAllImagesForProducto(int idProducto);

    //@Results(value = {
            //@Result(property = "idProducto", column = "id_producto")})
    @Select("select descripcion from caracteristica_producto where id_producto=#{idProducto} and activa=true")
    List<String> getAllCaractForProducto(int idProducto);
}