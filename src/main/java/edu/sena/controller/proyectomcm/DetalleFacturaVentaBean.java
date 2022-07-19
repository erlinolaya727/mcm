package edu.sena.controller.proyectomcm;


import edu.sena.ejb.proyectomcm.DetalleFacturaVentaFacadeLocal;
import edu.sena.entity.proyectomcm.DetalleFacturaVenta;
import edu.sena.entity.proyectomcm.FacturaDeVenta;
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
public class DetalleFacturaVentaBean implements Serializable {

    @EJB
    private DetalleFacturaVentaFacadeLocal detalleFacturaFacade;
    private List<DetalleFacturaVenta> listaDetalleFactura;
    private DetalleFacturaVenta detalleFactura;
    private FacturaDeVenta factura;
    private String msn;

    public List<DetalleFacturaVenta> getListaDetalleFactura() {
        this.listaDetalleFactura = this.detalleFacturaFacade.findAll();
        return listaDetalleFactura;
    }

    public void setListaDetalleFactura(List<DetalleFacturaVenta> listaDetalleFactura) {
        this.listaDetalleFactura = listaDetalleFactura;
    }

    public DetalleFacturaVenta getDetalleFactura() {
        return detalleFactura;
    }

    public void setDetalleFactura(DetalleFacturaVenta detalleFactura) {
        this.detalleFactura = detalleFactura;
    }

    public FacturaDeVenta getFactura() {
        return factura;
    }

    public void setFactura(FacturaDeVenta factura) {
        this.factura = factura;
    }

    @PostConstruct
    public void init() {
        this.detalleFactura = new DetalleFacturaVenta();
        this.factura = new FacturaDeVenta();
    }

    public void guardar() {
        try {
            this.detalleFactura.setFacturaVentaidFactura(factura);
            this.detalleFacturaFacade.create(detalleFactura);
            this.detalleFactura = new DetalleFacturaVenta();
            this.factura = new FacturaDeVenta();
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
            this.detalleFactura.setFacturaVentaidFactura(factura);
            this.detalleFacturaFacade.edit(detalleFactura);
            this.detalleFactura = new DetalleFacturaVenta();
            this.factura = new FacturaDeVenta();
            this.msn = "Registro Actualizado Correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "ERROR: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar(DetalleFacturaVenta eliminaDetalleFactura) {
        try {
            this.detalleFacturaFacade.remove(eliminaDetalleFactura);
            this.msn = "Registro Eliminado";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "ERROR: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void cargarDatos(DetalleFacturaVenta cargaDetalle) {

        this.detalleFactura=cargaDetalle;
        this.factura.setIdFactura(cargaDetalle.getFacturaVentaidFactura().getIdFactura());        
    }

    public void limpiarDatos() {
        this.factura = new FacturaDeVenta();
        this.detalleFactura= new DetalleFacturaVenta();
    }

}
