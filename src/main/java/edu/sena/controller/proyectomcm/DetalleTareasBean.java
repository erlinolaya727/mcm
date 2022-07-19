package edu.sena.controller.proyectomcm;


import edu.sena.ejb.proyectomcm.DetalleTareasFacadeLocal;
import edu.sena.entity.proyectomcm.DetalleTareas;
import edu.sena.entity.proyectomcm.Tareas;
import edu.sena.entity.proyectomcm.Tecnicos;
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
public class DetalleTareasBean implements Serializable {

    @EJB
    private DetalleTareasFacadeLocal detalleTareaEJB;
    private List<DetalleTareas> listaDetalleTareas;
    private DetalleTareas detalleTareas;
    private Tareas tareas;
    private Tecnicos tecnicos;
    private String msn;

    public List<DetalleTareas> getListaDetalleTareas() {
        this.listaDetalleTareas = this.detalleTareaEJB.findAll();
        return listaDetalleTareas;
    }

    public void setListaDetalleTareas(List<DetalleTareas> listaDetalleTareas) {
        this.listaDetalleTareas = listaDetalleTareas;
    }

    public DetalleTareas getDetalleTareas() {
        return detalleTareas;
    }

    public void setDetalleTareas(DetalleTareas detalleTareas) {
        this.detalleTareas = detalleTareas;
    }

    public Tareas getTareas() {
        return tareas;
    }

    public void setTareas(Tareas tareas) {
        this.tareas = tareas;
    }

    public Tecnicos getTecnicos() {
        return tecnicos;
    }

    public void setTecnicos(Tecnicos tecnicos) {
        this.tecnicos = tecnicos;
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn;
    }

    @PostConstruct
    public void init() {
        this.detalleTareas = new DetalleTareas();
        this.tareas = new Tareas();
        this.tecnicos = new Tecnicos();
    }

    public void limpiarDatos() {
        this.detalleTareas = new DetalleTareas();
        this.tareas = new Tareas();
        this.tecnicos = new Tecnicos();
    }

    public void cargarDatos(DetalleTareas cargaDetalle) {
        this.tareas.setIdTareas(cargaDetalle.getTareasidTareas().getIdTareas());
        this.tecnicos.setIdEmpleado(cargaDetalle.getTecnicosidEmpleado().getIdEmpleado());
        this.detalleTareas = cargaDetalle;
    }

    public void guardar() {
        try {
            this.detalleTareas.setTareasidTareas(tareas);
            this.detalleTareas.setTecnicosidEmpleado(tecnicos);
            this.detalleTareaEJB.create(detalleTareas);
            limpiarDatos();
            this.msn = "Registro Guardado con Exito";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "Error: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void editar() {
        try {
            this.detalleTareas.setTareasidTareas(tareas);
            this.detalleTareas.setTecnicosidEmpleado(tecnicos);
            this.detalleTareaEJB.edit(detalleTareas);
            limpiarDatos();
            this.msn = "Registro Editado con Exito";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "Error: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar(DetalleTareas detalleTareas) {
        try {
            this.detalleTareaEJB.remove(detalleTareas);
            this.msn="Registro Eliminado Exitosamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "Error: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

}
