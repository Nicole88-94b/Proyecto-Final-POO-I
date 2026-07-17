package model.ServicioTuristico;

import model.Persona.GuiaTuristico;
import model.Registrable;

/**
 * Representa un paseo lacustre realizado en una embarcación determinada.
 */
public class PaseoLacustre extends ServicioTuristico implements Registrable {
    private String tipoEmbarcacion;

    /**
     * Crea un paseo lacustre con sus datos principales y el guía asignado.
     *
     * @param codigo        código del servicio
     * @param nombre        nombre del servicio turístico
     * @param destino       destino del recorrido
     * @param precio        precio por persona
     * @param duracionDias número de días que dura el tour
     * @param guia          guía responsable del recorrido
     * @param tipoEmbarcacion tipo de embarcación usada para el recorrido
     * @throws IllegalArgumentException si el precio o la duración no son mayores que cero
     */
    public PaseoLacustre(String codigo, String nombre, String destino, double precio, double duracionDias, GuiaTuristico guia, String tipoEmbarcacion) {
        super(codigo, nombre, destino, precio, duracionDias, guia);
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    /**
     * Obtiene el tipo de embarcación del paseo.
     *
     * @return tipo de embarcación
     */
    public String getTipoEmbarcacion() {
        return tipoEmbarcacion;
    }

    /**
     * Asigna el tipo de embarcación del paseo.
     *
     * @param tipoEmbarcacion nueva embarcación
     */
    public void setTipoEmbarcacion(String tipoEmbarcacion) {
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    /**
     * Devuelve los datos comunes y el tipo de embarcación.
     *
     * @return representación textual del paseo
     */
    @Override
    public String toString() {
        return super.toString() + "\nTipo de embarcación a usar: " + tipoEmbarcacion + ".";
    }

    /**
     * Genera la información registrable del paseo.
     *
     * @return datos completos del paseo lacustre
     */
    @Override
    public String mostrarInformacion() {
        return toString();
    }
}
