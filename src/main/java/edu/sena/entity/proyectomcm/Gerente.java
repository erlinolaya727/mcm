/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.entity.proyectomcm;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author erlin
 */
@Entity
@Table(name = "gerente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gerente.findAll", query = "SELECT g FROM Gerente g"),
    @NamedQuery(name = "Gerente.findByIdGerente", query = "SELECT g FROM Gerente g WHERE g.idGerente = :idGerente")})
public class Gerente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idGerente")
    private Integer idGerente;
    @JoinColumn(name = "Usuario_idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuarioidUsuario;
    @OneToMany(mappedBy = "gerenteidGerente", fetch = FetchType.LAZY)
    private Collection<OrdenDeServicio> ordenDeServicioCollection;

    public Gerente() {
    }

    public Gerente(Integer idGerente) {
        this.idGerente = idGerente;
    }

    public Integer getIdGerente() {
        return idGerente;
    }

    public void setIdGerente(Integer idGerente) {
        this.idGerente = idGerente;
    }

    public Usuario getUsuarioidUsuario() {
        return usuarioidUsuario;
    }

    public void setUsuarioidUsuario(Usuario usuarioidUsuario) {
        this.usuarioidUsuario = usuarioidUsuario;
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
        hash += (idGerente != null ? idGerente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gerente)) {
            return false;
        }
        Gerente other = (Gerente) object;
        if ((this.idGerente == null && other.idGerente != null) || (this.idGerente != null && !this.idGerente.equals(other.idGerente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.pruebas.entity.Gerente[ idGerente=" + idGerente + " ]";
    }
    
}
