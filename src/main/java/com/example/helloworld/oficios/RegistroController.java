package com.example.helloworld.oficios;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloworld.oficios.model.RegistroAnunciante;

@RestController
@RequestMapping(value = "/api")
public class RegistroController {
  private RegistroService registroService;

  public RegistroController(RegistroService registroService) {
    this.registroService = registroService;
  }
    
    /**datoanunciante*/
    @DeleteMapping(value = "/jc/delete-registro", produces = "application/json; charset=utf-8")
    public void deleteRegistro(int id) {
      registroService.elimina(id);
    }
    @GetMapping(value = "/jc/registros-publicados", produces = "application/json; charset=utf-8")
    public List<RegistroAnunciante> registros() {
      return this.registroService.getAll();
    }
    @GetMapping(value = "/jc/trae-registro", produces = "application/json; charset=utf-8")
    public RegistroAnunciante trae(@RequestParam int id) {
      return registroService.selectById(id);
    }
    @PostMapping(value = "/jc/registro-anuncio", produces = "application/json; charset=utf-8")
    public void carga(RegistroAnunciante registroAnunciante) {
      registroService.guarda(registroAnunciante);
    }
}
