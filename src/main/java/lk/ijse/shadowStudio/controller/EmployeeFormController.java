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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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

    @FXML
    void btnDeleteEmployeeOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveEmployeeOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateEmployeeOnAction(ActionEvent event) {

    }
}
