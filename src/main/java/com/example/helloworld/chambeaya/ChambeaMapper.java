package com.example.helloworld.chambeaya;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.example.helloworld.chambeaya.model.Usuario;

@Repository

public interface ChambeaMapper {
    @Results(
            id="UsuariosMap", 
            value = {
                @Result(property = "idUser",        column = "id_user"),
                @Result(property = "apellidoP",     column = "apellido_p"),
                @Result(property = "apellidoM",     column = "apellido_m"),
                @Result(property = "fechaN",        column = "fecha_n"),
                @Result(property = "codigoPostal",  column = "codigo_postal"),
                @Result(property = "telefonoP",     column = "telefono_p"),
                @Result(property = "correoP",       column = "correo_p"),
                @Result(property = "imagenD",       column = "imagen_d"),
                @Result(property = "metodoPago",    column = "metodo_pago")
        })
    @Select("select * from usuarios where id_user=#{id}")
    Usuario getDatos(int id);
    
    @Insert("INSERT INTO usuarios VALUES("
            + "#{idUser},"
            + " #{nombre},"
            + " #{apellidoP},"
            + " #{apellidoM},"
            + " #{nick},"
            + " #{likes},"
            + " #{fechaN},"
            + " #{codigoPostal},"
            + " #{oficio},"
            + " #{telefonoP},"
            + " #{correoP},"
            + " #{habilitado},"
            + " #{imagenD},"
            + " #{metodoPago})")
    void insert(Usuario usuario);
    
    @Update("update usuarios set "
            + "nombre=#{nombre},"
            + " apellido_p=#{apellidoP},"
            + " apellido_m=#{apellidoM},"
            + " nick=#{nick},"
            + " likes=#{likes},"
            + " fecha_n=#{fechaN},"
            + " codigo_postal=#{codigoPostal},"
            + " oficio=#{oficio},"
            + " telefono_p=#{telefonoP},"
            + " correo_p=#{correoP},"
            + " habilitado=#{habilitado},"
            + " imagen_d=#{imagenD},"
            + " metodo_pago=#{metodoPago}"
            + " where id_user=#{idUser}")
    void update(Usuario usuario);

}
