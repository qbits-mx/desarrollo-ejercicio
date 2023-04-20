package com.example.helloworld.oficios;

import java.util.List;

import com.example.helloworld.oficios.model.Anuncio;

public interface AnuncioService {
  /**
   * Retorna todos los anuncios guardados en la base de datos.
   * 
   * @return Lista de Anuncios provenientes de la base de datos.
   */
  List<Anuncio> getAll();
  
  /**
   * Regresa un objeto de tipo 'Anuncio' el cual
   * tiene por id, el argumento pasado a este método.
   * Si no existe ningún anuncio con ese id, este método
   * regresa un producto nulo (null)
   * 
   * @param id Llave del anuncio a ser buscado
   * @return Anuncio asociado al id proporcionado
   */
  Anuncio selectById(int id);
  
  /**
   * Busca el anuncio dado y si no está en la base de datos,
   * lo inserta, pero si está en la base, lo actualiza.
   * 
   * @param Anuncio a ser insertado o actualizado
   */
  void guarda(Anuncio anuncio);
  
  /**
   * Elimina el anuncio cuyo id es el dado.
   * Si no existe ningún anuncio con ese di, no hace nada.
   * 
   * @param id Entero asociado a un posible anuncio.
   */
  void elimina(int id);

}