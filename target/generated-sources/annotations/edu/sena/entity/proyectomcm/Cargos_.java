package edu.sena.entity.proyectomcm;

import edu.sena.entity.proyectomcm.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-30T22:44:31")
@StaticMetamodel(Cargos.class)
public class Cargos_ { 

    public static volatile SingularAttribute<Cargos, String> nombreCargo;
    public static volatile SingularAttribute<Cargos, Integer> idCargos;
    public static volatile CollectionAttribute<Cargos, Usuario> usuarioCollection;

}