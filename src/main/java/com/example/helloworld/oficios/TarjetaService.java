package com.example.helloworld.oficios;

import java.util.List;

import com.example.helloworld.oficios.model.Tarjeta;

public interface TarjetaService {
    /**
     * Retorna todas las tarjetas guardadas en la base de datos.
     * 
     * @return Lista de Tarjetas provenientes de la base de datos.
     */
    List<Tarjeta> getAll();

    /**
     * Regresa un objeto de tipo 'Tarjeta' el cual tiene por id, el argumento pasado
     * a este método. Si no existe ninguna tarjeta con ese id, este método regresa una
     * tarjeta nula (null)
     * 
     * @param id Llave de la tarjeta a ser buscada
     * @return Tarjeta asociada al id proporcionado
     */
    Tarjeta selectById(int id);

    /**
     * Busca la tarjeta dada y si no está en la base de datos, la inserta, pero si
     * está en la base, la actualiza.
     * 
     * @param Tarjeta a ser insertado o actualizado
     */
    void guarda(Tarjeta p);

    /**
     * Elimina la tarjeta cuyo id es el dado. Si no existe ninguna tarjeta con ese
     * id, no hace nada.
     * 
     * @param id Entero asociado a una posible tarjeta.
     */
    void elimina(int id);

}