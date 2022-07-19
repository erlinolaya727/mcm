package edu.sena.controller.proyectomcm;

import edu.sena.ejb.proyectomcm.DetalleOrdenCompraFacadeLocal;
import edu.sena.entity.proyectomcm.DetalleOrdenCompra;
import edu.sena.entity.proyectomcm.OrdenDeCompra;
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
public class DetalleOrdenCompraBean implements Serializable {

    @EJB
    private DetalleOrdenCompraFacadeLocal DetalleOrdenCompraEJB;
    private List<DetalleOrdenCompra> listaDetalleOrdenCompra;
    private DetalleOrdenCompra detalleOrdenCompra;
    private Producto producto;
    private OrdenDeCompra ordenCompra;
    private String msn;

    public List<DetalleOrdenCompra> getListaDetalleOrdenCompra() {
        this.listaDetalleOrdenCompra = this.DetalleOrdenCompraEJB.findAll();
        return listaDetalleOrdenCompra;
    }

    public void setListaDetalleOrdenCompra(List<DetalleOrdenCompra> listaDetalleOrdenCompra) {
        this.listaDetalleOrdenCompra = listaDetalleOrdenCompra;
    }

    public DetalleOrdenCompra getDetalleOrdenCompra() {
        return detalleOrdenCompra;
    }

    public void setDetalleOrdenCompra(DetalleOrdenCompra detalleOrdenCompra) {
        this.detalleOrdenCompra = detalleOrdenCompra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public OrdenDeCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenDeCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn;
    }

    @PostConstruct
    public void init() {
        this.detalleOrdenCompra = new DetalleOrdenCompra();
        this.ordenCompra = new OrdenDeCompra();
        this.producto = new Producto();
    }

    public void guardar() {
        try {
            this.detalleOrdenCompra.setProductoidProducto(producto);
            this.detalleOrdenCompra.setOrdenCompraidOrden(ordenCompra);
            this.DetalleOrdenCompraEJB.create(detalleOrdenCompra);
            this.detalleOrdenCompra = new DetalleOrdenCompra();
            this.ordenCompra = new OrdenDeCompra();
            this.producto = new Producto();
            this.detalleOrdenCompra = new DetalleOrdenCompra();
            this.msn = "Registro Guardado Exitosamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "Error: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void editar() {
        try {
            this.detalleOrdenCompra.setProductoidProducto(producto);
            this.detalleOrdenCompra.setOrdenCompraidOrden(ordenCompra);
            this.DetalleOrdenCompraEJB.edit(detalleOrdenCompra);
            this.detalleOrdenCompra = new DetalleOrdenCompra();
            this.ordenCompra = new OrdenDeCompra();
            this.producto = new Producto();
            this.detalleOrdenCompra = new DetalleOrdenCompra();
            this.msn = "Registro Editado Exitosamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "Error: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar(DetalleOrdenCompra detalle) {
        try {
            this.DetalleOrdenCompraEJB.remove(detalle);
            this.msn = "Registro Eliminado Exitosamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "Error: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void limpiarDatos() {
        this.detalleOrdenCompra = new DetalleOrdenCompra();
        this.ordenCompra = new OrdenDeCompra();
        this.producto = new Producto();
    }

    public void cargarDatos(DetalleOrdenCompra cargaDetalleOC) {
        this.producto.setIdProducto(cargaDetalleOC.getProductoidProducto().getIdProducto());
        this.ordenCompra.setIdOrden(cargaDetalleOC.getOrdenCompraidOrden().getIdOrden());
        this.detalleOrdenCompra = cargaDetalleOC;
    }
}
