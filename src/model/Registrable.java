package model;

/**
 * Define el comportamiento común de las entidades que administra la agencia.
 */
public interface Registrable {
    /**
     * Genera un resumen con los datos relevantes de la entidad.
     *
     * @return resumen textual de la entidad
     */
    String mostrarInformacion();
}
