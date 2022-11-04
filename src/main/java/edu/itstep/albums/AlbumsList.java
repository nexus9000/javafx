package edu.itstep.albums;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.jetbrains.annotations.NotNull;

public class AlbumsList  extends Application {

    @Override
    public void start(@NotNull Stage stage) throws Exception {
      FXMLLoader fxmlLoader = new FXMLLoader(AlbumApplication.class.getResource("album-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 620, 550);
       scene.getStylesheets().add(AlbumApplication.class.getResource("album-style.css").toString());
       stage.setTitle("List Music Albums");
        stage.setIconified(true);

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                //your code goes here

                System.out.println("Close");
                //this line cancel the close request
                event.consume();
            }
        });
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }





}
