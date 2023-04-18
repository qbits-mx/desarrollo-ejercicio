package com.example.helloworld.chambeaya;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.helloworld.chambeaya.model.Usuario;

@Primary
@Service

public class ChambeaServiceImpl implements ChambeaService {
    private ChambeaMapper chambeaMapper;
    
    public ChambeaServiceImpl( ChambeaMapper chambeaMapper ) {
        this.chambeaMapper = chambeaMapper;
    }

    @Override
    public Usuario getDatos(int id) {
        System.out.println("enviando datos");
        return chambeaMapper.getDatos(id);
    }
    
    public void guarda(Usuario usuario) {
        int id = usuario.getIdUser();
        Usuario encontrado = this.getDatos(id);
        // si NO hay ningún renglón en la tabla "Persona",cuyo id sea
        // el parámetro que recibe el método 'ObtenProductoPorId'
        // entonces la variable "encontrado" será ingual a: null
        if(encontrado==null) {
            chambeaMapper.insert(usuario);
        } else {
            chambeaMapper.update(usuario);
        }
    }

}
