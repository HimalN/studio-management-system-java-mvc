package lk.ijse.shadowStudio.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
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

    public void initialize(){

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
        String name = txtUserNameSignUp.getText();
        String password = txtPasswordSignUp.getText();
        var dto = new SignUpDto(name,password);

        try {
            boolean isSaved = SignUpModel.saveUser(dto);
            if(isSaved){
                new Alert(Alert.AlertType.CONFIRMATION,"User Saved SuccessFully");
                clearFields();
                Parent rootNode = FXMLLoader.load(getClass().getResource("/views/login_form.fxml"));
                Scene scene = new Scene(rootNode);
                Stage stage = (Stage) this.rootNode.getScene().getWindow();
                stage.setTitle("Login");
                stage.setScene(scene);

            }
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }



    }


}
