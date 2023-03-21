package com.example.helloworld.productos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloworld.productos.model.ResultadoConsulta;
import com.example.helloworld.utilerias.Digestion;

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
    @GetMapping(
            value="/login", 
            produces = "application/json; charset=utf-8")
    public String fakeLogin(
            @RequestParam String user, 
            @RequestParam String password) {
        if(user.equals("gus") && password.equals("tavo")) {
            String cadenota = "{'user':'gus', 'exp':'2023-03-22', 'rol':'admin', 'pago':true}";
            return cadenota + "_" + Digestion.generateMd5(cadenota);
        }
        return "{'error':'bad pasword or user'}";
    }
    @GetMapping(
            value="/cambia", 
            produces = "application/json; charset=utf-8")
    public String fakeCambiaPassword(
            @RequestHeader String tokenDado,
            @RequestParam String nuevoPassword) {
        if(revisa(tokenDado)) {
            return "{'exito':'password cambiado'}";
        }
        return "{'error':'bad token'}";
    }

    private boolean revisa(String tokenDado) {
        String[] arreglo = tokenDado.split("_"); // "gus_tavo_are_sando_profe"
        String cadenaOriginal = arreglo[0];
        String hash = arreglo[1];
        String digestion = Digestion.generateMd5(cadenaOriginal);
        return (digestion.equals(hash));
    }
    
}
