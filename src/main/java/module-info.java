module com.example.students_information {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.students_information to javafx.fxml;
    exports com.example.students_information;
}