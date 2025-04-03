package gal.pazodamerce.visteisminas.controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import gal.pazodamerce.visteisminas.model.Cell;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ToggleButton;
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
    private GridPane gamePanel;
    /**
     * Para manexar os botons con facilidade
     */
    private ToggleButton[][] cellButtons;

    /**
     * Botón que representa la celda 0,0.
     */
    @FXML
    private ToggleButton cell00;

    /**
     * Botón que representa la celda 0,1.
     */
    @FXML
    private ToggleButton cell01;

    /**
     * Botón que representa la celda 0,2.
     */
    @FXML
    private ToggleButton cell02;

    /**
     * Botón que representa la celda 0,3.
     */
    @FXML
    private ToggleButton cell03;

    /**
     * Botón que representa la celda 0,4.
     */
    @FXML
    private ToggleButton cell04;

    /**
     * Botón que representa la celda 0,5.
     */
    @FXML
    private ToggleButton cell05;

    /**
     * Botón que representa la celda 1,0.
     */
    @FXML
    private ToggleButton cell10;

    /**
     * Botón que representa la celda 1,1.
     */
    @FXML
    private ToggleButton cell11;

    /**
     * Botón que representa la celda 1,2.
     */
    @FXML
    private ToggleButton cell12;

    /**
     * Botón que representa la celda 1,3.
     */
    @FXML
    private ToggleButton cell13;

    /**
     * Botón que representa la celda 1,4.
     */
    @FXML
    private ToggleButton cell14;

    /**
     * Botón que representa la celda 1,5.
     */
    @FXML
    private ToggleButton cell15;

    /**
     * Botón que representa la celda 2,0.
     */
    @FXML
    private ToggleButton cell20;

    /**
     * Botón que representa la celda 2,1.
     */
    @FXML
    private ToggleButton cell21;

    /**
     * Botón que representa la celda 2,2.
     */
    @FXML
    private ToggleButton cell22;

    /**
     * Botón que representa la celda 2,3.
     */
    @FXML
    private ToggleButton cell23;

    /**
     * Botón que representa la celda 2,4.
     */
    @FXML
    private ToggleButton cell24;

    /**
     * Botón que representa la celda 2,5.
     */
    @FXML
    private ToggleButton cell25;

    /**
     * Botón que representa la celda 3,0.
     */
    @FXML
    private ToggleButton cell30;

    /**
     * Botón que representa la celda 3,1.
     */
    @FXML
    private ToggleButton cell31;

    /**
     * Botón que representa la celda 3,2.
     */
    @FXML
    private ToggleButton cell32;

    /**
     * Botón que representa la celda 3,3.
     */
    @FXML
    private ToggleButton cell33;

    /**
     * Botón que representa la celda 3,4.
     */
    @FXML
    private ToggleButton cell34;

    /**
     * Botón que representa la celda 3,5.
     */
    @FXML
    private ToggleButton cell35;

    /**
     * Botón que representa la celda 4,0.
     */
    @FXML
    private ToggleButton cell40;

    /**
     * Botón que representa la celda 4,1.
     */
    @FXML
    private ToggleButton cell41;

    /**
     * Botón que representa la celda 4,2.
     */
    @FXML
    private ToggleButton cell42;

    /**
     * Botón que representa la celda 4,3.
     */
    @FXML
    private ToggleButton cell43;

    /**
     * Botón que representa la celda 4,4.
     */
    @FXML
    private ToggleButton cell44;

    /**
     * Botón que representa la celda 4,5.
     */
    @FXML
    private ToggleButton cell45;

    /**
     * Botón que representa la celda 5,0.
     */
    @FXML
    private ToggleButton cell50;

    /**
     * Botón que representa la celda 5,1.
     */
    @FXML
    private ToggleButton cell51;

    /**
     * Botón que representa la celda 5,2.
     */
    @FXML
    private ToggleButton cell52;

    /**
     * Botón que representa la celda 5,3.
     */
    @FXML
    private ToggleButton cell53;

    /**
     * Botón que representa la celda 5,4.
     */
    @FXML
    private ToggleButton cell54;

    /**
     * Botón que representa la celda 5,5.
     */
    @FXML
    private ToggleButton cell55;

    /**
     * Constructor de la clase VisTeisMinasFXController.
     *
     * @param gameRef partida actual
     */
    public VisTeisMinasFXController(final Game gameRef) {
        this.game = gameRef;
        cellButtons = new ToggleButton[game.getBoardRows()][game
                .getBoardColumns()];
        //CHECKSTYLE:OFF
        cellButtons[0][0] = cell00;
        cellButtons[0][1] = cell01;
        cellButtons[0][2] = cell02;
        cellButtons[0][3] = cell03;
        cellButtons[0][4] = cell04;
        cellButtons[0][5] = cell05;
        cellButtons[1][0] = cell10;
        cellButtons[1][1] = cell11;
        cellButtons[1][2] = cell12;
        cellButtons[1][3] = cell13;
        cellButtons[1][4] = cell14;
        cellButtons[1][5] = cell15;
        cellButtons[2][0] = cell20;
        cellButtons[2][1] = cell21;
        cellButtons[2][2] = cell22;
        cellButtons[2][3] = cell23;
        cellButtons[2][4] = cell24;
        cellButtons[2][5] = cell25;
        cellButtons[3][0] = cell30;
        cellButtons[3][1] = cell31;
        cellButtons[3][2] = cell32;
        cellButtons[3][3] = cell33;
        cellButtons[3][4] = cell34;
        cellButtons[3][5] = cell35;
        cellButtons[4][0] = cell40;
        cellButtons[4][1] = cell41;
        cellButtons[4][2] = cell42;
        cellButtons[4][3] = cell43;
        cellButtons[4][4] = cell44;
        cellButtons[4][5] = cell45;
        cellButtons[5][0] = cell50;
        cellButtons[5][1] = cell51;
        cellButtons[5][2] = cell52;
        cellButtons[5][3] = cell53;
        cellButtons[5][4] = cell54;
        cellButtons[5][5] = cell55;
        //CHECKSTYLE:ON
    }

    /**
     * Usado para comezar unha nova partida.
     */
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

    //TODO: Implementar o método de inicialización.
    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet.");

    }

    private void updatePanel() {

    }

    private void finishGame(String message) {

    }

    private void openCell(Cell cell) {

    }

    private void cellButtonActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void cellButtonMouseClicked(java.awt.event.MouseEvent evt) {
    }
}
