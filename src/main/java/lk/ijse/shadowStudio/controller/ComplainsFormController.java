package lk.ijse.shadowStudio.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ComplainsFormController {
    @FXML
    private JFXComboBox<?> cmbCustomerId;

    @FXML
    private TableColumn<?, ?> colComplainId;

    @FXML
    private TableColumn<?, ?> colCustomerId;

    @FXML
    private TableColumn<?, ?> colCustomerName;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colTelephone;

    @FXML
    private Label lblComplainsid;

    @FXML
    private Label lblCustName;

    @FXML
    private TextArea txtComplain;

    @FXML
    void btnDeleteComplainOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveComplainOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateComplainOnAction(ActionEvent event) {

    }

    @FXML
    void cmbCustomerIdOnAction(ActionEvent event) {

    }
}
