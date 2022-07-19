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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author erlin
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByPass", query = "SELECT u FROM Usuario u WHERE u.pass = :pass"),
    @NamedQuery(name = "Usuario.findByTelefono", query = "SELECT u FROM Usuario u WHERE u.telefono = :telefono"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByApellido", query = "SELECT u FROM Usuario u WHERE u.apellido = :apellido"),
    @NamedQuery(name = "Usuario.findByDireccion", query = "SELECT u FROM Usuario u WHERE u.direccion = :direccion"),
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email"),
    @NamedQuery(name = "Usuario.findByEstado", query = "SELECT u FROM Usuario u WHERE u.estado = :estado"),
    @NamedQuery(name = "Usuario.findByUsuFoto", query = "SELECT u FROM Usuario u WHERE u.usuFoto = :usuFoto"),
    @NamedQuery(name = "Usuario.findByUsuTipodocumento", query = "SELECT u FROM Usuario u WHERE u.usuTipodocumento = :usuTipodocumento")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @Size(max = 45)
    @Column(name = "pass")
    private String pass;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "apellido")
    private String apellido;
    @Size(max = 45)
    @Column(name = "direccion")
    private String direccion;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Column(name = "estado")
    private Short estado;
    @Size(max = 255)
    @Column(name = "usu_foto")
    private String usuFoto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "usuTipodocumento")
    private String usuTipodocumento;
    @ManyToMany(mappedBy = "usuarioCollection", fetch = FetchType.LAZY)
    private Collection<Roles> rolesCollection;
    @OneToMany(mappedBy = "usuarioidUsuario", fetch = FetchType.LAZY)
    private Collection<Analistainventarios> analistainventariosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioidUsuario", fetch = FetchType.LAZY)
    private Collection<Tecnicos> tecnicosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioidUsuario", fetch = FetchType.LAZY)
    private Collection<Gerente> gerenteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioidUsuario", fetch = FetchType.LAZY)
    private Collection<Vendedor> vendedorCollection;
    @JoinColumn(name = "Cargos_idCargos", referencedColumnName = "idCargos")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cargos cargosidCargos;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String telefono, String nombre, String apellido, String usuTipodocumento) {
        this.idUsuario = idUsuario;
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuTipodocumento = usuTipodocumento;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Short getEstado() {
        return estado;
    }

    public void setEstado(Short estado) {
        this.estado = estado;
    }

    public String getUsuFoto() {
        return usuFoto;
    }

    public void setUsuFoto(String usuFoto) {
        this.usuFoto = usuFoto;
    }

    public String getUsuTipodocumento() {
        return usuTipodocumento;
    }

    public void setUsuTipodocumento(String usuTipodocumento) {
        this.usuTipodocumento = usuTipodocumento;
    }

    @XmlTransient
    public Collection<Roles> getRolesCollection() {
        return rolesCollection;
    }

    public void setRolesCollection(Collection<Roles> rolesCollection) {
        this.rolesCollection = rolesCollection;
    }

    @XmlTransient
    public Collection<Analistainventarios> getAnalistainventariosCollection() {
        return analistainventariosCollection;
    }

    public void setAnalistainventariosCollection(Collection<Analistainventarios> analistainventariosCollection) {
        this.analistainventariosCollection = analistainventariosCollection;
    }

    @XmlTransient
    public Collection<Tecnicos> getTecnicosCollection() {
        return tecnicosCollection;
    }

    public void setTecnicosCollection(Collection<Tecnicos> tecnicosCollection) {
        this.tecnicosCollection = tecnicosCollection;
    }

    @XmlTransient
    public Collection<Gerente> getGerenteCollection() {
        return gerenteCollection;
    }

    public void setGerenteCollection(Collection<Gerente> gerenteCollection) {
        this.gerenteCollection = gerenteCollection;
    }

    @XmlTransient
    public Collection<Vendedor> getVendedorCollection() {
        return vendedorCollection;
    }

    public void setVendedorCollection(Collection<Vendedor> vendedorCollection) {
        this.vendedorCollection = vendedorCollection;
    }

    public Cargos getCargosidCargos() {
        return cargosidCargos;
    }

    public void setCargosidCargos(Cargos cargosidCargos) {
        this.cargosidCargos = cargosidCargos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.pruebas.entity.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
