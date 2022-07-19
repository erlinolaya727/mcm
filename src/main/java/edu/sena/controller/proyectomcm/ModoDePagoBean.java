package edu.sena.controller.proyectomcm;


import edu.sena.ejb.proyectomcm.ModoDePagoFacadeLocal;
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
public class ModoDePagoBean implements Serializable {

    @EJB
    private ModoDePagoFacadeLocal modoDePagoFacade;
    private List<ModoDePago> listaModoPago;
    private ModoDePago modoPago;
    private String msn;

    public List<ModoDePago> getListaModoPago() {
        this.listaModoPago = this.modoDePagoFacade.findAll();
        return listaModoPago;
    }

    public void setListaModoPago(List<ModoDePago> listaModoPago) {
        this.listaModoPago = listaModoPago;
    }

    public ModoDePago getModoPago() {
        this.listaModoPago = this.modoDePagoFacade.findAll();
        return modoPago;
    }

    public void setModoPago(ModoDePago modoPago) {
        this.modoPago = modoPago;
    }

    @PostConstruct
    public void init() {
        this.modoPago = new ModoDePago();
    }

    public void guardar() {
        try {
            this.modoDePagoFacade.create(modoPago);
            this.modoPago = new ModoDePago();
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
            this.modoDePagoFacade.edit(modoPago);
            this.modoPago = new ModoDePago();
            this.msn = "Registro Exitoso";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "Error: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar(ModoDePago eliminarModo) {
        try {
            this.modoDePagoFacade.remove(eliminarModo);
            this.msn = "Registro Eliminado";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "Error: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void cargarDatos(ModoDePago cargaModo) {
        this.modoPago = cargaModo;

    }

    public void limpiarDatos() {
        this.modoPago = new ModoDePago();
    }

}
