package com.example.helloworld.chambea;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.helloworld.chambea.model.Datos;
import com.example.helloworld.chambea.model.DatosAlta;
import com.example.helloworld.chambea.model.DatosTgc;
import com.example.helloworld.chambea.model.Resultados;
@Primary
@Service
public  class ChambeaServiceImpl implements ChambeaService{
    private ChambeaMapper chambeaMapper;
    public ChambeaServiceImpl(ChambeaMapper chambeaMapper) {
        this.chambeaMapper = chambeaMapper;
    }
    public List<DatosAlta> gettwo(int id) {
        return chambeaMapper.gettwo(id);

    }
    public Datos ObtenProductoPorId(int id) {
        return chambeaMapper.selectById(id);
    }
    public Resultados getBigResul(int id) {
        Datos datos = chambeaMapper.selectById(id);
        List<DatosAlta> alta = chambeaMapper.gettwo( id);
        List<DatosTgc> tgc = chambeaMapper.getNumeroDeTarjeta(id);
        
        List<String> DatosAlta = alta.stream().map(p-> p.getDescripcionCorta()).collect(Collectors.toList());
        List<String> DatosTgc = tgc.stream().map(p -> p.getNombre()).collect(Collectors.toList());

        return new Resultados(datos, DatosAlta, DatosTgc);
    }
    public void guarda(Datos datos) {
        int id = datos.getId();
        Datos encontrado = this.ObtenUsuarioPorId(id);
        // si NO hay ningún renglón en la tabla "Persona",cuyo id sea
        // el parámetro que recibe el método 'ObtenUsuarioPorId'
        // entonces la variable "encontrado" será ingual a: null
        if(encontrado==null) {
            chambeaMapper.insert(datos);
        } else {
            chambeaMapper.update(datos);
        }
    }
    public void elimina(int id) {
        chambeaMapper.delete(id);
    }
    @Override
    public Datos ObtenUsuarioPorId(int id) {
        return chambeaMapper.selectById(id);
    }
    @Override
    public List<DatosTgc> getone() {

        return chambeaMapper.getone();
    }
    
}
