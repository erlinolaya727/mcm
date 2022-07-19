
package edu.sena.controller.proyectomcm;


import edu.sena.ejb.proyectomcm.RolesFacadeLocal;
import edu.sena.entity.proyectomcm.Roles;
import edu.sena.entity.proyectomcm.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class RolesBean implements  Serializable {
    
    @EJB
    private RolesFacadeLocal rolesFacade;
    private Roles rol;
    private List<Roles> listaRoles;
    private Usuario usuario;

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }

    public List<Roles> getListaRoles() {
        this.listaRoles=this.rolesFacade.findAll();
        return listaRoles;
    }

    public void setListaRoles(List<Roles> listaRoles) {
        this.listaRoles = listaRoles;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @PostConstruct
    public void init(){
        this.rol=new Roles();
        this.usuario=new Usuario();
    }   
}
