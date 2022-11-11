package edu.itstep.albums;

import edu.itstep.sql.SqlOps;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;

public class AlbumsList extends Application {

    @Override
    public void start(@NotNull Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(AlbumApplication.class.getResource("tabview.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 601, 550);
       scene.getStylesheets().add(AlbumApplication.class.getResource("album-style.css").toString());
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
