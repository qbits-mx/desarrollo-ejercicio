package com.example.helloworld.chambea;

import org.mapstruct.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloworld.chambea.model.Datos;
import com.example.helloworld.productos.InvokeRemoteRestService;
import com.example.helloworld.productos.LoginService;
import com.example.helloworld.productos.ProductoService;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value="/gus/tavo")
public class ChambeaController {     
       private ChambeaService chambeaService;
         private InvokeRemoteRestService invokeRemoteRestService;

    public ChambeaController( ChambeaService chambeaService, InvokeRemoteRestService invokeRemoteRestService) {
           this.chambeaService = chambeaService;
           this.invokeRemoteRestService = invokeRemoteRestService;
       }
       @GetMapping(
               value= "/datos-personales", 
               produces = "application/json; charset=utf-8")
       public Datos sendGreetingsGET() {
           return tavito();
       }
       @PostMapping(value= "/datos-personales", produces = "application/json; charset=utf-8")
       public Datos tavito() {
           return chambeaService.calcula( 1, "pedregal", "gus1DELETE", "arellanbo", 67834,"hola",78987689,"hola");
       }
       @PostMapping(
               value= "/guardaPersona", 
               produces = "application/json; charset=utf-8")
       public Datos sendGreetings3(@RequestHeader int idUser ) {
           return chambeaService.calcula( 1, "pedregal", "gus1DELETE", "arellanbo", 67834,"hola",78987689,"hola");
       }
       @DeleteMapping(value= "/datos", produces = "application/json; charset=utf-8")
       public Datos sendGreetingDelete(           
               @RequestHeader int idUsuario) {
           return chambeaService.calcula(8, "algo", "perro", "gato", 345, "inu", 7989, "sandoval");
       } 
       
       @GetMapping(
               value= "/datos-alta/{variable1}", 
               produces = "application/json; charset=utf-8")
       public Datos testDiagonalesA(
               @RequestHeader("User-Agent") String idUser,
               @PathVariable String variable1, 
               @PathVariable String variable2, 
               @PathVariable String variable3) {
           return chambeaService.calcula(0, idUser, variable1, variable3, 0, variable2, 0, variable3);
       }
       @PostMapping(
               value= "/img-anuncios", 
               produces = "application/json; charset=utf-8")
       public String sendGreetings2(
               @RequestHeader int idUsuario,
               @RequestHeader String jwt) 
       {
           return invokeRemoteRestService.checkJwt(jwt);
           //return "{'5','sjk','Gustavo','Rangel','Rojas','01090','guschiha@gmail.com','92845896','nightmere'}".replace('\'', '\"');
       }
    
}
