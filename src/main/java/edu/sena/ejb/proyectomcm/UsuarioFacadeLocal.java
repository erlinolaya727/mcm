
package edu.sena.ejb.proyectomcm;

import edu.sena.entity.proyectomcm.Usuario;
import java.util.List;
import javax.ejb.Local;

@Local
public interface UsuarioFacadeLocal {

    void create(Usuario usuario);

    void edit(Usuario usuario);

    void remove(Usuario usuario);

    Usuario find(Object id);

    List<Usuario> findAll();

    List<Usuario> findRange(int[] range);

    int count();
      
    Usuario validarUsuario(String correoIn, String claveIn);
    
    Usuario recuperarClave(String correoIn);
}
