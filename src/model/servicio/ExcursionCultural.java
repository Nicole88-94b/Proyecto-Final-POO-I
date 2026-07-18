package model.servicio;

import model.persona.GuiaTuristico;
import model.Registrable;

/**
 * Representa una excursión cultural asociada a un lugar turístico.
 */
public class ExcursionCultural extends ServicioTuristico implements Registrable {
    private String lugarTuristico;
    /**
     * Crea una excursión cultural con sus datos principales y el guía asignado.
     *
     * @param codigo        código del servicio
     * @param nombre        nombre del servicio turístico
     * @param destino       destino del recorrido
     * @param precio        precio por persona
     * @param duracionDias número de días que dura el tour
     * @param guia          guía responsable del recorrido
     * @param lugarTuristico lugar en donde se llevará a cabo el tour
     * @throws IllegalArgumentException si el precio o la duración no son mayores que cero
     */
    public ExcursionCultural(String codigo, String nombre, String destino, double precio, double duracionDias, GuiaTuristico guia, String lugarTuristico) {
        super(codigo, nombre, destino, precio, duracionDias, guia);
        this.lugarTuristico = lugarTuristico;
    }

    /**
     * Obtiene el lugar turístico de la excursión.
     *
     * @return lugar visitado durante el tour
     */
    public String getLugarTuristico() {
        return lugarTuristico;
    }

    /**
     * Asigna el lugar turístico de la excursión.
     *
     * @param lugarTuristico nuevo lugar del tour
     */
    public void setLugarTuristico(String lugarTuristico) {
        this.lugarTuristico = lugarTuristico;
    }

    /**
     * Devuelve los datos comunes y el lugar turístico.
     *
     * @return representación textual de la excursión
     */
    @Override
    public String toString() {
        return super.toString() + "\nLugar del tour: " + lugarTuristico + "." ;
    }

    /**
     * Genera la información registrable de la excursión.
     *
     * @return datos completos de la excursión cultural
     */
    @Override
    public String mostrarInformacion() {
        return toString();
    }

}
