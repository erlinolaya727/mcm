/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.ejb.proyectomcm;

import edu.sena.entity.proyectomcm.OrdenDeServicio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author erlin
 */
@Local
public interface OrdenDeServicioFacadeLocal {

    void create(OrdenDeServicio ordenDeServicio);

    void edit(OrdenDeServicio ordenDeServicio);

    void remove(OrdenDeServicio ordenDeServicio);

    OrdenDeServicio find(Object id);

    List<OrdenDeServicio> findAll();

    List<OrdenDeServicio> findRange(int[] range);

    int count();
    
}
