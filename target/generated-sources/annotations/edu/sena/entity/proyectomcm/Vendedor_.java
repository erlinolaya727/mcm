package edu.sena.entity.proyectomcm;

import edu.sena.entity.proyectomcm.Cliente;
import edu.sena.entity.proyectomcm.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-30T22:44:32")
@StaticMetamodel(Vendedor.class)
public class Vendedor_ { 

    public static volatile SingularAttribute<Vendedor, Usuario> usuarioidUsuario;
    public static volatile SingularAttribute<Vendedor, Float> comision;
    public static volatile SingularAttribute<Vendedor, Integer> idVendedor;
    public static volatile CollectionAttribute<Vendedor, Cliente> clienteCollection;

}