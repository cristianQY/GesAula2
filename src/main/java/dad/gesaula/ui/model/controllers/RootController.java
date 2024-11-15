package dad.gesaula.ui.model.controllers;

import dad.gesaula.ui.model.Alumno;
import javafx.beans.Observable;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {



    @FXML
    private Tab alumnosTap;

    @FXML
    private Tab grupoTab;

    @FXML
    private Button guardarButton;

    @FXML
    private TextField nombreFicheroText;

    @FXML
    private Button nuevoButton;

    @FXML
    private BorderPane root;

    public RootController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/rootView.fxml"));
            loader.setController(this);
            loader.load();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            // Cargar la vista de alumnos y establecerla en la pestaña alumnosTab

            FXMLLoader gruposLoader = new FXMLLoader(getClass().getResource("/fxml/grupoView.fxml"));
            GrupoController grupoController = new GrupoController(); // Crear instancia de GrupoController
            gruposLoader.setController(grupoController);
            Parent grupoContent = gruposLoader.load();
            grupoTab.setContent(grupoContent);

            FXMLLoader alumnosLoader = new FXMLLoader(getClass().getResource("/fxml/alumnosView.fxml"));
            AlumnosController alumnosController = new AlumnosController(); // Crear instancia de GrupoController
            alumnosLoader.setController(alumnosController);
            Parent alumnosContent = alumnosLoader.load();
            alumnosTap.setContent(alumnosContent);

            // Establecer el contenido cargado en la pestaña



            // Si necesitas el controlador, puedes obtenerlo así:
            //AlumnosController alumnosController = alumnosLoader.getController();
            // Configura el controlador según sea necesario

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public BorderPane getRoot() {
        return root;
    }

    public void setRoot(BorderPane root) {
        this.root = root;
    }

    public Tab getAlumnosTap() {
        return alumnosTap;
    }

    public void setAlumnosTap(Tab alumnosTap) {
        this.alumnosTap = alumnosTap;
    }

    public Tab getGrupoTab() {
        return grupoTab;
    }

    public void setGrupoTab(Tab grupoTab) {
        this.grupoTab = grupoTab;
    }

    public Button getGuardarButton() {
        return guardarButton;
    }

    public void setGuardarButton(Button guardarButton) {
        this.guardarButton = guardarButton;
    }

    public TextField getNombreFicheroText() {
        return nombreFicheroText;
    }

    public void setNombreFicheroText(TextField nombreFicheroText) {
        this.nombreFicheroText = nombreFicheroText;
    }

    public Button getNuevoButton() {
        return nuevoButton;
    }

    public void setNuevoButton(Button nuevoButton) {
        this.nuevoButton = nuevoButton;
    }

    @FXML
    void onSaveAction(ActionEvent event) {

    }

    @FXML
    void onNewFileAction(ActionEvent event) {

    }

}
