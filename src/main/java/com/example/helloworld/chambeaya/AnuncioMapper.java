package com.example.helloworld.chambeaya;


    import java.util.List;

import org.apache.ibatis.annotations.Delete;
    import org.apache.ibatis.annotations.Insert;
    import org.apache.ibatis.annotations.Select;
    import org.apache.ibatis.annotations.Update;
    import org.springframework.stereotype.Repository;
    
@Repository
    public interface AnuncioMapper {

        @Select("SELECT * FROM Anuncio")
        public List<Anuncio> getAll();
        
        @Select("SELECT * FROM Anuncio WHERE id = #{id} ")
        public Anuncio getById(int id);

        @Insert("INSERT INTO Anuncio VALUES(#{id},#{idaAnuncio},#{},#{descripCorta},#{descripLarga},#{cp},#{oficio},#{telefonoNegocio},#{correoNegocio},#{nick} WHERE id=#{id}")
        public void insert(Anuncio p);
        
        @Update("UPDATE Anuncio SET  #{id},#{idaAnuncio},#{},#{descripCorta},#{descripLarga},#{cp},#{oficio},#{telefonoNegocio},correoNegocio#{correoNegocio},nick=#{nick} WHERE id=#{id}")
        public void update(Anuncio p);
        
        @Delete("DELETE FROM Anuncio WHERE id=#{idAnuncio}")
        public void delete(int idAnuncio);   
    }