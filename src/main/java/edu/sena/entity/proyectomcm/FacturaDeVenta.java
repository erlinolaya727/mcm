/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.entity.proyectomcm;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author erlin
 */
@Entity
@Table(name = "factura_de_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacturaDeVenta.findAll", query = "SELECT f FROM FacturaDeVenta f"),
    @NamedQuery(name = "FacturaDeVenta.findByIdFactura", query = "SELECT f FROM FacturaDeVenta f WHERE f.idFactura = :idFactura"),
    @NamedQuery(name = "FacturaDeVenta.findByIva", query = "SELECT f FROM FacturaDeVenta f WHERE f.iva = :iva"),
    @NamedQuery(name = "FacturaDeVenta.findByFecha", query = "SELECT f FROM FacturaDeVenta f WHERE f.fecha = :fecha")})
public class FacturaDeVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idFactura")
    private Integer idFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iva")
    private float iva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "Cliente_idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente clienteidCliente;
    @JoinColumn(name = "ModoPago_idModo", referencedColumnName = "idModo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ModoDePago modoPagoidModo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facturaVentaidFactura", fetch = FetchType.LAZY)
    private Collection<DetalleFacturaVenta> detalleFacturaVentaCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "facturaDeVenta", fetch = FetchType.LAZY)
    private ProductoHasFacturaDeVenta productoHasFacturaDeVenta;

    public FacturaDeVenta() {
    }

    public FacturaDeVenta(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public FacturaDeVenta(Integer idFactura, float iva, Date fecha) {
        this.idFactura = idFactura;
        this.iva = iva;
        this.fecha = fecha;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getClienteidCliente() {
        return clienteidCliente;
    }

    public void setClienteidCliente(Cliente clienteidCliente) {
        this.clienteidCliente = clienteidCliente;
    }

    public ModoDePago getModoPagoidModo() {
        return modoPagoidModo;
    }

    public void setModoPagoidModo(ModoDePago modoPagoidModo) {
        this.modoPagoidModo = modoPagoidModo;
    }

    @XmlTransient
    public Collection<DetalleFacturaVenta> getDetalleFacturaVentaCollection() {
        return detalleFacturaVentaCollection;
    }

    public void setDetalleFacturaVentaCollection(Collection<DetalleFacturaVenta> detalleFacturaVentaCollection) {
        this.detalleFacturaVentaCollection = detalleFacturaVentaCollection;
    }

    public ProductoHasFacturaDeVenta getProductoHasFacturaDeVenta() {
        return productoHasFacturaDeVenta;
    }

    public void setProductoHasFacturaDeVenta(ProductoHasFacturaDeVenta productoHasFacturaDeVenta) {
        this.productoHasFacturaDeVenta = productoHasFacturaDeVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFactura != null ? idFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaDeVenta)) {
            return false;
        }
        FacturaDeVenta other = (FacturaDeVenta) object;
        if ((this.idFactura == null && other.idFactura != null) || (this.idFactura != null && !this.idFactura.equals(other.idFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.pruebas.entity.FacturaDeVenta[ idFactura=" + idFactura + " ]";
    }
    
}
