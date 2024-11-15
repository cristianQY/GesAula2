package dad.gesaula.ui.model;

import dad.gesaula.ui.model.controllers.RootController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class GesAulaApp extends Application {

    private RootController rootController = new RootController();

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("GesAula");
        primaryStage.getIcons().add(new Image("images/app-icon-64x64.png"));
        primaryStage.setScene(new Scene(rootController.getRoot()));
        primaryStage.show();

    }
}
