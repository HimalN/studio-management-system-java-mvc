package lk.ijse.shadowStudio.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.shadowStudio.dto.ItemDto;
import lk.ijse.shadowStudio.dto.tm.ItemTm;
import lk.ijse.shadowStudio.model.RentItemModel;

import java.sql.SQLException;
import java.util.List;

public class RentItemFormController{

    @FXML
    private TableColumn<?, ?> colItemId;

    @FXML
    private TableColumn<?, ?> colItemName;

    @FXML
    private TableColumn<?, ?> colItemType;

    @FXML
    private TableColumn<?, ?> colRentalPrice;


    @FXML
    private TextField txtItemType;

    @FXML
    private Label lblItemId;

    @FXML
    private TextField txtItemName;

    @FXML
    private TextField txtRentalPrice;

    @FXML
    private TableView<ItemTm> tblItem;

    private final RentItemModel rentItemModel = new RentItemModel();

    public void initialize() throws SQLException {
        generateNextItemId();
        loadAllItem();
        setCellValueFactory();

    }
    private void generateNextItemId() throws SQLException {
        String itemId =RentItemModel.generateNextItemId();
        lblItemId.setText(itemId);
    }
    public void clearFields(){
        txtItemName.setText("");
        txtItemType.setText("");
        txtRentalPrice.setText("");
    }

    @FXML
    void btnDeleteItemOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveItemOnAction(ActionEvent event) throws SQLException {
        String itemId = lblItemId.getText();
        String itemName = txtItemName.getText();
        String itemType = txtItemType.getText();
        String itemPrice = txtRentalPrice.getText();

        ItemDto dto = new ItemDto(itemId,itemName,itemType,itemPrice);

        try {
            boolean isSaved = RentItemModel.saveItem(dto);
            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION,"Item Saved").show();
                clearFields();
            }else {
                new Alert(Alert.AlertType.ERROR,"Error While Saving Data").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
        initialize();
    }
    private void setCellValueFactory() {
        colItemId.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        colItemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        colItemType.setCellValueFactory(new PropertyValueFactory<>("itemType"));
        colRentalPrice.setCellValueFactory(new PropertyValueFactory<>("rentalPrice"));
    }


    private void loadAllItem() {
        var model = new RentItemModel();

        ObservableList<ItemTm> obList = FXCollections.observableArrayList();
        try{
            List<ItemDto> dtoList = model.getAllItem();

            for (ItemDto dto : dtoList) {
                obList.add(
                        new ItemTm(
                                dto.getItemId(),
                                dto.getItemName(),
                                dto.getItemType(),
                                dto.getRentalPrice()
                        )
                );
            }
            tblItem.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnUpdateItemOnAction(ActionEvent event) {

    }

}
