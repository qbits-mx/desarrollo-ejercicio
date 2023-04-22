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
    public List<DatosAlta> gettwo() {
        return chambeaMapper.gettwo();

    }
    public Datos ObtenProductoPorId(int id) {
        return chambeaMapper.selectById(id);
    }
    public Resultados getBigResul(int id) {
        Datos datos = chambeaMapper.selectById(id);
        DatosAlta datosAlta = chambeaMapper.selectById1(id);
        DatosTgc datosTgc = chambeaMapper.selectById2(id);
        List<DatosAlta> alta = chambeaMapper.gettwo();
        List<DatosTgc> tgc = chambeaMapper.getNumeroDeTarjeta(id);
        List<Datos> data = chambeaMapper.getFist();
        
        List<String> DatosAlta = alta.stream().map(p-> p.getDescripcionCorta()).collect(Collectors.toList());
        List<String> DatosTgc = tgc.stream().map(p -> p.getNombre()).collect(Collectors.toList());
        List<String> Datos = data.stream().map(p -> p.getApPaterno()).collect(Collectors.toList());


        return new Resultados(datos, datosAlta,datosTgc, DatosAlta, DatosTgc,Datos);
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
    public void guarda(DatosTgc datosTgc) {
        int id = datosTgc.getId();
        Datos encontrado = this.ObtenUsuarioPorId(id);
        // si NO hay ningún renglón en la tabla "Persona",cuyo id sea
        // el parámetro que recibe el método 'ObtenUsuarioPorId'
        // entonces la variable "encontrado" será ingual a: null
        if(encontrado==null) {
            chambeaMapper.insert2(datosTgc);
        } else {
            chambeaMapper.update2(datosTgc);
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
    @Override
    public List<Datos> getFist() {
        return chambeaMapper.getFist();
    }
    @Override
    public Datos selectById(int id) {
        return chambeaMapper.selectById(id);
    }
    @Override
    public DatosAlta selectById1(int id) {
        return chambeaMapper.selectById1(id);
    }
    @Override
    public DatosTgc selectById2(int id) {
       return chambeaMapper.selectById2(id);
    }
    @Override
    public DatosAlta selectById0(int id) {
      return chambeaMapper.selectById0(id);
    }
    @Override
    public void guarda(DatosAlta datosAlta) {
      int id = datosAlta.getId();
      DatosAlta encontrado = this.selectById1(id);

      if (encontrado == null) {
        chambeaMapper.insert1(datosAlta);
      } else {
        chambeaMapper.update1(datosAlta);
      }
    }
    @Override
    public void guarda1(Datos datos) {
        int id = datos.getId();
        Datos encontrado = this.selectById(id);

        if (encontrado == null) {
          chambeaMapper.insert(datos);
        } else {
          chambeaMapper.update(datos);
        }        
    }
    @Override
    public void guarda2(DatosTgc datosTgc) {
        int id = datosTgc.getId();
        DatosTgc encontrado = this.selectById2(id);

        if (encontrado == null) {
          chambeaMapper.insert2(datosTgc);
        } else {
          chambeaMapper.update2(datosTgc);
        }        
    }        
    }
