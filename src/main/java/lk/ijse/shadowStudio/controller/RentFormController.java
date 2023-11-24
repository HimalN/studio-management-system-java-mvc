package lk.ijse.shadowStudio.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;
import java.util.List;

import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.shadowStudio.RegExPatterns.RegExPatterns;
import lk.ijse.shadowStudio.dto.CustomerDto;
import lk.ijse.shadowStudio.dto.ItemDto;
import lk.ijse.shadowStudio.dto.PackageDto;
import lk.ijse.shadowStudio.dto.RentDto;
import lk.ijse.shadowStudio.dto.tm.RentTm;
import lk.ijse.shadowStudio.model.CustomerModel;
import lk.ijse.shadowStudio.model.PackagesModel;
import lk.ijse.shadowStudio.model.RentItemModel;
import lk.ijse.shadowStudio.model.RentModel;

public class RentFormController{


    @FXML
    private ComboBox<String> cmbCustomerId;

    @FXML
    private ComboBox<String> cmbItemId;


    @FXML
    private TableColumn<?, ?> colBroughtDate;

    @FXML
    private TableColumn<?, ?> colCustomerId;

    @FXML
    private TableColumn<?, ?> colCustomerName;

    @FXML
    private TableColumn<?, ?> colDayCount;

    @FXML
    private TableColumn<?, ?> colItemId;

    @FXML
    private TableColumn<?, ?> colItemName;

    @FXML
    private TableColumn<?, ?> colRentId;

    @FXML
    private TableView<RentTm> tblRent;

    @FXML
    private Label lblCustomerName;

    @FXML
    private Label lblItemName;

    @FXML
    private Label lblRentID;

    @FXML
    private TextField txtDayCount;

    @FXML
    private DatePicker broughtDate;

    private final RentModel rentModel = new RentModel();

    private CustomerModel customerModel = new CustomerModel();
    private RentItemModel rentItemModel = new RentItemModel();

    public void initialize() {
        generateNextRentId();
        loadCustomerIds();
        loadItemIds();
        loadAllRents();
        setCellValueFactory();


    }

    private void generateNextRentId() {
        try {
            String RentId = RentModel.generateNextRentId();
            lblRentID.setText(RentId);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnDeleteRentOnAction(ActionEvent event) throws SQLException {
        String id = lblRentID.getText();
        boolean isDeleted = rentModel.deleteRent(id);
        if (isDeleted) {
            new Alert(Alert.AlertType.CONFIRMATION, "Rent Information Deleted").show();
            loadAllRents();
            generateNextRentId();

        } else {
            new Alert(Alert.AlertType.INFORMATION, "Can not delete customer").show();

        }
    }

    @FXML
    void btnSaveRentOnAction(ActionEvent event) throws SQLException {
        String id = lblRentID.getText();
        String custId = cmbCustomerId.getValue();
        String custName = lblCustomerName.getText();
        String itemId = cmbItemId.getValue();
        String itemName = lblItemName.getText();
        String dayCount = txtDayCount.getText();
        String broughtdate = String.valueOf(broughtDate.getValue());

        boolean isValidDayCount = RegExPatterns.getValidDayCount().matcher(dayCount).matches();

        if (!isValidDayCount){
            new Alert(Alert.AlertType.ERROR,"Invalid Day Count");
        }else {
            var dto = new RentDto(id, custId, custName, itemId,itemName,dayCount,broughtdate);

            boolean isSaved = RentModel.saveRent(dto);
            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION,"Rent Details Added").show();
                loadAllRents();
                generateNextRentId();

            }else {
                new Alert(Alert.AlertType.ERROR,"Error While Saving data");
            }
        }
    }

    @FXML
    void btnUpdateRentrOnAction(ActionEvent event) {
/*        String id = lblPackageId.getText();
        String name = txtPackageName.getText();
        String type = txtPackageType.getText();
        String description = txtAboutPackage.getText();
        String price  = txtPackagePrice.getText();

            var dto = new PackageDto(id, name, type, description, price);
            try {
                boolean isUpdated = PackagesModel.updateCustomer(dto);
                if (isUpdated) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Package is Updated").show();
                    clearFields();
                    generateNextPackageId();
                    loadAllPackages();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Package is Not Updated").show();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        */
    }

    @FXML
    void cmbCustomerIdOnAction(ActionEvent event) {
        String id = cmbCustomerId.getValue();

        try {
            CustomerDto customerDto = customerModel.searchCustomer(id);
            lblCustomerName.setText(customerDto.getCust_Name());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void cmbItemIdOnAction(ActionEvent event) {
        String id = cmbItemId.getValue();

        try {
            ItemDto itemDto = rentItemModel.searchItem(id);
            lblItemName.setText(itemDto.getItemName());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void dateOnAction(ActionEvent event){

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
    private void loadItemIds() {
        ObservableList<String> obList = FXCollections.observableArrayList();

        try {
            List<ItemDto> idList = rentItemModel.getAllItem();

            for (ItemDto dto : idList) {
                obList.add(dto.getItemId());
            }

            cmbItemId.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
        colRentId.setCellValueFactory(new PropertyValueFactory<>("rent_id"));
        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("cust_id"));
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("cust_name"));
        colItemId.setCellValueFactory(new PropertyValueFactory<>("item_id"));
        colItemName.setCellValueFactory(new PropertyValueFactory<>("item_name"));
        colDayCount.setCellValueFactory(new PropertyValueFactory<>("day_count"));
        colBroughtDate.setCellValueFactory(new PropertyValueFactory<>("date"));
    }
    private void loadAllRents() {
        var model = new RentModel();

        ObservableList<RentTm> obList = FXCollections.observableArrayList();
        try {
            List<RentDto> dtoList = model.getAllRent();

            for (RentDto dto : dtoList) {
                obList.add(
                        new RentTm(
                                dto.getRentId(),
                                dto.getCustId(),
                                dto.getCustName(),
                                dto.getItemId(),
                                dto.getItemName(),
                                dto.getDaycount(),
                                dto.getDate()

                        )
                );
            }
            tblRent.setItems(obList);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }
}
