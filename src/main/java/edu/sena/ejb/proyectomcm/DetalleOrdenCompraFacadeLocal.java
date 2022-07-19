/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.ejb.proyectomcm;

import edu.sena.entity.proyectomcm.DetalleOrdenCompra;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author erlin
 */
@Local
public interface DetalleOrdenCompraFacadeLocal {

    void create(DetalleOrdenCompra detalleOrdenCompra);

    void edit(DetalleOrdenCompra detalleOrdenCompra);

    void remove(DetalleOrdenCompra detalleOrdenCompra);

    DetalleOrdenCompra find(Object id);

    List<DetalleOrdenCompra> findAll();

    List<DetalleOrdenCompra> findRange(int[] range);

    int count();
    
}
