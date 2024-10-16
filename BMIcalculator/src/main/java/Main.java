import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML layout
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("bmi_calculator.fxml")));
        primaryStage.setTitle("BMI Calculator"); // Set the window title
        primaryStage.setScene(new Scene(root, 300, 400)); // Set the scene size
        primaryStage.show(); // Display the window
    }

    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }
}
