package model.ServicioTuristico;

import model.Persona.GuiaTuristico;
import model.Registrable;

/**
 * Clase base que contiene los datos comunes de los servicios turísticos.
 */
public class ServicioTuristico implements Registrable {
    private String codigo;
    private String nombre;
    private String destino;
    private double precio;
    private double duracionHoras;
    private GuiaTuristico guia;


    /**
     * Crea un servicio con sus datos principales.
     *
     * @param codigo        código utilizado para identificar y filtrar el servicio
     * @param nombre        nombre del recorrido o ruta
     * @param destino       lugar donde se realizarán las actividades
     * @param precio        valor total del servicio
     * @param duracionHoras total de horas que durará el servicio
     * @throws IllegalArgumentException si el precio o la duración no son mayores que cero
     */
    public ServicioTuristico(String codigo, String nombre, String destino, double precio, double duracionHoras, GuiaTuristico guia) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.destino = destino;
        setPrecio(precio);
        setDuracionHoras(duracionHoras);
        this.guia = guia;

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

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


    public double getDuracionHoras() {
        return duracionHoras;
    }

    /**
     * Asigna la duración del servicio.
     *
     * @param duracionHoras nueva duración en horas
     * @throws IllegalArgumentException si la duración no es mayor que cero
     */
    public void setDuracionHoras(double duracionHoras) {
        if (duracionHoras <= 0) {
            throw new IllegalArgumentException("El número de horas debe ser mayor que cero.");
        }
        this.duracionHoras = duracionHoras;
    }


    @Override
    public String mostrarInformacion() {
        return "Servicio Turístico programado: " +
                "\nCódigo: " + codigo +
                " \nNombre: " + nombre +
                " \nDestino: " + destino +
                " \nPrecio: $" + precio +
                " \nDuración en horas: " + duracionHoras
                + "\nGuía responsable: " + guia.getCodigoGuia() + " " + guia.getNombre() + ".";
    }
}
