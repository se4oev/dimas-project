package ui;

import entity.Patient;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * Created by karpenko on 17.01.2022
 * Description:
 */
public class PatientTable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField searchField;
    @FXML
    private TableView<Patient> patientTable;
    @FXML
    private TableColumn<Patient, String> cardNumberColumn;
    @FXML
    private TableColumn<Patient, String> snilsColumn;
    @FXML
    private TableColumn<Patient, String> sexColumn;
    @FXML
    private TableColumn<Patient, String> fullnameColumn;
    @FXML
    private TableColumn<Patient, String> birthdayColumn;
    @FXML
    private TableColumn<Patient, String> ageColumn;
    @FXML
    private TableColumn<Patient, String> policyColumn;
    @FXML
    private TableColumn<Patient, Integer> finSourceColumn;

    @FXML
    public void initialize() {
        patientTable.setPlaceholder(new Label("Пока здеся ничего нет"));
    }

}
