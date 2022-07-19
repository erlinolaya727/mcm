package edu.sena.controller.proyectomcm;


import edu.sena.ejb.proyectomcm.AgendaFacadeLocal;
import edu.sena.entity.proyectomcm.Agenda;
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
public class AgendaBean implements Serializable {

    @EJB
    private AgendaFacadeLocal agendaFacade;
    private List<Agenda> Listagenda;
    private Agenda agenda;
    private String msn;

    public List<Agenda> getListagenda() {
        this.Listagenda=this.agendaFacade.findAll();
        return Listagenda;
    }

    public void setListagenda(List<Agenda> Listagenda) {
        this.Listagenda = Listagenda;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    @PostConstruct
    public void inicio() {
        this.agenda = new Agenda();
    }

    public void guardar() {
        try {
            this.agendaFacade.create(agenda);
            this.agenda = new Agenda();
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
            this.agendaFacade.edit(agenda);
            this.agenda = new Agenda();
            this.msn = "Registro Guardado Correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "ERROR: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar(Agenda eliminaProveedor) {
        try {
            this.agendaFacade.remove(eliminaProveedor);
            this.msn = "Registro Eliminado";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "ERROR: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void cargarDatos(Agenda cargaAgenda) {
        this.agenda = cargaAgenda;
    }

    public void limpiarDatos() {
        this.agenda = new Agenda();

    }
}
