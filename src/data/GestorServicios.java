package data;

import model.Persona.GuiaTuristico;
import model.ServicioTuristico.ExcursionCultural;
import model.ServicioTuristico.PaseoLacustre;
import model.ServicioTuristico.RutaGastronomica;
import model.ServicioTuristico.ServicioTuristico;

import java.util.ArrayList;
import java.util.List;

public class GestorServicios {
private List<ServicioTuristico> servicios;

public GestorServicios() {
    servicios = new ArrayList<>();
}

    public List<ServicioTuristico> getServicios() {
        return servicios;
    }


   public void cargarTours (List<String> lineas, GestorPersonas gestorPersonas) {
    int numeroLinea= 1;
       for (String linea : lineas) {
           ServicioTuristico servicio = procesarLineas(linea, numeroLinea, gestorPersonas);

           if (servicio != null) {
               servicios.add(servicio);
           }

           numeroLinea++;
       }

    }

    private ServicioTuristico procesarLineas(String linea, int numerolinea, GestorPersonas gestorPersonas) {
        String datos[] = linea.split(";", -1);
        if (datos.length != 8) {
            System.out.println("Error de lectura: la línea número " + numerolinea + " debe contener 8 campos.");
            return null;
        }

        String codigo = datos[0].trim();
        String nombre = datos[1].trim();
        String destino = datos[2].trim();
        String precioTexto = datos[3].trim();
        String duracionDiasTexto = datos[4].trim();
        String codigoGuia = datos[5].trim();
        String nombreGuia = datos[6].trim();
        String atributoParticularTour = datos[7].trim();

        if (verificarCampoVacios(codigo, nombre, destino, precioTexto, duracionDiasTexto, codigoGuia,
                nombreGuia, atributoParticularTour, numerolinea)) {
            return null;
        }

        try {
            double validarprecio = convertirPrecio(precioTexto);
            double validarDias = convertirDias(duracionDiasTexto);
            GuiaTuristico guia = gestorPersonas.buscarGuiaPorCodigo(codigoGuia);
            if (guia == null) {
                System.out.println("Línea " + numerolinea + " omitida. No existe código del guía");
                return null;
            }
            return crearServicio(codigo, nombre, destino, validarprecio, validarDias, guia, atributoParticularTour);
        } catch (IllegalArgumentException e) {
            System.out.println("Línea " + numerolinea + " omitida: " + e.getMessage());
            return null;
        }


    }

    private boolean verificarCampoVacios(String codigo, String nombre, String destino, String precioTexto,
                                         String duracionDiasTexto, String codigoGuia, String nombreGuia,
                                         String atributoParticularTour, int numeroLinea) {
        if (codigo.isEmpty() || nombre.isEmpty() || destino.isEmpty() || precioTexto.isEmpty() ||
                duracionDiasTexto.isEmpty() ||  codigoGuia.isEmpty() || nombreGuia.isEmpty() ||
                atributoParticularTour.isEmpty()) {
            System.out.println("Línea " + numeroLinea + " omitida: contiene campos vacíos.");
            return true;
        }
        return false;
    }

public double convertirPrecio(String precioTexto) {
    double precio = Double.parseDouble(precioTexto);
    if (precio <= 0) {
        throw new IllegalArgumentException("El precio debe ser mayor que cero.");
    }
    return precio;
}

public double convertirDias(String duracionDiasTexto) {
    double duracion = Double.parseDouble(duracionDiasTexto);
    if (duracion <= 0) {
        throw new IllegalArgumentException("La duración de días debe ser mayor que cero.");
    }
    return duracion;
}

public ServicioTuristico crearServicio(String codigo, String nombre, String destino, double precio, double duracionDias,
                                       GuiaTuristico guia, String atributoParticularTour) {
    switch (codigo) {
        case "01GA":
            int numeroParadas = convertirAtributo(atributoParticularTour);
            return new RutaGastronomica(codigo, nombre, destino, precio, duracionDias, guia, numeroParadas);

        case "02LA":
            return new PaseoLacustre(codigo, nombre, destino, precio, duracionDias, guia, atributoParticularTour);

        case "03CU":
            return new ExcursionCultural(codigo, nombre, destino, precio, duracionDias, guia, atributoParticularTour);

        default:
            throw new IllegalArgumentException("Código desconocido.");
    }
}

    private int convertirAtributo(String atributoParticularTour) {
        try {
            return Integer.parseInt(atributoParticularTour);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El número de paradas debe ser un número entero.");
        }
    }


}
