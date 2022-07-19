package edu.sena.entity.proyectomcm;

import edu.sena.entity.proyectomcm.FacturaDeVenta;
import edu.sena.entity.proyectomcm.OrdenDeCompra;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-30T22:44:32")
@StaticMetamodel(ModoDePago.class)
public class ModoDePago_ { 

    public static volatile CollectionAttribute<ModoDePago, OrdenDeCompra> ordenDeCompraCollection;
    public static volatile SingularAttribute<ModoDePago, Integer> idModo;
    public static volatile CollectionAttribute<ModoDePago, FacturaDeVenta> facturaDeVentaCollection;
    public static volatile SingularAttribute<ModoDePago, String> modo;

}