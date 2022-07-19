/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.ejb.proyectomcm;

import edu.sena.entity.proyectomcm.Taladro;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author erlin
 */
@Local
public interface TaladroFacadeLocal {

    void create(Taladro taladro);

    void edit(Taladro taladro);

    void remove(Taladro taladro);

    Taladro find(Object id);

    List<Taladro> findAll();

    List<Taladro> findRange(int[] range);

    int count();
    
}
