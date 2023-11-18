package lk.ijse.shadowStudio.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import com.jfoenix.controls.JFXComboBox;
import lk.ijse.shadowStudio.model.RentItemModel;

public class RentItemFormController{

    @FXML
    private TableColumn<?, ?> colItemId;

    @FXML
    private TableColumn<?, ?> colItemPrice;

    @FXML
    private TableColumn<?, ?> colItemType;

    @FXML
    private TableColumn<?, ?> colRentalPrice;

    @FXML
    private JFXComboBox<?> comItemType;

    @FXML
    private Label lblItemId;

    @FXML
    private TextField txtItemName;

    @FXML
    private TextField txtRentalPrice;

    @FXML
    void btnDeleteItemOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveItemOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateItemOnAction(ActionEvent event) {

    }

    @FXML
    void comItemTypeOnAction(ActionEvent event) {

    }



}
