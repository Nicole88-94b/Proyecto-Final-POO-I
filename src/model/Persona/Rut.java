package model.Persona;

import utils.RutInvalido;

public class Rut  {
    private String numeroRut;

    public Rut(String numeroRut) throws RutInvalido {
        validar(numeroRut);
        this.numeroRut = numeroRut;
    }

    private void validar(String numeroRut) throws  RutInvalido {
        if (numeroRut == null || numeroRut.isEmpty() || !numeroRut.matches("[0-9]{7,8}-[0-9kK]")) {
            throw new RutInvalido("Debes ingresar el rut sin puntos y con guión, por ejemplo: 12345678-9");
        }

    }

    public String getNumeroRut() {
        return numeroRut;
    }

    public void setNumeroRut(String numeroRut) throws RutInvalido {
        validar(numeroRut);
        this.numeroRut = numeroRut;
    }

    @Override
    public String toString() {
        return "\nRut: " + numeroRut;
    }

}
