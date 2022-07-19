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
@Table(name = "modo_de_pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModoDePago.findAll", query = "SELECT m FROM ModoDePago m"),
    @NamedQuery(name = "ModoDePago.findByIdModo", query = "SELECT m FROM ModoDePago m WHERE m.idModo = :idModo"),
    @NamedQuery(name = "ModoDePago.findByModo", query = "SELECT m FROM ModoDePago m WHERE m.modo = :modo")})
public class ModoDePago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idModo")
    private Integer idModo;
    @Size(max = 45)
    @Column(name = "modo")
    private String modo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modoPagoidModo", fetch = FetchType.LAZY)
    private Collection<FacturaDeVenta> facturaDeVentaCollection;
    @OneToMany(mappedBy = "modoPagoidModo", fetch = FetchType.LAZY)
    private Collection<OrdenDeCompra> ordenDeCompraCollection;

    public ModoDePago() {
    }

    public ModoDePago(Integer idModo) {
        this.idModo = idModo;
    }

    public Integer getIdModo() {
        return idModo;
    }

    public void setIdModo(Integer idModo) {
        this.idModo = idModo;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    @XmlTransient
    public Collection<FacturaDeVenta> getFacturaDeVentaCollection() {
        return facturaDeVentaCollection;
    }

    public void setFacturaDeVentaCollection(Collection<FacturaDeVenta> facturaDeVentaCollection) {
        this.facturaDeVentaCollection = facturaDeVentaCollection;
    }

    @XmlTransient
    public Collection<OrdenDeCompra> getOrdenDeCompraCollection() {
        return ordenDeCompraCollection;
    }

    public void setOrdenDeCompraCollection(Collection<OrdenDeCompra> ordenDeCompraCollection) {
        this.ordenDeCompraCollection = ordenDeCompraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModo != null ? idModo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModoDePago)) {
            return false;
        }
        ModoDePago other = (ModoDePago) object;
        if ((this.idModo == null && other.idModo != null) || (this.idModo != null && !this.idModo.equals(other.idModo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.pruebas.entity.ModoDePago[ idModo=" + idModo + " ]";
    }
    
}
