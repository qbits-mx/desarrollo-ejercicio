package com.example.helloworld.productos;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.helloworld.productos.modelo.ConsultaFinal;
import com.example.helloworld.productos.modelo.Producto;

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
    @Override
    public ConsultaFinal getConsultaFinal(int idProducto) {
        List<String> caracteristicas = productoMapper.getAllCaractForProducto(idProducto);
        List<String> imagenes = productoMapper.getAllImagesForProducto(idProducto);
        Producto producto = productoMapper.selectById(idProducto);
        ConsultaFinal rc = new ConsultaFinal(producto, imagenes, caracteristicas);
        return rc;
    }
    @Override
    public Producto ObtenProductoPorId(int id) {
        // TODO Auto-generated method stub
        return null;
    }
}
