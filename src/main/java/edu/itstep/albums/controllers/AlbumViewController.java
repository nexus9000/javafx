package edu.itstep.albums.controllers;

import edu.itstep.albums.model.Albums;
import edu.itstep.albums.model.ConnectionDB;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class AlbumViewController implements Initializable {
    public static ObservableList<Albums> osList;
    @FXML
    private TableView albumsTable;
    @FXML
    private TableColumn<Albums,String> id, albums;
    @FXML
    private  MenuItem close;
    private void initCols(){
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        albums.setCellValueFactory(new PropertyValueFactory<>("albumName"));
    }
 private void loadData()throws SQLException,ClassNotFoundException {
     osList = FXCollections.observableArrayList();
     ConnectionDB conn = ConnectionDB.getInstance();
     Connection connection = conn.getConnectionDB();
     HashMap<Long,String> albumsList = Albums.listAlbums(connection);
     for(Map.Entry<Long,String> entry : albumsList.entrySet()){
         osList.add(new Albums(entry.getKey(),entry.getValue()));
     }//end for loop
     albumsTable.setItems(osList);
 }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
     try {

         initCols();
         loadData();
     }catch(Exception e){
         e.printStackTrace();
     }
    }
    @FXML
    protected void onExit(){
        Platform.exit();
    }
}
