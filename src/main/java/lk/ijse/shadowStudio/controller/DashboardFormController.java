package lk.ijse.shadowStudio.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DashboardFormController {

    @FXML
    private Label lblDamages;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblElephantCount1;

    @FXML
    private Label lblElephantDeaths;

    @FXML
    private Label lblHumanDeaths;

    @FXML
    private Label lblHumanDeaths1;

    @FXML
    private Label lblHumanDeaths2;

    @FXML
    private Label lblTime;

    @FXML
    private Label lblwelcomeName;

    @FXML
    private AnchorPane rootHome;

    @FXML
    private Label txtDate;

    @FXML
    private Label txtTime;

    public void initialize(){
        setTime();
    }

    private void setTime() {
        Platform.runLater(() -> {
            lblDate.setText(String.valueOf(LocalDate.now()));

            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1), event -> {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
                String timeNow = LocalTime.now().format(formatter);
                lblTime.setText(timeNow);
            }));
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
        });
    }


}
