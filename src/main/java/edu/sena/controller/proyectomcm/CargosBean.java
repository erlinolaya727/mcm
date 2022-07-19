
package edu.sena.controller.proyectomcm;

import edu.sena.ejb.proyectomcm.CargosFacadeLocal;
import edu.sena.entity.proyectomcm.Cargos;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class CargosBean implements Serializable {

    @EJB
    private CargosFacadeLocal cargosFacade;
    private Cargos cargo;
    private List<Cargos> listaCargos;

    public Cargos getCargo() {
        return cargo;
    }

    public void setCargo(Cargos cargo) {
        this.cargo = cargo;
    }

    public List<Cargos> getListaCargos() {
        this.listaCargos = this.cargosFacade.findAll();
        return listaCargos;
    }

    public void setListaCargos(List<Cargos> listaCargos) {
        this.listaCargos = listaCargos;
    }

    @PostConstruct
    public void init() {
        this.cargo = new Cargos();
    }
}

