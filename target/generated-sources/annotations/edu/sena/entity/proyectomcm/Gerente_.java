package edu.sena.entity.proyectomcm;

import edu.sena.entity.proyectomcm.OrdenDeServicio;
import edu.sena.entity.proyectomcm.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-30T22:44:31")
@StaticMetamodel(Gerente.class)
public class Gerente_ { 

    public static volatile CollectionAttribute<Gerente, OrdenDeServicio> ordenDeServicioCollection;
    public static volatile SingularAttribute<Gerente, Integer> idGerente;
    public static volatile SingularAttribute<Gerente, Usuario> usuarioidUsuario;

}