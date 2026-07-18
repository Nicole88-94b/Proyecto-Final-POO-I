package ui;

import data.GestorArchivos;
import data.GestorPersonas;
import data.GestorReservas;
import data.GestorServicios;

import model.Registrable;
import model.Reserva;
import model.persona.Cliente;
import model.persona.GuiaTuristico;

import model.servicio.ServicioTuristico;

import java.util.ArrayList;
import java.util.List;

/**
 * Punto de entrada que demuestra la carga y consulta de los datos de la agencia.
 */
public class Main {
    /**
     * Carga clientes, guías, colaboradores y tours desde los archivos de recursos,
     * realiza búsquedas de ejemplo y muestra los resultados por consola.
     *
     * @param args argumentos de línea de comandos; no se utilizan
     */
    public static void main(String[] args) {

        GestorArchivos gestorArchivos = new GestorArchivos();
        GestorPersonas gestorPersonas = new GestorPersonas();
        List<String> lineasClientes = gestorArchivos.listaClientes();
        gestorPersonas.cargarClientes(lineasClientes);
        Cliente clienteEncontrado = gestorPersonas.buscarClientePorRut("98765432-1");

        if (clienteEncontrado != null) {
            System.out.println("Cliente encontrado:");
            System.out.println(clienteEncontrado);
        } else {
            System.out.println("Cliente no encontrado.");
        }

        List<String> lineasPersonas = gestorArchivos.listaGuiasColaboradores();
        gestorPersonas.cargarPersonas(lineasPersonas);

        GuiaTuristico guiaEncontrado = gestorPersonas.buscarGuiaPorCodigo("GUI-001");

        if (guiaEncontrado != null) {
            System.out.println("Guía encontrado:");
            System.out.println(guiaEncontrado);
            System.out.println("--------------------");
        } else {
            System.out.println("No se encontró el guía.");
            System.out.println("--------------------");
        }

        List<String> lineasTours = gestorArchivos.listaTours();

        GestorServicios gestorServicios = new GestorServicios();
        gestorServicios.cargarTours(lineasTours, gestorPersonas);

        for (ServicioTuristico servicio : gestorServicios.getServicios()) {
            System.out.println(servicio.mostrarInformacion());
        }

        ServicioTuristico servicioEncontrado = gestorServicios.buscarServicioPorCodigo("01GA");

        GestorReservas gestorReservas = new GestorReservas();

        if (clienteEncontrado != null && servicioEncontrado != null) {
            gestorReservas.agregarReserva("RES-001", clienteEncontrado, servicioEncontrado, 2,
                    "CONFIRMADA");

            Reserva reservaEncontrada = gestorReservas.buscarReservaPorCodigo("RES-001");

            System.out.println("\nReserva encontrada:");
            System.out.println(reservaEncontrada.mostrarInformacion());
            System.out.println("--------------------");
        }

        List<Registrable> registros = new ArrayList<>();

        registros.addAll(gestorPersonas.getPersonas());
        registros.addAll(gestorServicios.getServicios());
        registros.addAll(gestorReservas.getReservas().values());

        System.out.println("\nListado polimórfico:");

        for (Registrable registro : registros) {
            System.out.println(registro.mostrarInformacion());
            System.out.println("--------------------");
        }

    }


}
