package com.example.helloworld.productos;

import java.util.List;

import com.example.helloworld.productos.modelo.Producto;
import com.example.helloworld.productos.modelo.ResultadoConsulta;

public interface ProductoService {
  /**
   * Nos devuelve una lista de todos los productos pertenecientes a la lista.
   * @return Lista de productos de la base de datos de los productos.
   */
  List<Producto> tomaTodos();
  /**
   * Nos devuelve un objeto tipo "producto" que tiene un "id" asignado
   *  por este metodo.Si no existe ningun producto con el "id" asignado,
   * este metodo regresa un producto de tipo null.
   * @param id "KEY" del producto para ser encontrado.
   * @return Resultado del producto correspondiente al id proporcionado.
   */
  Producto tomaPorId(int id);
  /**
   * Busca el producto dado y si no está en la base de datos, 
   * lo inserta, pero si está en la base, lo actualiza.
   * 
   * @param producto Producto a ser insertado o actualizado
   */
  void cambia(Producto producto);
  /**
   * Elimina el producto cuyo id es el dado.
   * Si no existe ningún producto con ese di, no hace nada.
   * 
   * @param id Entero asociado a un posible producto.
   */
  void asesina(int id);


  /**
   * Retorna un objeto tipo json compuesto por 3 objetos diferentes
   * que constituyen el json.
   * @param idProducto Entero asociado al "id" de un objeto especifico.
   * @return objeto envolvente requerido de tipo consulta.
   */
  ResultadoConsulta getResultadoConsulta(int idProducto);
}

