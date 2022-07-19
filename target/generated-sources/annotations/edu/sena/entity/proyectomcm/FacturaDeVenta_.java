package edu.sena.entity.proyectomcm;

import edu.sena.entity.proyectomcm.Cliente;
import edu.sena.entity.proyectomcm.DetalleFacturaVenta;
import edu.sena.entity.proyectomcm.ModoDePago;
import edu.sena.entity.proyectomcm.ProductoHasFacturaDeVenta;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-30T22:44:31")
@StaticMetamodel(FacturaDeVenta.class)
public class FacturaDeVenta_ { 

    public static volatile SingularAttribute<FacturaDeVenta, Date> fecha;
    public static volatile SingularAttribute<FacturaDeVenta, ModoDePago> modoPagoidModo;
    public static volatile SingularAttribute<FacturaDeVenta, Float> iva;
    public static volatile SingularAttribute<FacturaDeVenta, ProductoHasFacturaDeVenta> productoHasFacturaDeVenta;
    public static volatile SingularAttribute<FacturaDeVenta, Integer> idFactura;
    public static volatile SingularAttribute<FacturaDeVenta, Cliente> clienteidCliente;
    public static volatile CollectionAttribute<FacturaDeVenta, DetalleFacturaVenta> detalleFacturaVentaCollection;

}