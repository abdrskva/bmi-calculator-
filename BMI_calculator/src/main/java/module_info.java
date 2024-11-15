module org.example.bmi {
    requires javafx.controls;
    requires javafx.fxml;

    // Exports your package so JavaFX can access your classes
    opens com.example.bmicalculator to javafx.fxml;
    exports com.example.bmicalculator;
}
