package model.Persona;

import model.Registrable;
import utils.TelefonoInvalido;

/**
 * Representa a una persona u organización externa que colabora con la agencia.
 */
public class ColaboradorExterno extends Persona implements Registrable {
    private String tipoColaboracion;

    /**
     * Crea un colaborador con sus datos y el tipo de colaboración que presta.
     *
     * @param nombre nombre del colaborador
     * @param rut RUT validado
     * @param direccion dirección del colaborador
     * @param correo correo electrónico
     * @param telefono teléfono de contacto
     * @param tipoColaboracion descripción de la colaboración
     * @throws TelefonoInvalido si el teléfono no cumple el formato requerido
     */
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

    /**
     * Devuelve los datos personales y el tipo de colaboración.
     *
     * @return representación textual del colaborador
     */
    @Override
    public String toString() {
        return super.toString() +
                "\nTipo de colaboración: " + tipoColaboracion;
    }

    /**
     * Genera la información registrable del colaborador.
     *
     * @return datos personales y tipo de colaboración
     */
    @Override
    public String mostrarInformacion() {
        return toString();
    }
}
