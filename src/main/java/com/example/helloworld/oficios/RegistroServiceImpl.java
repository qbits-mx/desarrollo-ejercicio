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
    public List<RegistroAnunciante> getAll() {
        return registroMapper.getAll();
    }
    public RegistroAnunciante selectById(int id) {
        return registroMapper.selectById(id);
    }
    public void guarda(RegistroAnunciante registroAnunciante) {
        int id = registroAnunciante.getId();
        RegistroAnunciante encontrado = this.selectById(id);
        if (encontrado == null) {
            registroMapper.insert(registroAnunciante);
        } else {
            registroMapper.update(registroAnunciante);
        }
    }
    public void elimina(int id) {
        registroMapper.delete(id);
    }
}