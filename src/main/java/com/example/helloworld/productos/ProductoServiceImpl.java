package com.example.helloworld.productos;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.helloworld.productos.modelo.Producto;
import com.example.helloworld.productos.modelo.ResultadoConsulta;
@Primary
@Service
public class ProductoServiceImpl implements ProductoService{
  private ProductoMapper productoMapper;
  public ProductoServiceImpl(ProductoMapper productoMapper) {
    this.productoMapper = productoMapper;
  }

  @Override
  public List<Producto> tomaTodos() {
    return productoMapper.getAll();
  }
  @Override
  public Producto tomaPorId(int id) {
    return productoMapper.selectById(id);
  }

  @Override
  public void cambia(Producto producto) {
    int id = producto.getId();
    Producto encontrado = tomaPorId(id);
    if (encontrado == null) {
      productoMapper.insert(producto);
    } else {
      productoMapper.update(producto);
    }
  }

  @Override
  public void asesina(int id) {
    productoMapper.delete(id);
  }

  @Override
  public ResultadoConsulta getResultadoConsulta(int idProducto) {
    List<String> caracteristicas = productoMapper.getAllCaractForProducto(idProducto);
    List<String> imagenes = productoMapper.getAllImagesForProducto(idProducto);
    Producto Producto = productoMapper.selectById(idProducto);
    ResultadoConsulta resultado = new ResultadoConsulta(Producto, imagenes, caracteristicas);
    return resultado;
  }
}
