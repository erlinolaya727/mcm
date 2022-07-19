
package edu.sena.ejb.proyectomcm;

import edu.sena.entity.proyectomcm.Bonificacion;
import java.util.List;
import javax.ejb.Local;

@Local
public interface BonificacionFacadeLocal {

    void create(Bonificacion bonificacion);

    void edit(Bonificacion bonificacion);

    void remove(Bonificacion bonificacion);

    Bonificacion find(Object id);

    List<Bonificacion> findAll();

    List<Bonificacion> findRange(int[] range);

    int count();
    
}
