package edu.sena.entity.proyectomcm;

import edu.sena.entity.proyectomcm.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-30T22:44:31")
@StaticMetamodel(Roles.class)
public class Roles_ { 

    public static volatile SingularAttribute<Roles, String> descripcion;
    public static volatile SingularAttribute<Roles, Integer> idRoles;
    public static volatile CollectionAttribute<Roles, Usuario> usuarioCollection;
    public static volatile SingularAttribute<Roles, String> nombre;

}