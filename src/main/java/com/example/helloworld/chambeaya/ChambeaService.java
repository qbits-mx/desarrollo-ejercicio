package com.example.helloworld.chambeaya;

import com.example.helloworld.chambeaya.model.Usuario;

public interface ChambeaService {
    /**
     * Retorna todos los datos de un usuario en especifico
     * guardados en la base de datos.
     * @return Objeto de datos de usuario provenientes de la base de datos.
     */
    Usuario getDatos(int id);
    
    /**
     * Busca el id del usuario dado y si no está en la base de datos, 
     * lo inserta, pero si está en la base, lo actualiza.
     * 
     * @param usuario Usuario a ser insertado o actualizado
     */
    void guarda(Usuario usuario);

}
