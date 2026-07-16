package ui;

import data.GestorArchivos;
import data.GestorPersonas;
import data.GestorServicios;
import model.Persona.Direccion;
import model.Persona.GuiaTuristico;
import model.Persona.Rut;
import model.ServicioTuristico.ServicioTuristico;
import utils.RutInvalido;
import utils.TelefonoInvalido;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GestorPersonas gestorPersonas = new GestorPersonas();
        try {
            Rut rutGuia = new Rut("12345678-9");
            Direccion direccionGuia =
                    new Direccion("Los Alerces", 125, "Los Lagos");

            GuiaTuristico guia = new GuiaTuristico(
                    "Camila Soto",
                    rutGuia,
                    direccionGuia,
                    "camila@llanquihuetour.cl",
                    "+56912345678",
                    "GUI-001"
            );

            gestorPersonas.agregarPersona(guia);

            System.out.println(guia);

        } catch (RutInvalido | TelefonoInvalido e) {
            System.out.println("No se pudo crear el guía: " + e.getMessage());
        }
        GuiaTuristico guiaEncontrado =
                gestorPersonas.buscarGuiaPorCodigo("GUI-001");

        if (guiaEncontrado != null) {
            System.out.println("Guía encontrado:");
            System.out.println(guiaEncontrado);
        } else {
            System.out.println("No se encontró el guía.");
        }
        GestorArchivos gestorArchivos = new GestorArchivos();
        List<String> lineasTours = gestorArchivos.listaTours();

        GestorServicios gestorServicios = new GestorServicios();
        gestorServicios.cargarTours(lineasTours, gestorPersonas);


        for (ServicioTuristico servicio : gestorServicios.getServicios()) {
            System.out.println(servicio.mostrarInformacion());
        }
    }


}
