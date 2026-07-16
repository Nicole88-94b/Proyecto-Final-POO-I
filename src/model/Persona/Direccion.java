package model.Persona;


public class Direccion  {
    private String calle;
    private int numero;
    private String region;

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

    @Override
    public String toString() {
        return "\nDirección: " + calle + ", #" + numero + ", " + region + ".";
    }

}
