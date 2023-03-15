package com.example.helloworld.productos;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoMapper {
    @Select("select * from Producto")
    List<Producto> getAll();
    
    @Select("select * from Producto where id=#{id}")
    Producto selectById(int id);
    
    @Insert("insert into Producto values(#{id}, #{nombre}, ...)")
    void insert(Producto producto);
    
    @Update("update Producto set nombre=#{nombre}, ... where id=#{id}")
    void update(Producto producto);
    
    @Delete("delete from Producto where id=#{id}")
    void delete(int id);
}
