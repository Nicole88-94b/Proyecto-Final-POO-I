package utils;

/**
 * Excepción que indica que un teléfono no cumple el formato requerido.
 */
public class TelefonoInvalido extends Exception {
    /**
     * Crea la excepción con una descripción del error de validación.
     *
     * @param message detalle del error
     */
    public TelefonoInvalido(String message) {
        super(message);
    }
}
