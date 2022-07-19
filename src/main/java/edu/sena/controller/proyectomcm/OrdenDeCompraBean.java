package edu.sena.controller.proyectomcm;



import edu.sena.ejb.proyectomcm.OrdenDeCompraFacadeLocal;
import edu.sena.entity.proyectomcm.ModoDePago;
import edu.sena.entity.proyectomcm.OrdenDeCompra;
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
public class OrdenDeCompraBean implements Serializable {

    @EJB
    private OrdenDeCompraFacadeLocal OrdenDeCompraFacade;
    private List<OrdenDeCompra> listaOrdenDeCompra;
    private OrdenDeCompra OrdenDeCompra;
    private ModoDePago ModoPago;
    private String msn;

    public List<OrdenDeCompra> getListaOrdenDeCompra() {
        this.listaOrdenDeCompra=this.OrdenDeCompraFacade.findAll();
        return listaOrdenDeCompra;
    }

    public OrdenDeCompra getOrdenDeCompra() {
        return OrdenDeCompra;
    }

    public void setOrdenDeCompra(OrdenDeCompra OrdenDeCompra) {
        this.OrdenDeCompra = OrdenDeCompra;
    }

    public ModoDePago getModoPago() {
        return ModoPago;
    }

    public void setModoPago(ModoDePago ModoPago) {
        this.ModoPago = ModoPago;
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn;
    }

    @PostConstruct
    public void init() {
        this.OrdenDeCompra = new OrdenDeCompra();
        this.ModoPago = new ModoDePago();
    }

    public void guardar() {
        try {
            this.OrdenDeCompra.setModoPagoidModo(ModoPago);
            this.OrdenDeCompraFacade.create(OrdenDeCompra);
            this.ModoPago = new ModoDePago();
            this.OrdenDeCompra = new OrdenDeCompra();
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
            this.OrdenDeCompra.setModoPagoidModo(ModoPago);
            this.OrdenDeCompraFacade.edit(OrdenDeCompra);
            this.ModoPago = new ModoDePago();
            this.OrdenDeCompra = new OrdenDeCompra();
            this.msn = "Registro Actualizado";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "ERROR: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar(OrdenDeCompra eliminaOrdenDeCompra) {
        try {
            this.OrdenDeCompraFacade.remove(eliminaOrdenDeCompra);
            this.msn = "Registro Eliminado";

        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "ERROR: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void cargarDatos(OrdenDeCompra cargaOrdenDeCompra) {
        this.ModoPago.setIdModo(cargaOrdenDeCompra.getModoPagoidModo().getIdModo());
        this.OrdenDeCompra = cargaOrdenDeCompra;
    }

    public void limpiarDatos() {
        this.OrdenDeCompra = new OrdenDeCompra();
        this.ModoPago = new ModoDePago();

    }
}
