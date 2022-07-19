package edu.sena.entity.proyectomcm;

import edu.sena.entity.proyectomcm.FacturaDeVenta;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-30T22:44:31")
@StaticMetamodel(DetalleFacturaVenta.class)
public class DetalleFacturaVenta_ { 

    public static volatile SingularAttribute<DetalleFacturaVenta, String> descripcion;
    public static volatile SingularAttribute<DetalleFacturaVenta, String> precioUnitario;
    public static volatile SingularAttribute<DetalleFacturaVenta, Integer> idDetallefactura;
    public static volatile SingularAttribute<DetalleFacturaVenta, Integer> cantidad;
    public static volatile SingularAttribute<DetalleFacturaVenta, FacturaDeVenta> facturaVentaidFactura;

}