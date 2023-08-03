module ku.cs {
    requires javafx.controls;
    requires javafx.fxml;


    opens ku.cs.lab02javafx to javafx.fxml;
    exports ku.cs.lab02javafx;
    exports ku.cs.controllers;
    opens ku.cs.controllers to javafx.fxml;
}