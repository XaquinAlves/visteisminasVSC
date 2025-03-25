package gal.pazodamerce.visteisminas.controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App.
 */
public class App extends Application {

    /**
     * The main scene of the application.
     */
    private static Scene scene;

    /**
     * Starts the application.
     *
     * @param stage the stage to start
     */
    @Override
    public void start(final Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(final String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(final String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml
                + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * The main entry point for the application.
     *
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        launch();
    }

}
