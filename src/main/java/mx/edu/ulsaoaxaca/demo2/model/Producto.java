package mx.edu.ulsaoaxaca.demo2.model;

/**
 * Producto
 */
public class Producto {

    private Integer id;
    private String nombre;
    private Integer categoria_id;
    private Integer cantidad;

    public Integer getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public Integer getCategoria_id() {
        return categoria_id;
    }

    public Integer getCantidad() {
        return cantidad;
    }
    

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    

    public void setCategoria_id(Integer categoria_id) {
        this.categoria_id = categoria_id;
    }

    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}