package edu.sena.entity.proyectomcm;

import edu.sena.entity.proyectomcm.CategoriaProducto;
import edu.sena.entity.proyectomcm.DetalleOrdenCompra;
import edu.sena.entity.proyectomcm.Inventario;
import edu.sena.entity.proyectomcm.ProductoHasFacturaDeVenta;
import edu.sena.entity.proyectomcm.Proveedor;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-30T22:44:31")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> descripcion;
    public static volatile SingularAttribute<Producto, String> marca;
    public static volatile CollectionAttribute<Producto, DetalleOrdenCompra> detalleOrdenCompraCollection;
    public static volatile SingularAttribute<Producto, CategoriaProducto> categoriaProductoidCategoria;
    public static volatile CollectionAttribute<Producto, ProductoHasFacturaDeVenta> productoHasFacturaDeVentaCollection;
    public static volatile SingularAttribute<Producto, Integer> ordenCompraidOrden;
    public static volatile SingularAttribute<Producto, Integer> idProducto;
    public static volatile CollectionAttribute<Producto, Inventario> inventarioCollection;
    public static volatile SingularAttribute<Producto, Double> precioVenta;
    public static volatile SingularAttribute<Producto, String> nombre;
    public static volatile SingularAttribute<Producto, String> garantia;
    public static volatile SingularAttribute<Producto, Proveedor> proveedoridProveedor;

}