package com.example.helloworld.productos;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service

public class ProductoServiceImpl implements ProductoService {
    private ProductoMapper productoMapper;
    public ProductoServiceImpl(ProductoMapper productoMapper) {
        this.productoMapper = productoMapper;
    }
    public List<Producto> obtenTodosLosProductos(){
        return productoMapper.getAll();
    };
    public Producto obtenProductoPorId(int id) {
        return productoMapper.selectById(id);
    };
    public void guarda(Producto producto) {
        int id = producto.getId();
        Producto encontrado = obtenProductoPorId(id);
        if (encontrado == null) {
            productoMapper.insert(producto);
        }else {
            productoMapper.update(producto);
        }
    }
    public void elimina(int id) {
        productoMapper.delete(id);
    }
}
