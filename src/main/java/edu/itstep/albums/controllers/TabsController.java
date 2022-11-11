package edu.itstep.albums.controllers;

import edu.itstep.sql.SqlOps;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TabsController implements Initializable {
    @FXML
    TabPane tabPane;
    @FXML
    Tab tab1;

    public TabsController(Stage stage) {
        try {
            //AlbumsList album = new AlbumsList();
          //  album.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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
