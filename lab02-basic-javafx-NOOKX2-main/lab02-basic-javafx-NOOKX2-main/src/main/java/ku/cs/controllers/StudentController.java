package ku.cs.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import ku.cs.models.Student;
import ku.cs.services.FXRouter;

import java.io.IOException;

public class StudentController {
    @FXML
    Label nameLabel;
    @FXML
    Label idLabel;
    @FXML
    Label nicknameLabel;
    @FXML
    public void initialize() {
        Student student = new Student("6510405571", "Thatchavit Thaveechaiyagarn", "Nook");
        showStudent(student);
    }

    private void showStudent(Student student) {
        nameLabel.setText(student.getName());
        idLabel.setText(student.getId());
        nicknameLabel.setText(student.getNickname());
    }

    @FXML protected void onHandleButtonClick (){
        try {
            FXRouter.goTo("game");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}