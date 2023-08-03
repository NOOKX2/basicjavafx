package ku.cs.lab02javafx;

import ku.cs.services.FXRouter;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXRouter.bind(this, stage, "", 800, 600);
        configRoute();
        // FXRouter.goTo("hello");
        FXRouter.goTo("hello");
    }

    public static void configRoute()
    {
        String viewPath = "ku/cs/views/";
        FXRouter.when("hello", viewPath + "hello-view.fxml");
        FXRouter.when("student", viewPath + "student.fxml");
        FXRouter.when("student-list", viewPath + "student-list.fxml");
        FXRouter.when("game",viewPath +"game.fxml");
        FXRouter.when("game-list", viewPath + "game-list.fxml");
        FXRouter.when("students-table", viewPath + "students-table.fxml");
    }

    public static void main(String[] args) {
        launch();
    }
}