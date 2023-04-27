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
import com.example.helloworld.chambea.model.Oficio;


@Repository
public interface ChambeaMapper {
    @Results(
            id="ChambeaMap", 
            value = {
                @Result(property = "apPaterno",        column = "ap_paterno"),
                @Result(property = "apMaterno",      column = "ap_materno"),
                @Result(property = "telPersonal",       column = "tel_personal")
        })
        @Select("select * from datos_personales")
        List<Datos> getMen();
    
        
        @ResultMap("ChambeaMap")
        @Select("select * from datos_personales where id=#{id}")
        Datos selectById(int id);
        
        @ResultMap("ChambeaMap")
        @Insert("insert into datos_personales values(#{id},#{nombre},#{apPaterno},#{apMaterno},#{cp},#{telPersonal},#{date},#{oficio})")
        void insert(Datos datos);
        
        @ResultMap("ChambeaMap")
        @Update("update datos_personales set nombre=#{nombre},ap_paterno=#{apPaterno},ap_materno=#{apMaterno},cp=#{cp},tel_personal=#{telPersonal},date=#{date},oficio=#{oficio} where id=#{id}")
        void update(Datos datos);
        
        @Delete("delete from datos_personales where id=#{id}")
        void delete(int id);
        

        @ResultMap("Holaya")
        @Select("select * from alta_de_anuncio")
        List<DatosAlta> gettwo();
        
        @Results(
                id="Holaya", 
                value = {
                    @Result(property = "fechaCarga",        column = "fecha_de_carga"),
                    @Result(property = "DescripcionCorta",      column = "Descripcion_corta"),
                    @Result(property = "DescripcionLarga",       column = "Descripcion_larga"),
                    @Result(property = "TelTrabajo",       column = "tel_trabajo"),
                    @Result(property = "Link",       column = "link")

            })
        
        @Select("select * from alta_de_anuncio where id=#{id}")
        DatosAlta selectById1(int id);
        
        @ResultMap("Holaya")
        @Insert("insert into alta_de_anuncio values(#{id},#{DescripcionCorta},#{DescripcionLarga},#{fechaCarga},#{cp},#{TelTrabajo},#{Negocio},#{Link},#{activo})")
        void insert1(DatosAlta datosAlta);
        
        @ResultMap("Holaya")
        @Update("update alta_de_anuncio set descripcion_corta=#{DescripcionCorta},descripcion_larga=#{DescripcionLarga},fecha_de_carga=#{fechaCarga}, cp=#{cp},tel_trabajo=#{TelTrabajo},Negocio=#{Negocio},Link=#{Link},activo=#{activo} where id=#{id}")
        void update1(DatosAlta datosAlta);
        
        @Delete("delete from alta_de_anuncio where id=#{id}")
        void delete1(int id);
        

        
        @ResultMap("ChambeaOne")
        @Select("select * from Tgc")
        List<DatosTgc> getone();
        
        @Results(
                id="ChambeaOne", 
                value = {
                    @Result(property = "NumeroDeTarjeta",        column = "numero_de_tarjeta"),
            }) 
        
        @Select("select * from Tgc where id=#{id}")
        DatosTgc selectById2(int id);
        
        @Insert("insert into Tgc values(#{id},#{Activo},#{Nombre},#{Vencimiento},#{NumeroDeTarjeta},#{numero3D})")
        void insert2(DatosTgc datosTg);
        
        @Update("update Tgc set activo=#{activo},Nombre=#{Nombre},Vencimiento=#{Vencimiento},Numero_de_tarjeta=#{NumeroDeTarjeta},numero3D=#{numero3D} where id=#{id}")
        void update2(DatosTgc datosTgc);
        
        @Delete("delete from Tgc where id=#{id}")
        void delete2(int id);
        
        
        @ResultMap("ChambeaMap")
        List<DatosTgc> getNumeroDeTarjeta(int id);
        
        @ResultMap("ChambeaMap")
        List<DatosAlta> getobtenTodosLosDatos(int id);
        
        @ResultMap("ChambeaMap")
        @Select("select * from datos_personales")
        List<Datos> getFist();
        
        @ResultMap("Holaya")
        @Select("select * from alta_de_anuncio where id=#{id}")
        DatosAlta selectById0(int id);


        @Select("select * from oficios where id=#{id}")
        Oficio getofice(int id);
        
        @ResultMap("Holaya")
        @Select("select * from alta_de_anuncio where id=#{id}")
        DatosAlta ver(int id);

}

