package lk.ijse.shadowStudio.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.shadowStudio.dto.BookingDto;
import lk.ijse.shadowStudio.dto.CustomerDto;
import lk.ijse.shadowStudio.dto.PackageDto;
import lk.ijse.shadowStudio.dto.tm.BookingTm;
import lk.ijse.shadowStudio.model.BookingsModel;
import lk.ijse.shadowStudio.model.CustomerModel;
import lk.ijse.shadowStudio.model.PackagesModel;

import java.sql.SQLException;
import java.util.List;

public class BookingsFormController {


    @FXML
    private TableView<BookingTm> tblBookings;

    @FXML
    private DatePicker bookingDate;

    @FXML
    private JFXComboBox<String> cmbCustomerId;

    @FXML
    private JFXComboBox<String> cmbPackageId;

    @FXML
    private TableColumn<?, ?> colBookingId;

    @FXML
    private TableColumn<?, ?> colCustomerId;

    @FXML
    private TableColumn<?, ?> colCustomerName;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colLocation;

    @FXML
    private TableColumn<?, ?> colPackageId;

    @FXML
    private TableColumn<?, ?> colPackageName;

    @FXML
    private TableColumn<?, ?> colTime;

    @FXML
    private Label lblBookingId;

    @FXML
    private Label lblCustomerName;

    @FXML
    private AnchorPane rootHome;

    @FXML
    private TextArea txtCustomerIdea;

    @FXML
    private TextField txtLocation;

    @FXML
    private TextField txtTime;
    @FXML
    private Label lblPackageName;
    private final BookingsModel bookingsModel = new BookingsModel();
    private final PackagesModel packagesModel = new PackagesModel();
    private CustomerModel customerModel = new CustomerModel();

    public void initialize() {
        generateNextBookingId();
        loadCustomerIds();
        loadPackageIds();
        loadAllBookings();
        setCellValueFactory();

    }
    public void clearFields(){
        lblBookingId.setText("");
        //cmbCustomerId.setValue(null);
        lblCustomerName.setText("");
        //cmbPackageId.setValue(null);
        txtCustomerIdea.setText("");
        lblPackageName.setText("");
        bookingDate.setValue(null);
        txtTime.setText("");
        txtLocation.setText("");

    }

    private void generateNextBookingId() {
        try {
            String bookingId = BookingsModel.generateNextBookingId();
            lblBookingId.setText(bookingId);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

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

    private void loadPackageIds() {
        ObservableList<String> obList = FXCollections.observableArrayList();

        try {
            List<PackageDto> idList = packagesModel.getAllPackages();

            for (PackageDto dto : idList) {
                obList.add(dto.getPackage_id());
            }

            cmbPackageId.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnDeleteBookingOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveBookingOnAction(ActionEvent event) {
        String id = lblBookingId.getText();
        String custId = cmbCustomerId.getValue();
        String custName = lblCustomerName.getText();
        String packageId = cmbPackageId.getValue();
        String packageName = lblPackageName.getText();
        String date = String.valueOf(bookingDate.getValue());
        String time = txtTime.getText();
        String location = txtLocation.getText();
        String custIdea = txtCustomerIdea.getText();


        var dto = new BookingDto(
                id,
                custId,
                custName,
                packageId,
                packageName,
                date,
                time,
                location,
                custIdea
        );

        boolean isSaved = BookingsModel.saveBooking(dto);
        if (isSaved){
            new Alert(Alert.AlertType.CONFIRMATION,"Complain Added").show();
            clearFields();
            loadAllBookings();
            generateNextBookingId();

        }else {
            new Alert(Alert.AlertType.ERROR,"Error While Saving data");
        }
    }

    @FXML
    void btnUpdateBookingOnAction(ActionEvent event) {

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
    void cmbPackageIdOnAction(ActionEvent event) {
        String id = cmbPackageId.getValue();

        try {
            PackageDto packageDto = packagesModel.searchPackage(id);
            lblPackageName.setText(packageDto.getPackage_name());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    private void setCellValueFactory() {
        colBookingId.setCellValueFactory(new PropertyValueFactory<>("booking_id"));
        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("cust_id"));
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("cust_name"));
        colPackageId.setCellValueFactory(new PropertyValueFactory<>("package_id"));
        colPackageName.setCellValueFactory(new PropertyValueFactory<>("package_name"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        colLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
    }

    private void loadAllBookings() {
        var model = new BookingsModel();

        ObservableList<BookingTm> obList = FXCollections.observableArrayList();
        List<BookingDto> dtoList = model.getAllBookings();

        for (BookingDto dto : dtoList) {
            obList.add(
                    new BookingTm(
                            dto.getBooking_id(),
                            dto.getCust_id(),
                            dto.getCust_name(),
                            dto.getPackage_id(),
                            dto.getPackage_name(),
                            dto.getDate(),
                            dto.getTime(),
                            dto.getLocation(),
                            dto.getDescription()
                    )
            );
        }
        tblBookings.setItems(obList);

    }
    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
       generateNextBookingId();
    }
}
