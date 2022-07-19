
package edu.sena.controller.proyectomcm;


import edu.sena.ejb.proyectomcm.CategoriaProductoFacadeLocal;
import edu.sena.entity.proyectomcm.CategoriaProducto;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class CategoriaProductoBean implements Serializable{
    
    @EJB
    private CategoriaProductoFacadeLocal categoriaFacade;
    private List<CategoriaProducto> listaCategoriaProducto;
    private CategoriaProducto categoriaProducto;
    private String msn;

    public List<CategoriaProducto> getListaCategoriaProducto() {
        this.listaCategoriaProducto=this.categoriaFacade.findAll();
        return listaCategoriaProducto;
    }

    public void setListaCategoriaProducto(List<CategoriaProducto> listaCategoriaProducto) {
        this.listaCategoriaProducto = listaCategoriaProducto;
    }

    public CategoriaProducto getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(CategoriaProducto categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn;
    }
    
    @PostConstruct
    public void init(){
        this.categoriaProducto=new CategoriaProducto();
    }
    
     public void guardar() {
        try {
            this.categoriaFacade.create(categoriaProducto);
            this.categoriaProducto=new CategoriaProducto();
            this.msn = "Registro Exitoso";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "Error: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void editar() {
        try {
            this.categoriaFacade.edit(categoriaProducto);
            this.categoriaProducto=new CategoriaProducto();
            this.msn = "Registro Exitoso";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "Error: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar(CategoriaProducto eliminarCategoria) {
        try {
            this.categoriaFacade.remove(eliminarCategoria);
            this.msn = "Registro Eliminado";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "Error: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void cargarDatos(CategoriaProducto cargaCategoria) {
        this.categoriaProducto=cargaCategoria;

    }

    public void limpiarDatos() {
        this.categoriaProducto=new CategoriaProducto();
    } 
}
