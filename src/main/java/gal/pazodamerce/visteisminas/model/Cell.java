package gal.pazodamerce.visteisminas.model;

/**
 * Clase que representa unha celda da pantalla de xogo do buscaminas.
 *
 * @author Xaquin Alves Gonzalez
 */
public class Cell {

    /**
     * Valor que representa o estado TAPADA.
     */
    public static final int TAPADA = 1;

    /**
     * Valor que representa o estado MARCADA.
     */
    public static final int MARCADA = 2;

    /**
     * Valor que representa o estado DESTAPADA.
     */
    public static final int DESTAPADA = 3;

    /**
     * Indica se a celda está minada.
     */
    private boolean mined;

    /**
     * Estado actual da celda: 1 = TAPADA, 2 = MARCADA, 3 = DESTAPADA.
     */
    private int state;

    /**
     * Fila na que se atopa a celda.
     */
    private int row;

    /**
     * Columna na que se atopa a celda.
     */
    private int column;

    /**
     * Crea unha nova instancia de Cell, sen mina e TAPADA, coa posicion
     * indicada como parametros.
     *
     * @param paramRow    fila da celda a crear
     * @param paramColumn columna da celda a crear
     */
    public Cell(final int paramRow, final int paramColumn) {
        this.row = paramRow;
        this.column = paramColumn;
        this.mined = false;
        this.state = TAPADA;
    }

    /**
     * Obten o valor equivalente a estar TAPADA.
     *
     * @return valor de estado cando TAPADA
     */
    public static int getTapada() {
        return TAPADA;
    }

    /**
     * Obten o valor equivalente a estar MARCADA.
     *
     * @return valor de estado cando MARCADA
     */
    public static int getMarcada() {
        return MARCADA;
    }

    /**
     * Obten o valor equivalente a estar DESTAPADA.
     *
     * @return valor de estado cando DESTAPADA
     */
    public static int getDestapada() {
        return DESTAPADA;
    }

    /**
     * @return se esta minada
     */
    public boolean isMined() {
        return mined;
    }

    /**
     * @param paramMined establece se esta minada
     */
    public void setMined(final boolean paramMined) {
        this.mined = paramMined;
    }

    /**
     * Obten o estado da celda: 1 = TAPADA 2 = MARCADA 3 = DESTAPADA.
     *
     * @return estado da celda
     */
    public int getState() {
        return state;
    }

    /**
     * Define o estado da celda: 1 = TAPADA 2 = MARCADA 3 = DESTAPADA.
     *
     * @param newState estado a establecer
     */
    public void setState(final int newState) {
        this.state = newState;
    }

    /**
     * @return fila da celda
     */
    public int getRow() {
        return row;
    }

    /**
     * @param newRow fila da celda a establecer
     */
    public void setRow(final int newRow) {
        this.row = newRow;
    }

    /**
     * @return columna da celda
     */
    public int getColumn() {
        return column;
    }

    /**
     * @param newColumn columna da celda a establecer
     */
    public void setColumn(final int newColumn) {
        this.column = newColumn;
    }
}
