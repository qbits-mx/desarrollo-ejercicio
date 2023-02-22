package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {

    /*
    aqui usaremos por CONVENCION:
        GetMapping    // se usa para recuperar información del server
        PostMapping   // se usa para hacer insertar información en el server
        PutMapping    // se usa para hacer update de información en el server
        DeleteMapping // se usa para hacer borrados de información en el server
        En el protocolo http, se conocen como "verbos" GET, POST, PUT y DELETE
        
        Todos pueden regresar códigos de error (4xx,5xx) y códigos de éxito (2xx)
        En términos generales:
            Los códigos 4xx son asociados a acciones de tipo "me mandaste algo mal"
            Los códigos 5xx son asociados a acciones de tipo "error del server, no tuyo"
    */
    @GetMapping(value= "/pregunta", produces = "application/json; charset=utf-8")
    public Persona sendGreetings() {
        Persona p = new Persona(1, "gus1", "arellano", "sandoval", 123.32F, true);
        return p;
    }
    /*
    
    Hay dos formas de pasar parámetros a los endpoint's antoados con GET:
    
    1) usando ? y & 
       ejemplo: http://localhost?a=1&b=7&otra=9
                http://bbva.com.mx?id=1724&type=retiro&monto=1000
    2) con separadores de diagonal 
       ejemplo: http://localhost/1/7/9
                http://www.gus.com/enero/24/2023
       
    Sirvem igual, pero a veces, es mas últil (seménticamente) usar uno de ellos 
    en particular, que sería el que mas se adapta al objeto de la invocación.
    */
    @GetMapping(
            value= "/pregunta2", produces = "application/text; charset=utf-8")
    public String sendGreetings2() {
        int a =0;
        System.out.println(1/a);
        return "{'gus':'tavo','edad':21}".replace('\'', '\"');
    }
    
    @GetMapping(
            value= "/pregunta3", 
            produces = "application/json; charset=utf-8")
    public Persona sendGreetings3() {
        Persona p = new Persona(3, "gus3", "arellano", "sandoval", 123.32F, true);
        return p;
    }
}
