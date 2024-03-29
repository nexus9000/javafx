package edu.itstep.albums.controllers;

import edu.itstep.albums.model.Albums;
import edu.itstep.albums.model.ConnectionMySqlDb;
import edu.itstep.albums.sql.MySqlOps;
import edu.itstep.sql.SqlOps;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AlbumViewController implements Initializable {

    @FXML
    private MenuItem close;

    public static ObservableList<Albums> osList;
    @FXML
    private TableView albumsTable;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        albumsTable = new TableView<Albums>();
        albumsTable.setItems(TableViewController.osList);
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
    @FXML
    protected void startDownload() {
        osList = albumsTable.getItems();
        ArrayList<Long> listDownload = new ArrayList<>();
        for(Albums album : osList){
            if ((album != null && album.getChecked() != null) &&  album.getChecked().isSelected() ){
                listDownload.add(album.getId());
                System.out.println(MySqlOps.userId + " " + album.getAlbumName());
            }//end if
        }//for
        try {
            ConnectionMySqlDb conn = ConnectionMySqlDb.getInstance();//connection to MySQL
            MySqlOps.writeToAlbums(conn.getConnectionDB(), listDownload);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
