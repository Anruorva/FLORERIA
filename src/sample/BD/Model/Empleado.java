package sample.BD.Model;

import java.sql.Date;

public class Empleado {
    String id,nombre, apellido, puesto, direccion, telefono, id_postal;   Date fch_nacimiento, fch_contratacion;

    public Empleado(String id, String nombre, String apellido, String puesto, String direccion, String telefono, String id_postal, Date fch_nacimiento, Date fch_contratacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.puesto = puesto;
        this.direccion = direccion;
        this.telefono = telefono;
        this.id_postal = id_postal;
        this.fch_nacimiento = fch_nacimiento;
        this.fch_contratacion = fch_contratacion;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getId_postal() {
        return id_postal;
    }

    public void setId_postal(String id_postal) {
        this.id_postal = id_postal;
    }

    public Date getFch_nacimiento() {
        return fch_nacimiento;
    }

    public void setFch_nacimiento(Date fch_nacimiento) {
        this.fch_nacimiento = fch_nacimiento;
    }

    public Date getFch_contratacion() {
        return fch_contratacion;
    }

    public void setFch_contratacion(Date fch_contratacion) {
        this.fch_contratacion = fch_contratacion;
    }
}
