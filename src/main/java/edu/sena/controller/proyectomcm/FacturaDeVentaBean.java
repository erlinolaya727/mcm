package edu.sena.controller.proyectomcm;


import edu.sena.ejb.proyectomcm.FacturaDeVentaFacadeLocal;
import edu.sena.entity.proyectomcm.Cliente;
import edu.sena.entity.proyectomcm.FacturaDeVenta;
import edu.sena.entity.proyectomcm.ModoDePago;
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
public class FacturaDeVentaBean implements Serializable {

    @EJB
    private FacturaDeVentaFacadeLocal facturaVentaFacade;
    private List<FacturaDeVenta> listaFacturaDeVenta;
    private FacturaDeVenta facturaVenta;
    private ModoDePago modoPago;
    private Cliente cliente;
    private String msn;

    public List<FacturaDeVenta> getListaFacturaDeVenta() {
        this.listaFacturaDeVenta = this.facturaVentaFacade.findAll();
        return listaFacturaDeVenta;
    }

    public void setListaFacturaDeVenta(List<FacturaDeVenta> listaFacturaDeVenta) {
        this.listaFacturaDeVenta = listaFacturaDeVenta;
    }

    public FacturaDeVenta getFacturaVenta() {
        return facturaVenta;
    }

    public void setFacturaVenta(FacturaDeVenta facturaVenta) {
        this.facturaVenta = facturaVenta;
    }

    public ModoDePago getModoPago() {
        return modoPago;
    }

    public void setModoPago(ModoDePago modoPago) {
        this.modoPago = modoPago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @PostConstruct
    public void init() {
        this.cliente = new Cliente();
        this.modoPago = new ModoDePago();
        this.facturaVenta = new FacturaDeVenta();
    }

    public void guardar() {
        try {
            this.facturaVenta.setClienteidCliente(cliente);
            this.facturaVenta.setModoPagoidModo(modoPago);
            this.facturaVentaFacade.create(facturaVenta);
            this.cliente = new Cliente();
            this.modoPago = new ModoDePago();
            this.facturaVenta = new FacturaDeVenta();
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
            this.facturaVenta.setClienteidCliente(cliente);
            this.facturaVenta.setModoPagoidModo(modoPago);
            this.facturaVentaFacade.edit(facturaVenta);
            this.cliente = new Cliente();
            this.modoPago = new ModoDePago();
            this.facturaVenta = new FacturaDeVenta();
            this.msn = "Registro Exitoso";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "Error: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar(FacturaDeVenta eliminarFactura) {
        try {
            this.facturaVentaFacade.remove(eliminarFactura);
            this.msn = "Registro Eliminado";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "Error: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void cargarDatos(FacturaDeVenta cargaFactura) {
        this.facturaVenta = cargaFactura;
        this.cliente.setIdCliente(cargaFactura.getClienteidCliente().getIdCliente());
        this.modoPago.setIdModo(cargaFactura.getModoPagoidModo().getIdModo());
    }

    public void limpiarDatos() {
        this.cliente = new Cliente();
        this.modoPago = new ModoDePago();
        this.facturaVenta = new FacturaDeVenta();
    }

}
