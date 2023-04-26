package com.example.helloworld.oficios;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.helloworld.oficios.model.Tarjeta;

@Primary
@Service
public class TarjetaServiceImpl implements TarjetaService {
    private TarjetaMapper tarjetaMapper;

    public TarjetaServiceImpl(TarjetaMapper tarjetaMapper) {
        this.tarjetaMapper = tarjetaMapper;
    }
    public List<Tarjeta> getAll() {
        return tarjetaMapper.getAll();
    }
    public Tarjeta selectById(int id) {
        return tarjetaMapper.selectById(id);
    }
    public void guarda(Tarjeta tarjeta) {
        int id = tarjeta.getId();
        Tarjeta encontrado = this.selectById(id);
        if (encontrado == null) {
            tarjetaMapper.insert(tarjeta);
        } else {
            tarjetaMapper.update(tarjeta);
        }
    }
    public void elimina(int id) {
        tarjetaMapper.delete(id);
    }

}