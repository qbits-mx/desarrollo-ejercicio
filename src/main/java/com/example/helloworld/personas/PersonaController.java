package com.example.helloworld.personas;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/gus/tavo/arellano")
public class PersonaController {
    private PersonaService primeraImplementacion;
    
    public PersonaController(@Qualifier("primeraImplementacionYYY") PersonaService primeraImplementacion) {
        this.primeraImplementacion = primeraImplementacion;
    }

    @GetMapping(
            value= "/pregunta", 
            produces = "application/json; charset=utf-8")
    public Persona sendGreetingsGET() {
      
        return tavito();
    }
    @PostMapping(value= "/pregunta", produces = "application/json; charset=utf-8")
    public Persona tavito() {
        return primeraImplementacion.calcula("algo", "pedregal", "gus1DELETE", "arellanbo", "sandoval");
    }
    
    @DeleteMapping(value= "/pregunta", produces = "application/json; charset=utf-8")
    public Persona sendGreetingDelete() {
        return primeraImplementacion.calcula("algo", "pedregal", "gus1DELETE", "arellanbo", "sandoval");
    } 
    @PostMapping(
            value= "/pregunta2", 
            produces = "application/json; charset=utf-8")
    public String sendGreetings2(
            @RequestHeader String apellido,
            @RequestParam String nombre) {
        return "{'gus':'"+nombre+apellido+"','edad':21}".replace('\'', '\"');
    }
    
    @PostMapping(
            value= "/guardaPersona", 
            produces = "application/json; charset=utf-8")
    public Persona sendGreetings3(@RequestBody Persona p) {
        return p;
    }
    
    @GetMapping(
            value= "/test-diagonales/{variable1}/{variable2}/{variable3}", 
            produces = "application/json; charset=utf-8")
    public Persona testDiagonalesA(
            @RequestHeader("User-Agent") String ua,
            @RequestHeader String colonia,
            @PathVariable String variable1, 
            @PathVariable String variable2, 
            @PathVariable String variable3) {
        return primeraImplementacion.calcula(ua, colonia, variable1, variable2, variable3);
    }
    
    @GetMapping(
            value= "/test-diagonales/{variable1}/{variable2}", 
            produces = "application/json; charset=utf-8")
    public Persona testDiagonalesB(
            @RequestHeader("User-Agent") String ua,
            @RequestHeader String colonia,
            @PathVariable String variable1, 
            @PathVariable String variable2) {
        return primeraImplementacion.calcula(ua, colonia, variable1, variable2, "variable3");
    }
    
    @GetMapping(
            value= "/test-params", 
            produces = "application/json; charset=utf-8")
    public Persona testParamsA(
            @RequestHeader("User-Agent") String ua,
            @RequestHeader String colonia,
            @RequestParam String variable1, 
            @RequestParam String variable2, 
            @RequestParam String variable3) {
        return primeraImplementacion.calcula(ua, colonia, variable1, variable2, variable3);
    }
    @GetMapping(
            value= "/personas", 
            produces = "application/json; charset=utf-8")
    public List<Persona> personas() {
        return primeraImplementacion.getAll();
    }
}
