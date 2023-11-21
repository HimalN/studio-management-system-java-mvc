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

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.ijse.shadowStudio.dto.CustomerDto;
import lk.ijse.shadowStudio.model.ComplainModel;
import lk.ijse.shadowStudio.model.CustomerModel;

public class ComplainsFormController {
    @FXML
    private JFXComboBox<String> cmbCustomerId;

    @FXML
    private TableColumn<?, ?> colComplainId;

    @FXML
    private TableColumn<?, ?> colCustomerId;

    @FXML
    private TableColumn<?, ?> colCustomerName;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private Label lblComplainsid;

    @FXML
    private Label lblCustName;

    @FXML
    private TextArea txtComplain;

    @FXML
    private TextField txtSearchComplain;

    private ComplainModel complainModel = new ComplainModel();
    private CustomerModel customerModel = new CustomerModel();

    public void initialize(){
        generateNextComplainId();
        loadCustomerIds();
    }

    private void loadCustomerIds() {
        ObservableList<String> obList = FXCollections.observableArrayList();

        try {
            List<CustomerDto> idList = customerModel.getAllCustomer();

            for (CustomerDto dto : idList) {
                obList.add(dto.getCust_id());
            }

            cmbCustomerId.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void generateNextComplainId() {
        try {
            String complainId = ComplainModel.generateNextComplainId();
            lblComplainsid.setText(complainId);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }


    @FXML
    void btnDeleteComplainOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveComplainOnAction(ActionEvent event) {
        String id = lblComplainsid.getText();
        String custId = cmbCustomerId.getValue();
        String custName = lblCustName.getText();
        String complain = txtComplain.getText();




    }

    @FXML
    void btnUpdateComplainOnAction(ActionEvent event) {

    }

    @FXML
    void cmbCustomerIdOnAction(ActionEvent event) {
        String id = cmbCustomerId.getValue();

        try {
            CustomerDto customerDto = customerModel.searchCustomer(id);
            lblCustName.setText(customerDto.getCust_Name());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @FXML
    void txtSearchComplainOnAction(ActionEvent event) {

    }
}