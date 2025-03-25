package gal.pazodamerce.visteisminas.view;

import java.util.Scanner;

import gal.pazodamerce.visteisminas.controller.Game;
import gal.pazodamerce.visteisminas.model.Cell;

/**
 * Clase que implementa a interface do xogo, en modo texto.
 *
 * @author Xaquin Alves Gonzalez
 */
public class VisTeisMinasMenu {

    /**
     * Nivel de dificultad fácil.
     */
    private static final int EASY_LEVEL = 1;

    /**
     * Nivel de dificultad media.
     */
    private static final int MEDIUM_LEVEL = 2;

    /**
     * Nivel de dificultad alta.
     */
    private static final int HARD_LEVEL = 3;

    /**
     * Número de filas en dificultad baja.
     */
    private static final int EASY_PANEL_ROWS = 6;

    /**
     * Número de filas en dificultad media.
     */
    private static final int MEDIUM_PANEL_ROWS = 8;

    /**
     * Número de filas en dificultad alta.
     */
    private static final int HARD_PANEL_ROWS = 10;

    /**
     * Número de columnas en dificultad baja.
     */
    private static final int EASY_PANEL_COLUMNS = 6;

    /**
     * Número de columnas en dificultad media.
     */
    private static final int MEDIUM_PANEL_COLUMNS = 8;

    /**
     * Número de columnas en dificultad alta.
     */
    private static final int HARD_PANEL_COLUMNS = 10;

    /**
     * Número de minas en dificultad baja.
     */
    private static final int EASY_PANEL_MINES = 8;

    /**
     * Número de minas en dificultad media.
     */
    private static final int MEDIUM_PANEL_MINES = 20;

    /**
     * Número de minas en dificultad alta.
     */
    private static final int HARD_PANEL_MINES = 40;

    /**
     * Número de filas del panel configurado.
     */
    private int panelRows;

    /**
     * Número de columnas del panel configurado.
     */
    private int panelColumns;

    /**
     * Número de minas en el panel configurado.
     */
    private int panelMines;

