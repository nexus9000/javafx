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

public class TableController implements Initializable {
    public static ObservableList<Albums> osList;
    @FXML
    public Tab tab1;
    public AnchorPane tab12;
    @FXML
    private TableView albumsTable;

    @FXML
    private TableColumn<Albums, String> id, albums, years,user,album;
    @FXML
    private TableColumn<Albums, CheckBox> checked;


    private void initCols() {
        if (id == null) {
            id = new TableColumn<>();
            albums = new TableColumn<Albums,String>();
            years = new TableColumn<Albums,String>();
            checked = new TableColumn<Albums, CheckBox>();
            albumsTable = new TableView<Albums>();
            user = new TableColumn<Albums,String>();
            album = new TableColumn<Albums,String>();
        }



        //id.setCellValueFactory(new PropertyValueFactory<>("id"));
        id.setVisible(false);
        albums.setCellValueFactory(new PropertyValueFactory<>("albumName"));
        years.setCellValueFactory(new PropertyValueFactory<>("years"));
        years.setVisible(false);
        albums.setVisible(false);
        checked.setVisible(false);
        user.setCellValueFactory(new PropertyValueFactory<Albums,String>("user"));
        album.setCellValueFactory(new PropertyValueFactory<Albums,String>("albums"));
    }

    private void loadData() throws SQLException, ClassNotFoundException {
        osList = FXCollections.observableArrayList();

        ConnectionDB conn = ConnectionDB.getInstance();
        Connection connection = conn.getConnectionDB();
        ArrayList<Albums> albumsList;
        albumsList = Albums.listUser(connection);
        for (Albums album : albumsList) {
            osList.add(album);
        }//end for loop
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
