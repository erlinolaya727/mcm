package edu.sena.entity.proyectomcm;

import edu.sena.entity.proyectomcm.Agenda;
import edu.sena.entity.proyectomcm.OrdenDeServicio;
import edu.sena.entity.proyectomcm.Tareas;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-30T22:44:31")
@StaticMetamodel(Servicios.class)
public class Servicios_ { 

    public static volatile CollectionAttribute<Servicios, Tareas> tareasCollection;
    public static volatile SingularAttribute<Servicios, Agenda> agendaidAgenda;
    public static volatile SingularAttribute<Servicios, Integer> idServicio;
    public static volatile SingularAttribute<Servicios, Date> fechaServicio;
    public static volatile SingularAttribute<Servicios, String> tareas;
    public static volatile SingularAttribute<Servicios, OrdenDeServicio> ordenServicioidOrden;

}