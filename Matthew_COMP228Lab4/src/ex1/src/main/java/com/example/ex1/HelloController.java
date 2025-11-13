package com.example.ex1;

// Matthew Elliott - 301424215
// November 12, 2025
// COMP228 Lab 4

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Objects;

public class HelloController {
    @FXML
    private TextField nameField, addressField, provinceField, cityField, postalField,
            phoneField, emailField;
    @FXML
    private CheckBox councilField, volunteerField;
    @FXML
    private RadioButton compField, businessField;
    @FXML
    private ComboBox<String> courseSelect;
    @FXML
    private ListView<String> courseList;
    @FXML
    private Button displayButton;
    @FXML
    private TextArea displayStudent;

    private static final ToggleGroup major = new ToggleGroup();

    // Creating default ListView value
    ObservableList<String> listItems = FXCollections.observableArrayList();

    // Creating the Observable Lists for the Combo Box
    ObservableList<String> compOptions = FXCollections.observableArrayList(
            "Java", "Python", "C#", "JavaScript"
    );
    ObservableList<String> businessOptions = FXCollections.observableArrayList(
            "Marketing", "Finance", "Accounting", "Human Resources"
    );

    @FXML
    public void initialize() {
        // Adding the Radio Buttons to the ToggleGroup
        compField.setToggleGroup(major);
        businessField.setToggleGroup(major);
        // Sets compField on by default
        compField.setSelected(true);

        compField.setToggleGroup(major);
        businessField.setToggleGroup(major);
        // Sets compField on by default
        compField.setSelected(true);

        // Setting listItems to courseList ListView
        courseList.setItems(listItems);

        compField.setOnAction(e -> updateCourses());
        businessField.setOnAction(e -> updateCourses());
        courseSelect.setOnAction(e -> addToList());
        displayButton.setOnAction(e -> onDisplay());
    }

    // Setting up the ComboBox
    private void updateCourses() {
        // Using a try catch to check which major is currently selected
        try {
            String majorPick = major.getSelectedToggle().toString();

            if (Objects.equals(majorPick, "RadioButton[id=compField, styleClass=radio-button radio]''")) {
                courseSelect.setItems(compOptions);
            } else if (Objects.equals(majorPick, "RadioButton[id=businessField, styleClass=radio-button radio]''")) {
                courseSelect.setItems(businessOptions);
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    // Adding data to ListView
    private void addToList() {
        try {
            // Getting the value of the ComboBox and adding it to the ListView
            String selectedCourse = courseSelect.getValue();

            // Loop through current list to ensure there are no duplicate entries
            for (String course : listItems) {
                if (Objects.equals(selectedCourse, course))
                {
                    return;
                }
            }
            courseList.getItems().add(selectedCourse);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    // Setting up the Display Button event to add data to TextArea
    private void onDisplay() {
        // Getting the value of each entry
        String name = nameField.getText().trim();
        String address = addressField.getText().trim();
        String province = provinceField.getText().trim();
        String city = cityField.getText().trim();
        String postal = postalField.getText().trim();
        String phone = phoneField.getText().trim();
        String email = emailField.getText().trim();
        String courses = courseList.getItems().toString();

        // Makes sure that fields are not empty
        if (name.isEmpty() || address.isEmpty() || province.isEmpty() || city.isEmpty() || postal.isEmpty() ||
        phone.isEmpty() || email.isEmpty()) {
            isEmpty();
            return;
        }

        // Checking for checkboxes
        String council = "";
        if (councilField.isSelected()) {
            council = "Student Council";
        }
        String volunteer = "";
        if (volunteerField.isSelected()) {
            volunteer = "Volunteer Work";
        }

        // Filling the TextArea:
        displayStudent.setText(name + ", " + address + ", " + province + " " + city + ", " + postal + ". " + phone
        + ", " + email + ". " + council + ". " + volunteer + ".\nCourses:\n" + courses);
    }

    private void isEmpty() {
        Alert alert = new Alert(Alert.AlertType.WARNING, "ONE OR MORE OF YOUR ENTRIES ARE EMPTY!");
        alert.showAndWait();
    }
}
