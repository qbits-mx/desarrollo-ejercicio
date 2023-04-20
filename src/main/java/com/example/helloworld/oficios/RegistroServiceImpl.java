package com.example.helloworld.oficios;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.helloworld.oficios.model.RegistroAnunciante;

@Primary
@Service
public class RegistroServiceImpl implements RegistroService {
private RegistroMapper registroMapper;

public RegistroServiceImpl(RegistroMapper registroMapper) {
this.registroMapper = registroMapper;

}

@Override
public List<RegistroAnunciante> getAll() {
return registroMapper.getAll();
}

@Override
public RegistroAnunciante selectById(int id) {
  return registroMapper.selectById(id);
}

@Override
public void guarda(RegistroAnunciante registroanunciante) {
  int id = registroanunciante.getId();
  RegistroAnunciante encontrado = this.selectById(id);

  if (encontrado == null) {
      registroMapper.insert(registroanunciante);
  } else {
      registroMapper.update(registroanunciante);
  }
}

@Override
public void elimina(int id) {
    registroMapper.delete(id);
}

}