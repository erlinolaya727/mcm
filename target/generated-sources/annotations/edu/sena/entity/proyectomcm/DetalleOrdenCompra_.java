package edu.sena.entity.proyectomcm;

import edu.sena.entity.proyectomcm.OrdenDeCompra;
import edu.sena.entity.proyectomcm.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-30T22:44:32")
@StaticMetamodel(DetalleOrdenCompra.class)
public class DetalleOrdenCompra_ { 

    public static volatile SingularAttribute<DetalleOrdenCompra, String> descripcion;
    public static volatile SingularAttribute<DetalleOrdenCompra, String> idDetalle;
    public static volatile SingularAttribute<DetalleOrdenCompra, Producto> productoidProducto;
    public static volatile SingularAttribute<DetalleOrdenCompra, Double> precioCompra;
    public static volatile SingularAttribute<DetalleOrdenCompra, OrdenDeCompra> ordenCompraidOrden;
    public static volatile SingularAttribute<DetalleOrdenCompra, Integer> cantidad;

}