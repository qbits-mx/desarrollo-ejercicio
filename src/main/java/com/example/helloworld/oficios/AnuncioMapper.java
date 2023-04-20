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

import com.example.helloworld.oficios.model.Anuncio;

@Repository
public interface AnuncioMapper {

    @Results(
        id="ChambaMap", 
        value = {
            @Result(property = "idAnunciante",        column = "id_anunciante"),
            @Result(property = "codigoPostal",        column = "codigo_postal")           
    })
    @Select("select * from anuncio")
    List<Anuncio> getAll();

    @ResultMap("ChambaMap")
    @Select("select * from anuncio where id=#{id}")
    Anuncio selectById(int id);
    
    @Insert("insert into anuncio values(#{id}, #{idAnunciante}, #{titulo}, #{anuncio}, #{codigoPostal}, #{oficio}, #{email}, #{telefono})")
    void insert(Anuncio anuncio);
    
    @Update("update anuncio set id_anunciante=#{idAnunciante}, titulo=#{titulo}, anuncio=#{anuncio}, codigo_postal=#{codigoPostal}, oficio=#{oficio}, email=#{email}, telefono=#{telefono}, where id=#{id} ")
    void update(Anuncio anuncio);

    @Delete("delete from anuncio where id=#{id}")
    void delete(int id);

}