package lk.ijse.shadowStudio.controller;

import com.jfoenix.controls.JFXButton;
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

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.ijse.shadowStudio.dto.CustomerDto;
import lk.ijse.shadowStudio.dto.EmployeeDto;
import lk.ijse.shadowStudio.model.CustomerModel;
import lk.ijse.shadowStudio.model.EmployeeModel;

public class EmployeeFormController{

    @FXML
    private TableColumn<?, ?> colEmployeeAddress;

    @FXML
    private TableColumn<?, ?> colEmployeeId;

    @FXML
    private TableColumn<?, ?> colEmployeeName;

    @FXML
    private TableColumn<?, ?> colEmployeeNic;

    @FXML
    private TableColumn<?, ?> colEmployeeTelephone;

    @FXML
    private Label lblEmployeeId;

    @FXML
    private AnchorPane rootHome;

    @FXML
    private TextField txtEmlployeeAddress;

    @FXML
    private TextField txtEmployeeName;

    @FXML
    private TextField txtEmployeeNic;

    @FXML
    private TextField txtEmployeeTp;

    private final EmployeeModel employeeModel = new EmployeeModel();

    private void clearFields() {
        txtEmployeeName.setText("");
        txtEmlployeeAddress.setText("");
        txtEmployeeNic.setText("");
        txtEmployeeTp.setText("");
    }

    @FXML
    void btnSaveEmployeeOnAction(ActionEvent event) {
        String empId = lblEmployeeId.getText();
        String empName = txtEmployeeName.getText();
        String empAddress = txtEmlployeeAddress.getText();
        String empNic = txtEmployeeNic.getText();
        String empTp = txtEmployeeTp.getText();

        EmployeeDto dto = new EmployeeDto(empId,empName,empAddress,empNic,empTp);

        try {
            boolean isSaved = EmployeeModel.saveEmployee(dto);
            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION,"Empoyee Saved").show();
                clearFields();
            }else {
                new Alert(Alert.AlertType.ERROR,"Error While Saving Data").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnDeleteEmployeeOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateEmployeeOnAction(ActionEvent event) {

    }
}
