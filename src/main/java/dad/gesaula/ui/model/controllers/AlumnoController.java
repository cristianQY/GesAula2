package dad.gesaula.ui.model.controllers;

import dad.gesaula.ui.model.Alumno;
import javafx.beans.Observable;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AlumnoController implements Initializable {



    @FXML
    private ChoiceBox<?> SexBox;

    @FXML
    private DatePicker nacimientoDate;

    @FXML
    private TextField nameAlumnText;

    @FXML
    private CheckBox repiteCheck;

    @FXML
    private TextField surnameAlumnText;

    @FXML
    private GridPane alumnoRoot;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public GridPane getAlumnoRoot() {
        return alumnoRoot;
    }

    public void setAlumnoRoot(GridPane alumnoRoot) {
        this.alumnoRoot = alumnoRoot;
    }
}
