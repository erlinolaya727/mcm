package edu.sena.entity.proyectomcm;

import edu.sena.entity.proyectomcm.Tecnicos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-30T22:44:32")
@StaticMetamodel(Bonificacion.class)
public class Bonificacion_ { 

    public static volatile SingularAttribute<Bonificacion, Date> fecha;
    public static volatile SingularAttribute<Bonificacion, String> total;
    public static volatile SingularAttribute<Bonificacion, Tecnicos> tecnicosidTecnicos;
    public static volatile SingularAttribute<Bonificacion, Integer> idBonificacion;

}