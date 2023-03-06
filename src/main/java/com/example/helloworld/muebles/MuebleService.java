package com.example.helloworld.muebles;

import java.util.List;

public interface MuebleService {
	Mueble compra(String lm, String sucursal, String variable1, String variable2, String variable3);
    List<Mueble> getAll();
}