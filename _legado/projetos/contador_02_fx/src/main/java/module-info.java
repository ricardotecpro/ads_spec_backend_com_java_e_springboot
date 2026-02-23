module com.example.contadorfx {
    requires javafx.controls;
    exports com.example;
    opens com.example to javafx.graphics;
}