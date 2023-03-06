package com.example.helloworld.muebles;

import java.util.List;

public interface MuebleService {
    Mueble calcula(String ua, String col, String v1, String v2, String v3);
    List<Mueble> getAll();
}
