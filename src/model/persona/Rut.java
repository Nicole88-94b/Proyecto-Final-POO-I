package model.persona;

import utils.RutInvalido;

/**
 * Encapsula un RUT chileno y valida su formato básico.
 */
public class Rut  {
    private String numeroRut;

    /**
     * Crea un RUT después de validar su formato.
     *
     * @param numeroRut RUT sin puntos y con guion
     * @throws RutInvalido si el valor no cumple el formato requerido
     */
    public Rut(String numeroRut) throws RutInvalido {
        validar(numeroRut);
        this.numeroRut = numeroRut;
    }

    /**
     * Comprueba que el RUT tenga entre siete y ocho dígitos, guion y dígito verificador.
     *
     * @param numeroRut RUT que se desea validar
     * @throws RutInvalido si el valor es nulo, está vacío o no cumple el formato
     */
    private void validar(String numeroRut) throws  RutInvalido {
        if (numeroRut == null || numeroRut.isEmpty() || !numeroRut.matches("[0-9]{7,8}-[0-9kK]")) {
            throw new RutInvalido("Debes ingresar el rut sin puntos y con guión, por ejemplo: 12345678-9");
        }

    }

    public String getNumeroRut() {
        return numeroRut;
    }

    /**
     * Valida y asigna un nuevo RUT.
     *
     * @param numeroRut nuevo RUT sin puntos y con guion
     * @throws RutInvalido si el valor no cumple el formato requerido
     */
    public void setNumeroRut(String numeroRut) throws RutInvalido {
        validar(numeroRut);
        this.numeroRut = numeroRut;
    }

    /**
     * Devuelve el RUT en formato legible.
     *
     * @return representación textual del RUT
     */
    @Override
    public String toString() {
        return "\nRut: " + numeroRut;
    }

}
