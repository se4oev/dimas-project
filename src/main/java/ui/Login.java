package ui;

import db.DbConnector;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.sql.Connection;

/**
 * Created by karpenko on 15.12.2021.
 * Description:
 */
public class Login {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField loginField;
    @FXML
    private TextField pathField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button signInButton;
    @FXML
    private Button cancelButton;
    @FXML
    void initialize() {
        cancelButton.setOnAction(e -> System.exit(0));

        signInButton.setOnAction(e -> onSignIn());
    }

    private void onSignIn() {
        String login = loginField.getText();
        String password = passwordField.getText();

        DbConnector dbConnector = new DbConnector(login, password);
        boolean connectionSuccessfull = dbConnector.checkConnection();


        if (connectionSuccessfull) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Слава Украине!");
            alert.setContentText("Оно живое!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Печаль");
            alert.setContentText("Не удалось подключиться к БД");
            alert.showAndWait();
        }

    }

}
