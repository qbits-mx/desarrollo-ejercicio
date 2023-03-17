package com.example.helloworld.productos;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class ProductoController {
  private ProductoService productoService;
  public ProductoController(ProductoService productoService) {
    this.productoService = productoService;
  }

  @GetMapping(
    value = "/producto/kixzeit",
    produces = "application/json; charset=utf-8")
  public List<Producto> listaTotal() {
    return this.productoService.tomaTodos();
    
  }
}
