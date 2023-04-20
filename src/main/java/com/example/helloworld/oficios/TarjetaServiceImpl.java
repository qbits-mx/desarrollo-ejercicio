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

    @Override
    public List<Tarjeta> getAll() {
        return tarjetaMapper.getAll();
    }

    @Override
    public Tarjeta selectById(int id) {
        return tarjetaMapper.selectById(id);
    }

    @Override
    public void guarda(Tarjeta tarjeta) {
        int id = tarjeta.getId();
        Tarjeta encontrado = this.selectById(id);

        if (encontrado == null) {
            tarjetaMapper.insert(tarjeta);
        } else {
            tarjetaMapper.update(tarjeta);
        }
    }

    @Override
    public void elimina(int id) {
        tarjetaMapper.delete(id);
    }

}