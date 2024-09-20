package lk.ijse.shadowStudio.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.shadowStudio.RegExPatterns.RegExPatterns;
import lk.ijse.shadowStudio.dto.SignUpDto;
import lk.ijse.shadowStudio.model.SignUpModel;

import java.io.IOException;
import java.sql.SQLException;


public class SignupFormController {
    @FXML
    private AnchorPane rootNode;

    @FXML
    private TextField txtPasswordSignUp;

    @FXML
    private TextField txtUserNameSignUp;

    @FXML
    private JFXButton btnSignUp;

    private SignUpModel userModel = new SignUpModel();

    public void initialize(){
        loadAllUser();
    }

    private void loadAllUser(){
        var model = new SignUpModel();
    }


    private void clearFields(){
        txtUserNameSignUp.setText("");
        txtPasswordSignUp.setText("");
    }

    public void btnLoginOmAction(ActionEvent actionEvent) throws IOException {
        System.out.println("Navigating to Login");
        Parent rootNode = FXMLLoader.load(getClass().getResource("/views/login_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setTitle("Login");
        stage.setScene(scene);


    }
    public void btnSignUpOnAction(ActionEvent actionEvent) throws IOException {
        String userName = txtUserNameSignUp.getText();
        String password = txtPasswordSignUp.getText();

        boolean isUserValid = RegExPatterns.getValidName().matcher(userName).matches();


        if (!isUserValid){
            new Alert(Alert.AlertType.ERROR,"User Name Invalid!!!").show();

        }

            var dto = new SignUpDto(userName, password);
            try {
                if (userName.isEmpty() || password.isEmpty()) {
                    new Alert(Alert.AlertType.ERROR, "One or more fields Empty").show();
                    return;
                }
                clearFields();
                boolean isSaved = userModel.saveUser(dto);
                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "New User Saved").show();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
                clearFields();
            }
    }

    @FXML
    void txtPasswordOnAction(ActionEvent event) {
        btnSignUp.requestFocus();
    }

    @FXML
    void txtUserNameOnAction(ActionEvent event) {
        txtPasswordSignUp.requestFocus();
    }


}
