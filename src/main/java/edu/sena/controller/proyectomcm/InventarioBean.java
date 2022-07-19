package edu.sena.controller.proyectomcm;


import edu.sena.ejb.proyectomcm.InventarioFacadeLocal;
import edu.sena.entity.proyectomcm.Inventario;
import edu.sena.entity.proyectomcm.Producto;
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
public class InventarioBean implements Serializable {

    @EJB
    private InventarioFacadeLocal inventarioFacade;
    private List<Inventario> listaInventario;
    private Inventario inventario;
    private Producto producto;
    private String msn;

    public List<Inventario> getListaInventario() {
        this.listaInventario = this.inventarioFacade.findAll();
        return listaInventario;
    }

    public void setListaInventario(List<Inventario> listaInventario) {
        this.listaInventario = listaInventario;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @PostConstruct
    public void init() {
        this.inventario = new Inventario();
        this.producto = new Producto();
    }

    public void guardar() {
        try {
            this.inventario.setProductoidProducto(producto);
            this.inventarioFacade.create(inventario);
            this.inventario = new Inventario();
            this.producto = new Producto();
            this.msn = "Registro Guardado Correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "ERROR: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void editar() {
        try {
            this.inventario.setProductoidProducto(producto);
            this.inventarioFacade.edit(inventario);
            
            this.inventario = new Inventario();
            this.producto = new Producto();
            this.msn = "Registro Guardado Correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "ERROR: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar(Inventario eliminaInventario) {
        try {
            this.inventarioFacade.remove(eliminaInventario);
            this.msn = "Registro Eliminado";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "ERROR: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void cargarDatos(Inventario cargaInventario) {
        this.producto.setIdProducto(cargaInventario.getProductoidProducto().getIdProducto());
        this.inventario=cargaInventario;
    }

    public void limpiarDatos() {
            this.inventario = new Inventario();
            this.producto = new Producto();
    }
}
