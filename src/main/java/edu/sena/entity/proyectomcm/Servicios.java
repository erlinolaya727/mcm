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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author erlin
 */
@Entity
@Table(name = "servicios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicios.findAll", query = "SELECT s FROM Servicios s"),
    @NamedQuery(name = "Servicios.findByIdServicio", query = "SELECT s FROM Servicios s WHERE s.idServicio = :idServicio"),
    @NamedQuery(name = "Servicios.findByFechaServicio", query = "SELECT s FROM Servicios s WHERE s.fechaServicio = :fechaServicio"),
    @NamedQuery(name = "Servicios.findByTareas", query = "SELECT s FROM Servicios s WHERE s.tareas = :tareas")})
public class Servicios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idServicio")
    private Integer idServicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_Servicio")
    @Temporal(TemporalType.DATE)
    private Date fechaServicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Tareas")
    private String tareas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviciosidConsecutivo", fetch = FetchType.LAZY)
    private Collection<Tareas> tareasCollection;
    @JoinColumn(name = "Agenda_idAgenda", referencedColumnName = "idAgenda")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Agenda agendaidAgenda;
    @JoinColumn(name = "OrdenServicio_idOrden", referencedColumnName = "idOrden_de_Servicio")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private OrdenDeServicio ordenServicioidOrden;

    public Servicios() {
    }

    public Servicios(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public Servicios(Integer idServicio, Date fechaServicio, String tareas) {
        this.idServicio = idServicio;
        this.fechaServicio = fechaServicio;
        this.tareas = tareas;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public Date getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(Date fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    public String getTareas() {
        return tareas;
    }

    public void setTareas(String tareas) {
        this.tareas = tareas;
    }

    @XmlTransient
    public Collection<Tareas> getTareasCollection() {
        return tareasCollection;
    }

    public void setTareasCollection(Collection<Tareas> tareasCollection) {
        this.tareasCollection = tareasCollection;
    }

    public Agenda getAgendaidAgenda() {
        return agendaidAgenda;
    }

    public void setAgendaidAgenda(Agenda agendaidAgenda) {
        this.agendaidAgenda = agendaidAgenda;
    }

    public OrdenDeServicio getOrdenServicioidOrden() {
        return ordenServicioidOrden;
    }

    public void setOrdenServicioidOrden(OrdenDeServicio ordenServicioidOrden) {
        this.ordenServicioidOrden = ordenServicioidOrden;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServicio != null ? idServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicios)) {
            return false;
        }
        Servicios other = (Servicios) object;
        if ((this.idServicio == null && other.idServicio != null) || (this.idServicio != null && !this.idServicio.equals(other.idServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.pruebas.entity.Servicios[ idServicio=" + idServicio + " ]";
    }
    
}
