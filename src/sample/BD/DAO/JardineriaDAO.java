package sample.BD.DAO;

;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.BD.Model.*;

import java.sql.*;

public class JardineriaDAO {
    Connection conn;
    public JardineriaDAO(Connection conn)
    {
        this.conn = conn;
    }
    public ObservableList<String> cboxPedidos(){
        ObservableList<String> codigos = FXCollections.observableArrayList();
        try {
            String query = "SELECT Id_pedido FROM Pedido";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            String p = null;
            while(rs.next()) {
                p = rs.getString(1);
                codigos.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return codigos;
    }
    public ObservableList<String> cboxCodigoPostal(){
        ObservableList<String> codigos = FXCollections.observableArrayList();
        try {
            String query = "SELECT Id_codigo_postal FROM Codigo_postal";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            String p = null;
            while(rs.next()) {
                p = rs.getString(1);
                codigos.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return codigos;
    }
    public ObservableList<String> cboxCientes(){
        ObservableList<String> clientes = FXCollections.observableArrayList();
        try {
            String query = "SELECT Id_cliente, Nombre_cliente FROM Cliente";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            String p = null;
            while(rs.next()) {
                p = rs.getString(1)+"-"+rs.getString(2);
                clientes.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return clientes;
    }
    public ObservableList<String> cboxEmpleados(){
        ObservableList<String> clientes = FXCollections.observableArrayList();
        try {
            String query = "SELECT Id_empleado, Nombre_empleado, Apellido_empleado FROM empleado";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            String p = null;
            while(rs.next()) {
                p = rs.getString(1)+"-"+rs.getString(2)+" "+rs.getString(3);
                clientes.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return clientes;
    }
    public ObservableList<String> cboxTransportistas(){
        ObservableList<String> clientes = FXCollections.observableArrayList();
        try {
            String query = "SELECT Id_transportista, Nombre_compania FROM Transportista";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            String p = null;
            while(rs.next()) {
                p = rs.getString(1)+"-"+rs.getString(2);
                clientes.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return clientes;
    }
    public ObservableList<String> cboxEstadosP(){
        ObservableList<String> clientes = FXCollections.observableArrayList();
        try {
            String query = "SELECT Id_estado_producto, Nombre_estado_producto FROM estado_producto";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            String p = null;
            while(rs.next()) {
                p = rs.getString(1)+"-"+rs.getString(2);
                clientes.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return clientes;
    }
    public ObservableList<String> cboxProductos(){
        ObservableList<String> clientes = FXCollections.observableArrayList();
        try {
            String query = "SELECT Id_producto, Nombre_producto FROM producto";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            String p = null;
            while(rs.next()) {
                p = rs.getString(1)+"-"+rs.getString(2);
                clientes.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return clientes;
    }
    public ObservableList<String> cboxCategorias(){
        ObservableList<String> clientes = FXCollections.observableArrayList();
        try {
            String query = "SELECT Id_categoria, Nombre_categoria FROM categoria";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            String p = null;
            while(rs.next()) {
                p = rs.getString(1)+"-"+rs.getString(2);
                clientes.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return clientes;
    }
    public ObservableList<consultas> consultar(String query, int i){
        ObservableList<consultas> consultass=FXCollections.observableArrayList();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            consultas p = null;
            while(rs.next()) {
                if(i==1)
                    p = new consultas(rs.getString(1) ,null);
                else
                    p = new consultas(rs.getString(1) ,rs.getString(2));
                consultass.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return consultass;
    }

    public ObservableList<Cliente> fetchClientes(){
        ObservableList<Cliente>  clientes= FXCollections.observableArrayList();
        try {
            String query = "SELECT * FROM Cliente";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            Cliente p = null;
            while(rs.next()) {
                p = new Cliente(
                        rs.getString("Id_cliente") , rs.getString("Nombre_cliente"), rs.getString("Apellido_cliente"), null, null, null);
                clientes.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return clientes;
    }
    public String tipoEmp(String id_e){
        String  tipo= "";
        try {
            String query;
            query = "SELECT Puesto_empleado FROM Empleado where Id_empleado =  '"+id_e+"';";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            Categoria p = null;
            if(rs.next()) {
                tipo= rs.getString("Puesto_empleado");
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return tipo;
    }
    public ObservableList<Empleado> fetchEmpleados(){
        ObservableList<Empleado> empleados = FXCollections.observableArrayList();
        try {
            String query = "SELECT * FROM Empleado";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            Empleado p = null;
            while(rs.next()) {
                p = new Empleado(
                        rs.getString("Id_empleado") , rs.getString("Nombre_empleado"), rs.getString("Apellido_empleado"),
                        rs.getString("Puesto_empleado"), rs.getString("Direccion_empleado"), rs.getString("Telefono_empleado"),
                        rs.getString("Id_codigo_postal"), rs.getDate("Fecha_nacimiento"), rs.getString("Contraseña"),rs.getDate("Fecha_contratacion"));
                empleados.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return empleados;
    }
    public ObservableList<Producto> fetchProductos(){
        ObservableList<Producto> productos = FXCollections.observableArrayList();
        try {
            String query = "SELECT * FROM Producto";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            Producto p = null;
            while(rs.next()) {
                p = new Producto(
                        rs.getString("Id_producto") , rs.getString("Nombre_producto"), rs.getString("Nombre_latin"),
                        rs.getString("Descripcion_producto"), rs.getString("Id_estado_producto"),rs.getFloat("Precio_compra_producto"),
                        rs.getFloat("Precio_venta_producto"), rs.getInt("Unidades_stock"), rs.getInt("Minimo_stock"));
                productos.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return productos;
    }
    public ObservableList<Producto> fetchProductos(String id_pedido){
        ObservableList<Producto> productos = FXCollections.observableArrayList();
        try {
            String query = "SELECT p.* FROM Producto p inner join Pedido_producto pp on p.Id_producto = pp.Id_producto where pp.Id_pedido ='"+id_pedido+"';";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            Producto p = null;
            while(rs.next()) {
                p = new Producto(
                        rs.getString("Id_producto") , rs.getString("Nombre_producto"), rs.getString("Nombre_latin"),
                        rs.getString("Descripcion_producto"), rs.getString("Id_estado_producto"),rs.getFloat("Precio_compra_producto"),
                        rs.getFloat("Precio_venta_producto"), rs.getInt("Unidades_stock"), rs.getInt("Minimo_stock"));
                productos.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return productos;
    }
    public boolean categ(String id_p, String id_cat){
        try {
            String query = "insert into Categoria_producto(Id_categoria, Id_producto)"
                    + "Values (?, ?);";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(1, id_cat);
            st.setString(2, id_p);
            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return false;
    }
    public boolean asigProducto(String id_pe, String id_pro, int cant, float desc){
        try {
            String query = "insert into Pedido_producto(Id_pedido, Id_producto, Cantidad_pedida, Descuento)"
                    + "Values (?, ?, ?, ?);";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(1, id_pe);
            st.setString(2, id_pro);
            st.setInt(3, cant);
            st.setFloat(4, desc);
            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return false;
    }
    public boolean asigDireccion(String id_Cliente, String id_Postal, String Direc, String Tel){
        try {
            String query = "insert into Cliente_codigo_postal(Id_codigo_postal, Id_cliente, Direccion_cliente, Telefono_cliente)"
                    + "Values (?, ?, ?, ?);";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(1, id_Postal);
            st.setString(2, id_Cliente);
            st.setString(3, Direc);
            st.setString(4, Tel);
            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return false;
    }
    public Boolean insertCategoria(Categoria categoria) {
        try {
            String query = "INSERT INTO Categoria (Id_categoria, Nombre_categoria, Descripcion_categoria) " +
                    "VALUES (?,?,?);";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(1, categoria.getId_categoria());
            st.setString(2, categoria.getNombre_categoria());
            st.setString(3, categoria.getDescripcion_categoria());
            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return false;
    }
    public Boolean updateCategoria(Categoria categoria) {
        try {
            String query = "update Categoria "
                    + " set  Nombre_categoria=?, Descripcion_categoria=?"
                    + " where Id_categoria=?";
            System.out.println(query + "updating....");
            PreparedStatement st =  conn.prepareStatement(query);

            st.setString(1, categoria.getNombre_categoria());
            st.setString(2, categoria.getDescripcion_categoria());
            st.setString(3, categoria.getId_categoria());
            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return false;
    }
    public Boolean deleteCategoria(String id) {
        try {
            String query = "delete from Categoria where Id_categoria= ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, id);
            st.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    public Boolean updateCliente(Cliente cliente) {
        try {
            String query = "update Cliente "
                    + " set  Nombre_cliente=?, Apellido_cliente=?"
                    + " where Id_cliente=?";
            System.out.println(query + "updating....");
            PreparedStatement st =  conn.prepareStatement(query);

            st.setString(1, cliente.getNombre());
            st.setString(2, cliente.getApellido());
            st.setString(3, cliente.getId());
            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return false;
    }
    public Boolean insertCliente(Cliente cliente) {
        try {
            String query = "CALL insetaCliente(?, ?, ?, ?, ?, ?);";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(1, cliente.getId());
            st.setString(2, cliente.getNombre());
            st.setString(3, cliente.getApellido());
            st.setString(4, cliente.getCp());
            st.setString(5, cliente.getDireccion());
            st.setString(6, cliente.getTelefono());
            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return false;
    }
    public Boolean deleteCliente(String id) {
        try {
            String query = "delete from cliente_codigo_postal where Id_cliente= ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, id);
            st.execute();
            query = "delete from Cliente where Id_cliente= ?";
            st = conn.prepareStatement(query);
            st.setString(1, id);
            st.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    public Boolean validEmpleado(String ID, String Con) {
        try {
            String query = "select Id_empleado from Empleado " +
                    "where Id_empleado = '"+ID+"' and  Contraseña = '"+Con+"'";
            Statement st =  conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs.next())
                return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return false;
    }
    public Boolean insertEmpleado(Empleado empleado) {
        try {
            String query = "CALL insertaEmpleado(?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(1, empleado.getId());
            st.setString(2, empleado.getNombre());
            st.setString(3, empleado.getApellido());
            st.setString(4, empleado.getPass());
            st.setString(5, empleado.getPuesto());
            st.setString(6, empleado.getDireccion());
            st.setString(7, empleado.getTelefono());
            st.setDate(8, empleado.getFch_nacimiento());
            st.setString(9, empleado.getId_postal());
            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return false;
    }
    public Boolean deleteEmpleado(String id) {
        try {
            String query = "delete from Empleado where Id_empleado= ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, id);
            st.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    public Boolean crearUser(String usr, String pass) {
        try {
            String query = "CREATE USER '"+usr+"'@'localhost' identified by '"+pass+"';";
            PreparedStatement st = conn.prepareStatement(query);
            st.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    public Boolean darPermiso(String usr, String Tipo) {
        try {
            String query;
            if(Tipo.equalsIgnoreCase("Gerente"))
                query = "GRANT ALL PRIVILEGES ON Jardineria.* to '"+usr+"'@'localhost';";
            else
                query = "GRANT INSERT, UPDATE, SELECT ON Jardineria.* to '"+usr+"'@'localhost';";
            PreparedStatement st = conn.prepareStatement(query);
            st.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    public Boolean insertPedido(Pedido pedido) {
        try {
            String query = "call insertaPedido(?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(1, pedido.getId());
            st.setDate(2, pedido.getFch_entrega());
            st.setDate(3, pedido.getFch_envio());
            st.setString(4, pedido.getRuta_envio());
            st.setString(5, pedido.getId_cliente());
            st.setString(6, pedido.getId_transportista());
            st.setString(7, pedido.getId_empleado());
            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return false;
    }
    public Boolean insertCarrito(Carrito carrito) {
        try {
            String query = "call insertaCarrito(?, ?, ?, ?);";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(1, carrito.getId_pedido());
            st.setString(2, carrito.getId_producto());
            st.setInt(3,carrito.getCantidad_pedida() );
            st.setFloat(4, carrito.getDescuento());
            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return false;
    }
    public Boolean deleteCarrito(String id_Pedido, String id_producto) {
        try {
            String query = "delete from Pedido_producto where Id_pedido= ? AND Id_producto = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, id_Pedido);
            st.setString(2, id_producto);
            st.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    public Boolean deletePedido(String id) {
        try {
            String query = "delete from Pedido_producto where Id_pedido= ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, id);
            st.execute();
            query = "delete from Pedido where Id_pedido= ?";
            st = conn.prepareStatement(query);
            st.setString(1, id);
            st.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public Boolean insertProducto(Producto producto) {
        try {
            String query = "INSERT INTO Producto (Id_producto, Nombre_producto, Nombre_latin, Precio_compra_producto, " +
                    "Precio_venta_producto, Unidades_stock, Minimo_stock, Descripcion_producto, Id_estado_producto)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(1, producto.getId());
            st.setString(2, producto.getNombre());
            st.setString(3, producto.getNombre_latin());
            st.setFloat(4, producto.getPrecio_compra());
            st.setFloat(5, producto.getPrecio_venta());
            st.setInt(6, producto.getUnidades());
            st.setInt(7, producto.getMinimo_stock());
            st.setString(8, producto.getDescripcion());
            st.setString(9, producto.getId_estado());
            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return false;
    }
    public Boolean updateProducto(Producto producto) {
        try {
            String query = "UPDATE Producto set Nombre_producto=?, Nombre_latin=?, Precio_compra_producto=?, " +
                    "Precio_venta_producto=?, Unidades_stock=?, Minimo_stock=?, Descripcion_producto=?, Id_estado_producto=?"
                    + " WHERE Id_producto=?;";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(1, producto.getNombre());
            st.setString(2, producto.getNombre_latin());
            st.setFloat(3, producto.getPrecio_compra());
            st.setFloat(4, producto.getPrecio_venta());
            st.setInt(5, producto.getUnidades());
            st.setInt(6, producto.getMinimo_stock());
            st.setString(7, producto.getDescripcion());
            st.setString(8, producto.getId_estado());
            st.setString(9, producto.getId());
            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return false;
    }
    public Boolean deleteProducto(String id) {
        try {
            String query = "delete from Producto where Id_producto= ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, id);
            st.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}

