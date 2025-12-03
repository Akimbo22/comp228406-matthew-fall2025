package com.opsdevelop.ex1;

// Matthew Elliott - 301424215
// Lab 05
// December 3, 2025

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML private TextField gameIDField, gameTitleField, playerIDField, firstNameField, lastNameField,
    addressField, postalField, provinceField, phoneField, playerGameIDField, dateField, scoreField;
    @FXML private TableView<PlayerRecord> recordTable;
    @FXML private TableColumn<PlayerRecord, String> gameTitleColumn, firstNameColumn, lastNameColumn,
    addressColumn, postalColumn, provinceColumn, dateColumn, phoneColumn;
    @FXML private TableColumn<PlayerRecord, Number> gameIDColumn, playerIDColumn,
    playerGameIDColumn, scoreColumn;
    @FXML private Button submitButton;

    private final PostgreSQLManager dbManager;
    private final ObservableList<PlayerRecord> records = FXCollections.observableArrayList();

    private static final String URL = "jdbc:postgresql://aws-1-us-east-2.pooler.supabase.com:5432/postgres?user=postgres.vczqwyqrsmuzcgoilyvk&password=Sch0oLw0rkg@m3r5$";
    private static final int PORT = 5432;
    private static final String DB = "postgres";
    private static final String USER = "postgres.vczqwyqrsmuzcgoilyvk";
    private static final String PASS = "Sch0oLw0rkg@m3r5$";

    // Setting up connection to Supabase
    public HelloController() {
        String URL = "jdbc:postgresql://aws-1-us-east-2.pooler.supabase.com:5432/postgres?user=postgres.vczqwyqrsmuzcgoilyvk&password=Sch0oLw0rkg@m3r5$";
        int PORT = 5432;
        String DB = "postgres";
        String USER = "postgres.vczqwyqrsmuzcgoilyvk";
        String PASS = "Sch0oLw0rkg@m3r5$";
        dbManager = new PostgreSQLManager(URL, PORT, DB, USER, PASS);
    }

    @FXML
    public void initialize() {
        gameIDColumn.setCellValueFactory(data -> data.getValue().gameIDProperty());
        gameTitleColumn.setCellValueFactory(data -> data.getValue().gameTitleProperty());
        playerIDColumn.setCellValueFactory(data -> data.getValue().playerIDProperty());
        firstNameColumn.setCellValueFactory(data -> data.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(data -> data.getValue().lastNameProperty());
        addressColumn.setCellValueFactory(data -> data.getValue().addressProperty());
        postalColumn.setCellValueFactory(data -> data.getValue().postalProperty());
        provinceColumn.setCellValueFactory(data -> data.getValue().provinceProperty());
        phoneColumn.setCellValueFactory(data -> data.getValue().phoneProperty());
        playerGameIDColumn.setCellValueFactory(data -> data.getValue().playerGameProperty());
        dateColumn.setCellValueFactory(data -> data.getValue().playDateProperty());
        scoreColumn.setCellValueFactory(data -> data.getValue().scoreProperty());



        recordTable.setItems(records);

        handleView();
        submitButton.setOnAction(e -> handleSubmit());
    }

    @FXML
    private void handleClear() {
        clearFields();
    }

    private void handleSubmit() {
        String game = gameTitleField.getText().trim();
        String first = firstNameField.getText().trim();
        String last  = lastNameField.getText().trim();
        String address = addressField.getText().trim();
        String postal = postalField.getText().trim();
        String province = provinceField.getText().trim();
        String date = dateField.getText().trim();
        String phone = phoneField.getText().trim();

        // Check if any of the fields are empty
        if (game.isEmpty() || first.isEmpty() || last.isEmpty() || address.isEmpty() ||
                postal.isEmpty() || province.isEmpty() || date.isEmpty() || gameIDField.getText().isBlank()
        || playerIDField.getText().isBlank() || phone.isEmpty() || playerGameIDField.getText().isBlank() ||
        scoreField.getText().isBlank()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please Fill Out ALL Information!");
            alert.showAndWait();
            return;
        }

        //setting the other ints:
        int gameID = Integer.parseInt(gameIDField.getText().trim());
        int playerID = Integer.parseInt(playerIDField.getText().trim());
        int playerGameID = Integer.parseInt(playerGameIDField.getText().trim());
        int score = Integer.parseInt(scoreField.getText().trim());

        boolean ok = dbManager.addRecord(gameID, game, playerID, first, last,
                address, postal, province, phone, playerGameID, date, score);
        if (ok) {
            // Clear the fields and reset the table
            clearFields();
            handleView();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Error Adding New Player Log!");
            alert.showAndWait();
        }
    }

    private void handleView() {
        records.clear();
        records.addAll(dbManager.getAllRecords());
    }

    private void clearFields() {
        gameIDField.clear();
        gameTitleField.clear();
        playerIDField.clear();
        firstNameField.clear();
        lastNameField.clear();
        addressField.clear();
        postalField.clear();
        provinceField.clear();
        phoneField.clear();
        playerGameIDField.clear();
        dateField.clear();
        scoreField.clear();
    }
}
