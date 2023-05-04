package com.example.students_information;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Objects;

public class UpdateStudentInfo {
    @FXML
    private AnchorPane UpdateInfoScreen;

    @FXML
    private Button cancel;

    @FXML
    private TextField editAge;

    @FXML
    private TextField editClass;

    @FXML
    private TextField editDoB;

    @FXML
    private TextField editID;

    @FXML
    private TextField editName;

    @FXML
    private Button saveUpdateInfo;

    @FXML
    private TextField searchSt;

    @FXML
    private Button searchStBt;

    ArrayList<StudentInfo> infoList = new ArrayList<>();
//    ListIterator li = null;
    public void searchStBt (ActionEvent event){
        try{
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
//            li = infoList.listIterator();
            for(StudentInfo s : infoList){
                String std = searchSt.getText();
                if(Objects.equals(s.getStID(), std)){
                    System.out.println("found "+ std);
                    editName.setText(s.getStName());
                    editID.setText(s.getStID());
                    editAge.setText(s.getStAge());
                    editClass.setText(s.getStClass());
                    editDoB.setText(s.getStDoB());
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void SaveUpdateInfo(ActionEvent event) throws IOException {
//        String mM = null;
//        String sM = null;
//        String eM = null;
//        String mF = null;
//        String sF = null;
//        String eF = null;

//        String name, id, age, cls, dob;
//        name= editName.getText();
//        id= editID.getText();
//        age=editAge.getText();
//        cls= editClass.getText();
//        dob=editDoB.getText();
        ListIterator<StudentInfo> li = infoList.listIterator();
        String str = searchSt.getText();
        while(li.hasNext()) {
            StudentInfo si = (StudentInfo) li.next();
            if (Objects.equals(str, si.getStID())){
                li.set(new StudentInfo(editName.getText(), editID.getText(), editAge.getText(), editClass.getText(), editDoB.getText(), null, null, null, null, null, null));
        }
    }
        FileWriter fw = new FileWriter("E:\\Students_Information\\src\\main\\resources\\com\\example\\students_information\\StudentInfo.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        for (StudentInfo si : infoList) {
            bw.write(si.getStName() + " " + si.getStID() + " " + si.getStAge() + " " + si.getStClass() + " " + si.getStDoB()+" "+si.getStMathM()+" "+si.getStScienceM()+" "+si.getStEngM()+" "+si.getStMathF()+" "+si.getStScienceF()+" "+si.getStEngF());
            bw.newLine();
        }
        bw.close();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Update Information");
        alert.setHeaderText("Student's Information Updated Successfully");

//            alert.setContentText("Student's Information added Successfully");
        alert.show();
    }

    public void cancel(ActionEvent event) {
        Stage stage = new Stage();
        stage=(Stage) UpdateInfoScreen.getScene().getWindow();
        stage.close();
    }
}
