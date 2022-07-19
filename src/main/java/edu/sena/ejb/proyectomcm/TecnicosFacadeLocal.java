/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.ejb.proyectomcm;

import edu.sena.entity.proyectomcm.Tecnicos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author erlin
 */
@Local
public interface TecnicosFacadeLocal {

    void create(Tecnicos tecnicos);

    void edit(Tecnicos tecnicos);

    void remove(Tecnicos tecnicos);

    Tecnicos find(Object id);

    List<Tecnicos> findAll();

    List<Tecnicos> findRange(int[] range);

    int count();
    
}
