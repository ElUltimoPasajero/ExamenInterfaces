module com.example.nuevoparking {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires java.sql;


    opens com.example.nuevoparking to javafx.fxml;
    exports com.example.nuevoparking;
}