package data;

import model.Persona.GuiaTuristico;
import model.ServicioTuristico.ExcursionCultural;
import model.ServicioTuristico.PaseoLacustre;
import model.ServicioTuristico.RutaGastronomica;
import model.ServicioTuristico.ServicioTuristico;

import java.util.ArrayList;
import java.util.List;

/**
 * Carga, valida, crea y consulta los servicios turísticos de la agencia.
 */
public class GestorServicios {
    private List<ServicioTuristico> servicios;

      public GestorServicios() {
        servicios = new ArrayList<>();
    }

      public List<ServicioTuristico> getServicios() {
        return servicios;
    }


    /**
     * Procesa las líneas de tours y agrega a la colección los servicios válidos.
     *
     * @param lineas líneas obtenidas desde el archivo de tours
     * @param gestorPersonas gestor utilizado para localizar al guía asignado
     */
    public void cargarTours(List<String> lineas, GestorPersonas gestorPersonas) {
        int numeroLinea = 1;
        for (String linea : lineas) {
            ServicioTuristico servicio = procesarLineas(linea, numeroLinea, gestorPersonas);

            if (servicio != null) {
                servicios.add(servicio);
            }

            numeroLinea++;
        }

    }

    /**
     * Valida y transforma una línea del archivo en un servicio turístico.
     *
     * @param linea línea con los ocho campos del tour
     * @param numerolinea posición de la línea dentro del archivo
     * @param gestorPersonas gestor utilizado para buscar al guía por código
     * @return servicio creado o nulo cuando la línea no es válida
     */
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

    /**
     * Comprueba que los campos obligatorios de un tour tengan contenido.
     *
     * @param codigo código del servicio
     * @param nombre nombre del servicio
     * @param destino destino del tour
     * @param precioTexto precio antes de su conversión
     * @param duracionDiasTexto duración antes de su conversión
     * @param codigoGuia código del guía asignado
     * @param nombreGuia nombre informado para el guía
     * @param atributoParticularTour dato propio del subtipo de tour
     * @param numeroLinea posición de la línea dentro del archivo
     * @return verdadero si existe algún campo vacío; de lo contrario, devuelve falso
     */
    private boolean verificarCampoVacios(String codigo, String nombre, String destino, String precioTexto,
                                         String duracionDiasTexto, String codigoGuia, String nombreGuia,
                                         String atributoParticularTour, int numeroLinea) {
        if (codigo.isEmpty() || nombre.isEmpty() || destino.isEmpty() || precioTexto.isEmpty() ||
                duracionDiasTexto.isEmpty() || codigoGuia.isEmpty() || nombreGuia.isEmpty() ||
                atributoParticularTour.isEmpty()) {
            System.out.println("Línea " + numeroLinea + " omitida: contiene campos vacíos.");
            return true;
        }
        return false;
    }

    /**
     * Convierte y valida el precio de un servicio.
     *
     * @param precioTexto precio en formato de texto
     * @return precio convertido a número
     * @throws IllegalArgumentException si el valor no es numérico o no es mayor que cero
     */
    public double convertirPrecio(String precioTexto) {
        double precio = Double.parseDouble(precioTexto);
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que cero.");
        }
        return precio;
    }

    /**
     * Convierte y valida la duración de un servicio.
     *
     * @param duracionDiasTexto duración en formato de texto
     * @return duración convertida a número de días
     * @throws IllegalArgumentException si el valor no es numérico o no es mayor que cero
     */
    public double convertirDias(String duracionDiasTexto) {
        double duracion = Double.parseDouble(duracionDiasTexto);
        if (duracion <= 0) {
            throw new IllegalArgumentException("La duración de días debe ser mayor que cero.");
        }
        return duracion;
    }

    /**
     * Crea el subtipo de servicio determinado por su código.
     *
     * @param codigo código que identifica el subtipo de servicio
     * @param nombre nombre del servicio
     * @param destino destino del tour
     * @param precio precio del servicio
     * @param duracionDias duración del servicio en días
     * @param guia guía responsable
     * @param atributoParticularTour dato propio del subtipo
     * @return servicio turístico del subtipo correspondiente
     * @throws IllegalArgumentException si el código o el atributo particular no son válidos
     */
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

    /**
     * Convierte a entero el número de paradas de una ruta gastronómica.
     *
     * @param atributoParticularTour número de paradas en formato de texto
     * @return número de paradas convertido a entero
     * @throws IllegalArgumentException si el valor no es un entero
     */
    private int convertirAtributo(String atributoParticularTour) {
        try {
            return Integer.parseInt(atributoParticularTour);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El número de paradas debe ser un número entero.");
        }
    }

    /**
     * Busca un servicio por su código, sin distinguir mayúsculas y minúsculas.
     *
     * @param codigoBuscado código del servicio buscado
     * @return servicio encontrado o nulo si no existe
     */
    public ServicioTuristico buscarServicioPorCodigo(String codigoBuscado) {
        for (ServicioTuristico servicio : servicios) {
            if (servicio.getCodigo().equalsIgnoreCase(codigoBuscado)) {
                return servicio;
            }
        }
        return null;
    }

}
