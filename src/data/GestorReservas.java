package data;

import model.Reserva;
import model.persona.Cliente;
import model.servicio.ServicioTuristico;

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
    public void agregarReserva(Reserva reserva) {
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
     * Crea y agrega una reserva a partir de sus datos principales.
     *
     * @param codigo           código único de la reserva
     * @param cliente          cliente que realiza la reserva
     * @param servicio         servicio turístico reservado
     * @param cantidadPersonas cantidad de pasajeros
     * @param estado           estado inicial de la reserva
     * @throws IllegalArgumentException si los datos son inválidos o el código ya existe
     */
    public void agregarReserva(String codigo, Cliente cliente, ServicioTuristico servicio, int cantidadPersonas,
                               String estado) {
        Reserva reserva = new Reserva(codigo, cliente, servicio, cantidadPersonas, estado);

        agregarReserva(reserva);
    }

    /**
     * Busca una reserva mediante su código.
     *
     * @param codigo código de la reserva buscada
     * @return reserva asociada al código o nulo si no existe
     */
    public Reserva buscarReservaPorCodigo(String codigo) {
        return reservas.get(codigo);
    }

    /**
     * Obtiene las reservas administradas, indexadas por código.
     *
     * @return mapa de reservas
     */
    public Map<String, Reserva> getReservas() {
        return reservas;
    }

}
