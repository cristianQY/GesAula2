package dad.gesaula.ui.model.controllers;

import dad.gesaula.ui.model.Alumno;
import javafx.beans.Observable;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AlumnosController implements Initializable {

    private AlumnoController alumnoController = new AlumnoController();

    private ListProperty<Alumno> alumno = new SimpleListProperty<>(
            FXCollections.observableArrayList(
                    friend -> new Observable[] { friend.nombreProperty(), friend.apellidosProperty() }
            ));
    private final ObjectProperty<Alumno> selectedFriend = new SimpleObjectProperty<>();

    @FXML
    private BorderPane alumnoRoot;

    @FXML
    private TableView<Alumno> alumnoTable;

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

        alumnoTable.itemsProperty().bind(alumno);
        selectedFriend.bind(alumnoTable.getSelectionModel().selectedItemProperty());
        eliminarAlumButton.disableProperty().bind(selectedFriend.isNull());

        selectedFriend.addListener(this::onSelectedFriendChanged);

    }

    private void onSelectedFriendChanged(ObservableValue<? extends Alumno> o, Alumno ov, Alumno nv) {
        if (nv == null) {
            alumnoRoot.setCenter(emptyBox);
        } else {
            alumnoRoot.setCenter(alumnoController.getAlumnoRoot());
        }
    }

    public BorderPane getAlumnoRoot() {
        return alumnoRoot;
    }

    public void setAlumnoRoot(BorderPane alumnoRoot) {
        this.alumnoRoot = alumnoRoot;
    }

    public TableView<?> getAlumnoTable() {
        return alumnoTable;
    }

    public void setAlumnoTable(TableView<Alumno> alumnoTable) {
        this.alumnoTable = alumnoTable;
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

    }

    @FXML
    void onNewAlumnAction(ActionEvent event) {

    }
}
