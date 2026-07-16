package model.Persona;

import model.Registrable;
import utils.TelefonoInvalido;

public abstract class Persona implements Registrable {
    private String nombre;
    private Rut rut;
    private Direccion direccion;
    private String correo;
    private String telefono;

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


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) throws TelefonoInvalido {
        if (telefono == null || telefono.isEmpty() || !telefono.matches("\\+569\\d{8}")) {
            throw new TelefonoInvalido("Teléfono invalido, debe registrar el número como +56912345678");
        }
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                rut.toString()
                + direccion.toString() +
                "\nCorreo: " + correo +
                "\nTeléfono: " + telefono;
    }

}
