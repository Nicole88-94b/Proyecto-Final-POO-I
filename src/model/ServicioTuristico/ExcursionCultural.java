package model.ServicioTuristico;

import model.Persona.GuiaTuristico;
import model.Registrable;

public class ExcursionCultural extends ServicioTuristico implements Registrable {
    private String lugarTuristico;
    /**
     * Crea una excursión cultural con sus datos principales y el guía asignado.
     *
     * @param codigo        código del servicio
     * @param nombre        nombre del servicio turístico
     * @param destino       destino del recorrido
     * @param precio        precio por persona
     * @param duracionHoras número de horas que dura el tour
     * @param guia          guía responsable del recorrido
     * @param lugarTuristico lugar en donde se llevará a cabo el tour
     * @throws IllegalArgumentException si el precio o la duración no son mayores que cero
     */
    public ExcursionCultural(String codigo, String nombre, String destino, double precio, double duracionHoras, GuiaTuristico guia, String lugarTuristico) {
        super(codigo, nombre, destino, precio, duracionHoras, guia);
        this.lugarTuristico = lugarTuristico;
    }

    public String getLugarTuristico() {
        return lugarTuristico;
    }

    public void setLugarTuristico(String lugarTuristico) {
        this.lugarTuristico = lugarTuristico;
    }

    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() +
                "\nLugar del tour: " + lugarTuristico + ".";
    }

}
