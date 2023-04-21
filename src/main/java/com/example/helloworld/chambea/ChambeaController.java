package com.example.helloworld.chambea;


import java.util.List;

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
import com.example.helloworld.chambea.model.DatosAlta;
import com.example.helloworld.chambea.model.DatosTgc;
import com.example.helloworld.chambea.model.Resultados;
import com.example.helloworld.muebles.Mueble;
import com.example.helloworld.productos.InvokeRemoteRestService;


import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value="/api")
public class  ChambeaController {     
       private ChambeaService chambeaService;
         private InvokeRemoteRestService invokeRemoteRestService;
        private Object jwtHelper;

    public ChambeaController( ChambeaService chambeaService, InvokeRemoteRestService invokeRemoteRestService) {
           this.chambeaService = chambeaService;
           this.invokeRemoteRestService = invokeRemoteRestService;
       }
    /*
    aqui usaremos por CONVENCION:
        GetMapping    // se usa para recuperar información del server
        PostMapping   // se usa para hacer insertar información en el server
        PutMapping    // se usa para hacer update de información en el server
        DeleteMapping // se usa para hacer borrados de información en el server
        En el protocolo http, se conocen como "verbos" GET, POST, PUT y DELETE
        
    */
    @GetMapping(
            value= "/informacion-del-usuario", 
            produces = "application/json; charset=utf-8")
    public String sendGreetings2(
            @RequestHeader int idUsuario,
            @RequestHeader String jwt) 
    {
        return invokeRemoteRestService.checkJwt(jwt);
        //return "{'5','sjk','Gustavo','Rangel','Rojas','01090','guschiha@gmail.com','92845896','nightmere'}".replace('\'', '\"');
    }
    @GetMapping(
            value= "/all-data", 
            produces = "application/json; charset=utf-8")
    public   List<DatosAlta> gettwo(
            @RequestHeader int id) {
        return chambeaService.gettwo( id); 
    }
    @GetMapping(
            value= "/all-datos", 
            produces = "application/json; charset=utf-8")
    public   List<DatosTgc> getone() {
        return chambeaService.getone(); 
    }
       

       

}
