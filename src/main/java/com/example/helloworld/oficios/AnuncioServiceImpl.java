package com.example.helloworld.oficios;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.helloworld.oficios.model.Anuncio;


@Primary
@Service
public class AnuncioServiceImpl implements AnuncioService {
private AnuncioMapper anuncioMapper;

public AnuncioServiceImpl(AnuncioMapper anuncioMapper) {
this.anuncioMapper = anuncioMapper;

}

@Override
public List<Anuncio> getAll() {
return anuncioMapper.getAll();
}

@Override
public Anuncio selectById(int id) {
  return anuncioMapper.selectById(id);
}

@Override
public void guarda(Anuncio anuncio) {
  int id = anuncio.getId();
  Anuncio encontrado = this.selectById(id);

  if (encontrado == null) {
    anuncioMapper.insert(anuncio);
  } else {
    anuncioMapper.update(anuncio);
  }
}

@Override
public void elimina(int id) {
  anuncioMapper.delete(id);
}


}