    /**
     * Mostra o panel de minas.
     *
     * @param game referencia a partida actual
     */
    private void showPanel(final Game game) {
        System.out.println("---      Estado do panel        ---");
        System.out.print("\n  ");
        for (int i = 0; i < panelColumns; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(" -------------");
        for (int i = 0; i < panelRows; i++) {

            String row = Integer.toString(i);
            String rowBelow = "-";
            for (int j = 0; j < panelColumns; j++) {

                switch (game.getCell(i, j).getState()) {
                    case Cell.TAPADA -> {
                        row = row.concat("| ");
                    }
                    case Cell.MARCADA -> {
                        row = row.concat("|X");
                    }
                    case Cell.DESTAPADA -> {
                        if (game.getCell(i, j).isMined()) {
                            row = row.concat("|!");
                        } else {
                            row = row.concat("|");
                            String num = String.valueOf(game.getAdjacentMines(
                                    game.getCell(i, j)));
                            row = row.concat(num);
                        }
                    }
                    default ->
                        System.out.println("");
                }
                rowBelow = rowBelow.concat("--");
            }
            row = row.concat("|");
            rowBelow = rowBelow.concat("-");
            System.out.println(row);
            System.out.println(rowBelow);
        }
    }

    /**
     * Inicia unha partida, mostra o panel e pide unha accion de forma
     * repetitiva hasta que acabe a partida, preguntando se se quere xogar outra
     * ao rematar.
     */
    public void startNewGame() {
        Scanner scanner = new Scanner(System.in);

        do {
            int choice;
            System.out.println("""
                    Seleccione un nivel de dificultade:
                    1.Baixo
                    2.Medio
                    3.Alto""");

            do {
                System.out.print("Eleccion: ");
                choice = scanner.nextInt();
                scanner.nextLine();
            } while (choice < EASY_LEVEL || choice > HARD_LEVEL);

            switch (choice) {
                case EASY_LEVEL -> {
                    panelRows = EASY_PANEL_ROWS;
                    panelColumns = EASY_PANEL_COLUMNS;
                    panelMines = EASY_PANEL_MINES;
                }
                case MEDIUM_LEVEL -> {
                    panelRows = MEDIUM_PANEL_ROWS;
                    panelColumns = MEDIUM_PANEL_COLUMNS;
                    panelMines = MEDIUM_PANEL_MINES;
                }
                case HARD_LEVEL -> {
                    panelRows = HARD_PANEL_ROWS;
                    panelColumns = HARD_PANEL_COLUMNS;
                    panelMines = HARD_PANEL_MINES;
                }
                default -> {
                }
            }

            Game game = new Game(panelRows, panelColumns, panelMines);
            boolean failed = false;

            do {
                failed = playTurn(game, scanner);
            } while (game.checkCellsToOpen() && !failed);

        } while (nextGame(scanner));
    }

    /**
     * Metodo que executa 1 turno, mostrando o panel e pedindo unha accion de
     * forma repetitiva ata que acabe a partida.
     *
     * @param game
     * @param scanner
     * @return se a partida acabou
     */
    private boolean playTurn(final Game game,
            final Scanner scanner) {
        boolean failed = false;
        System.out.println("---Estas xogando ao VisteisMinas---");
        System.out.println("---  version por: Xaquin Alves  ---");
        showPanel(game);

        System.out.print("Introduce a accion(s:Sair,"
                + " m:Marcar unha celda, d: Desmarcar unha"
                + "celda, a:Abrir unha celda): ");
        char choice = scanner.nextLine().charAt(0);

        switch (choice) {
            case 's' -> { //Sair
                failed = true;
            }
            case 'm' -> //Marcar celda
                selectCell(game, scanner, "Selecciona a"
                        + "celda a marcar: ").setState(Cell.MARCADA);
            case 'd' -> { //Desmarcar celda
                Cell cell = selectCell(game,
                        scanner, "Selecciona a celda a desmarcar: ");
                //Se a celda non esta marcada ou descuberta no se pode desmarcar
                switch (cell.getState()) {
                    case Cell.TAPADA ->
                        System.out.println("A celda"
                                + " seleccionada non esta marcada");
                    case Cell.DESTAPADA ->
                        System.out.println("A "
                                + "celda xa esta aberta");
                    default -> //Se a celda esta marcada desmarcamola
                        cell.setState(Cell.TAPADA);
                }
            }
            case 'a' -> { //Abrir celda
                Cell cell = selectCell(game, scanner,
                        "Selecciona unha celda para abrir: ");
                game.openCell(cell);
                //Se a celda esta minada a partida acaba
                if (cell.isMined()) {
                    game.openAllMines();
                    showPanel(game);
                    failed = true;
                }
            }
            default -> { //Se se introduce unha opcion incorrecta
                showIncorrectInput();
            }
        }
        return failed;
    }

    /**
     * Usado para pedir ao usuario que selecione unha celda, devolvendo a celda
     * seleccionada.
     *
     * @param game referencia a partida actual
     * @param scanner para pedir datos
     * @param text mensaxe inicial do metodo
     * @return celda seleccionada
     */
    private Cell selectCell(final Game game,
            final Scanner scanner, final String text) {
        System.out.println(text);
        System.out.print("Introduce a Fila:");
        int row = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Introduce a Columna:");
        int column = scanner.nextInt();
        scanner.nextLine();

        while (row >= panelRows || row < 0
                || column >= panelColumns || column < 0) {
            System.out.println("Posicion non valida."
                    + "Introduza outra posicion: ");
            System.out.print("Introduce a Fila:");
            row = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Introduce a Columna:");
            column = scanner.nextInt();
            scanner.nextLine();
        }

        return game.getCell(row, column);
    }

    /**
     * Pregunta se se quere xogar unha nova partida, devolvendo un booleano en
     * funcion da resposta.
     *
     * @param scanner para pedir datos
     * @return se se quere xogar outra partida
     */
    private boolean nextGame(final Scanner scanner) {
        System.out.print("Desexa xogar outra partida?(s/n):");
        char choice = scanner.nextLine().charAt(0);

        return choice == 's' || choice == 'S';
    }

    /**
     * Informa ao usuario de que introduciu unha opcion incorrecta.
     */
    private void showIncorrectInput() {
        System.out.println("Introduza unha opción válida");
    }
}
