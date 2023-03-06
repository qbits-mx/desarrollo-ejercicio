package com.example.helloworld.muebles;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service(value = "muebleImplementacionYYY")
public class MuebleServiceImpl2 implements MuebleService {
    private MuebleMapper muebleMapper;
    
    public MuebleServiceImpl2(MuebleMapper muebleMapper) {
        this.muebleMapper = muebleMapper;
    }
    
    public Mueble calcula(String ua, String col, String v1, String v2, String v3) {
        Mueble p = muebleMapper.getById(0);
//        float nuevo = 2*p.getPrecio();
//        if(nuevo>150) {
//            p.setNombre("super adinerado");
//        } else {
//            p.setColor("verde");
//        }
//        p.setPrecio(nuevo);
        muebleMapper.insert(p);
        return p;
    }
    @Override
    public List<Mueble> getAll() {
        return muebleMapper.getAll();
    }
}
