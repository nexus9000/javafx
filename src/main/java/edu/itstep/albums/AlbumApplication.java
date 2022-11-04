package edu.itstep.albums;

import edu.itstep.albums.controllers.LogInController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class AlbumApplication extends Application {
   public static Stage stageL;
    @Override
    public void start(@NotNull Stage stage) throws IOException {
        LogInController hello = new LogInController();
        FXMLLoader fxmlLoader = new FXMLLoader(AlbumApplication.class.getResource("login-view.fxml"));
        fxmlLoader.setController(hello);
        Scene scene = new Scene(fxmlLoader.load(), 350, 200);
        scene.getStylesheets().add(AlbumApplication.class.getResource("stylesheet.css").toString());
        stage.getIcons().add(new Image(AlbumApplication.class.getResourceAsStream("logo.png")));
        stage.setTitle("LogIn Music Albums");
        stage.setResizable(false);
        stage.setScene(scene);
        stageL = stage;
        stage.show();


    }


    public static void main(String[] args) {
        launch();
    }
}