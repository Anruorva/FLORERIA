package sample.Controllers;

import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import sample.BD.DAO.JardineriaDAO;
import sample.BD.Model.Pedido;
import sample.BD.Model.Producto;
import sample.BD.MySQL;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    JFXRadioButton radioButtonEfectivo,radioButtonTarjeta;
    @FXML
    JFXButton btnEliminar, btnNuevoPedido, btnAcceso, btnRegistrarPedido, btnAgregarCarro;
    @FXML
    TableView tbl;
    @FXML
    Label txtIdCliente, txtIdEmpleado, txtPedido;
    @FXML
    JFXComboBox<String> cboxTransportista, cboxClientes, cboxPedido;
    @FXML
    AnchorPane anchorNewPedido;
    @FXML
    JFXTextField txtNuevoPedido, txtRuta, txtUsuario;
    @FXML
    JFXPasswordField  txtPassword ;
    @FXML
    JFXDatePicker dateEntrega, dateEnvio;
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
        initProductos(null);
        llebnarCombox();
        btnRegistrarPedido.setOnAction(handler);
        btnNuevoPedido.setOnAction(handler);
        btnAcceso.setOnAction(handler);
        cboxClientes.setOnAction(handler);
        cboxPedido.setOnAction(handler);
        btnAgregarCarro.setOnAction(handler);
    }
    public void llebnarCombox(){
        cboxTransportista.getItems().clear();
        cboxPedido.getItems().clear();
        cboxClientes.getItems().clear();
        cboxClientes.setItems(jardineriaDAO.cboxCientes());
        cboxPedido.setItems(jardineriaDAO.cboxPedidos());
        cboxTransportista.setItems(jardineriaDAO.cboxTransportistas());
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
                if (event.getSource() == btnAcceso) {
                    if (jardineriaDAO.validEmpleado(txtUsuario.getText(), txtPassword.getText()))
                        txtIdEmpleado.setText(txtUsuario.getText());
                }
                if (event.getSource() == btnAgregarCarro) {
                    agregarCarro();
                }
        }
    };
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

    }
    private void colocarImagenesBotones(){
        URL link = getClass().getResource("/images/eliminar.png");
        Image image = new Image(link.toString(),35,20,false,true);
        btnEliminar.setGraphic(new ImageView(image));
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
        tbl.getColumns().addAll(column, column2, column3, column4, column5, column6, column7, column8, column9);
        if(id_P==null)
            tbl.setItems(jardineriaDAO.fetchProductos());
        else
            tbl.setItems(jardineriaDAO.fetchProductos(id_P));
    }
}