/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.ejb.proyectomcm;

import edu.sena.entity.proyectomcm.Inventario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author erlin
 */
@Local
public interface InventarioFacadeLocal {

    void create(Inventario inventario);

    void edit(Inventario inventario);

    void remove(Inventario inventario);

    Inventario find(Object id);

    List<Inventario> findAll();

    List<Inventario> findRange(int[] range);

    int count();
    
}
