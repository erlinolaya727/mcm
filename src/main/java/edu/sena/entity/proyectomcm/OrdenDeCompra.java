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
@Table(name = "orden_de_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenDeCompra.findAll", query = "SELECT o FROM OrdenDeCompra o"),
    @NamedQuery(name = "OrdenDeCompra.findByIdOrden", query = "SELECT o FROM OrdenDeCompra o WHERE o.idOrden = :idOrden"),
    @NamedQuery(name = "OrdenDeCompra.findByFecha", query = "SELECT o FROM OrdenDeCompra o WHERE o.fecha = :fecha")})
public class OrdenDeCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idOrden")
    private Integer idOrden;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "ModoPago_idModo", referencedColumnName = "idModo")
    @ManyToOne(fetch = FetchType.LAZY)
    private ModoDePago modoPagoidModo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenCompraidOrden", fetch = FetchType.LAZY)
    private Collection<DetalleOrdenCompra> detalleOrdenCompraCollection;

    public OrdenDeCompra() {
    }

    public OrdenDeCompra(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ModoDePago getModoPagoidModo() {
        return modoPagoidModo;
    }

    public void setModoPagoidModo(ModoDePago modoPagoidModo) {
        this.modoPagoidModo = modoPagoidModo;
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
        hash += (idOrden != null ? idOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenDeCompra)) {
            return false;
        }
        OrdenDeCompra other = (OrdenDeCompra) object;
        if ((this.idOrden == null && other.idOrden != null) || (this.idOrden != null && !this.idOrden.equals(other.idOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.pruebas.entity.OrdenDeCompra[ idOrden=" + idOrden + " ]";
    }
    
}
