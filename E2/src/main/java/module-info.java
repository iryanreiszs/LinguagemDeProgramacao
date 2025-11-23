module org.example.e2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.base;


    opens org.example.e2 to javafx.fxml;
    exports org.example.e2;
}