package sample.Controllers;

import com.jfoenix.controls.*;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import sample.BD.DAO.JardineriaDAO;
import sample.BD.Model.*;
import sample.BD.MySQL;

import javax.swing.*;
import java.net.URL;
import java.sql.Date;
import java.util.*;


public class Controller implements Initializable {
    @FXML
    JFXRadioButton radioButtonEfectivo,radioButtonTarjeta;
    @FXML
    JFXButton btnEliminar, btnNuevoPedido, btnAcceso, btnRegistrarPedido,
            btnAgregarCarro, btnRegistrarEmpleado,btnHechoRegistroEmpleado,
            btnProcederPago, btnRegistrarC, btnRegistrarCliente, btnPagar;
    @FXML
    MenuItem mnuMostrarProducto,mnuLlegadaProducto;
    @FXML
    TableView<Producto> tbl;
    @FXML
    TableView<Carrito> tblCarrito;
    @FXML
    Label txtIdCliente, txtIdEmpleado, txtPedido,txtTipoEmpleado;
    @FXML
    JFXComboBox<String> cboxTransportista, cboxClientes, cboxPedido, cboxCodigoPE, cboxCodigoPC, cboxTipoE;
    @FXML
    AnchorPane anchorNewPedido, anchorcliente, newEmpleado, anchorNewCliente;
    @FXML
    JFXTextField txtNuevoPedido, txtRuta, txtUsuario
            ,txtNombreE, txtDireccionE, txtApellidoE, txtIdE, txtTelefonoE,
            txtSubtotal, txtIva, txtTotal,
            txtNombreC, txtDireccionC, txtApellidoC, txtIdC, txtTelefonoC;
    @FXML
    JFXPasswordField  txtPassword, txtPassE ;
    @FXML
    JFXDatePicker dateEntrega, dateEnvio, dateNacimientoE;
    MySQL mySQL= new MySQL();
    JardineriaDAO jardineriaDAO= new JardineriaDAO(mySQL.getConnection());
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        ToggleGroup group = new ToggleGroup();
        radioButtonEfectivo.setToggleGroup(group);
        radioButtonTarjeta.setToggleGroup(group);
        colocarImagenesBotones();
        btnEliminar.setDisable(false);
        btnEliminar.setOnAction(handler);
        initProductos(null);
        initCarrito();
        llebnarCombox();
        btnRegistrarPedido.setOnAction(handler);
        btnNuevoPedido.setOnAction(handler);
        btnAcceso.setOnAction(handler);
        cboxClientes.setOnAction(handler);
        cboxPedido.setOnAction(handler);
        btnAgregarCarro.setOnAction(handler);
        btnRegistrarEmpleado.setOnAction(handler);
        btnHechoRegistroEmpleado.setOnAction(handler);
        btnRegistrarC.setOnAction(handler);
        btnRegistrarCliente.setOnAction(handler);
        mnuMostrarProducto.setOnAction(handler);
        btnPagar.setOnAction(handler);
        //mnuLlegadaProducto.seton;
    }
    public void llebnarCombox(){
        ObservableList<String> Tipos = FXCollections.observableArrayList();
        Tipos.addAll("Gerente","Comun");
        cboxTransportista.getItems().clear();
        cboxPedido.getItems().clear();
        cboxClientes.getItems().clear();
        cboxCodigoPE.getItems().clear();
        cboxTipoE.setItems(Tipos);
        cboxCodigoPE.setItems(jardineriaDAO.cboxCodigoPostal());
        cboxClientes.setItems(jardineriaDAO.cboxCientes());
        cboxPedido.setItems(jardineriaDAO.cboxPedidos());
        cboxTransportista.setItems(jardineriaDAO.cboxTransportistas());
        btnProcederPago.setOnAction(handler);
        cboxCodigoPC.setItems(jardineriaDAO.cboxCodigoPostal());
    }
    EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == btnNuevoPedido) anchorNewPedido.setVisible(true);
            if (event.getSource() == btnRegistrarPedido) btnPedidoo();
            if (event.getSource() == cboxClientes)
                txtIdCliente.setText(cboxClientes.getSelectionModel().getSelectedItem().toString().split("-")[0]);
            if (event.getSource() == cboxPedido)
                txtPedido.setText(cboxPedido.getSelectionModel().getSelectedItem().toString());
            if (event.getSource() == btnAcceso) { accesar(); }
            if (event.getSource() == btnAgregarCarro) agregarCarro();
            if (event.getSource()== btnRegistrarEmpleado) {
                if(txtTipoEmpleado.getText().equalsIgnoreCase("Gerente")) {
                    anchorcliente.setVisible(false);
                    newEmpleado.setVisible(true);
                }
            }
            if(event.getSource()==btnHechoRegistroEmpleado){ registraempleado(); }
            if(event.getSource() == btnEliminar){ eliminarCarro();}
            if(event.getSource() == btnProcederPago){ProcederPago();}
            if(event.getSource() == btnRegistrarCliente) anchorNewCliente.setVisible(true);
            if (event.getSource()==btnRegistrarC) { registrarCliente();}
            if(event.getSource()==btnPagar){
                String pagado;
                if(radioButtonEfectivo.isSelected()) pagado = "Efectivo";
                else pagado = "Tarjeta";
                JOptionPane.showMessageDialog(null, "Subtotal   = $"+txtSubtotal.getText()+
                                                                             "\nIVA        = $"+txtIva.getText()+
                                                                             "\nTotal      = $"+txtTotal.getText()+
                                                                           "\n\nPagado con = "+pagado);
                tblCarrito.getItems().clear();
            }
            if(event.getSource()==mnuMostrarProducto) initProductos(null);

        }
    };
    void registrarCliente() {
        Cliente clien = new Cliente(txtIdC.getText(), txtNombreC.getText(), txtApellidoC.getText(), txtTelefonoC.getText(),
                cboxCodigoPC.getSelectionModel().getSelectedItem(),txtDireccionC.getText());
        if(jardineriaDAO.insertCliente(clien)){
            anchorNewCliente.setVisible(false);
            cboxClientes.getItems().clear();
            cboxClientes.setItems(jardineriaDAO.cboxCientes());
            txtIdCliente.setText(clien.getId());
        }
    }
    void registraempleado(){
        Empleado empleado= new Empleado(txtIdE.getText(),txtNombreE.getText(), txtApellidoE.getText(),
                cboxTipoE.getSelectionModel().getSelectedItem().toString(),txtDireccionE.getText(),
                txtTelefonoE.getText(),cboxCodigoPE.getSelectionModel().getSelectedItem().toString(),
                Date.valueOf(dateNacimientoE.getValue()),txtPassE.getText(),null);
        String tipo, user, pass;
        user=txtUsuario.getText();
        pass=txtPassword.getText();
        tipo = txtTipoEmpleado.getText();
        if(jardineriaDAO.insertEmpleado(empleado)){
            mySQL.dbname="";
            mySQL.conn = null;
            jardineriaDAO = new JardineriaDAO(mySQL.getConnection());
            if(jardineriaDAO.crearUser(user,pass)){
                if(jardineriaDAO.darPermiso(user,tipo)) {
                    System.out.println("Hecho ;)");
                    mySQL.dbpass = pass;
                    mySQL.dbuser = user;
                    mySQL.dbname="Jardineria";
                    mySQL.conn = null;
                    jardineriaDAO = new JardineriaDAO(mySQL.getConnection());
                }
            }else{
                mySQL.dbname="Jardineria";
                mySQL.conn = null;
                jardineriaDAO = new JardineriaDAO(mySQL.getConnection());
            }
            newEmpleado.setVisible(false);
            anchorcliente.setVisible(true);
        }
    }
    void accesar(){
        String tipo, user, pass;
        user=txtUsuario.getText();
        pass=txtPassword.getText();
        if (jardineriaDAO.validEmpleado(user, pass)) {
            txtIdEmpleado.setText(user);
            txtTipoEmpleado.setText(jardineriaDAO.tipoEmp(user));
            if(txtTipoEmpleado.getText().equalsIgnoreCase("Gerente")) {
                mySQL.dbpass = txtPassword.getText();
                mySQL.dbuser = txtUsuario.getText();
                mySQL.dbname = "Jardineria";
                mySQL.conn = null;
                jardineriaDAO = new JardineriaDAO(mySQL.getConnection());
            }
        }
    }
    void btnPedidoo (){
        if(
        jardineriaDAO.insertPedido(new Pedido(txtNuevoPedido.getText(),
                txtRuta.getText(),
                cboxTransportista.getSelectionModel().getSelectedItem().toString().split("-")[0],
                txtIdEmpleado.getText(),
                txtIdCliente.getText(),
                Date.valueOf(dateEnvio.getValue()),
                Date.valueOf(dateEntrega.getValue())))){
            txtPedido.setText(txtNuevoPedido.getText());
            anchorNewPedido.setVisible(false);
            cboxPedido.getItems().clear();
            cboxPedido.setItems(jardineriaDAO.cboxPedidos());
        }
    }
    void agregarCarro(){
        Producto producto = tbl.getSelectionModel().getSelectedItem();
        int cantidad, descuento;
        cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad: "));
        descuento = Integer.parseInt(JOptionPane.showInputDialog("Descuento \n " +
                "1.- 10%\n" +
                "2.- 20%\n" +
                "3.- 30%\n" +
                "4.- 40%\n" +
                "5.- 50%\n"));
        float subtotal = (producto.getPrecio_venta()*cantidad)*Float.parseFloat("1."+descuento);
        Carrito carrito = new Carrito(producto.getId(),txtPedido.getText(), producto.getNombre(),cantidad,descuento,subtotal);
        if(jardineriaDAO.insertCarrito(carrito)){
            tblCarrito.getItems().addAll(carrito);
            initProductos(null);
        }
    }
    void eliminarCarro(){
        Carrito carrito = tblCarrito.getSelectionModel().getSelectedItem();
        if(jardineriaDAO.deleteCarrito(carrito.getId_pedido(),carrito.getId_producto())){
            tblCarrito.getItems().remove(tblCarrito.getSelectionModel().getSelectedIndex());
            initProductos(null);
        }
    }
    void ProcederPago(){
        ObservableList<Carrito> carritos= tblCarrito.getItems();
        float cont=0, iva, total;
        for(int i = 0; i<carritos.size();i++){
            cont = cont + carritos.get(i).getSubtotal();
        }
        iva = cont * 0.16F;
        total=cont+iva;
        txtSubtotal.setText(cont+"");
        txtIva.setText(iva+"");
        txtTotal.setText(total+"");
    }
    private void colocarImagenesBotones(){
        URL link = getClass().getResource("/images/eliminar.png");
        Image image = new Image(link.toString(),35,20,false,true);
        btnEliminar.setGraphic(new ImageView(image));
    }
    public void initCarrito() {
        tblCarrito.getItems().clear();
        tblCarrito.getColumns().clear();
        TableColumn column = new TableColumn("producto");
        column.setCellValueFactory(new PropertyValueFactory<Carrito, String>("producto"));
        TableColumn column2 = new TableColumn("Cantidad_pedida");
        column2.setCellValueFactory(new PropertyValueFactory<Carrito, String>("Cantidad_pedida"));
        TableColumn column3 = new TableColumn("Descuento");
        column3.setCellValueFactory(new PropertyValueFactory<Carrito, Float>("Descuento"));
        TableColumn column4 = new TableColumn("Subtotal");
        column4.setCellValueFactory(new PropertyValueFactory<Carrito, Float>("Subtotal"));
        tblCarrito.getColumns().addAll(column, column2, column3, column4);
    }
    public void initProductos(String id_P){
        tbl.getItems().clear();
        tbl.getColumns().clear();
        TableColumn column = new TableColumn("id");
        column.setCellValueFactory(new PropertyValueFactory<Producto, String>("id"));
        TableColumn column2 = new TableColumn("nombre");
        column2.setCellValueFactory(new PropertyValueFactory<Producto, String>("nombre"));
        TableColumn column3 = new TableColumn("nombre_latin");
        column3.setCellValueFactory(new PropertyValueFactory<Producto, String>("nombre_latin"));
        TableColumn column4 = new TableColumn("precio_compra");
        column4.setCellValueFactory(new PropertyValueFactory<Producto, Float>("precio_compra"));
        TableColumn column5 = new TableColumn("precio_venta");
        column5.setCellValueFactory(new PropertyValueFactory<Producto, Float>("precio_venta"));
        TableColumn column6 = new TableColumn("unidades");
        column6.setCellValueFactory(new PropertyValueFactory<Producto, Integer>("unidades"));
        TableColumn column7 = new TableColumn("minimo_stock");
        column7.setCellValueFactory(new PropertyValueFactory<Producto, Integer>("minimo_stock"));
        TableColumn column8 = new TableColumn("descripcion");
        column8.setCellValueFactory(new PropertyValueFactory<Producto, String>("descripcion"));
        TableColumn column9 = new TableColumn("id_estado");
        column9.setCellValueFactory(new PropertyValueFactory<Producto, String>("id_estado"));
        tbl.getColumns().addAll(column, column2, column5, column6, column7, column8, column9, column3, column4);
        if(id_P==null)
            tbl.setItems(jardineriaDAO.fetchProductos());
        else
            tbl.setItems(jardineriaDAO.fetchProductos(id_P));
    }
}