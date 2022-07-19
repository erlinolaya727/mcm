package edu.sena.controller.proyectomcm;

import edu.sena.ejb.proyectomcm.UsuarioFacadeLocal;
import edu.sena.entity.proyectomcm.Cargos;
import edu.sena.entity.proyectomcm.Usuario;
import edu.sena.utilidades.proyectomcm.Mail;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import org.primefaces.PrimeFaces;
import org.primefaces.shaded.commons.io.FilenameUtils;
import java.io.InputStream;
import java.io.File;
import java.util.Calendar;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {

    @EJB
    private UsuarioFacadeLocal usuarioFacadeLocal;
    private List<Usuario> listaUsuario;
    private Usuario usuario;
    private Cargos cargo;
    private String msn;
    private String correoIn;
    private String claveIn;
    private Usuario usuReg = new Usuario();
    private Usuario usuLog = new Usuario();
    private Usuario usuTemporal = new Usuario();
    private Part archivoFoto;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    public Usuario getUsuReg() {
        return usuReg;
    }

    public void setUsuReg(Usuario usuReg) {
        this.usuReg = usuReg;
    }

    public Usuario getUsuLog() {
        return usuLog;
    }

    public void setUsuLog(Usuario usuLog) {
        this.usuLog = usuLog;
    }

    public Usuario getUsuTemporal() {
        return usuTemporal;
    }

    public void setUsuTemporal(Usuario usuTemporal) {
        this.usuTemporal = usuTemporal;
    }

    public String getClaveIn() {
        return claveIn;
    }

    public void setClaveIn(String claveIn) {
        this.claveIn = claveIn;
    }

    public String getCorreoIn() {
        return correoIn;
    }

    public void setCorreoIn(String correoIn) {
        this.correoIn = correoIn;
    }

    public List<Usuario> getListaUsuario() {
        this.listaUsuario = this.usuarioFacadeLocal.findAll();
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cargos getCargo() {
        return cargo;
    }

    public void setCargo(Cargos cargo) {
        this.cargo = cargo;
    }

    public Part getArchivoFoto() {
        return archivoFoto;
    }

    public void setArchivoFoto(Part archivoFoto) {
        this.archivoFoto = archivoFoto;
    }

    @PostConstruct
    public void init() {
        this.usuario = new Usuario();
        this.cargo = new Cargos();
    }

    public void guardar() {
        try {
            this.usuario.setCargosidCargos(cargo);
            this.usuarioFacadeLocal.create(usuario);
            this.usuario = new Usuario();
            this.cargo = new Cargos();
            this.msn = "Registro Guardado Correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "ERROR: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void editar() {
        try {
            this.usuario.setCargosidCargos(cargo);
            this.usuarioFacadeLocal.edit(usuario);
            this.usuario = new Usuario();
            this.cargo = new Cargos();
            this.msn = "Registro Actualizado Correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "ERROR: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar(Usuario eliminaUsuario) {
        try {
            this.usuarioFacadeLocal.remove(eliminaUsuario);
            this.msn = "Registro Eliminado";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "ERROR: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void cargarDatos(Usuario cargaUsuarios) {

        this.cargo.setIdCargos(cargaUsuarios.getCargosidCargos().getIdCargos());
        this.usuario = cargaUsuarios;
    }

    public void limpiarDatos() {
        this.usuario = new Usuario();
        this.cargo = new Cargos();
    }

    public void validarUsuario() {
        try {
            usuLog = usuarioFacadeLocal.validarUsuario(correoIn, claveIn);
            if (usuLog != null) {
                if (usuLog.getEstado() == Short.parseShort("1")) {
                    FacesContext fc = FacesContext.getCurrentInstance();
                    fc.getExternalContext().redirect("usuario/index.xhtml");
                } else {
                    PrimeFaces.current().executeScript("Swal.fire({"
                            + "  title: 'Usuario !',"
                            + "  text: 'Inactivo ....',"
                            + "  icon: 'info',"
                            + "  confirmButtonText: 'Comuniquese con el administrador !!!!'"
                            + "})");
                }
            } else {
                PrimeFaces.current().executeScript("Swal.fire({"
                        + "  title: 'Usuario !',"
                        + "  text: 'No encontrado ....',"
                        + "  icon: 'error',"
                        + "  confirmButtonText: 'valide sus datos !!!!'"
                        + "})");
            }
        } catch (Exception e) {
            PrimeFaces.current().executeScript("Swal.fire({"
                    + "  title: 'Problemas !',"
                    + "  text: 'No se puede realizar esta accion',"
                    + "  icon: 'error',"
                    + "  confirmButtonText: 'Ok'"
                    + "})");
        }
    }

    public void recuperarClave() {
        try {
            usuReg = usuarioFacadeLocal.recuperarClave(correoIn);
            if (usuReg != null) {
                Mail.recuperarClaves(usuReg.getNombre() + usuReg.getApellido(), usuReg.getEmail(), usuReg.getPass());
                PrimeFaces.current().executeScript("Swal.fire({"
                        + "  title: 'Correo de recuperacion  !',"
                        + "  text: 'enviado correctamente',"
                        + "  icon: 'success',"
                        + "  confirmButtonText: 'Ok'"
                        + "})");

            } else {
                PrimeFaces.current().executeScript("Swal.fire({"
                        + "  title: 'Correo electronico !',"
                        + "  text: 'No encontrado ....',"
                        + "  icon: 'error',"
                        + "  confirmButtonText: 'Valide su correo'"
                        + "})");
            }
        } catch (Exception e) {
            PrimeFaces.current().executeScript("Swal.fire({"
                    + "  title: 'Problemas !',"
                    + "  text: 'No se puede realizar esta accion',"
                    + "  icon: 'error',"
                    + "  confirmButtonText: 'Ok'"
                    + "})");
        }
    }

    public void cerrarSesion() throws IOException {
        usuLog = null;
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.getExternalContext().invalidateSession();
        fc.getExternalContext().redirect("../index.xhtml");
    }

    public void validarUsuarioSesion() throws IOException {

        if (usuLog == null || usuLog.getEmail() == null) {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.getExternalContext().invalidateSession();
            fc.getExternalContext().redirect("../index.xhtml");
        }
    }

    public void cargarFotoPerfil() {
        if (archivoFoto != null) {
            if (archivoFoto.getSize() > 700000 || archivoFoto.getSize() < 10000) {
                PrimeFaces.current().executeScript("Swal.fire({"
                        + "  title: 'El archivo !',"
                        + "  text: 'No se puede cargar por el tamaño !!!',"
                        + "  icon: 'error',"
                        + "  confirmButtonText: 'Ok'"
                        + "})");
            } else if (archivoFoto.getContentType().equalsIgnoreCase("image/png") || archivoFoto.getContentType().equalsIgnoreCase("image/jpeg")) {

                try (InputStream is = archivoFoto.getInputStream()) {
                    File carpeta = new File("C:\\mcm\\usuarios\\fotoperfil");
                    if (!carpeta.exists()) {
                        carpeta.mkdirs();
                    }
                    Calendar hoy = Calendar.getInstance();
                    String nuevoNombre = sdf.format(hoy.getTime()) + ".";
                    nuevoNombre += FilenameUtils.getExtension(archivoFoto.getSubmittedFileName());
                    Files.copy(is, (new File(carpeta, nuevoNombre)).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    usuLog.setUsuFoto(nuevoNombre);
                    usuarioFacadeLocal.edit(usuLog);

                } catch (Exception e) {
                    PrimeFaces.current().executeScript("Swal.fire({"
                            + "  title: 'Problemas !',"
                            + "  text: 'No se puede realizar esta accion',"
                            + "  icon: 'error',"
                            + "  confirmButtonText: 'Ok'"
                            + "})");
                }
            } else {
                PrimeFaces.current().executeScript("Swal.fire({"
                        + "  title: 'El archivo !',"
                        + "  text: 'No es una imagen .png o .jpeg !!!',"
                        + "  icon: 'error',"
                        + "  confirmButtonText: 'Ok'"
                        + "})");
            }

        } else {
            PrimeFaces.current().executeScript("Swal.fire({"
                    + "  title: 'Problemas !',"
                    + "  text: 'No se puede realizar esta accion',"
                    + "  icon: 'error',"
                    + "  confirmButtonText: 'Ok'"
                    + "})");
        }

        PrimeFaces.current().executeScript("document.getElementById('resetform').click()");

    }

    public void actualizarmisdatos() {
        try {
            usuarioFacadeLocal.edit(usuLog);
            PrimeFaces.current().executeScript("Swal.fire({"
                    + "  title: 'Usuario !',"
                    + "  text: 'Actualizado correctamente',"
                    + "  icon: 'success',"
                    + "  confirmButtonText: 'Ok'"
                    + "})");

        } catch (Exception e) {
            PrimeFaces.current().executeScript("Swal.fire({"
                    + "  title: 'Problemas !',"
                    + "  text: 'No se puede realizar esta accion',"
                    + "  icon: 'error',"
                    + "  confirmButtonText: 'Ok'"
                    + "})");
        }
    }

    public void cambiarEstado(Usuario usuIn) {
        if (usuIn.getEstado() == Short.parseShort("0")) {
            usuIn.setEstado(Short.parseShort("1"));
        } else {
            usuIn.setEstado(Short.parseShort("0"));
        }
        usuarioFacadeLocal.edit(usuIn);
    }

    public void guardarTemporal(Usuario usuIn) {
        usuTemporal = usuIn;
    }
}
