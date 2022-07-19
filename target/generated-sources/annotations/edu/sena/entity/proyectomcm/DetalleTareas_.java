package edu.sena.entity.proyectomcm;

import edu.sena.entity.proyectomcm.Tareas;
import edu.sena.entity.proyectomcm.Tecnicos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-30T22:44:32")
@StaticMetamodel(DetalleTareas.class)
public class DetalleTareas_ { 

    public static volatile SingularAttribute<DetalleTareas, String> descripcion;
    public static volatile SingularAttribute<DetalleTareas, Date> fecha;
    public static volatile SingularAttribute<DetalleTareas, Integer> idDetalle;
    public static volatile SingularAttribute<DetalleTareas, Tareas> tareasidTareas;
    public static volatile SingularAttribute<DetalleTareas, Tecnicos> tecnicosidEmpleado;

}