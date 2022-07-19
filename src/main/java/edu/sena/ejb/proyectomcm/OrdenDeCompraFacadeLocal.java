/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.ejb.proyectomcm;

import edu.sena.entity.proyectomcm.OrdenDeCompra;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author erlin
 */
@Local
public interface OrdenDeCompraFacadeLocal {

    void create(OrdenDeCompra ordenDeCompra);

    void edit(OrdenDeCompra ordenDeCompra);

    void remove(OrdenDeCompra ordenDeCompra);

    OrdenDeCompra find(Object id);

    List<OrdenDeCompra> findAll();

    List<OrdenDeCompra> findRange(int[] range);

    int count();
    
}
