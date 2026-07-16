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
     * @param duracionHoras   número de horas que dura el tour
     * @param guia            guía responsable del recorrido
     * @param numeroDeParadas número de paradas que tendrá el tour
     * @throws IllegalArgumentException si el precio, la duración o el número de paradas no son mayores que cero
     */
    public RutaGastronomica(String codigo, String nombre, String destino, double precio, double duracionHoras, GuiaTuristico guia, int numeroDeParadas) {
        super(codigo, nombre, destino, precio, duracionHoras, guia);
        setNumeroDeParadas(numeroDeParadas);
    }


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
    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() +
                "\nNúmero de paradas planificadas: " + numeroDeParadas + ".";
    }

}
