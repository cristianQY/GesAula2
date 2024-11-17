package dad.gesaula.ui.model.controllers;

import dad.gesaula.ui.model.Alumno;
import javafx.beans.Observable;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AlumnosController implements Initializable {

    private final AlumnoController alumnoController = new AlumnoController();

    private final ListProperty<Alumno> alumnos = new SimpleListProperty<>(
            FXCollections.observableArrayList(
                    alumno -> new Observable[] { alumno.nombreProperty(), alumno.apellidosProperty() }
            ));
    private final ObjectProperty<Alumno> selectedAlumno = new SimpleObjectProperty<>();

    @FXML
    private BorderPane alumnosRoot;

    @FXML
    private ListView<Alumno> alumnoList;

    @FXML
    private Button eliminarAlumButton;

    @FXML
    private Button nuevoAlumButton;

    @FXML
    private VBox emptyBox;

    public AlumnosController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/alumnosView.fxml"));
            loader.setController(this);
            loader.load();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        alumnoList.itemsProperty().bind(alumnos);
        selectedAlumno.bind(alumnoList.getSelectionModel().selectedItemProperty());
        eliminarAlumButton.disableProperty().bind(selectedAlumno.isNull());

        selectedAlumno.addListener(this::onSelectedAlumnoChanged);

        alumnoController.alumnoProperty().bind(selectedAlumno);

    }

    private void onSelectedAlumnoChanged(ObservableValue<? extends Alumno> o, Alumno ov, Alumno nv) {
        // Limpia el VBox antes de añadir nuevos nodos
        emptyBox.getChildren().clear();

        if (nv == null) {
            // Muestra un mensaje indicando que no hay selección
            emptyBox.getChildren().add(new javafx.scene.control.Label("No hay alumno seleccionado."));
        } else {
            // Configura los detalles del AlumnoController

            emptyBox.getChildren().add(alumnoController.getAlumnoRoot());
        }
    }


    public BorderPane getAlumnosRoot() {
        return alumnosRoot;
    }

    public void setAlumnosRoot(BorderPane alumnosRoot) {
        this.alumnosRoot = alumnosRoot;
    }

    public ListView<Alumno> getAlumnoList() {
        return alumnoList;
    }

    public void setAlumnoList(ListView<Alumno> alumnoList) {
    }

    public Button getEliminarAlumButton() {
        return eliminarAlumButton;
    }

    public void setEliminarAlumButton(Button eliminarAlumButton) {
        this.eliminarAlumButton = eliminarAlumButton;
    }

    public Button getNuevoAlumButton() {
        return nuevoAlumButton;
    }

    public void setNuevoAlumButton(Button nuevoAlumButton) {
        this.nuevoAlumButton = nuevoAlumButton;
    }

    @FXML
    void onDeleteAction(ActionEvent event) {
        Alumno selected = selectedAlumno.get();
        if (selected != null) {
            alumnos.remove(selected);
            alumnoList.getSelectionModel().clearSelection(); // Limpia la selección actual
        }
    }

    @FXML
    void onNewAlumnAction(ActionEvent event) {
        // Deseleccionar el alumno actual
        alumnoList.getSelectionModel().clearSelection();

        // Crea un nuevo alumno
        Alumno alumno = new Alumno();
        alumno.setNombre("Nombre");
        alumno.setApellidos("Apellidos");

        // Añade el nuevo alumno a la lista
        alumnos.add(alumno);

        // Selecciona automáticamente el nuevo alumno
        alumnoList.getSelectionModel().select(alumno);

    }

    public ObservableList<Alumno> getAlumno() {
        return alumnos.get();
    }

    public ListProperty<Alumno> friendsProperty() {
        return alumnos;
    }

}
