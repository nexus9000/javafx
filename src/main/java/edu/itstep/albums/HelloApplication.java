package edu.itstep.albums;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    static Stage stageL;
    @Override
    public void start(Stage stage) throws IOException {
        HelloController hello = new HelloController();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        fxmlLoader.setController(hello);
        Scene scene = new Scene(fxmlLoader.load(), 350, 200);
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