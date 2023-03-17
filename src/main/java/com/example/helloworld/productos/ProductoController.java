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
    value = "/producto",
    produces = "application/json; charset=utf-8")
  public List<Producto> listaTotal() {
    return this.productoService.tomaTodos();
  }

  @GetMapping(
    value = "/one",
    produces = "application/json; charset=utf-8")
  public Producto ProductoIndividual(@RequestParam int id) {
    return productoService.tomaPorId(id);
  }
    
  @GetMapping(
    value = "/products",
    produces = "application/json; charset=utf-8")
    public ResultadoConsulta getProducto(@RequestParam int id) {
      return productoService.getResultadoConsulta(id);
    }
  
}
