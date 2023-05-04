package com.example.students_information;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class UpdateInformation {

    @FXML
    private AnchorPane UpdateInfoScreen;
    @FXML
    private Button UpdateStGrade;

    @FXML
    private Button UpdateStInfo;

    @FXML
    private Button cancel;

    Parent root;
    Stage stage = new Stage();

    public void UpdateStInfo(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("UpdateStudentInfo.fxml"));
        root = fxmlLoader.load();
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("logo.png")));
        stage.getIcons().add(icon);
        stage.setTitle("Update Information");
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void UpdateStGrade(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("UpdateStudentGrade.fxml"));
        root = fxmlLoader.load();
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("logo.png")));
        stage.getIcons().add(icon);
        stage.setTitle("Update Grade");
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void cancel(ActionEvent event){
        Stage stage = new Stage();
        stage=(Stage) UpdateInfoScreen.getScene().getWindow();
        stage.close();
    }
}
