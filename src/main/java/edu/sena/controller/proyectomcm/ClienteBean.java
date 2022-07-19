package edu.sena.controller.proyectomcm;


import edu.sena.ejb.proyectomcm.ClienteFacadeLocal;
import edu.sena.entity.proyectomcm.Cliente;
import edu.sena.entity.proyectomcm.Vendedor;
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
public class ClienteBean implements Serializable {

    @EJB
    private ClienteFacadeLocal clienteFacade;
    private List<Cliente> listaCliente;
    private Cliente cliente;
    private Vendedor vendedor;
    private String msn;
    private List<Cliente> filtroClientes;

    public List<Cliente> getListaCliente() {
        this.listaCliente = this.clienteFacade.findAll();
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public List<Cliente> getFiltroClientes() {
        return filtroClientes;
    }

    public void setFiltroClientes(List<Cliente> filtroClientes) {
        this.filtroClientes = filtroClientes;
    }

    
    
    public Cliente getCliente() {
        return cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @PostConstruct
    public void init() {
        this.cliente = new Cliente();
        this.vendedor = new Vendedor();
    }

    public void guardar() {
        try {
            this.cliente.setVendedoridVendedor(vendedor);
            this.clienteFacade.create(cliente);
            this.cliente = new Cliente();
            this.vendedor = new Vendedor();
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
            this.cliente.setVendedoridVendedor(vendedor);
            this.clienteFacade.edit(cliente);
            this.cliente = new Cliente();
            this.vendedor = new Vendedor();
            this.msn = "Registro Editado";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "Error: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar(Cliente eliminarCliente) {
        try {
            this.clienteFacade.remove(eliminarCliente);
            this.msn = "Registro Eliminado";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "Error: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void cargarDatos(Cliente cargaCliente) {
        this.vendedor.setIdVendedor(cargaCliente.getVendedoridVendedor().getIdVendedor());
        this.cliente = cargaCliente;
    }

    public void limpiarDatos() {
        this.cliente = new Cliente();
        this.vendedor = new Vendedor();
    }
}
