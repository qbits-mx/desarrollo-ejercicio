package com.example.helloworld.chambea;

import java.util.List;

import com.example.helloworld.chambea.model.Datos;
import com.example.helloworld.chambea.model.DatosTgc;
import com.example.helloworld.chambea.model.Oficio;
import com.example.helloworld.chambea.model.Resultados;
import com.example.helloworld.chambea.model.DatosAlta;
public interface ChambeaService {
        /**
         * Retorna todos los productos guardados en la base de datos.
         * @param id 
         * @return Lista de Productos provenientes de la base de datos.
         */
        List<DatosAlta> gettwo();

        Datos ObtenUsuarioPorId(int id);
        Datos selectById(int id);
        DatosAlta selectById1(int id);
        DatosTgc selectById2(int id);


        /**
         * Busca el producto dado y si no está en la base de datos, 
         * lo inserta, pero si está en la base, lo actualiza.
         * 
         * @param producto Producto a ser insertado o actualizado
         */

        /**
         * Elimina el producto cuyo id es el dado.
         * Si no existe ningún producto con ese di, no hace nada.
         * 
         * @param id Entero asociado a un posible producto.
         */
        void elimina(int id);
        void elimina1(int id);
        void elimina2(int id);

        List<DatosTgc> getone();

        List<Datos> getFist();
        
        DatosAlta selectById0(int id);
        void guarda(DatosAlta datosAlta);
        void guarda1(Datos datos);
        void guarda2(DatosTgc datosTgc);

        Oficio getofice(int id);

    }

