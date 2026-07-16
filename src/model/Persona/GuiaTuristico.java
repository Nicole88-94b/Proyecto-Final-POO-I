package model.Persona;

import model.Registrable;

public class GuiaTuristico extends Persona implements Registrable {
    private String codigoGuia;

    public GuiaTuristico(String nombre, Rut rut, Direccion direccion, String correo, String telefono, String codigoGuia) {
        super(nombre, rut, direccion, correo, telefono);
        this.codigoGuia = codigoGuia;
    }

    public String getCodigoGuia() {
        return codigoGuia;
    }

    public void setCodigoGuia(String codigoGuia) {
        this.codigoGuia = codigoGuia;
    }

    @Override
    public String mostrarInformacion() {
    return "Guía Turístico: \n" +
            "Código: " + codigoGuia + "\n" + super.mostrarInformacion();
    }
}
