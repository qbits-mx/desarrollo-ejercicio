package com.example.helloworld.productos;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class ProductoServiceImpl implements ProductoService{
    private ProductoMapper productMapper;
    
    public ProductoServiceImpl(ProductoMapper productMapper) {
        this.productMapper = productMapper;
    }
    public List<Producto> obtenTodosLosProductos() {
        return productMapper.getAll();
    }
    public Producto ObtenProductoPorId(int id) {
        return productMapper.selectById(id);
    }
    public void guarda(Producto producto) {
        int id = producto.getId();
        Producto encontrado = this.ObtenProductoPorId(id);
        // si NO hay ningún renglón en la tabla "Persona",cuyo id sea
        // el parámetro que recibe el método 'ObtenProductoPorId'
        // entonces la variable "encontrado" será ingual a: null
        if(encontrado==null) {
            productMapper.insert(producto);
        } else {
            productMapper.update(producto);
        }
    }
    public void elimina(int id) {
        productMapper.delete(id);
    }
}
