package com.example.students_information;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Objects;

public class UpdateStudentGrade {
    @FXML
    private Label engG;
    @FXML
    private Label mathG;
    @FXML
    private Label scG;

    @FXML
    private Label LName;
    @FXML
    private Button cancel;

    @FXML
    private TextField engF;

    @FXML
    private TextField engM;

    @FXML
    private TextField gradeTxtF;

    @FXML
    private TextField mathF;

    @FXML
    private TextField mathM;

    @FXML
    private TextField scienceF;

    @FXML
    private TextField scienceM;

    @FXML
    private Button searchStBt;

    @FXML
    private TextField searchStTxtF;

    @FXML
    private AnchorPane updateGradeScreen;

    @FXML
    private Button updateMarks;
    ArrayList<StudentInfo> infoList = new ArrayList<>();
    String name,id,age,cls,dob;
    public void searchSt(ActionEvent event) throws IOException {
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
            infoList.add(st);
        }
        br.close();
           ListIterator<StudentInfo> li = infoList.listIterator();
        for(StudentInfo s : infoList){
            String std = searchStTxtF.getText();
            if(Objects.equals(s.getStID(), std)){
                System.out.println("found "+ std);
                LName.setText(s.getStName());
//                name = s.getStName();
                id = s.getStID();
                age = s.getStAge();
                cls = s.getStClass();
                dob = s.getStDoB();
                mathM.setText(s.getStMathM());
                scienceM.setText(s.getStScienceM());
                engM.setText(s.getStEngM());
                mathF.setText(s.getStMathF());
                scienceF.setText(s.getStScienceF());
                engF.setText(s.getStEngF());
            }
        }
    }

    public void updateMarks(ActionEvent event) throws IOException {
        ListIterator<StudentInfo> li = infoList.listIterator();
        String str = searchStTxtF.getText();
        while(li.hasNext()) {
            StudentInfo si = (StudentInfo) li.next();
            if (Objects.equals(str, si.getStID())){
                li.set(new StudentInfo(LName.getText(),id,age,cls,dob,mathM.getText(),scienceM.getText(),engM.getText(),mathF.getText(),scienceF.getText(),engF.getText()));
            }
        }
        FileWriter fw = new FileWriter("E:\\Students_Information\\src\\main\\resources\\com\\example\\students_information\\StudentInfo.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        for (StudentInfo si : infoList) {
            bw.write(si.getStName() + " " + si.getStID() + " " + si.getStAge() + " " + si.getStClass() + " " + si.getStDoB()+" "+si.getStMathM()+" "+si.getStScienceM()+" "+si.getStEngM()+" "+si.getStMathF()+" "+si.getStScienceF()+" "+si.getStEngF());
            bw.newLine();
        }
        bw.close();
        double math1 = Double.parseDouble(mathM.getText());
        double math2 = Double.parseDouble(mathF.getText());
        double sc1 = Double.parseDouble(scienceM.getText());
        double sc2 = Double.parseDouble(scienceF.getText());
        double eng1 = Double.parseDouble(engM.getText());
        double eng2 = Double.parseDouble(engF.getText());
        double math,sc,eng,total;
        math= math1+math2;
        sc= sc1+sc2;
        eng= eng1+eng2;
        total = math+sc+eng;
        if(math>=80) mathG.setText("A");
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
        else engG.setText("F");

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Update Grade");
        alert.setHeaderText("Student's Grade Updated Successfully");
        alert.show();

    }

    public void cancel(ActionEvent event) {
        Stage stage = new Stage();
        stage=(Stage) updateGradeScreen.getScene().getWindow();
        stage.close();
    }

}
