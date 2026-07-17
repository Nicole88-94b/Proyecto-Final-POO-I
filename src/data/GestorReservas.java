package data;

import model.Reserva;

import java.util.HashMap;
import java.util.Map;

/**
 * Administra reservas en memoria, utilizando su código como clave única.
 */
public class GestorReservas {
    private Map<String, Reserva> reservas;


    public GestorReservas() {
        reservas = new HashMap<>();
    }

    /**
     * Agrega una reserva si es válida y su código aún no está registrado.
     *
     * @param reserva reserva que se desea almacenar
     * @throws IllegalArgumentException si la reserva es nula o su código ya existe
     */
    public void agregarReserva(Reserva reserva){
        if (reserva == null) {
            throw new IllegalArgumentException("La reserva no puede ser nula.");
        }

        String codigo = reserva.getCodigoReserva();
        if (reservas.containsKey(codigo)) {
            throw new IllegalArgumentException("Ya existe una reserva con el código " + codigo);
        }

        reservas.put(codigo, reserva);
    }
    /**
     * Busca una reserva mediante su código.
     *
     * @param codigo código de la reserva buscada
     * @return reserva asociada al código o nulo si no existe
     */
    public Reserva buscarReservaPorCodigo(String codigo){
        return reservas.get(codigo);
    }
    /**
     * Obtiene las reservas administradas, indexadas por código.
     *
     * @return mapa de reservas
     */
    public Map<String, Reserva> getReservas(){
        return reservas;
    }

}
