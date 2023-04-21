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

import com.example.helloworld.oficios.model.Anuncio;

@RestController
@RequestMapping(value = "/api")
public class AnuncioController {
    private AnuncioService anuncioService;

    public AnuncioController(AnuncioService anuncioService) {
        this.anuncioService = anuncioService;
    }

    /** anuncio */
    @DeleteMapping(value = "/jc/delete-anuncio", produces = "application/json; charset=utf-8")
    public void deleteAnuncio(int id) {
        anuncioService.elimina(id);
    }

    @GetMapping(value = "/jc/anuncios-publicados", produces = "application/json; charset=utf-8")
    public List<Anuncio> anuncios() {
        return this.anuncioService.obtenTodosLosAnuncios();
    }

    @GetMapping(value = "/jc/anuncio", produces = "application/json; charset=utf-8")
    public Anuncio obtenerAnunciante(@RequestParam int id) {
        return anuncioService.obtenAnuncioPorId(id);
    }
    
    @GetMapping(value = "/jc/anunciante/{id}", produces = "application/json; charset=utf-8")
    public Anuncio Anunciante(@PathVariable int id) {
        return anuncioService.obtenAnuncioPorIdAnunciante(id);
    }

    @PostMapping(value = "/jc/agrega-anuncio", produces = "application/json; charset=utf-8")
    public void carga(@RequestBody Anuncio anuncio) {
        anuncioService.guarda(anuncio);
    }
}