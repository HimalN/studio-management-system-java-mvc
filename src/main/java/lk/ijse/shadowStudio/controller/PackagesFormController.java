package lk.ijse.shadowStudio.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.sql.SQLException;
import java.util.List;

import javafx.scene.control.Label;
import lk.ijse.shadowStudio.dto.PackageDto;
import lk.ijse.shadowStudio.dto.tm.CustomerTm;
import lk.ijse.shadowStudio.dto.tm.PackageTm;
import lk.ijse.shadowStudio.model.PackagesModel;

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
    private TextField txtPackageType;

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
    private TableView<PackageTm> tblPackages;

    private final PackagesModel packagesModel = new PackagesModel();

    public void initialize(){
        generateNextPackageId();
        loadAllPackages();
        setCellValueFactory();

    }
    private void clearFields(){
        lblPackageId.setText("");
        txtPackageName.setText("");
        txtAboutPackage.setText("");
        txtPackagePrice.setText("");

    }
    private void generateNextPackageId(){

        try {
            String packageId  = PackagesModel.generateNextPackageId();
            lblPackageId.setText(packageId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnDeletePackageOnAction(ActionEvent event) {

    }

    @FXML
    void btnSavePackageOnAction(ActionEvent event) {
        String packageId = lblPackageId.getText();
        String packageName = txtPackageName.getText();
        String packageType = txtPackageType.getText();
        String packageAbout = txtAboutPackage.getText();
        String packagePrice = txtPackagePrice.getText();

        var dto = new PackageDto(packageId,packageName,packageType,packageAbout,packagePrice);

        try {
            boolean isSaved = PackagesModel.savePackage(dto);
            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION,"Package Saved").show();
                generateNextPackageId();
                loadAllPackages();
                setCellValueFactory();

            }else {
                new Alert(Alert.AlertType.ERROR,"Error while Saving data").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    private void setCellValueFactory() {
        colPackageId.setCellValueFactory(new PropertyValueFactory<>("package_id"));
        colPackageName.setCellValueFactory(new PropertyValueFactory<>("package_name"));
        colPackageType.setCellValueFactory(new PropertyValueFactory<>("package_type"));
        colPackageDescription.setCellValueFactory(new PropertyValueFactory<>("package_description"));
        colPackagePrice.setCellValueFactory(new PropertyValueFactory<>("package_price"));
    }
    private void loadAllPackages() {
        var model = new PackagesModel();

        ObservableList<PackageTm> obList = FXCollections.observableArrayList();
        try {
            List<PackageDto> dtoList = model.getAllPackages();

            for (PackageDto dto : dtoList) {
                obList.add(
                        new PackageTm(
                                dto.getPackage_id(),
                                dto.getPackage_name(),
                                dto.getPackage_type(),
                                dto.getPackage_description(),
                                dto.getPackage_price()
                        )
                );
            }
            tblPackages.setItems(obList);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnUpdatePackageOnAction(ActionEvent event) {

    }

    @FXML
    void comPackageTypeOnAction(ActionEvent event) {

    }
}