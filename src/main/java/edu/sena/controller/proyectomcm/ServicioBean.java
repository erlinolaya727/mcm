
package edu.sena.controller.proyectomcm;

import edu.sena.ejb.proyectomcm.ServiciosFacadeLocal;
import edu.sena.entity.proyectomcm.Agenda;
import edu.sena.entity.proyectomcm.OrdenDeServicio;
import edu.sena.entity.proyectomcm.Servicios;
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
public class ServicioBean implements Serializable {
    @EJB
    private ServiciosFacadeLocal servicioFacade;
    private List<Servicios> ListaServicio;
    private Servicios servicio;
    private Agenda agenda;
    private OrdenDeServicio ordenDeServicio;
    private String msn;
    private List<Servicios> filtraServicio;

    public List<Servicios> getListaServicio() {
        this.ListaServicio = this.servicioFacade.findAll();
        return ListaServicio;

    }

    public void setListaServicio(List<Servicios> ListaServicio) {
        this.ListaServicio = ListaServicio;
    }

    public Servicios getServicio() {
        return servicio;
    }

    public void setServicio(Servicios servicio) {
        this.servicio = servicio;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public OrdenDeServicio getOrdenDeServicio() {
        return ordenDeServicio;
    }

    public void setOrdenDeServicio(OrdenDeServicio ordenDeServicio) {
        this.ordenDeServicio = ordenDeServicio;
    }

    @PostConstruct
    public void inicializar() {
        this.servicio = new Servicios();
        this.agenda = new Agenda();
        this.ordenDeServicio = new OrdenDeServicio();
    }

    public void guardar() {
        try {
            this.servicio.setAgendaidAgenda(agenda);
            this.servicio.setOrdenServicioidOrden(ordenDeServicio);
            this.servicioFacade.create(servicio);
            this.servicio = new Servicios();
            this.agenda = new Agenda();
            this.ordenDeServicio = new OrdenDeServicio();
            this.msn = "Registro Guardado Correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "ERROR: " +e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void editar() {
        try {
            this.servicio.setAgendaidAgenda(agenda);
            this.servicio.setOrdenServicioidOrden(ordenDeServicio);
            this.servicioFacade.edit(servicio);
            this.servicio = new Servicios();
            this.agenda = new Agenda();
            this.ordenDeServicio = new OrdenDeServicio();
            this.msn = "Registro Modificado Correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "ERROR: " +e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar(Servicios eliminaServicio) {
        try {
            this.servicioFacade.remove(eliminaServicio);
            this.msn = "Registro Eliminado";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "ERROR: " +e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void cargarDatos(Servicios cargaServicio) {
        this.agenda.setIdAgenda(cargaServicio.getAgendaidAgenda().getIdAgenda());
        this.ordenDeServicio.setIdOrdendeServicio(cargaServicio.getOrdenServicioidOrden().getIdOrdendeServicio());
        this.servicio = cargaServicio;
    }

    public void limpiarDatos() {
            this.servicio = new Servicios();
            this.agenda = new Agenda();
            this.ordenDeServicio = new OrdenDeServicio();
    }
}
