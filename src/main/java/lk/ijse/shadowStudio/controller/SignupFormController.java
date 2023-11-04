package lk.ijse.shadowStudio.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class SignupFormController {
    @FXML
    private AnchorPane rootNode;

    @FXML
    private TextField txtPasswordSignUp;

    @FXML
    private TextField txtUserNameSignUp;

    public void btnLoginOmAction(ActionEvent actionEvent) throws IOException {
        System.out.println("Navigating to Login");
        Parent rootNode = FXMLLoader.load(getClass().getResource("/views/login_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setTitle("Login");
        stage.setScene(scene);


    }

    public void btnSignUpOnAction(ActionEvent actionEvent) throws IOException {
        System.out.println("Navigating to Login");
        Parent rootNode = FXMLLoader.load(getClass().getResource("/views/login_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setTitle("Login");
        stage.setScene(scene);

    }
}
