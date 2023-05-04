package com.example.students_information;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloController {
    @FXML
    private Button AddStudentBt;

    @FXML
    private Button UpdateInfoBt;

    @FXML
    private Button ViewInfoBt;
    @FXML
    private Button cancel;

    @FXML
    private AnchorPane mainScreen;

    Parent root;
    Stage stage = new Stage();
    public void AddStudentBt(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AddStudent.fxml"));
        root = fxmlLoader.load();
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("logo.png")));
        stage.getIcons().add(icon);
        stage.setTitle("Add Student");
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void UpdateInfoBt(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("UpdateInformation.fxml"));
        root = fxmlLoader.load();
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("logo.png")));
        stage.getIcons().add(icon);
        stage.setTitle("Update Information");
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void ViewInfoBt(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ViewInformation.fxml"));
        root = fxmlLoader.load();
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("logo.png")));
        stage.getIcons().add(icon);
        stage.setTitle("View Information");
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void cancel(ActionEvent event) {
        Stage stage = new Stage();
        stage=(Stage) mainScreen.getScene().getWindow();
        stage.close();
    }

}