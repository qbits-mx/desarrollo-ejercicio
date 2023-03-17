package com.example.helloworld.productos;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloworld.productos.modelo.Producto;
import com.example.helloworld.productos.modelo.ResultadoConsulta;
import com.example.helloworld.productos.modelo.ResultadoConsultaCompras;

@RestController
@RequestMapping(value="/gera")
public class ProductoController {
    private ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping(
            value ="/productotodos",
            produces = "application/json; charset=utf-8" 
            )
    public List<Producto> listaTotal(){
        return this.productoService.obtenTodosLosProductos();
    }
    @GetMapping(
            value= "/productId", 
            produces = "application/json; charset=utf-8")
    public Producto ProductoIndividual(@RequestParam int id) {
        return productoService.obtenProductoPorId(id);
    }
    @GetMapping(
            value= "/producto", 
            produces = "application/json; charset=utf-8")
    public ResultadoConsulta getProducto(@RequestParam int id) {
        return productoService.getResultadoConsulta(id);
    }
    @GetMapping(
            value= "/compras", 
            produces = "application/json; charset=utf-8")
    public ResultadoConsultaCompras getProductoCompras(@RequestParam int id) {
        return productoService.getResultadoConsultaCompras(id);
    }
}

    
