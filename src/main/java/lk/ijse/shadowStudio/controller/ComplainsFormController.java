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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ComplainsFormController {
    @FXML
    private ComboBox<?> cmbComplainStatus;

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
    private Label lblDate;

    @FXML
    private Label lblTime;

    @FXML
    private AnchorPane rootHome;

    @FXML
    private TextField txtComplainId;

    @FXML
    private TextField txtCustomerId;

    @FXML
    private TextArea txtDescription;

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
    void cmbComplainStatusOnAction(ActionEvent event) {

    }
}
