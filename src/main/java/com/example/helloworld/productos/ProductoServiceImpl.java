package com.example.helloworld.productos;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.helloworld.productos.modelo.DetallesCompras;
import com.example.helloworld.productos.modelo.Producto;
import com.example.helloworld.productos.modelo.ProductoRes;
import com.example.helloworld.productos.modelo.ResultadoConsulta;
import com.example.helloworld.productos.modelo.ResultadoConsultaCompras;

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
    public ResultadoConsulta getResultadoConsulta(int idProducto) {
        List<String> caracteristicas = productoMapper.getAllCaractForProducto(idProducto);
        List<String> imagenes = productoMapper.getAllImagesForProducto(idProducto);
        Producto producto = productoMapper.selectById(idProducto);
        ResultadoConsulta rc = new ResultadoConsulta(producto, imagenes, caracteristicas);
        return rc;
    }
    @Override
    public ResultadoConsultaCompras getResultadoConsultaCompras(int idUsuario) {
        //String[] resultado = {};
        DetallesCompras detalles = productoMapper.selectByIdComprasUsuario(idUsuario);
        List<String> totalesCompras = productoMapper.selectByIdTodasComprasUsuario(idUsuario);
        int idProducto = detalles.getIdProducto();
        System.out.println(idProducto);
        System.out.println(totalesCompras);
        ProductoRes producto = productoMapper.selectByIdComprasProducto(1);
        ResultadoConsultaCompras rc2 = new ResultadoConsultaCompras(producto, detalles);
        return rc2;
    }
}
