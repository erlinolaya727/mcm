/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.ejb.proyectomcm;

import edu.sena.entity.proyectomcm.DetalleTareas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author erlin
 */
@Local
public interface DetalleTareasFacadeLocal {

    void create(DetalleTareas detalleTareas);

    void edit(DetalleTareas detalleTareas);

    void remove(DetalleTareas detalleTareas);

    DetalleTareas find(Object id);

    List<DetalleTareas> findAll();

    List<DetalleTareas> findRange(int[] range);

    int count();
    
}
