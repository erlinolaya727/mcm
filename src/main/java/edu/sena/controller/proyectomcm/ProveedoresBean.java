
package edu.sena.controller.proyectomcm;


import edu.sena.ejb.proyectomcm.ProveedorFacadeLocal;
import edu.sena.entity.proyectomcm.Ciudades;
import edu.sena.entity.proyectomcm.Proveedor;
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
public class ProveedoresBean implements Serializable {
    
    @EJB
    private ProveedorFacadeLocal provedorFacade;
    private List<Proveedor> listaProveedor;
    private Proveedor proveedor;
    private Ciudades ciudad;
    private String msn;
    private List<Proveedor> filterProveedores;

    public List<Proveedor> getFilterProveedores() {
        return filterProveedores;
    }

    public void setFilterProveedores(List<Proveedor> filterProveedores) {
        this.filterProveedores = filterProveedores;
    }

    public List<Proveedor> getListaProveedor() {
        this.listaProveedor = this.provedorFacade.findAll();
        return listaProveedor;
    }

    public void setListaProveedor(List<Proveedor> listaProveedor) {
        this.listaProveedor = listaProveedor;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Ciudades getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudades ciudad) {
        this.ciudad = ciudad;
    }

    @PostConstruct
    public void init(){
        this.proveedor=new Proveedor();
        this.ciudad=new Ciudades();
    }
    
    public void guardar(){
        try{ 
            this.proveedor.setCiudadesidCiudad(ciudad);
            this.provedorFacade.create(proveedor);
            this.ciudad=new Ciudades();
            this.proveedor=new Proveedor();
            this.msn="Registro Guardado Correctamente";
        }catch(Exception e){
            e.printStackTrace();
            this.msn="ERROR: " +e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
      public void editar(){
        try{ 
            this.proveedor.setCiudadesidCiudad(ciudad);
            this.provedorFacade.edit(proveedor);
            this.ciudad=new Ciudades();
            this.proveedor=new Proveedor();
            this.msn="Registro Actualizado";
        }catch(Exception e){
            e.printStackTrace();
            this.msn="ERROR: " +e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
      
    public void eliminar(Proveedor eliminaProveedor ){
        try{
            this.provedorFacade.remove(eliminaProveedor);
            this.msn="Registro Eliminado";
        }catch(Exception e){
            e.printStackTrace();
            this.msn="ERROR: " +e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
      public void cargarDatos(Proveedor cargaProveedor) {
        this.ciudad.setIdCiudad(cargaProveedor.getCiudadesidCiudad().getIdCiudad());
        this.proveedor=cargaProveedor;
    }
      
        public void limpiarDatos() {
        this.proveedor = new Proveedor();
        this.ciudad = new Ciudades();
    }
}

