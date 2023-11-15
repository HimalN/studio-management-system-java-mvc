package lk.ijse.shadowStudio.controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.shadowStudio.db.DbConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginFormController {

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    private AnchorPane rootNode;


    @FXML
    void btnLoginOmAction(ActionEvent event) throws IOException, SQLException {
        System.out.println("navigating to signup");
        Parent rootNode = FXMLLoader.load(getClass().getResource("/views/main_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setTitle("Dashboard");
        stage.setScene(scene);
        stage.centerOnScreen();


    }

    @FXML
    void btnSignUpOnAction(ActionEvent event) throws IOException {
        System.out.println("navigating to signup");
        Parent rootNode = FXMLLoader.load(getClass().getResource("/views/signup_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setTitle("SignUp");
        stage.setScene(scene);
    }

}

