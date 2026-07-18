package model.persona;

import model.Registrable;
import utils.TelefonoInvalido;

/**
 * Representa a un guía turístico identificado por un código interno.
 */
public class GuiaTuristico extends Persona implements Registrable {
    private String codigoGuia;

    /**
     * Crea un guía con sus datos personales y su código interno.
     *
     * @param nombre nombre completo
     * @param rut RUT validado
     * @param direccion dirección de residencia
     * @param correo correo electrónico
     * @param telefono teléfono de contacto
     * @param codigoGuia código utilizado para asignar servicios
     * @throws TelefonoInvalido si el teléfono no cumple el formato requerido
     */
    public GuiaTuristico(String nombre, Rut rut, Direccion direccion, String correo, String telefono,
                         String codigoGuia) throws TelefonoInvalido {
        super(nombre, rut, direccion, correo, telefono);
        this.codigoGuia = codigoGuia;
    }

    public String getCodigoGuia() {
        return codigoGuia;
    }

    public void setCodigoGuia(String codigoGuia) {
        this.codigoGuia = codigoGuia;
    }

    /**
     * Devuelve el código y los datos personales del guía.
     *
     * @return representación textual del guía
     */
    @Override
    public String toString() {
        return "Guía Turístico: \n" +
                "Código: " + codigoGuia + "\n" + super.toString();
    }

    /**
     * Genera la información registrable del guía.
     *
     * @return código y datos personales del guía
     */
    @Override
    public String mostrarInformacion() {
    return toString();
    }
}
