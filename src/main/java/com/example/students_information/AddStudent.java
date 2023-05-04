package com.example.students_information;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AddStudent {
    @FXML
    private AnchorPane AddStScene;
    @FXML
    private TextField StAge;

    @FXML
    private TextField StClass;

    @FXML
    private TextField StDoB;

    @FXML
    private TextField StID;

    @FXML
    private TextField StName;

    @FXML
    private Button cancel;

    @FXML
    private Button saveInfo;

    ArrayList<StudentInfo> StudentList = new ArrayList<StudentInfo>();
    String mM = null;
    String sM = null;
    String eM = null;
    String mF = null;
    String sF = null;
    String eF = null;
    public void saveInfo(ActionEvent event){
//        String stName = StName.getText();
//        String stID = StID.getText();
//        String stAge =StAge.getText();
//        String stClass = StClass.getText();
//        String stDoB =StDoB.getText();
//        System.out.println("saved");


        try {
            // FileWriter fw = new FileWriter(String.valueOf(getClass().getClassLoader().getResourceAsStream("StudentInfo.txt")));
            FileWriter fw = new FileWriter("E:\\Students_Information\\src\\main\\resources\\com\\example\\students_information\\StudentInfo.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            StudentList.add(new StudentInfo(StName.getText(),StID.getText(),StAge.getText(),StClass.getText(),StDoB.getText(),mM,sM,eM,mF,sF,eF));
            for(StudentInfo si : StudentList){
                bw.write(si.getStName()+" "+si.getStID()+" "+si.getStAge()+" "+si.getStClass()+" "+si.getStDoB()+" "+si.getStMathM()+" "+si.getStScienceM()+" "+si.getStEngM()+" "+si.getStMathF()+" "+si.getStScienceF()+" "+si.getStEngF());
//                bw.write("Name : " + studentInfo.getStName() + "\n");
//                bw.write("ID   : " + studentInfo.getStID() + "\n");
//                bw.write("Age  : " + studentInfo.getStAge() + "\n");
//                bw.write("Class: " + studentInfo.getStClass() + "\n");
//                bw.write("DoB  : " + studentInfo.getStDoB() + "\n");
                bw.newLine();
            }

            bw.close();
            fw.close();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Add New Student");
            alert.setHeaderText("Student's Information added Successfully");

//            alert.setContentText("Student's Information added Successfully");
            alert.show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void cancel(ActionEvent event) {
        Stage stage = new Stage();
        stage=(Stage) AddStScene.getScene().getWindow();
        stage.close();
    }

}
