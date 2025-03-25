package gal.pazodamerce.visteisminas.view;

import gal.pazodamerce.visteisminas.controller.App;

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
        if (args.length > 0 && args[0].equals("texto")) {
            VisTeisMinasMenu visTeisMinasMenu = new VisTeisMinasMenu();
            visTeisMinasMenu.startNewGame();
        } else {
            App.main(args);
        }
    }
}
