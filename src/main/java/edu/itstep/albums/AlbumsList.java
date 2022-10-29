package edu.itstep.albums;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

public class AlbumsList  extends Application {

    @Override
    public void start(@NotNull Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(AlbumApplication.class.getResource("album-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 550);
        scene.getStylesheets().add(AlbumApplication.class.getResource("album-style.css").toString());
        stage.setTitle("List Music Albums");
        stage.setIconified(true);

        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }





}
