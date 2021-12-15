package ui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Молодец");
        alert.setContentText("Возьми пирожок с полки");
        alert.showAndWait();
    }

}
