/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.ejb.proyectomcm;

import edu.sena.entity.proyectomcm.Analistainventarios;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author erlin
 */
@Stateless
public class AnalistaInventariosFacade extends AbstractFacade<Analistainventarios> implements AnalistaInventariosFacadeLocal {

    @PersistenceContext(unitName = "upMCMpayara")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AnalistaInventariosFacade() {
        super(Analistainventarios.class);
    }
    
}
