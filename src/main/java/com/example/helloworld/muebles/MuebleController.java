package com.example.helloworld.muebles;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/juan/carlos/ramos") //con esta ruta podemos mandar a llamar desde navegador
public class MuebleController {
	private MuebleService primeraImplementacion;
	
    public MuebleController(@Qualifier("muebleImplementacionYYY") MuebleService primeraImplementacion) {
        this.primeraImplementacion = primeraImplementacion;
    }
    @GetMapping(
            value= "/muebles", 
            produces = "application/json; charset=utf-8")
    public List<Mueble> muebles() {
        return primeraImplementacion.getAll();
    }

}
