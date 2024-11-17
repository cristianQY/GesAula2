package dad.gesaula.ui.model.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dad.gesaula.ui.model.Alumno;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

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

    private List<Alumno> alumnos = new ArrayList<>();

    // Instancias de los controladores que vamos a cargar
    private AlumnosController alumnosController;
    private GrupoController grupoController;

    public RootController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/rootView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            // Cargar la vista de grupos y establecerla en la pestaña de grupoTab
            FXMLLoader gruposLoader = new FXMLLoader(getClass().getResource("/fxml/grupoView.fxml"));
            grupoController = new GrupoController(); // Crear una instancia de GrupoController
            gruposLoader.setController(grupoController);
            Parent grupoContent = gruposLoader.load();
            grupoTab.setContent(grupoContent);

            // Cargar la vista de alumnos y establecerla en la pestaña alumnosTab
            FXMLLoader alumnosLoader = new FXMLLoader(getClass().getResource("/fxml/alumnosView.fxml"));
            alumnosController = new AlumnosController(); // Crear una instancia de AlumnosController
            alumnosLoader.setController(alumnosController);
            Parent alumnosContent = alumnosLoader.load();
            alumnosTap.setContent(alumnosContent);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onSaveAction(ActionEvent event) {
        String nombreFichero = nombreFicheroText.getText();

        // Verificar si el nombre del fichero es válido
        if (nombreFichero == null || nombreFichero.trim().isEmpty()) {
            System.out.println("El nombre del fichero es obligatorio.");
            return;
        }

        File archivo = new File(nombreFichero + ".json");

        // Crear un ObjectMapper con soporte para Java 8 Date/Time
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule()); // Registrar el módulo para Java 8 Date/Time

        try {
            // Crear un mapa con los datos a guardar
            Map<String, Object> datosGuardados = new HashMap<>();

            // Obtener los controladores desde las instancias
            List<Alumno> alumnosList = alumnosController.getAlumno();  // Ahora alumnosController no es null

            // Obtener los datos del grupo
            Map<String, Object> grupoData = new HashMap<>();
            grupoData.put("denominacion", grupoController.getDenominacionText().getText());
            grupoData.put("fechaInicio", grupoController.getInicioDate().getValue());
            grupoData.put("fechaFin", grupoController.getFinDate().getValue());
            grupoData.put("actitud", grupoController.getActitudSlider().getValue());
            grupoData.put("examen", grupoController.getExamenSlider().getValue());
            grupoData.put("practica", grupoController.getPracticaSlider().getValue());

            // Añadir los datos al mapa
            datosGuardados.put("grupo", grupoData);
            datosGuardados.put("alumnos", alumnosList);

            // Serializar los datos a un archivo JSON
            objectMapper.writeValue(archivo, datosGuardados);
            System.out.println("Datos guardados en: " + archivo.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al guardar el archivo.");
        }
    }

    @FXML
    void onNewFileAction(ActionEvent event) {

    }

    public BorderPane getRoot() {
        return root;
    }

    public void setRoot(BorderPane root) {
        this.root = root;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}

