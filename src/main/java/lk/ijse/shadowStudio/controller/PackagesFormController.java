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

public class PackagesFormController{
    @FXML
    private TableColumn<?, ?> colPackageDescription;

    @FXML
    private TableColumn<?, ?> colPackageId;

    @FXML
    private TableColumn<?, ?> colPackageName;

    @FXML
    private TableColumn<?, ?> colPackagePrice;

    @FXML
    private TableColumn<?, ?> colPackageType;

    @FXML
    private ComboBox<?> comboPackageType;

    @FXML
    private Label lblPackageId;

    @FXML
    private AnchorPane rootHome;

    @FXML
    private TextArea txtAboutPackage;

    @FXML
    private TextField txtPackageName;

    @FXML
    private TextField txtPackagePrice;

    @FXML
    void btnDeletePackageOnAction(ActionEvent event) {

    }

    @FXML
    void btnSavePackageOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdatePackageOnAction(ActionEvent event) {

    }

    @FXML
    void comPackageTypeOnAction(ActionEvent event) {

    }
}