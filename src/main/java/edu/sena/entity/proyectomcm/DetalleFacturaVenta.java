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
import javax.persistence.Lob;
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
@Table(name = "detalle_factura_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleFacturaVenta.findAll", query = "SELECT d FROM DetalleFacturaVenta d"),
    @NamedQuery(name = "DetalleFacturaVenta.findByIdDetallefactura", query = "SELECT d FROM DetalleFacturaVenta d WHERE d.idDetallefactura = :idDetallefactura"),
    @NamedQuery(name = "DetalleFacturaVenta.findByCantidad", query = "SELECT d FROM DetalleFacturaVenta d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalleFacturaVenta.findByDescripcion", query = "SELECT d FROM DetalleFacturaVenta d WHERE d.descripcion = :descripcion")})
public class DetalleFacturaVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDetallefactura")
    private Integer idDetallefactura;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Lob
    @Size(max = 16777215)
    @Column(name = "precio_unitario")
    private String precioUnitario;
    @Size(max = 45)
    @Column(name = "Descripcion")
    private String descripcion;
    @JoinColumn(name = "FacturaVenta_idFactura", referencedColumnName = "idFactura")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private FacturaDeVenta facturaVentaidFactura;

    public DetalleFacturaVenta() {
    }

    public DetalleFacturaVenta(Integer idDetallefactura) {
        this.idDetallefactura = idDetallefactura;
    }

    public Integer getIdDetallefactura() {
        return idDetallefactura;
    }

    public void setIdDetallefactura(Integer idDetallefactura) {
        this.idDetallefactura = idDetallefactura;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(String precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public FacturaDeVenta getFacturaVentaidFactura() {
        return facturaVentaidFactura;
    }

    public void setFacturaVentaidFactura(FacturaDeVenta facturaVentaidFactura) {
        this.facturaVentaidFactura = facturaVentaidFactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetallefactura != null ? idDetallefactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFacturaVenta)) {
            return false;
        }
        DetalleFacturaVenta other = (DetalleFacturaVenta) object;
        if ((this.idDetallefactura == null && other.idDetallefactura != null) || (this.idDetallefactura != null && !this.idDetallefactura.equals(other.idDetallefactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.pruebas.entity.DetalleFacturaVenta[ idDetallefactura=" + idDetallefactura + " ]";
    }
    
}
