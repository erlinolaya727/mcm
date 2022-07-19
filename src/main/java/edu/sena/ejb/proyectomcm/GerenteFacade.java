/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.ejb.proyectomcm;

import edu.sena.entity.proyectomcm.Gerente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author erlin
 */
@Stateless
public class GerenteFacade extends AbstractFacade<Gerente> implements GerenteFacadeLocal {

    @PersistenceContext(unitName = "upMCMpayara")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GerenteFacade() {
        super(Gerente.class);
    }
    
}
