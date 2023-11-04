package lk.ijse.shadowStudio.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class BookingsFormController {

    @FXML
    private JFXComboBox<?> cmbCustomerId;

    @FXML
    private JFXComboBox<?> cmbPackageId;

    @FXML
    private Label lblCustomerName;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblOrderId;

    @FXML
    private Label lblTime;

    @FXML
    private AnchorPane rootHome;

    @FXML
    void cmbCustomerOnAction(ActionEvent event) {

    }

    @FXML
    void cmbPackageOnAction(ActionEvent event) {

    }

    public void btnSaveBookingOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteBookingOnAction(ActionEvent actionEvent) {
    }

    public void btnUpdateBookingOnAction(ActionEvent actionEvent) {
    }

    public void btnViewBookingsOnAction(ActionEvent actionEvent) {
    }
}
