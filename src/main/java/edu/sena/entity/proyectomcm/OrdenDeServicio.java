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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "orden_de_servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenDeServicio.findAll", query = "SELECT o FROM OrdenDeServicio o"),
    @NamedQuery(name = "OrdenDeServicio.findByIdOrdendeServicio", query = "SELECT o FROM OrdenDeServicio o WHERE o.idOrdendeServicio = :idOrdendeServicio"),
    @NamedQuery(name = "OrdenDeServicio.findByFechainicio", query = "SELECT o FROM OrdenDeServicio o WHERE o.fechainicio = :fechainicio"),
    @NamedQuery(name = "OrdenDeServicio.findByFechaTerminacion", query = "SELECT o FROM OrdenDeServicio o WHERE o.fechaTerminacion = :fechaTerminacion")})
public class OrdenDeServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idOrden_de_Servicio")
    private Integer idOrdendeServicio;
    @Column(name = "Fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechainicio;
    @Column(name = "Fecha_Terminacion")
    @Temporal(TemporalType.DATE)
    private Date fechaTerminacion;
    @JoinTable(name = "orden_de_servio_has_tecnicos", joinColumns = {
        @JoinColumn(name = "Orden_de Servio_idOrden_de Servio", referencedColumnName = "idOrden_de_Servicio")}, inverseJoinColumns = {
        @JoinColumn(name = "Tecnicos_idEmpleado", referencedColumnName = "idEmpleado")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Tecnicos> tecnicosCollection;
    @JoinColumn(name = "Ciudades_idCiudad", referencedColumnName = "idCiudad")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ciudades ciudadesidCiudad;
    @JoinColumn(name = "Cliente_idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente clienteidCliente;
    @JoinColumn(name = "Gerente_idGerente", referencedColumnName = "idGerente")
    @ManyToOne(fetch = FetchType.LAZY)
    private Gerente gerenteidGerente;
    @JoinColumn(name = "TipoServicio_IdTipo", referencedColumnName = "idTipoServicio")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoServicio tipoServicioIdTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenServicioidOrden", fetch = FetchType.LAZY)
    private Collection<Servicios> serviciosCollection;

    public OrdenDeServicio() {
    }

    public OrdenDeServicio(Integer idOrdendeServicio) {
        this.idOrdendeServicio = idOrdendeServicio;
    }

    public Integer getIdOrdendeServicio() {
        return idOrdendeServicio;
    }

    public void setIdOrdendeServicio(Integer idOrdendeServicio) {
        this.idOrdendeServicio = idOrdendeServicio;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechaTerminacion() {
        return fechaTerminacion;
    }

    public void setFechaTerminacion(Date fechaTerminacion) {
        this.fechaTerminacion = fechaTerminacion;
    }

    @XmlTransient
    public Collection<Tecnicos> getTecnicosCollection() {
        return tecnicosCollection;
    }

    public void setTecnicosCollection(Collection<Tecnicos> tecnicosCollection) {
        this.tecnicosCollection = tecnicosCollection;
    }

    public Ciudades getCiudadesidCiudad() {
        return ciudadesidCiudad;
    }

    public void setCiudadesidCiudad(Ciudades ciudadesidCiudad) {
        this.ciudadesidCiudad = ciudadesidCiudad;
    }

    public Cliente getClienteidCliente() {
        return clienteidCliente;
    }

    public void setClienteidCliente(Cliente clienteidCliente) {
        this.clienteidCliente = clienteidCliente;
    }

    public Gerente getGerenteidGerente() {
        return gerenteidGerente;
    }

    public void setGerenteidGerente(Gerente gerenteidGerente) {
        this.gerenteidGerente = gerenteidGerente;
    }

    public TipoServicio getTipoServicioIdTipo() {
        return tipoServicioIdTipo;
    }

    public void setTipoServicioIdTipo(TipoServicio tipoServicioIdTipo) {
        this.tipoServicioIdTipo = tipoServicioIdTipo;
    }

    @XmlTransient
    public Collection<Servicios> getServiciosCollection() {
        return serviciosCollection;
    }

    public void setServiciosCollection(Collection<Servicios> serviciosCollection) {
        this.serviciosCollection = serviciosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdendeServicio != null ? idOrdendeServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenDeServicio)) {
            return false;
        }
        OrdenDeServicio other = (OrdenDeServicio) object;
        if ((this.idOrdendeServicio == null && other.idOrdendeServicio != null) || (this.idOrdendeServicio != null && !this.idOrdendeServicio.equals(other.idOrdendeServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.pruebas.entity.OrdenDeServicio[ idOrdendeServicio=" + idOrdendeServicio + " ]";
    }
    
}
