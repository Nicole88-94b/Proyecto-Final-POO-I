package utils;

/**
 * Excepción que indica que un RUT no cumple el formato requerido.
 */
public class RutInvalido extends Exception {
    /**
     * Crea la excepción con una descripción del error de validación.
     *
     * @param message detalle del error
     */
    public RutInvalido(String message) {
        super(message);
    }
}
