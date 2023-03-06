package com.example.helloworld.muebles;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.helloworld.mappers.MuebleMapper;

@Service
public class MuebleServiceImpl implements MueblesService {
	    private MuebleMapper muebleMapper;
	    
	    public MuebleServiceImpl(MuebleMapper muebleMapper) {
	        this.muebleMapper = muebleMapper;
	    }
	    public Mueble cal(int id, String nom, String col, String pre, String ago) {
	        return muebleMapper.getById(7534);
	    }
	    @Override
	    public List<Mueble> getAll() {
	    	List<Mueble> resultado = muebleMapper.getAll();
	    	System.out.println(resultado);
	        return resultado;
	    }


}
