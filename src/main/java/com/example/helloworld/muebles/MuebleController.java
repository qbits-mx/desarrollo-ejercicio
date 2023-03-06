package com.example.helloworld.muebles;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/kix/zeit")
public class MuebleController {
    private MuebleService primeraImplementacion;
    
    public MuebleController(@Qualifier("primeraImplementacion") MuebleService primeraImplementacion) {
        this.primeraImplementacion = primeraImplementacion;
    }

    @PostMapping(value= "/respuesta", produces = "application/json; charset=utf-8")
    public Mueble kix() {
        return primeraImplementacion.calcula("silla", "azul", "128.25", "cocina", "agotada");
    }
    
    @DeleteMapping(value= "/respuesta", produces = "application/json; charset=utf-8")
    public Mueble sendGreetingDelete() {
        return primeraImplementacion.calcula("mueble", "marron", "1247.54", "sala", "en stock");
    } 

    @PostMapping(
            value= "/guardaMueble", 
            produces = "application/json; charset=utf-8")
    public Mueble sendGreetings(@RequestBody Mueble p) {
        System.out.println(p.getNombre());
        return p;
    }
    
    @GetMapping(
            value= "/muebles", 
            produces = "application/json; charset=utf-8")
    public List<Mueble> muebles() {
        return primeraImplementacion.getAll();
    }
}
