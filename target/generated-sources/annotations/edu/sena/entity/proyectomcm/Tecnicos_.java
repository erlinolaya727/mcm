package edu.sena.entity.proyectomcm;

import edu.sena.entity.proyectomcm.Bonificacion;
import edu.sena.entity.proyectomcm.DetalleTareas;
import edu.sena.entity.proyectomcm.OrdenDeServicio;
import edu.sena.entity.proyectomcm.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-30T22:44:31")
@StaticMetamodel(Tecnicos.class)
public class Tecnicos_ { 

    public static volatile CollectionAttribute<Tecnicos, OrdenDeServicio> ordenDeServicioCollection;
    public static volatile CollectionAttribute<Tecnicos, Bonificacion> bonificacionCollection;
    public static volatile SingularAttribute<Tecnicos, Integer> idEmpleado;
    public static volatile SingularAttribute<Tecnicos, Usuario> usuarioidUsuario;
    public static volatile CollectionAttribute<Tecnicos, DetalleTareas> detalleTareasCollection;

}