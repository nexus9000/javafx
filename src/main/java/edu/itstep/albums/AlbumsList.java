package edu.itstep.albums;

import edu.itstep.sql.SqlOps;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;

public class AlbumsList extends Application {

    @Override
    public void start(@NotNull Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(AlbumApplication.class.getResource("tabview.fxml"));
       // FXMLLoader fxmlLoader1 = new FXMLLoader(AlbumApplication.class.getResource("tabview.fxml"));
       // fxmlLoader1.setController(tdv);


        Scene scene = new Scene(fxmlLoader.load(), 620, 550);
        scene.getStylesheets().add(AlbumApplication.class.getResource("stylesheet.css").toString());
        stage.getIcons().add(new Image(AlbumApplication.class.getResourceAsStream("logo.png")));
        stage.setTitle("List Music Albums");
        //stage.setIconified(true);
        stage.setResizable(false);
        stage.setScene(scene);


        stage.show();

        stage.setOnCloseRequest(new EventHandler<>() {
            @Override
            public void handle(WindowEvent event) {
                try {
                    SqlOps.closeConn();
                    Platform.exit();
                } catch (SQLException sql) {
                    sql.printStackTrace();
                }
            }
        });

    }


}
