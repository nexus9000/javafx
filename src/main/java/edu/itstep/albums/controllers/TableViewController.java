package edu.itstep.albums.controllers;

import edu.itstep.albums.model.Albums;
import edu.itstep.albums.model.ConnectionDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TableViewController implements Initializable {


    public static ObservableList<Albums> osList;
    @FXML
    public Tab tab1;
    public AnchorPane tab12;
    @FXML
    private TableView albumsTable;

    public TableView getAlbumsTable() {
        return albumsTable;
    }

    public void setAlbumsTable(TableView albumsTable) {
        this.albumsTable = albumsTable;
    }

    @FXML
    private TableColumn<Albums, String> id, albums, years;
    @FXML
    private TableColumn<Albums, CheckBox> checked;


    private void initCols() {
        if (id == null) {
            id = new TableColumn<>();
            albums = new TableColumn<>();
            years = new TableColumn<>();
            checked = new TableColumn<>();
            albumsTable = new TableView();
            tab1 = new Tab();
            tab12 = new AnchorPane();
        }



        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        albums.setCellValueFactory(new PropertyValueFactory<>("albumName"));
        years.setCellValueFactory(new PropertyValueFactory<>("years"));
       // checked.setCellValueFactory(c->new SimpleBooleanProperty(c.getValue().getChecked()));
        //checked.setCellFactory(p -> new CheckBoxTableCell<>());
        checked.setCellValueFactory(new PropertyValueFactory<>("checked"));

    }

    private void loadData() throws SQLException, ClassNotFoundException {
        osList = FXCollections.observableArrayList();

        ConnectionDB conn = ConnectionDB.getInstance();
        Connection connection = conn.getConnectionDB();
        ArrayList<Albums> albumsList;
        albumsList = Albums.listAlbums(connection);
        for (Albums album : albumsList) {
            osList.add(album);
        }//end for loop
        osList.add(new Albums("test","test"));
        albumsTable.setItems(osList);
        albumsTable.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() > 1) {
                onEdit();
            }
        });

    }
    public void onEdit() {
        // check the table's selected item and get selected item
        if (albumsTable.getSelectionModel().getSelectedItem() != null) {
            Albums selected = (Albums) albumsTable.getSelectionModel().getSelectedItem();
            System.out.println(selected.getAlbumName());


        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {

            initCols();
            loadData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
