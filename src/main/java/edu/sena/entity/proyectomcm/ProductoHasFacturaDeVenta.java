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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author erlin
 */
@Entity
@Table(name = "producto_has_factura_de_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoHasFacturaDeVenta.findAll", query = "SELECT p FROM ProductoHasFacturaDeVenta p"),
    @NamedQuery(name = "ProductoHasFacturaDeVenta.findByFacturadeVentaidFactura", query = "SELECT p FROM ProductoHasFacturaDeVenta p WHERE p.facturadeVentaidFactura = :facturadeVentaidFactura")})
public class ProductoHasFacturaDeVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FacturaVenta_idFactura")
    private Integer facturadeVentaidFactura;
    @JoinColumn(name = "FacturaVenta_idFactura", referencedColumnName = "idFactura", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private FacturaDeVenta facturaDeVenta;
    @JoinColumn(name = "Producto_idProducto", referencedColumnName = "idProducto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto productoidProducto;

    public ProductoHasFacturaDeVenta() {
    }

    public ProductoHasFacturaDeVenta(Integer facturadeVentaidFactura) {
        this.facturadeVentaidFactura = facturadeVentaidFactura;
    }

    public Integer getFacturadeVentaidFactura() {
        return facturadeVentaidFactura;
    }

    public void setFacturadeVentaidFactura(Integer facturadeVentaidFactura) {
        this.facturadeVentaidFactura = facturadeVentaidFactura;
    }

    public FacturaDeVenta getFacturaDeVenta() {
        return facturaDeVenta;
    }

    public void setFacturaDeVenta(FacturaDeVenta facturaDeVenta) {
        this.facturaDeVenta = facturaDeVenta;
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
        hash += (facturadeVentaidFactura != null ? facturadeVentaidFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoHasFacturaDeVenta)) {
            return false;
        }
        ProductoHasFacturaDeVenta other = (ProductoHasFacturaDeVenta) object;
        if ((this.facturadeVentaidFactura == null && other.facturadeVentaidFactura != null) || (this.facturadeVentaidFactura != null && !this.facturadeVentaidFactura.equals(other.facturadeVentaidFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.pruebas.entity.ProductoHasFacturaDeVenta[ facturadeVentaidFactura=" + facturadeVentaidFactura + " ]";
    }
    
}
