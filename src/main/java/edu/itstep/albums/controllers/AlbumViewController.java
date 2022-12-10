package edu.itstep.albums.controllers;

import edu.itstep.albums.model.Albums;
import edu.itstep.albums.model.ConnectionDB;
import edu.itstep.sql.SqlOps;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AlbumViewController implements Initializable {
    public static ObservableList<Albums> osList;
    @FXML
    private TableView albumsTable;
    @FXML
    private TableColumn<Albums, String> id, albums, years;
    @FXML
    private TableColumn<Albums,Boolean> checked;
    @FXML
    private MenuItem close;

    private void initCols() {
        if(id == null){
            id= new TableColumn<>();
            albums = new TableColumn<>();
            years = new TableColumn<>();
            checked = new TableColumn<>();
            albumsTable = new TableView();
        }

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        albums.setCellValueFactory(new PropertyValueFactory<>("albumName"));
        years.setCellValueFactory(new PropertyValueFactory<>("years"));
        //checked.setCellValueFactory(new PropertyValueFactory<>("checked"));
        checked.setCellValueFactory(new PropertyValueFactory<>("checked"));
        checked.setCellFactory(p-> new CheckBoxTableCell<>());


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
        albumsTable.setItems(osList);
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

    @FXML
    protected void onExit() {
        try {
            SqlOps.closeConn();
        } catch (SQLException sql) {
            sql.printStackTrace();
        } finally {
            Platform.exit();
        }
    }
}
