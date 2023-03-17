package com.example.helloworld.productos;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloworld.productos.modelo.Producto;
import com.example.helloworld.productos.modelo.ConsultaFinal;

@RestController
@RequestMapping(value="/prime")
public class ProductoController {
    private ProductoService productoService;
    
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }
    
    @GetMapping(
            value="/dameToditos", 
            produces = "application/json; charset=utf-8")
    public List<Producto> listaTotal() {
        return this.productoService.obtenTodosLosProductos();
    }
    @GetMapping(
            value= "/productId", 
            produces = "application/json; charset=utf-8")
    public Producto ProductoIndividual(@RequestParam int id) {
        return productoService.ObtenProductoPorId(id);
    }
    @GetMapping(
            value= "/producto", 
            produces = "application/json; charset=utf-8")
    public ConsultaFinal getProducto(@RequestParam int id) {
        return productoService.getConsultaFinal(id);
    }
}
