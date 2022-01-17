import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ui.Login;

import java.io.File;
import java.io.IOException;

/**
 * Created by karpenko on 11.12.2021.
 * Description:
 */
public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        showLoginPane();

        showPatientTable(stage);

    }


    private void showLoginPane() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ui" + File.separator + "Login.fxml"));
            AnchorPane pane = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Авторизация");
            stage.initStyle(StageStyle.UNDECORATED);
            stage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(pane);
            stage.setScene(scene);

            Login loginController = loader.getController();
            loginController.setOnClose(() -> stage.close());
            stage.showAndWait();
        } catch (IOException e) {
            System.out.println("Can't load Login.fxml");
            throw new RuntimeException(e);
        }
    }

    private void showPatientTable(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ui" + File.separator + "PatientTable.fxml"));
            AnchorPane pane = loader.load();

            Scene scene = new Scene(pane);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println("Load failed");
            throw new RuntimeException(e);
        }
    }
}
