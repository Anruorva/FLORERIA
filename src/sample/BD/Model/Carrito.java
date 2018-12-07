package sample.BD.Model;

public class Carrito {
    String Id_producto, Id_pedido, producto;
    int Cantidad_pedida, Descuento;
    float Subtotal;

    public Carrito(String id_producto, String id_pedido, String producto, int cantidad_pedida, int descuento, float subtotal) {
        Id_producto = id_producto;
        Id_pedido = id_pedido;
        this.producto = producto;
        Cantidad_pedida = cantidad_pedida;
        Descuento = descuento;
        Subtotal = subtotal;
    }

    public String getId_producto() {
        return Id_producto;
    }

    public void setId_producto(String id_producto) {
        Id_producto = id_producto;
    }

    public String getId_pedido() {
        return Id_pedido;
    }

    public void setId_pedido(String id_pedido) {
        Id_pedido = id_pedido;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad_pedida() {
        return Cantidad_pedida;
    }

    public void setCantidad_pedida(int cantidad_pedida) {
        Cantidad_pedida = cantidad_pedida;
    }

    public int getDescuento() {
        return Descuento;
    }

    public void setDescuento(int descuento) {
        Descuento = descuento;
    }

    public float getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(float subtotal) {
        Subtotal = subtotal;
    }
}
