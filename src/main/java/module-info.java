module edu.itstep.albums {
    requires javafx.controls;
    requires javafx.fxml;
    requires sql.module;
    requires java.sql;


    opens edu.itstep.albums to javafx.fxml;
    exports edu.itstep.albums;
}