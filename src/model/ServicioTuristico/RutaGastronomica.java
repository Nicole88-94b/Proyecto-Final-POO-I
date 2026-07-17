package model.ServicioTuristico;

import model.Persona.GuiaTuristico;
import model.Registrable;

/**
 * Representa una ruta gastronómica ofrecida por la agencia.
 */
public class RutaGastronomica extends ServicioTuristico implements Registrable {
    private int numeroDeParadas;

    /**
     * Crea una ruta gastronómica con sus datos principales y el guía asignado.
     *
     * @param codigo          código del servicio
     * @param nombre          nombre del servicio turístico
     * @param destino         destino del recorrido
     * @param precio          precio por persona
     * @param duracionDias   número de días que dura el tour
     * @param guia            guía responsable del recorrido
     * @param numeroDeParadas número de paradas que tendrá el tour
     * @throws IllegalArgumentException si el precio, la duración o el número de paradas no son mayores que cero
     */
    public RutaGastronomica(String codigo, String nombre, String destino, double precio, double duracionDias, GuiaTuristico guia, int numeroDeParadas) {
        super(codigo, nombre, destino, precio, duracionDias, guia);
        setNumeroDeParadas(numeroDeParadas);
    }


    /**
     * Obtiene el número de paradas de la ruta.
     *
     * @return cantidad de paradas planificadas
     */
    public int getNumeroDeParadas() {
        return numeroDeParadas;
    }

    /**
     * Asigna el número de paradas planificadas.
     *
     * @param numeroDeParadas nuevo número de paradas
     * @throws IllegalArgumentException si el número no es mayor que cero
     */
    public void setNumeroDeParadas(int numeroDeParadas) {
        if (numeroDeParadas <= 0) {
            throw new IllegalArgumentException("El número de paradas debe ser mayor que cero.");
        }
        this.numeroDeParadas = numeroDeParadas;
    }

    /**
     * Devuelve los datos comunes y el número de paradas.
     *
     * @return representación textual de la ruta
     */
    @Override
    public String toString() {
        return super.toString() + "\nNúmero de paradas planificadas: " + numeroDeParadas + ".";
    }

    /**
     * Genera la información registrable de la ruta.
     *
     * @return datos completos de la ruta gastronómica
     */
    @Override
    public String mostrarInformacion() {
        return toString();
    }

}
