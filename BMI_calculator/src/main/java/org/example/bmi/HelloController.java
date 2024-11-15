package com.example.bmicalculator;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private TextField weightField;
    @FXML
    private TextField heightField;
    @FXML
    private ComboBox<String> unitComboBox;
    @FXML
    private Label resultLabel;
    @FXML
    private Label statusLabel;

    @FXML
    public void initialize() {
        unitComboBox.getItems().addAll("Metric (kg, m)", "English (lbs, in)");
        unitComboBox.setValue("Metric (kg, m)");
    }

    @FXML
    protected void onCalculateButtonClick() {
        try {
            double weight = Double.parseDouble(weightField.getText());
            double height = Double.parseDouble(heightField.getText());
            boolean isMetric = unitComboBox.getValue().equals("Metric (kg, m)");

            double bmi = calculateBMI(weight, height, isMetric);
            resultLabel.setText("Your BMI: " + String.format("%.2f", bmi));
            statusLabel.setText("Status: " + getBMIStatus(bmi));
        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter valid numbers.");
            statusLabel.setText("");
        }
    }

    private double calculateBMI(double weight, double height, boolean isMetric) {
        if (isMetric) {
            return weight / (height * height);
        } else {
            return (weight / (height * height)) * 703;
        }
    }

    private String getBMIStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 24.9) {
            return "Normal";
        } else if (bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    @FXML
    protected void onClearButtonClick() {
        weightField.clear();
        heightField.clear();
        resultLabel.setText("");
        statusLabel.setText("");
    }
}
