
package edu.sena.controller.proyectomcm;

import edu.sena.ejb.proyectomcm.GerenteFacadeLocal;
import edu.sena.entity.proyectomcm.Gerente;
import edu.sena.entity.proyectomcm.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class GerenteBean implements Serializable{
    @EJB
    private GerenteFacadeLocal gerenteFacade;
    private List<Gerente> listaGerente;
    private Gerente gerente;
    
    private Usuario idUsuario;

    public GerenteFacadeLocal getGerenteFacade() {
        return gerenteFacade;
    }

    public void setGerenteFacade(GerenteFacadeLocal gerenteFacade) {
        this.gerenteFacade = gerenteFacade;
    }

    public List<Gerente> getListaGerente() {
        this.listaGerente = this.gerenteFacade.findAll();
        return listaGerente;
    }

    public void setListaGerente(List<Gerente> listaGerente) {
        this.listaGerente = listaGerente;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    @PostConstruct
    public void inicializar() {
        this.gerente = new Gerente();
        this.idUsuario = new Usuario();
    }
    
}