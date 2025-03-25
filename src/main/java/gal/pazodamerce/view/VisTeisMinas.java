package gal.pazodamerce.view;

public final class VisTeisMinas {

    // Private constructor to prevent instantiation
    private VisTeisMinas() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Inicia a aplicación con interfaz de texto ou gráfica.
     *
     * @param args Argumentos da liña de comandos (non utilizados).
     */
    public static void main(final String[] args) {
        VisTeisMinasMenu visTeisMinasMenu = new VisTeisMinasMenu();
        visTeisMinasMenu.startNewGame();
    }
}
