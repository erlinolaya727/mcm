/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.entity.proyectomcm;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author erlin
 */
@Entity
@Table(name = "detalle_orden_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleOrdenCompra.findAll", query = "SELECT d FROM DetalleOrdenCompra d"),
    @NamedQuery(name = "DetalleOrdenCompra.findByIdDetalle", query = "SELECT d FROM DetalleOrdenCompra d WHERE d.idDetalle = :idDetalle"),
    @NamedQuery(name = "DetalleOrdenCompra.findByDescripcion", query = "SELECT d FROM DetalleOrdenCompra d WHERE d.descripcion = :descripcion"),
    @NamedQuery(name = "DetalleOrdenCompra.findByCantidad", query = "SELECT d FROM DetalleOrdenCompra d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalleOrdenCompra.findByPrecioCompra", query = "SELECT d FROM DetalleOrdenCompra d WHERE d.precioCompra = :precioCompra")})
public class DetalleOrdenCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "idDetalle")
    private String idDetalle;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "cantidad")
    private Integer cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_compra")
    private Double precioCompra;
    @JoinColumn(name = "OrdenCompra_idOrden", referencedColumnName = "idOrden")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private OrdenDeCompra ordenCompraidOrden;
    @JoinColumn(name = "Producto_idProducto", referencedColumnName = "idProducto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto productoidProducto;

    public DetalleOrdenCompra() {
    }

    public DetalleOrdenCompra(String idDetalle) {
        this.idDetalle = idDetalle;
    }

    public String getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(String idDetalle) {
        this.idDetalle = idDetalle;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public OrdenDeCompra getOrdenCompraidOrden() {
        return ordenCompraidOrden;
    }

    public void setOrdenCompraidOrden(OrdenDeCompra ordenCompraidOrden) {
        this.ordenCompraidOrden = ordenCompraidOrden;
    }

    public Producto getProductoidProducto() {
        return productoidProducto;
    }

    public void setProductoidProducto(Producto productoidProducto) {
        this.productoidProducto = productoidProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalle != null ? idDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleOrdenCompra)) {
            return false;
        }
        DetalleOrdenCompra other = (DetalleOrdenCompra) object;
        if ((this.idDetalle == null && other.idDetalle != null) || (this.idDetalle != null && !this.idDetalle.equals(other.idDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.pruebas.entity.DetalleOrdenCompra[ idDetalle=" + idDetalle + " ]";
    }
    
}
