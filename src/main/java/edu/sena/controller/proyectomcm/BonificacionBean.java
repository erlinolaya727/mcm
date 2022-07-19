package edu.sena.controller.proyectomcm;

import edu.sena.ejb.proyectomcm.BonificacionFacadeLocal;
import edu.sena.entity.proyectomcm.Bonificacion;
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
public class BonificacionBean implements Serializable {

    @EJB
    private BonificacionFacadeLocal bonificacionFacade;
    private List<Bonificacion> listaBonificacion;
    private Bonificacion Bonificacion;
    private Tecnicos tecnicos;
    private String msn;

    public List<Bonificacion> getListaBonificacion() {
        this.listaBonificacion = this.bonificacionFacade.findAll();
        return listaBonificacion;
    }

    public void setListaBonificacion(List<Bonificacion> listaBonificacion) {
        this.listaBonificacion = listaBonificacion;
    }

    public Bonificacion getBonificacion() {
        return Bonificacion;
    }

    public void setBonificacion(Bonificacion Bonificacion) {
        this.Bonificacion = Bonificacion;
    }

    public Tecnicos getTecnicos() {
        return tecnicos;
    }

    public void setTecnicos(Tecnicos tecnicos) {
        this.tecnicos = tecnicos;
    }

    @PostConstruct
    public void inic() {
        this.Bonificacion = new Bonificacion();
        this.tecnicos = new Tecnicos();

    }

    public void guardar() {
        try {
            this.Bonificacion.setTecnicosidTecnicos(tecnicos);
            this.bonificacionFacade.create(Bonificacion);
            this.Bonificacion = new Bonificacion();
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
            this.Bonificacion.setTecnicosidTecnicos(tecnicos);
            this.bonificacionFacade.edit(Bonificacion);
            this.Bonificacion = new Bonificacion();
            this.msn = "Registro Editado Correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "ERROR: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar(Bonificacion eliminaBonificacion) {
        try {
            this.bonificacionFacade.remove(eliminaBonificacion);
            this.msn = "Registro Eliminado";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "ERROR: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void cargarDatos(Bonificacion cargaDatos) {
        this.tecnicos.setIdEmpleado(cargaDatos.getTecnicosidTecnicos().getIdEmpleado());
        this.Bonificacion =cargaDatos;
    }

    public void limpiarDatos() {
        this.Bonificacion = new Bonificacion();

    }
}
