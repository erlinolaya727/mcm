/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.ejb.proyectomcm;

import edu.sena.entity.proyectomcm.Analistainventarios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author erlin
 */
@Local
public interface AnalistaInventariosFacadeLocal {

    void create(Analistainventarios analistainventarios);

    void edit(Analistainventarios analistainventarios);

    void remove(Analistainventarios analistainventarios);

    Analistainventarios find(Object id);

    List<Analistainventarios> findAll();

    List<Analistainventarios> findRange(int[] range);

    int count();
    
}
