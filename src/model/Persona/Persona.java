package model.Persona;

import model.Registrable;
import utils.TelefonoInvalido;

/**
 * Clase base de las personas vinculadas con la agencia.
 */
public abstract class Persona implements Registrable {
    private String nombre;
    private Rut rut;
    private Direccion direccion;
    private String correo;
    private String telefono;

    /**
     * Crea una persona con sus datos personales y de contacto.
     *
     * @param nombre nombre completo
     * @param rut RUT validado de la persona
     * @param direccion dirección de residencia
     * @param correo correo electrónico
     * @param telefono teléfono en formato chileno móvil
     * @throws TelefonoInvalido si el teléfono no cumple el formato requerido
     */
    public Persona(String nombre, Rut rut, Direccion direccion, String correo, String telefono)
            throws TelefonoInvalido {
        this.nombre = nombre;
        this.rut = rut;
        this.direccion = direccion;
        this.correo = correo;
        setTelefono(telefono);
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Rut getRut() {
        return rut;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    /**
     * Valida y asigna el teléfono de contacto.
     *
     * @param telefono teléfono con el formato {@code +56912345678}
     * @throws TelefonoInvalido si el teléfono es nulo, está vacío o no cumple el formato
     */
    public void setTelefono(String telefono) throws TelefonoInvalido {
        if (telefono == null || telefono.isEmpty() || !telefono.matches("\\+569\\d{8}")) {
            throw new TelefonoInvalido("Teléfono invalido, debe registrar el número como +56912345678");
        }
        this.telefono = telefono;
    }

    /**
     * Devuelve los datos personales y de contacto.
     *
     * @return representación textual de la persona
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre +
                rut.toString()
                + direccion.toString() +
                "\nCorreo: " + correo +
                "\nTeléfono: " + telefono;
    }

}
