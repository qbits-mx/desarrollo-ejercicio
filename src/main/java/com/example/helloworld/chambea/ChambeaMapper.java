package com.example.helloworld.chambea;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.example.helloworld.chambea.model.Datos;
import com.example.helloworld.chambea.model.DatosAlta;
import com.example.helloworld.chambea.model.DatosTgc;


@Repository
public interface ChambeaMapper {
    @Results(
            id="ChambeaMap", 
            value = {
                @Result(property = "apPaterno",        column = "ap_paterno"),
                @Result(property = "apMaterno",      column = "ap_materno"),
                @Result(property = "telPersonal",       column = "tel_personal"),
                @Result(property = "nickName",       column = "nick_name")

        })
        @Select("select * from datos_personales")
        List<Datos> getAllOne();
        
        @ResultMap("ChambeaMap")
        @Select("select * from datos_personales where id=#{id}")
        Datos selectById(int id);
        
        @Insert("insert into datos_personales values(#{id},#{nombre},#{apPaterno},#{apMaterno},#{cp},#{email},#{telPersonal},#{nickName})")
        void insert(Datos datos);
        
        @Update("update datos_personales set nombre=#{nombre},ap_paterno}=#{apPaterno},ap_materno=#{apMaterno},cp=#{cp},email=#{email},tel_personal=#{telPersonal},nick_name=#{nickName} where id=#{id}")
        void update(Datos datos);
        
        @Delete("delete from datos_personales where id=#{id}")
        void delete(int id);
        
        @ResultMap("ChambeaMap")
        @Select("select * from datos_personales")
        List<DatosAlta> gettwo(int id);
        
        @Select("select * from alta_de_anuncio where id=#{id}")
        DatosAlta selectById1(int id);
        
        @Insert("insert into alta_de_anuncio values(#{id},#{activo},#{fechaCarga},#{DescripcionCorta},#{cp},#{DescripcionLarga},#{TelTrabajo},#{Negocio},#{Link})")
        void insert1(DatosAlta datosAlta);
        
        @Update("update alta_de_anuncio set activo=#{activo},fecha_carga=#{fechaCarga},descripcion_corta=#{DescripcionCorta},descripcion_larga=#{DescripcionLarga}, cp=#{cp},tel_trabajo=#{TelTrabajo},Negocio=#{Negocio},Link=#{Link} where id=#{id}")
        void update1(DatosAlta datosAlta);
        
        @Delete("delete from alta_de_anuncio where id=#{id}")
        void delete1(int id);
        
        @Results(
                id="ChambeaOne", 
                value = {
                    @Result(property = "NumeroDeTarjeta",        column = "numero_de_tarjeta"),
            }) 
        @Select("select * from Tgc")
        List<DatosTgc> getone();
        
        @ResultMap("ChambeaMap")
        @Select("select * from Tgc where id=#{id}")
        DatosTgc selectById2(int id);
        
        @Insert("insert into Tgc values(#{id},#{Activo},#{Nombre},#{NumeroDeTarjeta},#{Vencimiento})")
        void insert2(DatosTgc datosTg);
        
        @Update("update Tgc set activo=#{activo},Nombre=#{Nombre},Numero_de_tarjeta=#{NumeroDeTarjeta},Vencimiento=#{Vencimiento} where id=#{id}")
        void update2(DatosTgc datosTgc);
        
        @Delete("delete from Tgc where id=#{id}")
        void delete2(int id);
        
        @ResultMap("ChambeaMap")
        List<DatosTgc> getNumeroDeTarjeta(int id);
        @ResultMap("ChambeaMap")
        List<DatosAlta> getobtenTodosLosDatos(int id);

}

