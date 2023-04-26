package com.example.helloworld.oficios;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.example.helloworld.oficios.model.RegistroAnunciante;

@Repository
public interface RegistroMapper {

    @Results(
        id="RegisterMap", 
        value = {
            @Result(property = "apellidoPaterno",        column = "apellido_paterno"),
            @Result(property = "apellidoMaterno",        column = "apellido_materno"),
            @Result(property = "telefonoPersonal",        column = "telefono_personal"),
            @Result(property = "fechaNacimiento",        column = "fecha_nacimiento"),
            @Result(property = "codigoPostal",        column = "codigo_postal")           
    })
    @Select("select * from registro_anunciante")
    List<RegistroAnunciante> getAll();

    @ResultMap("RegisterMap")
    @Select("select * from registro_anunciante where id=#{id}")
    RegistroAnunciante selectById(int id);
    
    @Insert("insert into registro_anunciante values(#{id}, #{nombre}, #{apellidoPaterno}, #{apellidoMaterno}, #{telefonoPersonal}, #{fechaNacimiento}, #{oficio}, #{codigoPostal})")
    void insert(RegistroAnunciante rm);
    
    @Update("update registro_anunciante set nombre=#{nombre}, apellido_paterno=#{apellidoPaterno}, apellido_materno=#{apellidoMaterno}, telefono_personal=#{telefonoPersonal}, fecha_nacimiento=#{fechaNacimiento}, oficio=#{oficio}, codigo_postal=#{codigoPostal} where id=#{id}")
    void update(RegistroAnunciante rm);

    @Delete("delete from registro_anunciante where id=#{id}")
    void delete(int id);

}