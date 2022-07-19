package edu.sena.entity.proyectomcm;

import edu.sena.entity.proyectomcm.FacturaDeVenta;
import edu.sena.entity.proyectomcm.OrdenDeServicio;
import edu.sena.entity.proyectomcm.Taladro;
import edu.sena.entity.proyectomcm.Vendedor;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-30T22:44:31")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile CollectionAttribute<Cliente, OrdenDeServicio> ordenDeServicioCollection;
    public static volatile SingularAttribute<Cliente, String> contacto;
    public static volatile SingularAttribute<Cliente, Integer> idCliente;
    public static volatile SingularAttribute<Cliente, Vendedor> vendedoridVendedor;
    public static volatile SingularAttribute<Cliente, String> direccion;
    public static volatile CollectionAttribute<Cliente, FacturaDeVenta> facturaDeVentaCollection;
    public static volatile SingularAttribute<Cliente, String> telefono;
    public static volatile SingularAttribute<Cliente, String> nombre;
    public static volatile SingularAttribute<Cliente, String> email;
    public static volatile CollectionAttribute<Cliente, Taladro> taladroCollection;

}