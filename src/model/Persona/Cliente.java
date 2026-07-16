package model.Persona;

import model.Registrable;
import model.ServicioTuristico.ServicioTuristico;
import utils.TelefonoInvalido;

public class Cliente extends Persona implements Registrable {

    public Cliente(String nombre, Rut rut, Direccion direccion, String correo,
                   String telefono) throws TelefonoInvalido {
        super(nombre, rut, direccion, correo, telefono);

    }


    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String mostrarInformacion() {
        return toString();
    }
}
