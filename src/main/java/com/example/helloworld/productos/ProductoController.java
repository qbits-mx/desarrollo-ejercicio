package com.example.helloworld.productos;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.helloworld.productos.modelo.Producto;
import com.example.helloworld.productos.modelo.ResultadoConsulta;

@RestController
@RequestMapping(value="/kix")
public class ProductoController {
  private ProductoService productoService;

  public ProductoController(ProductoService productoService) {
    this.productoService = productoService;
  }

  @GetMapping(
    value = "/productall",
    produces = "application/json; charset=utf-8")
  public List<Producto> listaTotal() {
    return this.productoService.tomaTodos();
  }

  @GetMapping(
    value = "/productid",
    produces = "application/json; charset=utf-8")
  public Producto ProductoIndividual(@RequestParam int id) {
    return productoService.tomaPorId(id);
  }
    
  @GetMapping(
    value = "/product",
    produces = "application/json; charset=utf-8")
    public ResultadoConsulta getProducto(@RequestParam int id) {
      return productoService.getResultadoConsulta(id);
    }
  
}
