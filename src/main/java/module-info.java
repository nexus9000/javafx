module edu.itstep.albums {
    requires javafx.controls;
    requires javafx.fxml;
    requires sql.module;
    requires java.sql;
    requires org.jetbrains.annotations;


    opens edu.itstep.albums to javafx.fxml;
    exports edu.itstep.albums;
    exports edu.itstep.albums.controllers;
    exports edu.itstep.albums.model;
    opens edu.itstep.albums.controllers to javafx.fxml;
    opens edu.itstep.albums.model to javafx.fxml;
}