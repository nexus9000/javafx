package edu.itstep.albums;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AlbumsList  extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("album-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 350, 200);
        stage.setTitle("List Music Albums");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }


}
