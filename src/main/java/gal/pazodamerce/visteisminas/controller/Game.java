package gal.pazodamerce.visteisminas.controller;

import java.util.ArrayList;

import gal.pazodamerce.visteisminas.model.Cell;

/**
 * Clase que implementa a funcionalidade do buscaminas, representando unha
 * partida do xogo.
 *
 * @author Xaquin Alves Gonzalez
 */
public class Game {

    /**
     * Número de filas en dificultad baja.
     */
    public static final int EASY_PANEL_ROWS = 6;

    /**
     * Número de filas en dificultad media.
     */
    public static final int MEDIUM_PANEL_ROWS = 8;

    /**
     * Número de filas en dificultad alta.
     */
    public static final int HARD_PANEL_ROWS = 10;

    /**
     * Número de columnas en dificultad baja.
     */
    public static final int EASY_PANEL_COLUMNS = 6;

    /**
     * Número de columnas en dificultad media.
     */
    public static final int MEDIUM_PANEL_COLUMNS = 8;

    /**
     * Número de columnas en dificultad alta.
     */
    public static final int HARD_PANEL_COLUMNS = 10;

    /**
     * Número de minas en dificultad baja.
     */
    public static final int EASY_PANEL_MINES = 8;

    /**
     * Número de minas en dificultad media.
     */
    public static final int MEDIUM_PANEL_MINES = 20;

    /**
     * Número de minas en dificultad alta.
     */
    public static final int HARD_PANEL_MINES = 40;
    /**
     * Número de filas do taboleiro.
     */
    private final int boardRows;

    /**
     * Número de columnas do taboleiro.
     */
    private final int boardColumns;
    /**
     * Array bidimensional de celdas que representa o taboleiro.
     */
    private Cell[][] cells;

    /**
     * Crea unha nova instancia de Game coas medidas introducidas como
     * parametroe o numero de minas indicado.
     *
     * @param rows numero de filas a establecer
     * @param columns numero de columnas a establecer
     * @param mines numero de minas a establecer
     */
    public Game(final int rows, final int columns, final int mines) {
        this.boardRows = rows;
        this.boardColumns = columns;
        cells = new Cell[boardRows][boardColumns];
        for (int i = 0; i < boardRows; i++) {
            for (int j = 0; j < boardColumns; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }

        fillMines(mines);
    }

    /**
     * Obtén o número de filas do taboleiro.
     *
     * @return o número de filas do taboleiro
     */
    public int getBoardRows() {
        return boardRows;
    }

    /**
     * Obtén o número de columnas do taboleiro.
     *
     * @return o número de columnas do taboleiro
     */
    public int getBoardColumns() {
        return boardColumns;
    }

    /**
     * Devolve a celda da posicion dada.
     *
     * @param row posicion nas filas
     * @param column posicion nas columnas
     * @return celda que se atopa na posicion dada
     */
    public Cell getCell(final int row, final int column) {
        return cells[row][column];
    }

    /**
     * Obten un array de celdas coas celdas adxacentes a introducida como
     * paramentro.
     *
     * @param cell celda a analizar
     * @return ArrayList de celdas adxacentes
     */
    private ArrayList<Cell> getAdjacentCells(final Cell cell) {
        ArrayList<Cell> adjacentCells = new ArrayList<>();
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> columns = new ArrayList<>();

        //Gardamos en rows as posicions de fila adxacentes que sexan validas
        rows.add(cell.getRow());
        if ((cell.getRow() - 1) >= 0) {
            rows.add(cell.getRow() - 1);
        }
        if ((cell.getRow() + 1) < boardRows) {
            rows.add(cell.getRow() + 1);
        }
        //Mismo proceso coas columnas
        columns.add(cell.getColumn());
        if ((cell.getColumn() - 1) >= 0) {
            columns.add(cell.getColumn() - 1);
        }
        if ((cell.getColumn() + 1) < boardColumns) {
            columns.add(cell.getColumn() + 1);
        }
        /* Cos arrays de posicions creados, obtemos as celdas adxacentes,
        asegurandonos que non se usa unha posicion fora dos limites do
        array de celdas */
        for (int i = 0; i < rows.size(); i++) {
            for (int j = 0; j < columns.size(); j++) {
                adjacentCells.add(cells[rows.get(i)][columns.get(j)]);
            }
        }

        return adjacentCells;
    }

    /**
     * Devolve o numero de minas adxacentes a celda pasada como parametro.
     *
     * @param cell celda a analizar
     * @return numero de minas adxacentes
     */
    public int getAdjacentMines(final Cell cell) {
        ArrayList<Cell> adjacentCells = getAdjacentCells(cell);
        int adjacentMines = 0;
        for (Cell cell1 : adjacentCells) {
            if (cell1.isMined()) {
                adjacentMines++;
            }
        }
        return adjacentMines;
    }

    /**
     * Destapa unha celda, e en caso de que non haxa minas adxacentes, destapa
     * tamen todas as celdas adxacentes, de forma recursiva.
     *
     * @param cell celda a destapar
     */
    public void openCell(final Cell cell) {
        cell.setState(Cell.DESTAPADA);

        if (getAdjacentMines(cell) == 0) {
            ArrayList<Cell> adjacentCells = getAdjacentCells(cell);
            for (int i = 0; i < adjacentCells.size(); i++) {
                adjacentCells.get(i).setState(Cell.DESTAPADA);
            }
        }
    }

    /**
     * Destapa todas as celdas con minas, usado cando acaba a partida.
     */
    public void openAllMines() {
        for (Cell[] cells1 : cells) {
            for (Cell cell : cells1) {
                if (cell.isMined()) {
                    cell.setState(Cell.DESTAPADA);
                }
            }
        }
    }

    /**
     * Comproba se quedan celdas tapadas sen minas, usado para saber se o
     * xogador gañou a partida.
     *
     * @return se quedan celdas tapadas sen minas
     */
    public boolean checkCellsToOpen() {
        for (Cell[] cells1 : cells) {
            for (Cell cell : cells1) {
                if (!cell.isMined() && cell.getState() != Cell.DESTAPADA) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Inche as celdas co numero de minas indicado en posicions aleatorias.
     *
     * @param mines numero de minas
     */
    private void fillMines(final int mines) {
        int row;
        int colum;

        for (int i = 0; i < mines; i++) {
            do {
                row = new java.util.Random().nextInt(boardRows);
                colum = new java.util.Random().nextInt(boardColumns);
            } while (cells[row][colum].isMined());

            cells[row][colum].setMined(true);
        }
    }
}
