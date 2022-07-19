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
@Table(name = "tipo_servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoServicio.findAll", query = "SELECT t FROM TipoServicio t"),
    @NamedQuery(name = "TipoServicio.findByIdTipoServicio", query = "SELECT t FROM TipoServicio t WHERE t.idTipoServicio = :idTipoServicio"),
    @NamedQuery(name = "TipoServicio.findByTipo", query = "SELECT t FROM TipoServicio t WHERE t.tipo = :tipo")})
public class TipoServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTipoServicio")
    private Integer idTipoServicio;
    @Size(max = 45)
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoServicioIdTipo", fetch = FetchType.LAZY)
    private Collection<OrdenDeServicio> ordenDeServicioCollection;

    public TipoServicio() {
    }

    public TipoServicio(Integer idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
    }

    public Integer getIdTipoServicio() {
        return idTipoServicio;
    }

    public void setIdTipoServicio(Integer idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<OrdenDeServicio> getOrdenDeServicioCollection() {
        return ordenDeServicioCollection;
    }

    public void setOrdenDeServicioCollection(Collection<OrdenDeServicio> ordenDeServicioCollection) {
        this.ordenDeServicioCollection = ordenDeServicioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoServicio != null ? idTipoServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoServicio)) {
            return false;
        }
        TipoServicio other = (TipoServicio) object;
        if ((this.idTipoServicio == null && other.idTipoServicio != null) || (this.idTipoServicio != null && !this.idTipoServicio.equals(other.idTipoServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.pruebas.entity.TipoServicio[ idTipoServicio=" + idTipoServicio + " ]";
    }
    
}
