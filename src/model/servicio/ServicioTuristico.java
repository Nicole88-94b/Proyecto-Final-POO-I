package model.servicio;

import model.persona.GuiaTuristico;
import model.Registrable;

/**
 * Clase base que contiene los datos comunes de los servicios turísticos.
 */
public class ServicioTuristico implements Registrable {
    private String codigo;
    private String nombre;
    private String destino;
    private double precio;
    private double duracionDias;
    private GuiaTuristico guia;


    /**
     * Crea un servicio con sus datos principales.
     *
     * @param codigo        código utilizado para identificar y filtrar el servicio
     * @param nombre        nombre del recorrido o ruta
     * @param destino       lugar donde se realizarán las actividades
     * @param precio        valor total del servicio
     * @param duracionDias total de días que durará el servicio
     * @param guia guía responsable del servicio
     * @throws IllegalArgumentException si el precio o la duración no son mayores que cero
     */
    public ServicioTuristico(String codigo, String nombre, String destino, double precio, double duracionDias,
                             GuiaTuristico guia) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.destino = destino;
        setPrecio(precio);
        setDuracionDias(duracionDias);
        this.guia = guia;

    }

    /**
     * Obtiene el código del servicio.
     *
     * @return código del servicio
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Asigna el código del servicio.
     *
     * @param codigo nuevo código
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtiene el nombre del servicio.
     *
     * @return nombre del tour
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna el nombre del servicio.
     *
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el destino del servicio.
     *
     * @return destino del tour
     */
    public String getDestino() {
        return destino;
    }

    /**
     * Asigna el destino del servicio.
     *
     * @param destino nuevo destino
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * Obtiene el precio del servicio.
     *
     * @return precio registrado
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Asigna el precio por persona.
     *
     * @param precio nuevo precio del servicio
     * @throws IllegalArgumentException si el precio no es mayor que cero
     */
    public void setPrecio(double precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que cero.");
        }
        this.precio = precio;
    }


    /**
     * Obtiene la duración del servicio.
     *
     * @return duración en días
     */
    public double getDuracionDias() {
        return duracionDias;
    }

    /**
     * Asigna la duración del servicio.
     *
     * @param duracionDias nueva duración en días
     * @throws IllegalArgumentException si la duración no es mayor que cero
     */
    public void setDuracionDias(double duracionDias) {
        if (duracionDias <= 0) {
            throw new IllegalArgumentException("El número de días debe ser mayor que cero.");
        }
        this.duracionDias = duracionDias;
    }

    /**
     * Devuelve los datos comunes del servicio y del guía responsable.
     *
     * @return representación textual del servicio
     */
    @Override
    public String toString() {
        return "\nServicio Turístico programado: " +
                "\nCódigo: " + codigo +
                " \nNombre: " + nombre +
                " \nDestino: " + destino +
                " \nPrecio: $" + precio +
                " \nDuración en días: " + duracionDias
                + "\nGuía responsable: " + guia.getCodigoGuia() + " " + guia.getNombre() + ".";
    }

    /**
     * Genera la información registrable del servicio.
     *
     * @return datos completos del servicio
     */
    @Override
    public String mostrarInformacion() {
        return toString();
    }
}
