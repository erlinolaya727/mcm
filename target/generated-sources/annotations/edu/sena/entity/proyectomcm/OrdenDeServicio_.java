package edu.sena.entity.proyectomcm;

import edu.sena.entity.proyectomcm.Ciudades;
import edu.sena.entity.proyectomcm.Cliente;
import edu.sena.entity.proyectomcm.Gerente;
import edu.sena.entity.proyectomcm.Servicios;
import edu.sena.entity.proyectomcm.Tecnicos;
import edu.sena.entity.proyectomcm.TipoServicio;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-30T22:44:32")
@StaticMetamodel(OrdenDeServicio.class)
public class OrdenDeServicio_ { 

    public static volatile SingularAttribute<OrdenDeServicio, Date> fechainicio;
    public static volatile SingularAttribute<OrdenDeServicio, Gerente> gerenteidGerente;
    public static volatile SingularAttribute<OrdenDeServicio, TipoServicio> tipoServicioIdTipo;
    public static volatile SingularAttribute<OrdenDeServicio, Ciudades> ciudadesidCiudad;
    public static volatile CollectionAttribute<OrdenDeServicio, Tecnicos> tecnicosCollection;
    public static volatile SingularAttribute<OrdenDeServicio, Cliente> clienteidCliente;
    public static volatile SingularAttribute<OrdenDeServicio, Date> fechaTerminacion;
    public static volatile CollectionAttribute<OrdenDeServicio, Servicios> serviciosCollection;
    public static volatile SingularAttribute<OrdenDeServicio, Integer> idOrdendeServicio;

}