package edu.sena.entity.proyectomcm;

import edu.sena.entity.proyectomcm.Ciudades;
import edu.sena.entity.proyectomcm.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-30T22:44:31")
@StaticMetamodel(Proveedor.class)
public class Proveedor_ { 

    public static volatile SingularAttribute<Proveedor, String> contacto;
    public static volatile SingularAttribute<Proveedor, Ciudades> ciudadesidCiudad;
    public static volatile SingularAttribute<Proveedor, Integer> idProveedor;
    public static volatile SingularAttribute<Proveedor, String> direccion;
    public static volatile CollectionAttribute<Proveedor, Producto> productoCollection;
    public static volatile SingularAttribute<Proveedor, String> telefono;
    public static volatile SingularAttribute<Proveedor, String> nombre;
    public static volatile SingularAttribute<Proveedor, String> email;

}