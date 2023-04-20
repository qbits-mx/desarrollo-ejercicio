package com.example.helloworld.oficios;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

  @GetMapping(value = "/get-ads", produces = "application/json; charset=utf-8")
  public List<Anuncio> listaTotal() {
    return this.anuncioService.getAll();
  }

  @GetMapping(value = "/get-ads-byid", produces = "application/json; charset=utf-8")
  public Anuncio AnuncioIndividual(@RequestParam int id) {
    return anuncioService.selectById(id);
  }

  @DeleteMapping(value = "/delete-ads-byid", produces = "application/json; charset=utf-8")
  public void borra(int id) {
    anuncioService.elimina(id);
  }

  @PostMapping(value = "/update-ads", produces = "application/json; charset=utf-8")
  public void save(Anuncio anuncio) {
    anuncioService.guarda(anuncio);
  }

}