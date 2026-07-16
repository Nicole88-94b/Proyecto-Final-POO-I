package model.Persona;

import model.Registrable;
import model.ServicioTuristico.ServicioTuristico;

public class Cliente extends Persona implements Registrable {
    private ServicioTuristico servicio;

    public Cliente(String nombre, Rut rut, Direccion direccion, String correo, String telefono, ServicioTuristico servicio) {
        super(nombre, rut, direccion, correo, telefono);
        this.servicio = servicio;
    }


    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() + "\n" + servicio.mostrarInformacion();
    }
}
