package edu.sena.entity.proyectomcm;

import edu.sena.entity.proyectomcm.DetalleTareas;
import edu.sena.entity.proyectomcm.Servicios;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-30T22:44:32")
@StaticMetamodel(Tareas.class)
public class Tareas_ { 

    public static volatile SingularAttribute<Tareas, Integer> idTareas;
    public static volatile SingularAttribute<Tareas, Date> fehainicio;
    public static volatile SingularAttribute<Tareas, String> duracion;
    public static volatile CollectionAttribute<Tareas, DetalleTareas> detalleTareasCollection;
    public static volatile SingularAttribute<Tareas, Servicios> serviciosidConsecutivo;
    public static volatile SingularAttribute<Tareas, Date> fechaFin;

}