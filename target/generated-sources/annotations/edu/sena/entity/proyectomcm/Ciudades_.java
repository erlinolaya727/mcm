package edu.sena.entity.proyectomcm;

import edu.sena.entity.proyectomcm.OrdenDeServicio;
import edu.sena.entity.proyectomcm.Proveedor;
import edu.sena.entity.proyectomcm.Taladro;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-30T22:44:31")
@StaticMetamodel(Ciudades.class)
public class Ciudades_ { 

    public static volatile CollectionAttribute<Ciudades, OrdenDeServicio> ordenDeServicioCollection;
    public static volatile SingularAttribute<Ciudades, String> nombreCiudad;
    public static volatile CollectionAttribute<Ciudades, Proveedor> proveedorCollection;
    public static volatile SingularAttribute<Ciudades, Integer> idCiudad;
    public static volatile CollectionAttribute<Ciudades, Taladro> taladroCollection;

}