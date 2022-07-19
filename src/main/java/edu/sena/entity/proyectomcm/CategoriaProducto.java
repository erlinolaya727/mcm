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
@Table(name = "categoria_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaProducto.findAll", query = "SELECT c FROM CategoriaProducto c"),
    @NamedQuery(name = "CategoriaProducto.findByIdCategoria", query = "SELECT c FROM CategoriaProducto c WHERE c.idCategoria = :idCategoria"),
    @NamedQuery(name = "CategoriaProducto.findByNombreCate", query = "SELECT c FROM CategoriaProducto c WHERE c.nombreCate = :nombreCate")})
public class CategoriaProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCategoria")
    private Integer idCategoria;
    @Size(max = 45)
    @Column(name = "nombre_cate")
    private String nombreCate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriaProductoidCategoria", fetch = FetchType.LAZY)
    private Collection<Producto> productoCollection;

    public CategoriaProducto() {
    }

    public CategoriaProducto(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCate() {
        return nombreCate;
    }

    public void setNombreCate(String nombreCate) {
        this.nombreCate = nombreCate;
    }

    @XmlTransient
    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaProducto)) {
            return false;
        }
        CategoriaProducto other = (CategoriaProducto) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.pruebas.entity.CategoriaProducto[ idCategoria=" + idCategoria + " ]";
    }
    
}
