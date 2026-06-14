module org.example.playground.playground {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.playground.playground to javafx.fxml;
    exports org.example.playground.playground;
}