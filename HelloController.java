package com.example.lab_1_nabin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
public class HelloController implements Initializable {
    @FXML
    private TableView<Appointment> tableView;
    @FXML
    private TableColumn<Appointment, Integer> ID;
    @FXML
    private TableColumn<Appointment, String> Name;
    @FXML
    private TableColumn<Appointment, String> Doctor;
    @FXML
    private TableColumn<Appointment, Integer> Room;
    ObservableList<Appointment> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ID.setCellValueFactory(new
                PropertyValueFactory<Appointment, Integer>("ID"));
        Name.setCellValueFactory(new
                PropertyValueFactory<Appointment, String>("Name"));
        Doctor.setCellValueFactory(new
                PropertyValueFactory<Appointment, String>("Doctor"));
        Room.setCellValueFactory(new
                PropertyValueFactory<Appointment, Integer>("Room"));
        tableView.setItems(list);
    }

    @FXML
    protected void onHelloButtonClick() {
        populateTable();
    }

    public void populateTable() {
        // Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214lab1";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM appointment_tbl";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String Name = resultSet.getString("Name");
                String Doctor = resultSet.getString("Doctor");
                int Room = resultSet.getInt("Room");
                tableView.getItems().add(new Appointment(ID, Name, Doctor,
                        Room));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

