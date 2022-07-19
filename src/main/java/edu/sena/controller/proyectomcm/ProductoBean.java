package edu.sena.controller.proyectomcm;


import edu.sena.ejb.proyectomcm.ProductoFacadeLocal;
import edu.sena.entity.proyectomcm.CategoriaProducto;
import edu.sena.entity.proyectomcm.OrdenDeCompra;
import edu.sena.entity.proyectomcm.Producto;
import edu.sena.entity.proyectomcm.Proveedor;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ProductoBean implements Serializable {

    @EJB
    private ProductoFacadeLocal productoFacade;
    private List<Producto> listaProductos;
    private Producto producto;
    private Proveedor proveedor;
    private CategoriaProducto categoriaProducto;
    private OrdenDeCompra ordenCompra;
    private String msn;
 
    public List<Producto> getListaProductos() {
        this.listaProductos = this.productoFacade.findAll();
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public CategoriaProducto getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(CategoriaProducto categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public OrdenDeCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenDeCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    @PostConstruct
    public void init() {
        this.producto = new Producto();
        this.proveedor = new Proveedor();
        this.ordenCompra = new OrdenDeCompra();
        this.categoriaProducto = new CategoriaProducto();
    }

    public void guardar() {
        try {
            this.producto.setCategoriaProductoidCategoria(categoriaProducto);
            this.producto.setProveedoridProveedor(proveedor);
            this.productoFacade.create(producto);
            this.producto = new Producto();
            this.proveedor = new Proveedor();
            this.ordenCompra = new OrdenDeCompra();
            this.categoriaProducto = new CategoriaProducto();
            this.msn = "Registro Exitoso";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "Error: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void editar() {
        try {
            this.producto.setCategoriaProductoidCategoria(categoriaProducto);
            this.producto.setProveedoridProveedor(proveedor);
            this.productoFacade.edit(producto);
            this.producto = new Producto();
            this.proveedor = new Proveedor();
            this.ordenCompra = new OrdenDeCompra();
            this.categoriaProducto = new CategoriaProducto();
            this.msn = "Registro Exitoso";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "Error: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar(Producto eliminarProducto) {
        try {
            this.productoFacade.remove(eliminarProducto);
            this.msn = "Registro Eliminado";
        } catch (Exception e) {
            e.printStackTrace();
            this.msn = "Error: " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msn);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void cargarDatos(Producto cargaProducto) {
        this.categoriaProducto.setIdCategoria(cargaProducto.getCategoriaProductoidCategoria().getIdCategoria());
        this.proveedor.setIdProveedor(cargaProducto.getProveedoridProveedor().getIdProveedor());
        this.producto=cargaProducto;
    }

    public void limpiarDatos() {
        this.producto = new Producto();
            this.proveedor = new Proveedor();
            this.ordenCompra = new OrdenDeCompra();
            this.categoriaProducto = new CategoriaProducto();
    }

}
