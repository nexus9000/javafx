package edu.itstep.albums;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;

import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    protected void onButtonClick() {
        boolean isLoggedUser = true;
        if(isLoggedUser){
            //
          HelloApplication.stageL.close();
          AlbumsList list = new AlbumsList();
          try {
              Stage stage = new Stage();
              list.start(stage);
          }catch(Exception exc){
              exc.printStackTrace();
          }
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong " +
                    "password or username!", ButtonType.OK, ButtonType.CANCEL);
            alert.show();
        }
    }
}