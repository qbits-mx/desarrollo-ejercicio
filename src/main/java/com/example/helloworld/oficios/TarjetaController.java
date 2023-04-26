package com.example.helloworld.oficios;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloworld.oficios.model.Tarjeta;

@RestController
@RequestMapping(value = "/api")
public class TarjetaController {
    private TarjetaService tarjetaService;

    public TarjetaController(TarjetaService tarjetaService) {
        this.tarjetaService = tarjetaService;
    }

    /** tarjeta */
    @DeleteMapping(value = "/jc/delete-tarjeta", produces = "application/json; charset=utf-8")
    public void deleteTarjeta(int id) {
        tarjetaService.elimina(id);
    }

    @GetMapping(value = "/jc/tarjetas-publicadas", produces = "application/json; charset=utf-8")
    public List<Tarjeta> tarjetas() {
        return this.tarjetaService.getAll();
    }

    @GetMapping(value = "/jc/tarjeta/{id}", produces = "application/json; charset=utf-8")
    public Tarjeta id(@PathVariable int id) {
        return tarjetaService.selectById(id);
    }

    @PostMapping(value = "/jc/agrega-tarjeta", produces = "application/json; charset=utf-8")
    public void carga(@RequestBody Tarjeta tarjeta) {
        tarjetaService.guarda(tarjeta);
    }
}