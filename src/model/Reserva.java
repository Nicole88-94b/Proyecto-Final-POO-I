package model;

import model.persona.Cliente;
import model.servicio.ServicioTuristico;

/**
 * Representa la reserva de un servicio turístico realizada por un cliente.
 */
public class Reserva implements Registrable {


    private String codigoReserva;
    private Cliente cliente;
    private ServicioTuristico servicio;
    private int cantidadPersonas;
    private String estado;


    /**
     * Crea una reserva y valida todos sus datos.
     *
     * @param codigoReserva código único de la reserva
     * @param cliente cliente que realiza la reserva
     * @param servicio servicio turístico reservado
     * @param cantidadPersonas cantidad de pasajeros
     * @param estado estado inicial de la reserva
     * @throws IllegalArgumentException si algún dato no cumple las reglas de la reserva
     */
    public Reserva(String codigoReserva, Cliente cliente, ServicioTuristico servicio, int cantidadPersonas, String estado) {
        setCodigoReserva(codigoReserva);
        setCliente(cliente);
        setServicio(servicio);
        setCantidadPersonas(cantidadPersonas);
        setEstado(estado);

    }


    public String getCodigoReserva() {
        return codigoReserva;
    }

    /**
     * Valida y asigna el código de la reserva.
     *
     * @param codigoReserva nuevo código
     * @throws IllegalArgumentException si el código es nulo o está vacío
     */
    public void setCodigoReserva(String codigoReserva) {
        if (codigoReserva == null || codigoReserva.trim().isEmpty()) {
            throw new IllegalArgumentException("El código de la reserva debe ser válido.");
        }
        this.codigoReserva = codigoReserva;
    }


    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Valida y asigna el cliente de la reserva.
     *
     * @param cliente cliente que realiza la reserva
     * @throws IllegalArgumentException si el cliente es nulo
     */
    private void setCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Debe ingresar un cliente.");
        }
        this.cliente = cliente;
    }

    public ServicioTuristico getServicio() {
        return servicio;
    }

    /**
     * Valida y asigna el servicio turístico.
     *
     * @param servicio servicio que se desea reservar
     * @throws IllegalArgumentException si el servicio es nulo
     */
    private void setServicio(ServicioTuristico servicio) {
        if (servicio == null) {
            throw new IllegalArgumentException("Debe ingresar un servicio.");
        }
        this.servicio = servicio;
    }


    public int getCantidadPersonas() {
        return cantidadPersonas;
    }
    /**
     * Valida y asigna la cantidad de personas.
     *
     * @param cantidadPersonas nueva cantidad de pasajeros
     * @throws IllegalArgumentException si la cantidad no es mayor que cero
     */
    public void setCantidadPersonas(int cantidadPersonas) {
        if (cantidadPersonas <= 0) {
            throw new IllegalArgumentException("La cantidad de personas debe ser mayor que cero.");
        }
        this.cantidadPersonas = cantidadPersonas;
    }

    public String getEstado() {
        return estado;
    }

    /**
     * Valida, normaliza y asigna el estado de la reserva.
     *
     * @param estado estado nuevo
     * @throws IllegalArgumentException si no es PENDIENTE, CONFIRMADA o CANCELADA
     */
    public void setEstado(String estado) {
        if (estado == null || estado.trim().isEmpty()) {
            throw new IllegalArgumentException("Debe ingresar un estado.");
        }

        String estadoNormalizado = estado.trim().toUpperCase();
        if (!estadoNormalizado.matches("PENDIENTE|CONFIRMADA|CANCELADA")) {
            throw new IllegalArgumentException(
                    "Debe ingresar un estado válido: PENDIENTE, CONFIRMADA o CANCELADA."
            );
        }
        this.estado = estadoNormalizado;
    }

    /**
     * Devuelve todos los datos de la reserva.
     *
     * @return representación textual de la reserva
     */
    @Override
    public String toString() {
        return "Reserva: " +
                "\nCódigo de la reserva: " + codigoReserva +
                "\nCliente: " + cliente +
                "\nServicio: " + servicio +
                "\nCantidad de personas: " + cantidadPersonas +
                "\nEstado: " + estado;
    }

    /**
     * Genera la información registrable de la reserva.
     *
     * @return datos completos de la reserva
     */
    @Override
    public String mostrarInformacion() {
        return toString();
    }

}
