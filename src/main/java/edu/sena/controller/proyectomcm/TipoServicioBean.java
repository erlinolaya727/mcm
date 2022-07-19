package edu.sena.controller.proyectomcm;


import edu.sena.ejb.proyectomcm.TipoServicioFacadeLocal;
import edu.sena.entity.proyectomcm.TipoServicio;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TipoServicioBean implements Serializable {
    @EJB
    private TipoServicioFacadeLocal tipoServicioFacade;
    private List<TipoServicio> listaTipoServicio;
    private TipoServicio Servicio;

    public List<TipoServicio> getListaTipoServicio() {
        this.listaTipoServicio=this.tipoServicioFacade.findAll();
        return listaTipoServicio;
    }

    public void setListaTipoServicio(List<TipoServicio> listaTipoServicio) {
        this.listaTipoServicio = listaTipoServicio;
    }

    public TipoServicio getServicio() {
        return Servicio;
    }

    public void setServicio(TipoServicio Servicio) {
        this.Servicio = Servicio;
    }
    
    
    
    
    @PostConstruct
    public void init(){
        this.Servicio=new TipoServicio();
    }
}