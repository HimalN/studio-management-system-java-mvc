package lk.ijse.shadowStudio.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ReportsFormController{

    @FXML
    private JFXButton btnBookings;

    @FXML
    private JFXButton btnComplains;

    @FXML
    private JFXButton btnCustomer;

    @FXML
    private JFXButton btnEmployee;

    @FXML
    private JFXButton btnLogout;

    @FXML
    private JFXButton btnPackages;

    @FXML
    private JFXButton btnRent;

    @FXML
    private JFXButton btnRentItem;

    @FXML
    private JFXButton btnReports;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    @FXML
    private AnchorPane rootNode;

    @FXML
    void btnBookingsOnAction(ActionEvent event) throws IOException {
        System.out.println("Navigating to Bookings");
        Parent rootNode = FXMLLoader.load(getClass().getResource("/views/book_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setTitle("Manage Bookings");
        stage.setScene(scene);
    }

    @FXML
    void btnComplainsOnAction(ActionEvent event) throws IOException {
        System.out.println("Navigating to Complains");
        Parent rootNode = FXMLLoader.load(getClass().getResource("/views/complains_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setTitle("Manage Complains");
        stage.setScene(scene);
    }

    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        System.out.println("Navigating to Customer Manage");
        Parent rootNode = FXMLLoader.load(getClass().getResource("/views/customer_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setTitle("Manage Customer");
        stage.setScene(scene);
    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) throws IOException {
        System.out.println("Navigating to Dashboard");
        Parent rootNode = FXMLLoader.load(getClass().getResource("/views/dashboard_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setTitle("Dashboard");
        stage.setScene(scene);

    }

    @FXML
    void btnEmployeeOnAction(ActionEvent event) throws IOException {
        System.out.println("Navigating to Employee");
        Parent rootNode = FXMLLoader.load(getClass().getResource("/views/employee_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setTitle("Manage Employee");
        stage.setScene(scene);
    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) throws IOException {
        System.out.println("Navigating to Logout");
        Parent rootNode = FXMLLoader.load(getClass().getResource("/views/login_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setTitle("Login");
        stage.setScene(scene);
    }

    @FXML
    void btnPackagesOnAction(ActionEvent event) throws IOException {
        System.out.println("Navigating to Manage Packages");
        Parent rootNode = FXMLLoader.load(getClass().getResource("/views/packages_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setTitle("Manage Packages");
        stage.setScene(scene);
    }

    @FXML
    void btnRentItemOnAction(ActionEvent event) throws IOException {
        System.out.println("Navigating to Rent Item ");
        Parent rootNode = FXMLLoader.load(getClass().getResource("/views/renting_items_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setTitle("Renting Items Manage");
        stage.setScene(scene);
    }

    @FXML
    void btnRentOnAction(ActionEvent event) throws IOException {
        System.out.println("Navigating to Rent");
        Parent rootNode = FXMLLoader.load(getClass().getResource("/views/rent_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setTitle("Manage Rent");
        stage.setScene(scene);
    }

    @FXML
    void btnReportsOnAction(ActionEvent event) throws IOException {
        System.out.println("Navigating to reports");
        Parent rootNode = FXMLLoader.load(getClass().getResource("/views/reports_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setTitle("Reports");
        stage.setScene(scene);
    }

}
