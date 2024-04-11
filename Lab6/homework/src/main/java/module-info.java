module org.example.lab6_compulsory {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.lab6_compulsory to javafx.fxml;
    exports org.example.lab6_compulsory;
}