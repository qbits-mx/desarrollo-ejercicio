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
    public List<Anuncio> obtenTodosLosAnuncios() {
        return anuncioMapper.getAll();
    }
    public Anuncio obtenAnuncioPorId(int id) {
        return anuncioMapper.selectById(id);
    }
    public Anuncio obtenAnuncioPorIdAnunciante(int id) {
        return anuncioMapper.selectByIdAnunciante(id);
    }
    public void guarda(Anuncio anuncio) {
        int id = anuncio.getId();
        Anuncio encontrado = this.obtenAnuncioPorId(id);
        if (encontrado == null) {
            anuncioMapper.insert(anuncio);
        } else {
            anuncioMapper.update(anuncio);
        }
    }
    public void elimina(int id) {
        anuncioMapper.delete(id);
    }
}