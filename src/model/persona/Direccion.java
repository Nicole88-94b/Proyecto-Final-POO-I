package model.persona;


/**
 * Representa una dirección mediante calle, número y región.
 */
public class Direccion  {
    private String calle;
    private int numero;
    private String region;

    /**
     * Crea una dirección y valida que su número sea positivo.
     *
     * @param calle nombre de la calle
     * @param numero número de la propiedad
     * @param region región donde se ubica la dirección
     * @throws IllegalArgumentException si el número no es mayor que cero
     */
    public Direccion(String calle, int numero, String region) {
        this.calle = calle;
        setNumero(numero);
        this.region = region;
    }


    public String getCalle() {
        return calle;
    }


    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    /**
     * Valida y asigna el número de la propiedad.
     *
     * @param numero nuevo número de la dirección
     * @throws IllegalArgumentException si el número no es mayor que cero
     */
    public void setNumero(int numero) throws IllegalArgumentException {
        if (numero <=0 ) {
            throw new IllegalArgumentException("El número de la dirección no puede ser cero ni negativo");
        }
        this.numero = numero;
    }


    public String getRegion() {
        return region;
    }


    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Devuelve la dirección en formato legible.
     *
     * @return calle, número y región
     */
    @Override
    public String toString() {
        return "\nDirección: " + calle + ", #" + numero + ", " + region + ".";
    }

}
