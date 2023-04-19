package com.example.helloworld.chambea;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.helloworld.chambea.model.Datos;
import com.example.helloworld.chambea.model.DatosAlta;
import com.example.helloworld.chambea.model.DatosImg;
import com.example.helloworld.chambea.model.Resultados;
@Primary
@Service
public abstract class ChambeaServiceImpl implements ChambeaService{
    private ChambeaMapper chambeaMapper;
    public ChambeaServiceImpl(ChambeaMapper chambeaMapper) {
        this.chambeaMapper = chambeaMapper;
    }
    public List<Datos> obtenTodosLosDatos() {
        return chambeaMapper.getAllOne();
    }
    public Datos ObtenProductoPorId(int id) {
        return chambeaMapper.selectById(id);
    }
    public Resultados getBigResul(int id) {
        Datos datos = chambeaMapper.selectById(id);
        List<DatosAlta> alta = chambeaMapper.getAllCaractForDatos(id);
        List<DatosImg> imagenes = chambeaMapper.getAllImagesForUsers(id);
        
        List<String> DatosAlta = alta.stream().map(p-> p.getDescripcionCorta()).collect(Collectors.toList());
        List<String> DatosImg = imagenes.stream().map(p -> p.getNombreDeLaImagen()).collect(Collectors.toList());

        return new Resultados(datos, DatosAlta, DatosImg);
    }
    public void guarda(Datos datos) {
        int id = datos.getIdUsuario();
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
}
