package edu.sena.entity.proyectomcm;

import edu.sena.entity.proyectomcm.DetalleOrdenCompra;
import edu.sena.entity.proyectomcm.ModoDePago;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-30T22:44:31")
@StaticMetamodel(OrdenDeCompra.class)
public class OrdenDeCompra_ { 

    public static volatile SingularAttribute<OrdenDeCompra, Date> fecha;
    public static volatile SingularAttribute<OrdenDeCompra, ModoDePago> modoPagoidModo;
    public static volatile CollectionAttribute<OrdenDeCompra, DetalleOrdenCompra> detalleOrdenCompraCollection;
    public static volatile SingularAttribute<OrdenDeCompra, Integer> idOrden;

}