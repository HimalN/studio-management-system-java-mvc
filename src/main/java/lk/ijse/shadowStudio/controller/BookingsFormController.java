package lk.ijse.shadowStudio.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class BookingsFormController {

    @FXML
    private DatePicker bookingDate;

    @FXML
    private JFXComboBox<?> cmbCustomerId;

    @FXML
    private JFXComboBox<?> cmbPackageId;

    @FXML
    private TableColumn<?, ?> colBookingId;

    @FXML
    private TableColumn<?, ?> colCustomerId;

    @FXML
    private TableColumn<?, ?> colCustomerName;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colLocation;

    @FXML
    private TableColumn<?, ?> colPackageId;

    @FXML
    private TableColumn<?, ?> colPackageName;

    @FXML
    private TableColumn<?, ?> colTime;

    @FXML
    private Label lblBookingId;

    @FXML
    private Label lblCustomerName;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    @FXML
    private AnchorPane rootHome;

    @FXML
    private TextArea txtCustomerIdea;

    @FXML
    private TextField txtLocation;

    @FXML
    private TextField txtTime;

    @FXML
    void btnDeleteBookingOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveBookingOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateBookingOnAction(ActionEvent event) {

    }

    @FXML
    void cmbCustomerIdOnAction(ActionEvent event) {

    }

    @FXML
    void cmbPackageIdOnAction(ActionEvent event) {

    }
}
