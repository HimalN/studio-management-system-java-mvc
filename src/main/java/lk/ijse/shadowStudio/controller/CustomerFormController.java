package lk.ijse.shadowStudio.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.shadowStudio.dto.CustomerDto;
import lk.ijse.shadowStudio.dto.tm.CustomerTm;
import lk.ijse.shadowStudio.model.CustomerModel;

import java.sql.SQLException;
import java.util.List;

public class CustomerFormController {

    @FXML
    private TableColumn<?, ?> colCustAddress;

    @FXML
    private TableColumn<?, ?> colCustId;

    @FXML
    private TableColumn<?, ?> colCustName;

    @FXML
    private TableColumn<?, ?> colCustNic;

    @FXML
    private TableColumn<?, ?> colCustTelephone;

    @FXML
    private Label lblcustId;

    @FXML
    private AnchorPane rootHome;

    @FXML
    private TableView<CustomerTm> tblCustomer;

    @FXML
    private TextField txtCustomerAddress;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private TextField txtCustomerNic;

    @FXML
    private TextField txtCustomerTp;

    @FXML
    private TextField txtCustomerSearch;

    private final CustomerModel customerModel = new CustomerModel();

    public void initialize() {
        generateNextCustomerId();
        setCellValueFactory();
        loadAllCustomer();
    }

    private void setCellValueFactory() {
        colCustId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colCustName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        colCustAddress.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
        colCustNic.setCellValueFactory(new PropertyValueFactory<>("customerNic"));
        colCustTelephone.setCellValueFactory(new PropertyValueFactory<>("customerTp"));
    }


    private void loadAllCustomer() {
        var model = new CustomerModel();

        ObservableList<CustomerTm> obList = FXCollections.observableArrayList();
        try{
            List<CustomerDto> dtoList = model.getAllCustomer();

            for (CustomerDto dto : dtoList) {
                obList.add(
                        new CustomerTm(
                                dto.getCust_id(),
                                dto.getCust_Name(),
                                dto.getCust_address(),
                                dto.getCust_nic(),
                                dto.getCust_tp()
                        )
                );
            }
            tblCustomer.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private void clearFields() {
        txtCustomerName.setText("");
        txtCustomerAddress.setText("");
        txtCustomerNic.setText("");
        txtCustomerTp.setText("");
    }

    @FXML
    void btnSaveCustomerOnAction(ActionEvent event) {
        String custId = lblcustId.getText();
        String custName = txtCustomerName.getText();
        String custAddress = txtCustomerAddress.getText();
        String custNic = txtCustomerNic.getText();
        String custTp = txtCustomerTp.getText();

        var dto = new CustomerDto(custId, custName, custAddress, custNic, custTp);

        try {
            boolean isSaved = CustomerModel.saveCustomer(dto);
            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION,"Customer Savd").show();
                clearFields();
            }else {
                new Alert(Alert.AlertType.ERROR,"Error While Saving Data").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
        initialize();

    }
    private void generateNextCustomerId() {
        try {
            String custId = CustomerModel.generateNextCustomerId();
            lblcustId.setText(custId);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
    @FXML
    void btnUpdateCustomerOnAction(ActionEvent event) {
        String id = lblcustId.getText();
        String name = txtCustomerName.getText();
        String address = txtCustomerAddress.getText();
        String mobile = txtCustomerNic.getText();
        String tp = txtCustomerTp.getText();

        var dto  = new CustomerDto(id, name, address, mobile,tp);

        try {
            boolean isUpdated = customerModel.updateCustomer(dto);
            if(isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Customer details updated").show();;
                clearFields();
                loadAllCustomer();
            } else {
                new Alert(Alert.AlertType.ERROR, "Customer details not updated").show();;
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            clearFields();
        }
    }
    @FXML
    void btnDeleteCustomerOnAction(ActionEvent event) throws SQLException {
        String id  = txtCustomerSearch.getText();

        try {
            boolean isDeleted = CustomerModel.deleteCustomer(id);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Customer Deleted").show();
                clearFields();
                loadAllCustomer();
            } else {
                new Alert(Alert.AlertType.ERROR, "Customer Not Deleted").show();
            }
        }catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
        generateNextCustomerId();


    }

    @FXML
    void txtCustomerSearchOnAction(ActionEvent event) {



    }

}