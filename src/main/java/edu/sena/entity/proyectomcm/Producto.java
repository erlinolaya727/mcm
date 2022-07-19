/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.entity.proyectomcm;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author erlin
 */
@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Producto.findByMarca", query = "SELECT p FROM Producto p WHERE p.marca = :marca"),
    @NamedQuery(name = "Producto.findByGarantia", query = "SELECT p FROM Producto p WHERE p.garantia = :garantia"),
    @NamedQuery(name = "Producto.findByPrecioVenta", query = "SELECT p FROM Producto p WHERE p.precioVenta = :precioVenta"),
    @NamedQuery(name = "Producto.findByOrdenCompraidOrden", query = "SELECT p FROM Producto p WHERE p.ordenCompraidOrden = :ordenCompraidOrden")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProducto")
    private Integer idProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 240)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 60)
    @Column(name = "marca")
    private String marca;
    @Size(max = 45)
    @Column(name = "garantia")
    private String garantia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_venta")
    private Double precioVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrdenCompra_idOrden")
    private int ordenCompraidOrden;
    @JoinColumn(name = "CategoriaProducto_idCategoria", referencedColumnName = "idCategoria")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CategoriaProducto categoriaProductoidCategoria;
    @JoinColumn(name = "Proveedor_idProveedor", referencedColumnName = "idProveedor")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Proveedor proveedoridProveedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoidProducto", fetch = FetchType.LAZY)
    private Collection<Inventario> inventarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoidProducto", fetch = FetchType.LAZY)
    private Collection<ProductoHasFacturaDeVenta> productoHasFacturaDeVentaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoidProducto", fetch = FetchType.LAZY)
    private Collection<DetalleOrdenCompra> detalleOrdenCompraCollection;

    public Producto() {
    }

    public Producto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(Integer idProducto, String nombre, int ordenCompraidOrden) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.ordenCompraidOrden = ordenCompraidOrden;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getOrdenCompraidOrden() {
        return ordenCompraidOrden;
    }

    public void setOrdenCompraidOrden(int ordenCompraidOrden) {
        this.ordenCompraidOrden = ordenCompraidOrden;
    }

    public CategoriaProducto getCategoriaProductoidCategoria() {
        return categoriaProductoidCategoria;
    }

    public void setCategoriaProductoidCategoria(CategoriaProducto categoriaProductoidCategoria) {
        this.categoriaProductoidCategoria = categoriaProductoidCategoria;
    }

    public Proveedor getProveedoridProveedor() {
        return proveedoridProveedor;
    }

    public void setProveedoridProveedor(Proveedor proveedoridProveedor) {
        this.proveedoridProveedor = proveedoridProveedor;
    }

    @XmlTransient
    public Collection<Inventario> getInventarioCollection() {
        return inventarioCollection;
    }

    public void setInventarioCollection(Collection<Inventario> inventarioCollection) {
        this.inventarioCollection = inventarioCollection;
    }

    @XmlTransient
    public Collection<ProductoHasFacturaDeVenta> getProductoHasFacturaDeVentaCollection() {
        return productoHasFacturaDeVentaCollection;
    }

    public void setProductoHasFacturaDeVentaCollection(Collection<ProductoHasFacturaDeVenta> productoHasFacturaDeVentaCollection) {
        this.productoHasFacturaDeVentaCollection = productoHasFacturaDeVentaCollection;
    }

    @XmlTransient
    public Collection<DetalleOrdenCompra> getDetalleOrdenCompraCollection() {
        return detalleOrdenCompraCollection;
    }

    public void setDetalleOrdenCompraCollection(Collection<DetalleOrdenCompra> detalleOrdenCompraCollection) {
        this.detalleOrdenCompraCollection = detalleOrdenCompraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.pruebas.entity.Producto[ idProducto=" + idProducto + " ]";
    }
    
}
