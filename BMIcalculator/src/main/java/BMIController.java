import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.application.Platform;

public class BMIController {

    @FXML
    private TextField weightField; // Input field for weight
    @FXML
    private TextField heightField; // Input field for height
    @FXML
    private ChoiceBox<String> unitChoice; // Dropdown for selecting unit type
    @FXML
    private Label resultLabel; // Label to display the BMI result

    // Method to calculate BMI when the button is clicked

    public void calculateBMI() {
        try {
            // Parse input values
            double weight = Double.parseDouble(weightField.getText());
            double height = Double.parseDouble(heightField.getText());
            String unit = unitChoice.getValue();

            double bmi;

            // Calculate BMI based on selected unit type
            if ("Metric (kg, m)".equals(unit)) {
                bmi = weight / (height * height);
            } else {
                bmi = (weight / (height * height)) * 703; // Convert lbs/inches to BMI
            }

            // Display the BMI and status
            resultLabel.setText(String.format("Your BMI: %.2f - %s", bmi, getBMIStatus(bmi)));
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input!"); // Error message for invalid input
        }
    }

    // Method to determine BMI status based on calculated BMI
    private String getBMIStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Normal";
        else if (bmi < 30) return "Overweight";
        else return "Obese";
    }

    // Method to clear input fields and results
    @FXML
    public void clearFields() {
        weightField.clear();
        heightField.clear();
        resultLabel.setText("");
    }

    // Method to exit the application
    @FXML
    public void exitApp() {
        Platform.exit();
    }

    // Method to show help information
    @FXML
    public void showHelp() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Help");
        alert.setHeaderText(null);
        alert.setContentText("Enter your weight and height, select the unit, and click 'Calculate BMI'.");
        alert.showAndWait();
    }
}
