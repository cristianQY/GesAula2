package dad.gesaula.ui.model.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GrupoController implements Initializable {

    @FXML
    private Label actitudPorcenLabel;

    @FXML
    private Slider actitudSlider;

    @FXML
    private TextField denominacionText;

    @FXML
    private Label exaPorcenLabel;

    @FXML
    private Slider examenSlider;

    @FXML
    private DatePicker finDate;

    @FXML
    private GridPane grupoRoot;

    @FXML
    private DatePicker inicioDate;

    @FXML
    private Label practicPorcenLabel;

    @FXML
    private Slider practicaSlider;

    public GrupoController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/grupoView.fxml"));
            loader.setController(this);
            loader.load();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public Label getActitudPorcenLabel() {
        return actitudPorcenLabel;
    }

    public void setActitudPorcenLabel(Label actitudPorcenLabel) {
        this.actitudPorcenLabel = actitudPorcenLabel;
    }

    public Slider getActitudSlider() {
        return actitudSlider;
    }

    public void setActitudSlider(Slider actitudSlider) {
        this.actitudSlider = actitudSlider;
    }

    public TextField getDenominacionText() {
        return denominacionText;
    }

    public void setDenominacionText(TextField denominacionText) {
        this.denominacionText = denominacionText;
    }

    public Label getExaPorcenLabel() {
        return exaPorcenLabel;
    }

    public void setExaPorcenLabel(Label exaPorcenLabel) {
        this.exaPorcenLabel = exaPorcenLabel;
    }

    public Slider getExamenSlider() {
        return examenSlider;
    }

    public void setExamenSlider(Slider examenSlider) {
        this.examenSlider = examenSlider;
    }

    public DatePicker getFinDate() {
        return finDate;
    }

    public void setFinDate(DatePicker finDate) {
        this.finDate = finDate;
    }

    public GridPane getGrupoRoot() {
        return grupoRoot;
    }

    public void setGrupoRoot(GridPane grupoRoot) {
        this.grupoRoot = grupoRoot;
    }

    public DatePicker getInicioDate() {
        return inicioDate;
    }

    public void setInicioDate(DatePicker inicioDate) {
        this.inicioDate = inicioDate;
    }

    public Label getPracticPorcenLabel() {
        return practicPorcenLabel;
    }

    public void setPracticPorcenLabel(Label practicPorcenLabel) {
        this.practicPorcenLabel = practicPorcenLabel;
    }

    public Slider getPracticaSlider() {
        return practicaSlider;
    }

    public void setPracticaSlider(Slider practicaSlider) {
        this.practicaSlider = practicaSlider;
    }
}
