package com.example.helloworld.productos;

import java.util.List;

import com.example.helloworld.productos.modelo.ConsultaFinal;
import com.example.helloworld.productos.modelo.Producto;

public interface ProductoService {
    /**
     * Retorna todos los productos guardados en la base de datos.
     * @return Lista de Productos provenientes de la base de datos.
     */
    List<Producto> obtenTodosLosProductos();
    
    /**
     * Regresa un objeto de tipo 'Producto' el cual
     * tiene por id, el argumento pasado a este método.
     * Si no existe ningún producto con ese id, este método
     * regresa un producto nulo (null)
     * 

     */
    Producto ObtenProductoPorId(int id);
    
    /**
     * Busca el producto dado y si no está en la base de datos, 
     * lo inserta, pero si está en la base, lo actualiza.
     * 
     */
    void guarda(Producto producto);
    
    /**
     * Elimina el producto cuyo id es el dado.
     * Si no existe ningún producto con ese di, no hace nada.
     * 
     */
    void elimina(int id);
    /**
     * Retorna un objeto compuesto por tres objetos dependientes
     * que constituyen en conjunto el json requerido por el cliente.
     * 

     */
    ConsultaFinal getConsultaFinal(int idProducto);

}
