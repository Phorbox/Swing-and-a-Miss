module application {
    requires javafx.fxml;
    requires javafx.controls;
    exports application;
    exports application.controller;
    opens application.controller;
}