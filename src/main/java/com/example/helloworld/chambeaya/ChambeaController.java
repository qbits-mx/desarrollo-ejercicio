package com.example.helloworld.chambeaya;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloworld.chambeaya.model.Usuario;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping(value="/chambea")

public class ChambeaController {
    private ChambeaService chambeaService;
    
    public ChambeaController( ChambeaService chambeaService){
        this.chambeaService = chambeaService;
    }
    
    @ApiOperation(
            value = "UserDatos::Datos",
            notes = "Obtener la informacion del usuario por su Id")
    @GetMapping(
            value= "/user", 
            produces = "application/json; charset=utf-8")
    public Usuario datosTotales(int id) {
        return this.chambeaService.getDatos(id);
    }
    
    @ApiOperation(
            value = "CreaGuardaActualiza::DatosDeUsuario",
            notes = "Crea al usuario al confirmar su registro, "
                    + "guarda un usuario o actualiza su informacion personal")
    @PostMapping(
            value = "/guarda",
            produces = "application/json; charset=utf-8")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se agrego o actualizo correctamente"),
            @ApiResponse(code = 400, message = "Error al guardar")
    })
    public void guarda ( 
            @RequestBody Usuario ccr) {
        this.chambeaService.guarda(ccr);
        // pido ccr sólo para ejemplificar el uso del body
    }

}
