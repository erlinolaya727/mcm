package edu.sena.controller.proyectomcm;


import edu.sena.ejb.proyectomcm.TaladroFacadeLocal;
import edu.sena.entity.proyectomcm.Ciudades;
import edu.sena.entity.proyectomcm.Cliente;
import edu.sena.entity.proyectomcm.Taladro;
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
public class TaladroBean implements Serializable {

    @EJB
    private TaladroFacadeLocal taladroFacade;
    private List<Taladro> listaTaladro;
    private Taladro taladro;
    private Cliente cliente;
    private Ciudades ciudad;
    private String msn;

    public List<Taladro> getListaTaladro() {
        this.listaTaladro = this.taladroFacade.findAll();
        return listaTaladro;
    }

    public void setListaTaladro(List<Taladro> listaTaladro) {
        this.listaTaladro = listaTaladro;
    }

    public Taladro getTaladro() {
        return taladro;
    }

    public void setTaladro(Taladro taladro) {
        this.taladro = taladro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Ciudades getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudades ciudad) {
        this.ciudad = ciudad;
    }

    @PostConstruct
    public void init() {
        this.ciudad = new Ciudades();
        this.cliente = new Cliente();
        this.taladro = new Taladro();
    }

    public void guardar() {
        try {
            this.taladro.setCiudadesidCiudad(ciudad);
            this.taladro.setClienteidCliente(cliente);
            this.taladroFacade.create(taladro);
            this.ciudad = new Ciudades();
            this.cliente = new Cliente();
            this.taladro = new Taladro();
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
            this.taladro.setCiudadesidCiudad(ciudad);
            this.taladro.setClienteidCliente(cliente);
            this.taladroFacade.edit(taladro);
            this.ciudad = new Ciudades();
            this.cliente = new Cliente();
            this.taladro = new Taladro();
            this.msn = "Registro Actualizado";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "ERROR: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar(Taladro eliminaTaladro) {
        try {
            this.taladroFacade.remove(eliminaTaladro);
            this.msn = "Registro Eliminado";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "ERROR: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void cargarDatos(Taladro cargaTaladro) {

        this.taladro = cargaTaladro;
        this.ciudad.setIdCiudad(cargaTaladro.getCiudadesidCiudad().getIdCiudad());
        this.cliente.setIdCliente(cargaTaladro.getClienteidCliente().getIdCliente());
    }

    public void limpiarDatos() {
        this.cliente = new Cliente();
        this.taladro = new Taladro();
        this.ciudad = new Ciudades();
    }
}
