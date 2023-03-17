package com.example.helloworld.productos;

import java.util.List;

import org.apache.catalina.webresources.Cache;
import org.springframework.stereotype.*;

import com.example.helloworld.productos.modelo.Producto;
import com.example.helloworld.productos.modelo.ResultadoConsulta;

@Service
public class ProductoServiceImpl implements ProductoService{
  private ProductoMapper productMapper;
  public ProductoServiceImpl(ProductoMapper productMapper) {
    this.productMapper = productMapper;
  }

  @Override
  public List<Producto> tomaTodos() {
    return productMapper.getAll();
  }
  @Override
  public Producto tomaPorId(int id) {
    return productMapper.selectById(id);
  }

  @Override
  public void cambia(Producto producto) {
    int id = producto.getId();
    Producto encontrado = this.tomaPorId(id);
    if (encontrado == null) {
      productMapper.insert(producto);
    } else {
      productMapper.update(producto);
    }
  }

  @Override
  public void asesina(int id) {
    productMapper.delete(id);
  }

  @Override
  public ResultadoConsulta getResultadoConsulta(int idProducto) {
    List<String> caracteristicas = productMapper.getAllCaractForProducto(idProducto);
    List<String> imagenes = productMapper.getAllImagesForProducto(idProducto);
    Producto Producto = productMapper.selectById(idProducto);
    ResultadoConsulta resultado = new ResultadoConsulta(Producto, caracteristicas, imagenes );
    return resultado;
  }
}
