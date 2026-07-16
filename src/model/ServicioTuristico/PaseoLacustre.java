package model.ServicioTuristico;

import model.Persona.GuiaTuristico;
import model.Registrable;

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

    public String getTipoEmbarcacion() {
        return tipoEmbarcacion;
    }

    public void setTipoEmbarcacion(String tipoEmbarcacion) {
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTipo de embarcación a usar: " + tipoEmbarcacion + ".";
    }

    @Override
    public String mostrarInformacion() {
        return toString();
    }
}
