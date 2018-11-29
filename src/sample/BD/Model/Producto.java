package sample.BD.Model;

public class Producto {
    String id,nombre, nombre_latin, descripcion, id_estado;
    float precio_compra, precio_venta;
    int unidades, minimo_stock;

    public Producto(String id, String nombre, String nombre_latin, String descripcion, String id_estado, float precio_compra, float precio_venta, int unidades, int minimo_stock) {
        this.id = id;
        this.nombre = nombre;
        this.nombre_latin = nombre_latin;
        this.descripcion = descripcion;
        this.id_estado = id_estado;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.unidades = unidades;
        this.minimo_stock = minimo_stock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre_latin() {
        return nombre_latin;
    }

    public void setNombre_latin(String nombre_latin) {
        this.nombre_latin = nombre_latin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getId_estado() {
        return id_estado;
    }

    public void setId_estado(String id_estado) {
        this.id_estado = id_estado;
    }

    public float getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(float precio_compra) {
        this.precio_compra = precio_compra;
    }

    public float getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(float precio_venta) {
        this.precio_venta = precio_venta;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public int getMinimo_stock() {
        return minimo_stock;
    }

    public void setMinimo_stock(int minimo_stock) {
        this.minimo_stock = minimo_stock;
    }
}
