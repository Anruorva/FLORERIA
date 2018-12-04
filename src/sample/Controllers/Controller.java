package sample.Controllers;

import com.jfoenix.controls.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.BD.DAO.JardineriaDAO;
import sample.BD.Model.Producto;
import sample.BD.MySQL;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    JFXRadioButton radioButtonEfectivo;
    @FXML
    JFXRadioButton radioButtonTarjeta;
    @FXML
    JFXButton btnEliminar;
    @FXML
    public TableView tbl;
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