package sample.BD.Model;

public class Categoria {
    String Id_categoria, Nombre_categoria, Descripcion_categoria;

    public Categoria(String id_categoria, String nombre_categoria, String descripcion_categoria) {
        Id_categoria = id_categoria;
        Nombre_categoria = nombre_categoria;
        Descripcion_categoria = descripcion_categoria;
    }

    public String getId_categoria() {
        return Id_categoria;
    }

    public void setId_categoria(String id_categoria) {
        Id_categoria = id_categoria;
    }

    public String getNombre_categoria() {
        return Nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        Nombre_categoria = nombre_categoria;
    }

    public String getDescripcion_categoria() {
        return Descripcion_categoria;
    }

    public void setDescripcion_categoria(String descripcion_categoria) {
        Descripcion_categoria = descripcion_categoria;
    }
}
