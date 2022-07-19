package edu.sena.controller.proyectomcm;


import edu.sena.ejb.proyectomcm.OrdenDeServicioFacadeLocal;
import edu.sena.entity.proyectomcm.Ciudades;
import edu.sena.entity.proyectomcm.Cliente;
import edu.sena.entity.proyectomcm.Gerente;
import edu.sena.entity.proyectomcm.OrdenDeServicio;
import edu.sena.entity.proyectomcm.TipoServicio;
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
public class OrdenDeServicioBean implements Serializable {

    @EJB
    private OrdenDeServicioFacadeLocal ordenDeServicioFacade;
    private List<OrdenDeServicio> ListaOrdenDeServicio;
    private OrdenDeServicio IdOrdenServicio;
    private Cliente cliente;
    private TipoServicio tipoServicio;
    private Ciudades ciudades;
    private Gerente gerente;
    private String msn;

    public OrdenDeServicioFacadeLocal getOrdenDeServicioFacade() {
        return ordenDeServicioFacade;
    }

    public void setOrdenDeServicioFacade(OrdenDeServicioFacadeLocal ordenDeServicioFacade) {
        this.ordenDeServicioFacade = ordenDeServicioFacade;
    }

    public List<OrdenDeServicio> getListaOrdenDeServicio() {
        this.ListaOrdenDeServicio = this.ordenDeServicioFacade.findAll();
        return ListaOrdenDeServicio;
    }

    public void setListaOrdenDeServicio(List<OrdenDeServicio> ListaOrdenDeServicio) {
        this.ListaOrdenDeServicio = ListaOrdenDeServicio;
    }

    public OrdenDeServicio getIdOrdenServicio() {
        return IdOrdenServicio;
    }

    public void setIdOrdenServicio(OrdenDeServicio IdOrdenServicio) {
        this.IdOrdenServicio = IdOrdenServicio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public Ciudades getCiudades() {
        return ciudades;
    }

    public void setCiudades(Ciudades ciudades) {
        this.ciudades = ciudades;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn;
    }

    @PostConstruct
    public void inicializar() {
        this.IdOrdenServicio = new OrdenDeServicio();
        this.cliente = new Cliente();
        this.ciudades = new Ciudades();
        this.gerente = new Gerente();
    }

    public void guardar() {
        try {
            this.IdOrdenServicio.setClienteidCliente(cliente);
            this.IdOrdenServicio.setTipoServicioIdTipo(tipoServicio);
            this.IdOrdenServicio.setCiudadesidCiudad(ciudades);
            this.IdOrdenServicio.setGerenteidGerente(gerente);
            this.ordenDeServicioFacade.create(IdOrdenServicio);
            this.IdOrdenServicio = new OrdenDeServicio();
            this.cliente = new Cliente();
            this.tipoServicio = new TipoServicio();
            this.ciudades = new Ciudades();
            this.gerente = new Gerente();
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
            this.IdOrdenServicio.setClienteidCliente(cliente);
            this.IdOrdenServicio.setTipoServicioIdTipo(tipoServicio);
            this.IdOrdenServicio.setCiudadesidCiudad(ciudades);
            this.IdOrdenServicio.setGerenteidGerente(gerente);
            this.ordenDeServicioFacade.edit(IdOrdenServicio);
            this.IdOrdenServicio = new OrdenDeServicio();
            this.cliente = new Cliente();
            this.tipoServicio = new TipoServicio();
            this.ciudades = new Ciudades();
            this.gerente = new Gerente();
            this.msn = "Registro Guardado Correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "ERROR: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar(OrdenDeServicio eliminaOrdenDeServicio) {
        try {
            this.ordenDeServicioFacade.remove(eliminaOrdenDeServicio);
            this.msn = "Registro Eliminado";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "ERROR: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void cargarDatos(OrdenDeServicio cargaOrdenDeServicio) {
        this.cliente.setIdCliente(cargaOrdenDeServicio.getClienteidCliente().getIdCliente());
        this.tipoServicio.setIdTipoServicio(cargaOrdenDeServicio.getTipoServicioIdTipo().getIdTipoServicio());
        this.ciudades.setIdCiudad(cargaOrdenDeServicio.getCiudadesidCiudad().getIdCiudad());
        this.gerente.setIdGerente(cargaOrdenDeServicio.getGerenteidGerente().getIdGerente());
        this.IdOrdenServicio = cargaOrdenDeServicio;
    }

    public void limpiarDatos() {
        this.IdOrdenServicio = new OrdenDeServicio();
        this.cliente = new Cliente();
        this.tipoServicio = new TipoServicio();
        this.ciudades = new Ciudades();
        this.gerente = new Gerente();
        this.IdOrdenServicio = new OrdenDeServicio();
    }
}
