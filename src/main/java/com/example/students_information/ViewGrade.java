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

public class ViewGrade {
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
    @FXML
    private Label engG;

    @FXML
    private Label mathG;

    @FXML
    private Label scG;

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
                double math1 = Double.parseDouble(si.getStMathM());
                double math2 = Double.parseDouble(si.getStMathF());
                double sc1 = Double.parseDouble(si.getStScienceM());
                double sc2 = Double.parseDouble(si.getStScienceF());
                double eng1 = Double.parseDouble(si.getStEngM());
                double eng2 = Double.parseDouble(si.getStEngF());
                double math,sc,eng,total;
                math= math1+math2;
                sc= sc1+sc2;
                eng= eng1+eng2;
                total = math+sc+eng;
                LName.setText(si.getStName());
                LID.setText(String.valueOf(math));
                LAge.setText(String.valueOf(sc));
                LClass.setText(String.valueOf(eng));
                if(math>= 80) mathG.setText("A");
                else if(math>=60) mathG.setText("B");
                else if(math>=50) mathG.setText("C");
                else if(math>=40) mathG.setText("D");
                else mathG.setText("F");

                if(sc>=80) scG.setText("A");
                else if(sc>=60) scG.setText("B");
                else if(sc>=50) scG.setText("C");
                else if(sc>=40) scG.setText("D");
                else scG.setText("F");

                if(eng>=80) engG.setText("A");
                else if(eng>=60) engG.setText("B");
                else if(eng>=50) engG.setText("C");
                else if(eng>=40) engG.setText("D");

            }
        }

    }
    public void cancel(ActionEvent event) {
        Stage stage = new Stage();
        stage=(Stage) viewBGScreen.getScene().getWindow();
        stage.close();
    }
}
