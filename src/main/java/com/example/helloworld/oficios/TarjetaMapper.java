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

import com.example.helloworld.oficios.model.Tarjeta;

@Repository
public interface TarjetaMapper {

    @Results(id = "TarjetaMap",
            value = { 
            @Result(property = "idAnunciante", column = "id_anunciante"),
            @Result(property = "nombreTitular", column = "nombre_titular") })
    @Select("select * from documento_bancario")
    List<Tarjeta> getAll();

    @ResultMap("TarjetaMap")
    @Select("select * from documento_bancario where id=#{id}")
    Tarjeta selectById(int id);

    @Insert("insert into documento_bancario values(#{id}, #{idAnunciante}, #{nombreTitular}, #{tarjeta}, #{expira}, #{verificacion})")
    void insert(Tarjeta tarjeta);

    @Update("update documento_bancario set id_anunciante=#{idAnunciante}, nombre_titular=#{nombreTitular}, tarjeta=#{tarjeta}, expira=#{expira}, verificacion=#{verificacion}")
    void update(Tarjeta tarjeta);

    @Delete("delete from documento_bancario where id=#{id}")
    void delete(int id);

}