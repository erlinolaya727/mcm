
package edu.sena.controller.proyectomcm;


import edu.sena.ejb.proyectomcm.CiudadesFacadeLocal;
import edu.sena.entity.proyectomcm.Ciudades;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CiudadesBean implements Serializable {
    
    @EJB
    private CiudadesFacadeLocal ciudadFacade;
    private Ciudades ciudad;
    private List <Ciudades> listaCiudades;

    public Ciudades getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudades ciudad) {
        this.ciudad = ciudad;
    }

    public List<Ciudades> getListaCiudades() {
        this.listaCiudades=this.ciudadFacade.findAll();
        return listaCiudades;
    }

    public void setListaCiudades(List<Ciudades> listaCiudades) {
        this.listaCiudades = listaCiudades;
    }


    
    @PostConstruct
    public void init(){
        this.ciudad=new Ciudades();
    }
}
