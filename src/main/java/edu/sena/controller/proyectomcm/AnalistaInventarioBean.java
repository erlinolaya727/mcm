package edu.sena.controller.proyectomcm;


import edu.sena.ejb.proyectomcm.AnalistaInventariosFacadeLocal;
import edu.sena.entity.proyectomcm.Analistainventarios;
import edu.sena.entity.proyectomcm.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class AnalistaInventarioBean implements Serializable {

    @EJB
    private AnalistaInventariosFacadeLocal analistaInventarioFacade;
    private List<Analistainventarios> listaAnalistaInventario;
    private Analistainventarios analistaInventario;
    private Usuario usuario;

    public List<Analistainventarios> getListaAnalistaInventario() {
        this.listaAnalistaInventario = this.analistaInventarioFacade.findAll();
        return listaAnalistaInventario;
    }

    public void setListaAnalistaInventario(List<Analistainventarios> listaAnalistaInventario) {
        this.listaAnalistaInventario = listaAnalistaInventario;
    }

    public Analistainventarios getAnalistaInventario() {
        return analistaInventario;
    }

    public void setAnalistaInventario(Analistainventarios analistaInventario) {
        this.analistaInventario = analistaInventario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @PostConstruct
    public void init() {
        this.analistaInventario = new Analistainventarios();
        this.usuario = new Usuario();
    }
}
