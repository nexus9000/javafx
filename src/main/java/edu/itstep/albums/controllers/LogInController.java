package edu.itstep.albums.controllers;

import edu.itstep.albums.AlbumApplication;
import edu.itstep.albums.AlbumsList;
import edu.itstep.albums.model.ConnectionDB;
import edu.itstep.albums.model.ConnectionMySqlDb;
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

import java.sql.SQLException;

public final class LogInController {
    @FXML
    private TextField userName;
    @FXML
    private PasswordField passwd;

    @FXML
    protected void onButtonClick() {
        logIn();
    }

    private final void logIn() {
        User userPojo = new User();
        String user = userName.getText();
        StringBuilder password = new StringBuilder(passwd.getText());
        ConnectionDB connSQLite = null;
        ConnectionMySqlDb conn = null;
        boolean isLoggedUser = false;
        try {
            connSQLite = ConnectionDB.getInstance();//connection to sqlite
            conn = ConnectionMySqlDb.getInstance();//connection to MySQL
            userPojo.setUserName(user);
            userPojo.setPassword(password.toString());
            isLoggedUser = userPojo.isUserAuthenticated(conn.getConnectionDB());

        } catch (Exception exc) {
            exc.printStackTrace();
            try {
                isLoggedUser = userPojo.isUserAuthenticated(connSQLite.getConnectionDB());
                System.out.println( isLoggedUser);
            }catch(SQLException | ClassNotFoundException sql){
                sql.printStackTrace();
            }
        }finally {
            try {
                if (isLoggedUser) {
                    password.delete(0, password.length());
                    AlbumApplication.stageL.close();
                    AlbumsList list = new AlbumsList();
                    Stage stage = new Stage();
                    list.start(stage);

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong " +
                            "password or username!", ButtonType.OK, ButtonType.CANCEL);
                    alert.show();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    @FXML
    protected void onEnter(@NotNull KeyEvent key) {
        if (key.getCode().equals(KeyCode.ENTER)) {
            logIn();
        }
    }
}