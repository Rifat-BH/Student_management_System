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

public class ViewInformation {

    @FXML
    private Button cancel;

    @FXML
    private Button viewGrade;

    @FXML
    private Button viewInfo;

    @FXML
    private AnchorPane viewInfoScreen;

    Parent root;
    Stage stage = new Stage();
    public void viewInfo(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ViewBackGroundInfo.fxml"));
        root = fxmlLoader.load();
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("logo.png")));
        stage.getIcons().add(icon);
        stage.setTitle("Student's Information");
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void viewGrade(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ViewGrade.fxml"));
        root = fxmlLoader.load();
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("logo.png")));
        stage.getIcons().add(icon);
        stage.setTitle("Student's Grade");
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void cancel(ActionEvent event){
        Stage stage = new Stage();
        stage=(Stage) viewInfoScreen.getScene().getWindow();
        stage.close();
    }
}
