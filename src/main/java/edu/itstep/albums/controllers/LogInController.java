package edu.itstep.albums.controllers;

import edu.itstep.albums.AlbumApplication;
import edu.itstep.albums.AlbumsList;
import edu.itstep.albums.model.ConnectionDB;
import edu.itstep.albums.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

public class LogInController {
    @FXML
    private TextField userName;
    @FXML
    private PasswordField passwd;
    @FXML
    protected void onButtonClick() {
       logIn();
    }
    private void logIn(){
        User userPojo = new User();
        String user = userName.getText();
        String password = passwd.getText();
        try {
            ConnectionDB conn = ConnectionDB.getInstance();
            userPojo.setUserName(user);
            userPojo.setPassword(password);
            boolean isLoggedUser = userPojo.isUserAuthenticated(conn.getConnectionDB());
            if (isLoggedUser) {
                AlbumApplication.stageL.close();
                AlbumsList list = new AlbumsList();
                Stage stage = new Stage();
                list.start(stage);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong " +
                        "password or username!", ButtonType.OK, ButtonType.CANCEL);
                alert.show();
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    @FXML
    protected void onEnter(@NotNull KeyEvent key){
        if(key.getCode().equals(KeyCode.ENTER)){
           logIn();
        }
    }
}