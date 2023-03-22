package com.example.helloworld.productos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

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
            String cadenota = "{'user':'gus', 'exp':'2020-02-20 14:01:27', 'rol':'admin', 'pago':true}";
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
        // también si no me llega algo de la forma xxxxxx_yyyyy return false;
        if (!tokenDado.contains("_")) {
            return false;
        }
        
        String[] arreglo = tokenDado.split("_");
        String cadenaOriginal = arreglo[0];
        String hash = arreglo[1];
        String digestion = Digestion.generateMd5(cadenaOriginal);

        // if d>fecha_en_token => return false;
        Date fechaActual = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaEnToken = "2023-03-22 14:01:29"; // Cambia esto por la fecha que obtienes del token

        try {
            Date fechaToken = sdf.parse(fechaEnToken);
            if (fechaActual.compareTo(fechaToken) > 0) {
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }

        return (digestion.equals(hash));
    }

}
