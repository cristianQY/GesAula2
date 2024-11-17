package dad.gesaula.ui.model.controllers;

import dad.gesaula.ui.model.Alumno;
import dad.gesaula.ui.model.Sexo;
import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AlumnoController implements Initializable {

    private final ObjectProperty<Alumno> alumno = new SimpleObjectProperty<>();

    @FXML
    private ChoiceBox<Sexo> SexBox;  // Cambiar el tipo de ChoiceBox a String

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

    public AlumnoController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/alumnoView.fxml"));
            loader.setController(this);
            loader.load();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SexBox.getItems().addAll(Sexo.values());  // Agregar todos los valores del enum Sexo

        // Establecer un valor por defecto si es necesario
        SexBox.setValue(Sexo.HOMBRE);

        // Enlazar el estado del CheckBox con un valor booleano (true o false)
        repiteCheck.setSelected(false);  // Valor por defecto para "repite"

        alumno.addListener(this::onAlumnoChanged);
    }

    private void onAlumnoChanged(ObservableValue<? extends Alumno> o, Alumno ov, Alumno nv) {

        if (ov != null) {

            // Desvincular las propiedades anteriores
            nameAlumnText.textProperty().unbindBidirectional(ov.nombreProperty());
            surnameAlumnText.textProperty().unbindBidirectional(ov.apellidosProperty());
            nacimientoDate.valueProperty().unbindBidirectional(ov.fechaNacimientoProperty());
            SexBox.valueProperty().unbindBidirectional(ov.sexoProperty()); // Cambiar valueProperty por selectedItemProperty
            repiteCheck.selectedProperty().unbindBidirectional(ov.repiteProperty()); // Cambiar selectedProperty por selectedProperty

        }
        if (nv != null) {

            // Vincular las propiedades al nuevo alumno
            nameAlumnText.textProperty().bindBidirectional(nv.nombreProperty());
            surnameAlumnText.textProperty().bindBidirectional(nv.apellidosProperty());
            nacimientoDate.valueProperty().bindBidirectional(nv.fechaNacimientoProperty());
            SexBox.valueProperty().bindBidirectional(nv.sexoProperty()); // Vinculación del ChoiceBox
            repiteCheck.selectedProperty().bindBidirectional(nv.repiteProperty()); // Vinculación del CheckBox

        }
    }

    public GridPane getAlumnoRoot() {
        return alumnoRoot;
    }

    public void setAlumnoRoot(GridPane alumnoRoot) {
        this.alumnoRoot = alumnoRoot;
    }

    public ObjectProperty<Alumno> alumnoObjectProperty() {

        return alumno;

    }

    public Alumno getAlumno() {
        return alumno.get();
    }

    public ObjectProperty<Alumno> alumnoProperty() {
        return alumno;
    }
}
