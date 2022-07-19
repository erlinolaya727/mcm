/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.ejb.proyectomcm;

import edu.sena.entity.proyectomcm.FacturaDeVenta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author erlin
 */
@Local
public interface FacturaDeVentaFacadeLocal {

    void create(FacturaDeVenta facturaDeVenta);

    void edit(FacturaDeVenta facturaDeVenta);

    void remove(FacturaDeVenta facturaDeVenta);

    FacturaDeVenta find(Object id);

    List<FacturaDeVenta> findAll();

    List<FacturaDeVenta> findRange(int[] range);

    int count();
    
}
