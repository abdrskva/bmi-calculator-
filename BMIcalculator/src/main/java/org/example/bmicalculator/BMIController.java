package org.example.bmicalculator;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.application.Platform;

public class BMIController {

    @FXML
    private TextField weightField;
    @FXML
    private TextField heightField;
    @FXML
    private ChoiceBox<String> unitChoice;
    @FXML
    private Label resultLabel;

    @FXML
    public void calculateBMI() {
        try {
            double weight = Double.parseDouble(weightField.getText());
            double height = Double.parseDouble(heightField.getText());
            String unit = unitChoice.getValue();

            double bmi;

            if ("Metric (kg, m)".equals(unit)) {
                bmi = weight / (height * height);
            } else {
                bmi = (weight / (height * height)) * 703; // Convert lbs/inches to BMI
            }

            resultLabel.setText(String.format("Your BMI: %.2f - %s", bmi, getBMIStatus(bmi)));
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input!");
        }
    }

    private String getBMIStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Normal";
        else if (bmi < 30) return "Overweight";
        else return "Obese";
    }

    @FXML
    public void clearFields() {
        weightField.clear();
        heightField.clear();
        resultLabel.setText("");
    }

    @FXML
    public void exitApp() {
        Platform.exit();
    }

    @FXML
    public void showHelp() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Help");
        alert.setHeaderText(null);
        alert.setContentText("Enter your weight and height, select the unit, and click 'Calculate BMI'.");
        alert.showAndWait();
    }
}
