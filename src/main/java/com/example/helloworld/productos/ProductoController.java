package com.example.helloworld.productos;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloworld.productos.model.ResultadoConsulta;
import com.example.helloworld.utileria.Digestion;

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
            @RequestParam String fecha,
            @RequestParam String password) {
        SimpleDateFormat sdf=new  SimpleDateFormat ("dd/MM/yyyy");   
        SimpleDateFormat sf=new  SimpleDateFormat ("hh:mm:ss");   

        Date d = new Date();
        String sFecha= sdf.format(d);
        String shora= sf.format(d);


        if(user.equals("gus") && password.equals("tavo")&&  sFecha.equals(fecha)) {
            String cadenota = "{'user':'gus', 'exp':'22-03-2023', 'rol':'admin', 'pago':true  'hora':"+ shora +"  }";
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
        String[] arreglo = tokenDado.split("_"); 
        String cadenaOriginal = arreglo[0];
        String hash = arreglo[1];
        String digestion = Digestion.generateMd5(cadenaOriginal);
        return (digestion.equals(hash));
    }

}
