package com.example.helloworld.productos;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloworld.productos.model.ResultadoConsulta;

@RestController
@RequestMapping(value="/hola")
public class ProductoController {
    private ProductoService productoService;
    
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }
    
    @GetMapping(
            value="/dameProducto", 
            produces = "application/json; charset=utf-8")
    public ResultadoConsulta listaTotal(int id) {
        return this.productoService.getBigResult(id);
    }
}
