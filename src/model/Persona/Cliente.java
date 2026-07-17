package model.Persona;

import model.Registrable;
import utils.TelefonoInvalido;

/**
 * Representa a un cliente que puede contratar servicios turísticos.
 */
public class Cliente extends Persona implements Registrable {

    /**
     * Crea un cliente con sus datos personales y de contacto.
     *
     * @param nombre nombre completo
     * @param rut RUT validado
     * @param direccion dirección de residencia
     * @param correo correo electrónico
     * @param telefono teléfono de contacto
     * @throws TelefonoInvalido si el teléfono no cumple el formato requerido
     */
    public Cliente(String nombre, Rut rut, Direccion direccion, String correo,
                   String telefono) throws TelefonoInvalido {
        super(nombre, rut, direccion, correo, telefono);

    }


    /**
     * Devuelve los datos heredados del cliente.
     *
     * @return representación textual del cliente
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Genera la información registrable del cliente.
     *
     * @return datos personales y de contacto
     */
    @Override
    public String mostrarInformacion() {
        return toString();
    }
}
