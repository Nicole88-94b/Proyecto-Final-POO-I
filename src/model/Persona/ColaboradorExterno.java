package model.Persona;

import model.Registrable;
import utils.TelefonoInvalido;

public class ColaboradorExterno extends Persona implements Registrable {
    private String tipoColaboracion;

    public ColaboradorExterno(String nombre, Rut rut, Direccion direccion, String correo,
                              String telefono, String tipoColaboracion) throws TelefonoInvalido {
        super(nombre, rut, direccion, correo, telefono);
        this.tipoColaboracion = tipoColaboracion;
    }

    public String getTipoColaboracion() {
        return tipoColaboracion;
    }

    public void setTipoColaboracion(String tipoColaboracion) {
        this.tipoColaboracion = tipoColaboracion;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nTipo de colaboración: " + tipoColaboracion;
    }

    @Override
    public String mostrarInformacion() {
        return toString();
    }
}
