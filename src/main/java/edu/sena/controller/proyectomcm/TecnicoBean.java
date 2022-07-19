package edu.sena.controller.proyectomcm;


import edu.sena.ejb.proyectomcm.TecnicosFacadeLocal;
import edu.sena.entity.proyectomcm.Tecnicos;
import edu.sena.entity.proyectomcm.Usuario;
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
public class TecnicoBean implements Serializable {

    @EJB
    private TecnicosFacadeLocal tecnicoFace;
    private List<Tecnicos> listaTecnicos;
    private Tecnicos tecnico;
    private Usuario usuario;
    private String msn;

    public List<Tecnicos> getListaTecnicos() {
        this.listaTecnicos = this.tecnicoFace.findAll();
        return listaTecnicos;
    }

    public void setListaTecnicos(List<Tecnicos> listaTecnicos) {
        this.listaTecnicos = listaTecnicos;
    }

    public Tecnicos getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnicos tecnico) {
        this.tecnico = tecnico;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    @PostConstruct
    public void init() {
        this.tecnico = new Tecnicos();
        this.usuario = new Usuario();
    }

    public void guardar() {
        try {
            this.tecnico.setUsuarioidUsuario(usuario);
            this.tecnicoFace.create(tecnico);
            this.tecnico = new Tecnicos();
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
            this.tecnico.setUsuarioidUsuario(usuario);
            this.tecnicoFace.edit(tecnico);
            this.tecnico = new Tecnicos();
            this.msn = "Registro Guardado Correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "ERROR: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar(Tecnicos tecnico) {
        try {
            this.tecnicoFace.remove(tecnico);
            this.msn = "Registro Eliminado";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "ERROR: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void cargarDatos(Tecnicos cargaDatos) {
        this.usuario.setIdUsuario(cargaDatos.getUsuarioidUsuario().getIdUsuario());
        this.tecnico = cargaDatos;
    }

    public void limpiarDatos() {
        this.tecnico = new Tecnicos();
        this.usuario=new Usuario();

    }
}
