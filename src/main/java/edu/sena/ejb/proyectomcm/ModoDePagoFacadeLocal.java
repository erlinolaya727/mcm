/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.ejb.proyectomcm;

import edu.sena.entity.proyectomcm.ModoDePago;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author erlin
 */
@Local
public interface ModoDePagoFacadeLocal {

    void create(ModoDePago modoDePago);

    void edit(ModoDePago modoDePago);

    void remove(ModoDePago modoDePago);

    ModoDePago find(Object id);

    List<ModoDePago> findAll();

    List<ModoDePago> findRange(int[] range);

    int count();
    
}
