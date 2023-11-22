package lk.ijse.shadowStudio.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.shadowStudio.dto.CustomerDto;
import lk.ijse.shadowStudio.model.BookingsModel;
import lk.ijse.shadowStudio.model.CustomerModel;
import lk.ijse.shadowStudio.model.PackagesModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
    private AnchorPane rootHome;

    @FXML
    private TextArea txtCustomerIdea;

    @FXML
    private TextField txtLocation;

    @FXML
    private TextField txtTime;
    private final BookingsModel bookingsModel = new BookingsModel();
    private final PackagesModel packagesModel = new PackagesModel();
    private CustomerModel customerModel = new CustomerModel();

    public void initialize() {
        generateNextBookingId();
        loadCustomerIds();
    }

    private void generateNextBookingId() {
        try {
            String bookingId = BookingsModel.generateNextBookingId();
            lblBookingId.setText(bookingId);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }
    private void loadCustomerIds() {

    }

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
        String id = (String) cmbCustomerId.getValue();

        try {
            CustomerDto customerDto = customerModel.searchCustomer(id);
            lblCustomerName.setText(customerDto.getCust_Name());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void cmbPackageIdOnAction(ActionEvent event) {

    }
}
