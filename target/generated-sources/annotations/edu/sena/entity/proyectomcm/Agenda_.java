package edu.sena.entity.proyectomcm;

import edu.sena.entity.proyectomcm.Servicios;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-30T22:44:32")
@StaticMetamodel(Agenda.class)
public class Agenda_ { 

    public static volatile SingularAttribute<Agenda, Date> fecha;
    public static volatile SingularAttribute<Agenda, Integer> idAgenda;
    public static volatile SingularAttribute<Agenda, String> idServicios;
    public static volatile CollectionAttribute<Agenda, Servicios> serviciosCollection;

}