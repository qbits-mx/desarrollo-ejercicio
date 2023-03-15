package com.example.helloworld.productos;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductoMapper {

    @Select("SELECT * FROM Producto")
    List<Producto> getAll();
    
    @Select("SELECT * FROM Producto WHERE id = #{id}")
    Producto selectById(int id);
    
    @Insert("INSERT INTO Producto VALUES(#{id}, #{nombre}, #{total_stars}, #{}, #{}, #{}, #{}, #{}, #{}, #{}, #{}, #{}, #{}, #{}")
    void insert(Producto prodcuto);
    void update(Producto prodcuto);
    void delete(int id);
}