package edu.itstep.albums.controllers;

import edu.itstep.sql.SqlOps;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AlbumViewController implements Initializable {

    @FXML
    private MenuItem close;





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
    @FXML
    public void startDownload(ActionEvent actionEvent) {
    }
}
