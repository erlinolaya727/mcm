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
import javax.persistence.ManyToMany;
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
@Table(name = "tecnicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tecnicos.findAll", query = "SELECT t FROM Tecnicos t"),
    @NamedQuery(name = "Tecnicos.findByIdEmpleado", query = "SELECT t FROM Tecnicos t WHERE t.idEmpleado = :idEmpleado")})
public class Tecnicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEmpleado")
    private Integer idEmpleado;
    @ManyToMany(mappedBy = "tecnicosCollection", fetch = FetchType.LAZY)
    private Collection<OrdenDeServicio> ordenDeServicioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tecnicosidEmpleado", fetch = FetchType.LAZY)
    private Collection<DetalleTareas> detalleTareasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tecnicosidTecnicos", fetch = FetchType.LAZY)
    private Collection<Bonificacion> bonificacionCollection;
    @JoinColumn(name = "Usuario_idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuarioidUsuario;

    public Tecnicos() {
    }

    public Tecnicos(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @XmlTransient
    public Collection<OrdenDeServicio> getOrdenDeServicioCollection() {
        return ordenDeServicioCollection;
    }

    public void setOrdenDeServicioCollection(Collection<OrdenDeServicio> ordenDeServicioCollection) {
        this.ordenDeServicioCollection = ordenDeServicioCollection;
    }

    @XmlTransient
    public Collection<DetalleTareas> getDetalleTareasCollection() {
        return detalleTareasCollection;
    }

    public void setDetalleTareasCollection(Collection<DetalleTareas> detalleTareasCollection) {
        this.detalleTareasCollection = detalleTareasCollection;
    }

    @XmlTransient
    public Collection<Bonificacion> getBonificacionCollection() {
        return bonificacionCollection;
    }

    public void setBonificacionCollection(Collection<Bonificacion> bonificacionCollection) {
        this.bonificacionCollection = bonificacionCollection;
    }

    public Usuario getUsuarioidUsuario() {
        return usuarioidUsuario;
    }

    public void setUsuarioidUsuario(Usuario usuarioidUsuario) {
        this.usuarioidUsuario = usuarioidUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tecnicos)) {
            return false;
        }
        Tecnicos other = (Tecnicos) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.pruebas.entity.Tecnicos[ idEmpleado=" + idEmpleado + " ]";
    }
    
}
