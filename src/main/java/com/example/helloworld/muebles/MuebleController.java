package com.example.helloworld.muebles;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloworld.personas.Persona;



@RestController
@RequestMapping(value="/gus/tavo/arellano")
public class MuebleController {
    private MuebleService implementacion;
    
    public MuebleController(MuebleService implementacion) {
    	this.implementacion = implementacion;
    }
      
    @GetMapping(
            value= "/mueble",
            produces = "application/json; charset=utf-8")
    public Mueble sendGreetingsGET() {
        return tango();
    }
   
    @PostMapping(value= "/mueble2", produces = "application/json; charset=utf-8")
    public Mueble tango() {
        return implementacion.compra("lm", "mesa", "blanca", "hola", "true");
    }

    @GetMapping(
            value= "/mueble3", 
            produces = "application/json; charset=utf-8")
    public List<Mueble> muebles() {
        return implementacion.getAll();
    }
}