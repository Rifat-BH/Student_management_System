package com.example.students_information;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Objects;

public class ViewBackGroundInfo {
    @FXML
    private Label LAge;

    @FXML
    private Label LClass;

    @FXML
    private Label LDOB;

    @FXML
    private Label LID;

    @FXML
    private Label LName;
    @FXML
    private Button cancel;

    @FXML
    private Button searchViewID;

    @FXML
    private AnchorPane viewBGScreen;

    @FXML
    private TextField viewStInfoTextF;

    ArrayList<StudentInfo> viewInfoAList = new ArrayList<>();
    public void viewInfo(ActionEvent event) throws IOException {
        FileReader fr = new FileReader("E:\\Students_Information\\src\\main\\resources\\com\\example\\students_information\\StudentInfo.txt");
        BufferedReader br = new BufferedReader(fr);
        String brrl;
        while( (brrl = br.readLine()) != null){
            String [] array = brrl.split(" ");
            String name, id, age,cls,dob,mM,sM,eM,mF,sF,eF;
            name = array[0];
            id  = array[1];
            age = array[2];
            cls = array[3];
            dob = array[4];
            mM = array[5];
            sM = array[6];
            eM = array[7];
            mF = array[8];
            sF = array[9];
            eF = array[10];
            StudentInfo st = new StudentInfo(name, id, age,cls,dob,mM,sM,eM,mF,sF,eF);
            viewInfoAList.add(st);
        }
        br.close();

        String str = viewStInfoTextF.getText();
        for (StudentInfo si : viewInfoAList) {
            if (Objects.equals(str, si.getStID())) {
                LName.setText(si.getStName());
                LID.setText(si.getStID());
                LAge.setText(si.getStAge());
                LClass.setText(si.getStClass());
                LDOB.setText(si.getStDoB());

            }
        }

    }
    public void cancel(ActionEvent event) {
        Stage stage = new Stage();
        stage=(Stage) viewBGScreen.getScene().getWindow();
        stage.close();
    }
}
