package model.Persona;

import model.Registrable;

public class Direccion implements Registrable {
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

    public void setNumero(int numero) throws NumberFormatException {
        if (numero <=0 ) {
            throw new NumberFormatException("El número de la dirección no puede ser negativo");
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
    public String mostrarInformacion() {
        return "\nDirección: " + getCalle() + ", #" + getNumero() + ", " + getRegion() + ".";
    }
}
