package gal.pazodamerce.visteisminas.controller;

import java.io.IOException;
import java.util.Optional;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;

public class VisTeisMinasFXController implements Initializable {

    /**
     * Referencia a partida actual.
     */
    private Game game;

    /**
     * Panel de juego donde se mostrarán las celdas.
     */
    @FXML
    GridPane gamePanel;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    public void startNewGame() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Dificultade");
        alert.setHeaderText("Seleccione un nivel de dificultade:");

        ButtonType buttonTypeBaixo = new ButtonType("Baixo");
        ButtonType buttonTypeMedio = new ButtonType("Medio");
        ButtonType buttonTypeAlto = new ButtonType("Alto");

        alert.getButtonTypes().setAll(buttonTypeBaixo, buttonTypeMedio,
                buttonTypeAlto);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeBaixo) {
            game = new Game(Game.EASY_PANEL_ROWS, Game.EASY_PANEL_COLUMNS,
                    Game.EASY_PANEL_MINES);
        } else if (result.get() == buttonTypeMedio) {
            game = new Game(Game.MEDIUM_PANEL_ROWS, Game.MEDIUM_PANEL_COLUMNS,
                    Game.MEDIUM_PANEL_MINES);
        } else if (result.get() == buttonTypeAlto) {
            game = new Game(Game.HARD_PANEL_ROWS, Game.HARD_PANEL_COLUMNS,
                    Game.HARD_PANEL_MINES);
        }

    }
}
