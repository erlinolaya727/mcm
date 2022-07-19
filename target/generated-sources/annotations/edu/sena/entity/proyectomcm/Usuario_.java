package edu.sena.entity.proyectomcm;

import edu.sena.entity.proyectomcm.Analistainventarios;
import edu.sena.entity.proyectomcm.Cargos;
import edu.sena.entity.proyectomcm.Gerente;
import edu.sena.entity.proyectomcm.Roles;
import edu.sena.entity.proyectomcm.Tecnicos;
import edu.sena.entity.proyectomcm.Vendedor;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-30T22:44:31")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, Short> estado;
    public static volatile SingularAttribute<Usuario, Cargos> cargosidCargos;
    public static volatile CollectionAttribute<Usuario, Gerente> gerenteCollection;
    public static volatile SingularAttribute<Usuario, String> pass;
    public static volatile CollectionAttribute<Usuario, Tecnicos> tecnicosCollection;
    public static volatile SingularAttribute<Usuario, Integer> idUsuario;
    public static volatile SingularAttribute<Usuario, String> direccion;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile SingularAttribute<Usuario, String> usuFoto;
    public static volatile SingularAttribute<Usuario, String> apellido;
    public static volatile CollectionAttribute<Usuario, Analistainventarios> analistainventariosCollection;
    public static volatile CollectionAttribute<Usuario, Roles> rolesCollection;
    public static volatile SingularAttribute<Usuario, String> telefono;
    public static volatile SingularAttribute<Usuario, String> email;
    public static volatile SingularAttribute<Usuario, String> usuTipodocumento;
    public static volatile CollectionAttribute<Usuario, Vendedor> vendedorCollection;

}