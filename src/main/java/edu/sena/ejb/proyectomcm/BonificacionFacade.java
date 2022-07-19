
package edu.sena.ejb.proyectomcm;


import edu.sena.entity.proyectomcm.Bonificacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author erlin
 */
@Stateless
public class BonificacionFacade extends AbstractFacade<Bonificacion> implements BonificacionFacadeLocal {

    @PersistenceContext(unitName = "upMCMpayara")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BonificacionFacade() {
        super(Bonificacion.class);
    }
    
}
