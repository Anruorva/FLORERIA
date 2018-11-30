package sample.BD.Model;

import java.sql.Date;

public class Pedido {
    String id, ruta_envio, id_transportista, id_empleado, id_cliente;    Date fch_envio, fch_pedido, fch_objetivo, fch_entrega;

    public Pedido(String id, String ruta_envio, String id_transportista, String id_empleado, String id_cliente, Date fch_envio, Date fch_pedido, Date fch_objetivo, Date fch_entrega) {
        this.id = id;
        this.ruta_envio = ruta_envio;
        this.id_transportista = id_transportista;
        this.id_empleado = id_empleado;
        this.id_cliente = id_cliente;
        this.fch_envio = fch_envio;
        this.fch_pedido = fch_pedido;
        this.fch_objetivo = fch_objetivo;
        this.fch_entrega = fch_entrega;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRuta_envio() {
        return ruta_envio;
    }

    public void setRuta_envio(String ruta_envio) {
        this.ruta_envio = ruta_envio;
    }

    public String getId_transportista() {
        return id_transportista;
    }

    public void setId_transportista(String id_transportista) {
        this.id_transportista = id_transportista;
    }

    public String getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(String id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Date getFch_envio() {
        return fch_envio;
    }

    public void setFch_envio(Date fch_envio) {
        this.fch_envio = fch_envio;
    }

    public Date getFch_pedido() {
        return fch_pedido;
    }

    public void setFch_pedido(Date fch_pedido) {
        this.fch_pedido = fch_pedido;
    }

    public Date getFch_objetivo() {
        return fch_objetivo;
    }

    public void setFch_objetivo(Date fch_objetivo) {
        this.fch_objetivo = fch_objetivo;
    }

    public Date getFch_entrega() {
        return fch_entrega;
    }

    public void setFch_entrega(Date fch_entrega) {
        this.fch_entrega = fch_entrega;
    }
}
