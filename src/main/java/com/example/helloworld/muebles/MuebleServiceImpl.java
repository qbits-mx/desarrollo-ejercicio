package com.example.helloworld.muebles;

import java.util.List;

import org.springframework.stereotype.Service;

@Service(value = "implementacion")
public class MuebleServiceImpl implements MuebleService {
    private MuebleMapper muebleMapper;
    
    public MuebleServiceImpl(MuebleMapper muebleMapper) {
        this.muebleMapper = muebleMapper;
    }
    @Override
    public List<Mueble> getAll() {
        return muebleMapper.getAll();
	}
	@Override
	public Mueble compra(String lm, String sucursal, String variable1, String variable2, String variable3) {
		return muebleMapper.getById(1);
	}
	
}