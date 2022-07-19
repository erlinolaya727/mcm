
package edu.sena.controller.proyectomcm;


import edu.sena.ejb.proyectomcm.VendedorFacadeLocal;
import edu.sena.entity.proyectomcm.Usuario;
import edu.sena.entity.proyectomcm.Vendedor;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class VendedorBean implements Serializable{
    
    @EJB
    private VendedorFacadeLocal vendedorFacade;
    private List<Vendedor> listaVendedor;
    private Vendedor vendedor;
    private Usuario usuario;

    public List<Vendedor> getListaVendedor() {
        this.listaVendedor=this.vendedorFacade.findAll();
        return listaVendedor;
    }

    public void setListaVendedor(List<Vendedor> listaVendedor) {
        this.listaVendedor = listaVendedor;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @PostConstruct
    public void init(){
        this.vendedor=new Vendedor();
        this.usuario=new Usuario();
    }
}
