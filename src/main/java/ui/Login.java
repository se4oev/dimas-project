package ui;

import db.DbConnector;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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

    private Runnable onClose = () -> {};

    @FXML
    void initialize() {
        cancelButton.setOnAction(e -> onExit());

        signInButton.setOnAction(e -> onSignIn());

        pathField.setPromptText("localhost:5432/base_name");

//        rootPane.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent keyEvent) {
//                if (keyEvent.getCode() == KeyCode.ESCAPE)
//                    onExit();
//            }
//        }); АНОНИМНЫЙ КЛАСС

        rootPane.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ESCAPE)
                onExit();
        });
        // Лямбда

        rootPane.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode() == KeyCode.ENTER){
                    onSignIn();
                }
            }
        });
 //       rootPane.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {
  //          if (keyEvent.getCode() == KeyCode.ENTER){
  //              onSignIn();
  //          }
  //      }); ЛЯМБДА
    }

    private void onSignIn() {
        String login = loginField.getText();
        String password = passwordField.getText();
        String path = pathField.getText();

        DbConnector dbConnector = new DbConnector(path, login, password);
        boolean connectionSuccessfull = dbConnector.checkConnection();


        if (connectionSuccessfull) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Слава Украине!");
            alert.setContentText("Оно живое!");
            alert.showAndWait();
            onClose.run();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Печаль");
            alert.setContentText("Не удалось подключиться к БД");
            alert.showAndWait();
        }

    }

    public void setOnClose(Runnable onClose) {
        this.onClose = onClose;
    }

    class ExitHandler implements EventHandler<KeyEvent> {

        @Override
        public void handle(KeyEvent keyEvent) {
            if (keyEvent.getCode() == KeyCode.ESCAPE) {
                onExit();
            }
        }
        // Внутренный класс
    }

    private void onExit() {
        System.exit(0);
    }

    class LoginHandler implements EventHandler<KeyEvent>{
        @Override
        public void handle(KeyEvent keyEvent) {
            if (keyEvent.getCode() == KeyCode.ENTER){
                onSignIn();
            }
        }
    }
}
