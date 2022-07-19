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
@Table(name = "cargos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cargos.findAll", query = "SELECT c FROM Cargos c"),
    @NamedQuery(name = "Cargos.findByIdCargos", query = "SELECT c FROM Cargos c WHERE c.idCargos = :idCargos"),
    @NamedQuery(name = "Cargos.findByNombreCargo", query = "SELECT c FROM Cargos c WHERE c.nombreCargo = :nombreCargo")})
public class Cargos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCargos")
    private Integer idCargos;
    @Size(max = 255)
    @Column(name = "nombre_cargo")
    private String nombreCargo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cargosidCargos", fetch = FetchType.LAZY)
    private Collection<Usuario> usuarioCollection;

    public Cargos() {
    }

    public Cargos(Integer idCargos) {
        this.idCargos = idCargos;
    }

    public Integer getIdCargos() {
        return idCargos;
    }

    public void setIdCargos(Integer idCargos) {
        this.idCargos = idCargos;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCargos != null ? idCargos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargos)) {
            return false;
        }
        Cargos other = (Cargos) object;
        if ((this.idCargos == null && other.idCargos != null) || (this.idCargos != null && !this.idCargos.equals(other.idCargos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.pruebas.entity.Cargos[ idCargos=" + idCargos + " ]";
    }
    
}
