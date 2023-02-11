module edu.itstep.albums {
    requires javafx.controls;
    requires javafx.fxml;
    requires sql.module;
    requires java.sql;
    requires org.jetbrains.annotations;
    requires jbcrypt;
    requires lombok;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;

    opens edu.itstep.albums to javafx.fxml;
    exports edu.itstep.albums;
    exports edu.itstep.albums.controllers;
    exports edu.itstep.albums.model;
    opens edu.itstep.albums.controllers to javafx.fxml;
    opens edu.itstep.albums.model to javafx.fxml;
}