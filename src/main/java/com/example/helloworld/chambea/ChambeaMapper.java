package com.example.helloworld.chambea;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.helloworld.chambea.model.Datos;
import com.example.helloworld.chambea.model.DatosAlta;
import com.example.helloworld.chambea.model.DatosImg;
import com.example.helloworld.productos.model.CaracteristicaProducto;
import com.example.helloworld.productos.model.ImagenProducto;
import com.example.helloworld.productos.model.Producto;



public interface ChambeaMapper {
    @Results(
            id="ChambeaMap", 
            value = {
                @Result(property = "apPaterno",        column = "ap_paterno"),
                @Result(property = "apMaterno",      column = "ap_materno"),
                @Result(property = "telPersonal",         column = "tel_personal"),
                @Result(property = "fechaCarga",       column = "fecha_de_carga"),
                @Result(property = "DescripcionCorta",       column = "descripcion_corta"),
                @Result(property = "DescripcionLarga",       column = "descripcion_larga"),
                @Result(property = "TelTrabajo",       column = "tel_trabajo"),
                @Result(property = "idUsuario",       column = "id_usuario"),
                @Result(property = "NombreDeLaImagen",       column = "nombre_de_la_imagen")


        })
        @Select("select * from datos_personales")
        List<Datos> getAllOne();
        
        @ResultMap("ChambeaMap")
        @Select("select * from datos_personales where id=#{id}")
        Producto selectById1(int id);
        
        @Insert("insert into datos_personales values(#{id},#{nombre},#{apPaterno},#{apMaterno},#{cp},#{email},#{telPersonal},#{nickName})")
        void insert(Datos datos);
        
        @Update("update datos_personales set nombre=#{nombre},apPaterno}=#{apPaterno},apMaterno=#{apMaterno},cp=#{cp},email=#{email},telPersonal=#{telPersonal},nickName=#{nickName} where id=#{id}")
        void update(Datos datos);
        
        @Delete("delete from datos_personales where id=#{id}")
        void delete(int id);
        
        
        @Select("select * from alta_de_anuncio")
        List<Producto> gettwo();
        
        @Select("select * from alta_de_anuncio where id=#{id}")
        Datos selectById(int id);
        
        @Insert("insert into alta_de_anuncio values(#{id},#{activo},#{fechaCarga},#{DescripcionCorta},#{cp},#{DescripcionLarga},#{email},#{TelTrabajo},#{Negocio},#{Link})")
        void insert1(DatosAlta datosAlta);
        
        @Update("update alta_de_anuncio set activo=#{activo},fecha_carga=#{fechaCarga},descripcion_corta=#{DescripcionCorta},descripcion_larga=#{DescripcionLarga}, cp=#{cp},email=#{email},tel_trabajo=#{TelTrabajo},Negocio=#{Negocio},Link=#{Link} where id=#{id}")
        void update1(DatosAlta datosAlta);
        
        @Delete("delete from alta_de_anuncio where id=#{id}")
        void delete1(int id);
        
        
        @Select("select * from imagenes")
        List<Producto> get3();
        
        @Select("select * from imagenes where id=#{id}")
        Datos selectById3(int id);
        
        @Insert("insert into imagenes values(#{id},#{activo},#{idUsuario},#{NombreDeLaImagen})")
        void insert2(DatosImg imagenes);
        
        @Update("update imagenes set activo=#{activo},id_usuario=#{idUsuario},nombre_de_la_imagen=#{NombreDeLaImagen} where id=#{id}")
        void update2(DatosImg imagenes);
        
        @Delete("delete from imagenes where id=#{id}")
        void delete2(int id);
        
        
        @Results(value = {
                @Result(property = "idUsuario", column = "id")})
        @Select("select id, id, nombre, activa from imagenes where id=#{idUsuario}")
        List<DatosImg> getAllImagesForUsers(int id);
        List<DatosAlta> getAllCaractForDatos(int id);

}

