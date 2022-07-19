/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.entity.proyectomcm;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author erlin
 */
@Entity
@Table(name = "detalle_tareas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleTareas.findAll", query = "SELECT d FROM DetalleTareas d"),
    @NamedQuery(name = "DetalleTareas.findByIdDetalle", query = "SELECT d FROM DetalleTareas d WHERE d.idDetalle = :idDetalle"),
    @NamedQuery(name = "DetalleTareas.findByFecha", query = "SELECT d FROM DetalleTareas d WHERE d.fecha = :fecha"),
    @NamedQuery(name = "DetalleTareas.findByDescripcion", query = "SELECT d FROM DetalleTareas d WHERE d.descripcion = :descripcion")})
public class DetalleTareas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDetalle")
    private Integer idDetalle;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "Tareas_idTareas", referencedColumnName = "idTareas")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tareas tareasidTareas;
    @JoinColumn(name = "Tecnicos_idEmpleado", referencedColumnName = "idEmpleado")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tecnicos tecnicosidEmpleado;

    public DetalleTareas() {
    }

    public DetalleTareas(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Tareas getTareasidTareas() {
        return tareasidTareas;
    }

    public void setTareasidTareas(Tareas tareasidTareas) {
        this.tareasidTareas = tareasidTareas;
    }

    public Tecnicos getTecnicosidEmpleado() {
        return tecnicosidEmpleado;
    }

    public void setTecnicosidEmpleado(Tecnicos tecnicosidEmpleado) {
        this.tecnicosidEmpleado = tecnicosidEmpleado;
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
        if (!(object instanceof DetalleTareas)) {
            return false;
        }
        DetalleTareas other = (DetalleTareas) object;
        if ((this.idDetalle == null && other.idDetalle != null) || (this.idDetalle != null && !this.idDetalle.equals(other.idDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.pruebas.entity.DetalleTareas[ idDetalle=" + idDetalle + " ]";
    }
    
}
