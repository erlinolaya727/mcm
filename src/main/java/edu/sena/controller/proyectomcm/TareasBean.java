package edu.sena.controller.proyectomcm;


import edu.sena.ejb.proyectomcm.TareasFacadeLocal;
import edu.sena.entity.proyectomcm.Servicios;
import edu.sena.entity.proyectomcm.Tareas;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class TareasBean implements Serializable {

    @EJB
    private TareasFacadeLocal tareaEJB;
    private Tareas tareas;
    private Servicios servicio;
    private String msn;
    private List<Tareas> listaTareas;
    private int cantidadDias;

    public int getCantidadDias() {
        return cantidadDias;
    }

    public void setCantidadDias(int cantidadDias) {
        this.cantidadDias = cantidadDias;
    }

    public Tareas getTareas() {
        return tareas;
    }

    public void setTareas(Tareas tareas) {
        this.tareas = tareas;
    }

    public Servicios getServicio() {
        return servicio;
    }

    public void setServicio(Servicios servicio) {
        this.servicio = servicio;
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn;
    }

    public List<Tareas> getListaTareas() {
        this.listaTareas = this.tareaEJB.findAll();
        return listaTareas;
    }

    public void setListaTareas(List<Tareas> listaTareas) {
        this.listaTareas = listaTareas;
    }

    @PostConstruct
    public void init() {
        this.servicio = new Servicios();
        this.tareas = new Tareas();
    }

    public void guardar() {
        try {
            this.tareas.setServiciosidConsecutivo(servicio);
            this.tareaEJB.create(tareas);
            this.servicio = new Servicios();
            this.tareas = new Tareas();
            this.msn = "Registro Guardado Exitosamente";
        } catch (Exception e) {
            e.getMessage();
            this.msn = "Error: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void editar() {
        try {
            this.tareas.setServiciosidConsecutivo(servicio);
            this.tareaEJB.edit(tareas);
            this.servicio = new Servicios();
            this.tareas = new Tareas();
            this.msn = "Registro Actualizado Exitosamente";
        } catch (Exception e) {
            e.getMessage();
            this.msn = "Error: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar(Tareas eliminaTarea) {
        try {
            this.tareaEJB.remove(eliminaTarea);
            this.msn = "Registro Eliminado";
        } catch (Exception e) {
            e.getMessage();
            this.msn = "Error: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void cargarDatos(Tareas datosTareas) {
        this.servicio.setIdServicio(datosTareas.getServiciosidConsecutivo().getIdServicio());
        this.tareas = datosTareas;
    }
    
    public void limpiarDatos() {
        this.servicio = new Servicios();
        this.tareas = new Tareas();
    }
    
    public int cantidadDias(Date inicio){
        
        return cantidadDias;
    }
}
