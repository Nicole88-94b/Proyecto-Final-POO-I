package data;

import model.Persona.*;
import utils.RutInvalido;
import utils.TelefonoInvalido;

import java.util.ArrayList;
import java.util.List;

/**
 * Carga, valida, almacena y consulta las personas vinculadas con la agencia.
 */
public class GestorPersonas {
    private List<Persona> personas;


    public GestorPersonas() {
        personas = new ArrayList<>();
    }


    public List<Persona> getPersonas() {
        return personas;
    }

    /**
     * Agrega una persona a la colección.
     *
     * @param persona persona que se desea almacenar
     */
    public void agregarPersona(Persona persona) {
        personas.add(persona);
    }

    /**
     * Busca un guía turístico mediante su código.
     *
     * @param codigoBuscado código del guía buscado
     * @return guía encontrado o nulo si no existe
     */
    public GuiaTuristico buscarGuiaPorCodigo(String codigoBuscado) {
        for (Persona persona : personas) {
            if (persona instanceof GuiaTuristico) {
                GuiaTuristico guiaTuristico = (GuiaTuristico) persona;
                if (guiaTuristico.getCodigoGuia().equals(codigoBuscado)) {
                    return guiaTuristico;
                }
            }
        }
        return null;
    }

    /**
     * Procesa las líneas de guías y colaboradores y almacena las válidas.
     *
     * @param lineas líneas obtenidas desde el archivo de personas
     */
    public void cargarPersonas(List<String> lineas) {
        int numeroLinea = 1;
        for (String linea : lineas) {
            Persona persona = procesarLineas(linea, numeroLinea);

            if (persona != null) {
                personas.add(persona);
            }

            numeroLinea++;
        }
    }

    /**
     * Valida y transforma una línea en un guía o colaborador externo.
     *
     * @param linea línea con los nueve campos de la persona
     * @param numeroLinea posición de la línea dentro del archivo
     * @return persona creada o nulo cuando la línea no es válida
     */
    private Persona procesarLineas(String linea, int numeroLinea) {
        String datos[] = linea.split(";", -1);
        if (datos.length != 9) {
            System.out.println("Error de lectura: la línea número " + numeroLinea + " debe contener 9 campos.");
            return null;
        }

        String tipo = datos[0].trim().toUpperCase();
        String nombre = datos[1].trim();
        String rut = datos[2].trim();
        String direccionCalle = datos[3].trim();
        String direccionNumero = datos[4].trim();
        String direccionRegion = datos[5].trim();
        String correo = datos[6].trim();
        String telefono = datos[7].trim();
        String atributoParticular = datos[8].trim();

        if (verificarCampoVacios(tipo, nombre, rut, direccionCalle, direccionNumero, direccionRegion,
                correo, telefono, atributoParticular, numeroLinea)) {
            return null;
        }
        try {
            Rut rutPersona = new Rut(rut);
            int numeroDireccion = convertirDireccionNumero(direccionNumero);
            Direccion direccion = new Direccion(direccionCalle, numeroDireccion, direccionRegion);

            return crearGuiaColaborador(tipo, nombre, rutPersona, direccion, correo,
                    telefono, atributoParticular);
        } catch (IllegalArgumentException | RutInvalido | TelefonoInvalido e) {
            System.out.println("Línea " + numeroLinea + " omitida: " + e.getMessage());
            return null;
        }
    }


    /**
     * Comprueba que los campos de un guía o colaborador tengan contenido.
     *
     * @param tipo tipo de persona
     * @param nombre nombre completo
     * @param rut RUT sin puntos
     * @param direccionCalle calle de la dirección
     * @param direccionNumero número de la dirección antes de su conversión
     * @param direccionRegion región de residencia
     * @param correo correo electrónico
     * @param telefono teléfono de contacto
     * @param atributoParticular código de guía o tipo de colaboración
     * @param numeroLinea posición de la línea dentro del archivo
     * @return verdadero si existe algún campo vacío; de lo contrario, devuelve falso
     */
    private boolean verificarCampoVacios(String tipo, String nombre, String rut, String direccionCalle, String
                                                 direccionNumero, String direccionRegion, String correo, String telefono, String atributoParticular,
                                         int numeroLinea) {
        if (tipo.isEmpty() || nombre.isEmpty() || rut.isEmpty() || direccionCalle.isEmpty() || direccionNumero.isEmpty()
                || direccionRegion.isEmpty() || correo.isEmpty() || telefono.isEmpty() || atributoParticular.isEmpty()) {
            System.out.println("Línea " + numeroLinea + " omitida: contiene campos vacíos.");
            return true;
        }
        return false;
    }


    /**
     * Convierte y valida el número de una dirección.
     *
     * @param direccionNumero número en formato de texto
     * @return número de dirección convertido a entero
     * @throws IllegalArgumentException si el valor no es numérico o no es mayor que cero
     */
    private int convertirDireccionNumero(String direccionNumero) {
        int direccionNumerica = Integer.parseInt(direccionNumero);
        if (direccionNumerica <= 0) {
            throw new IllegalArgumentException("La dirección debe ser mayor que cero.");
        }
        return direccionNumerica;
    }

    /**
     * Crea un guía turístico o un colaborador según el tipo indicado.
     *
     * @param tipo tipo de persona esperado
     * @param nombre nombre completo
     * @param rut RUT validado
     * @param direccion dirección de la persona
     * @param correo correo electrónico
     * @param telefono teléfono de contacto
     * @param atributoParticular código de guía o tipo de colaboración
     * @return guía o colaborador creado
     * @throws TelefonoInvalido si el teléfono no cumple el formato requerido
     * @throws IllegalArgumentException si el tipo no es reconocido
     */
    private Persona crearGuiaColaborador(String tipo, String nombre, Rut rut,
                                         Direccion direccion, String correo, String telefono,
                                         String atributoParticular) throws TelefonoInvalido {
        switch (tipo) {
            case "GUIA":
                return new GuiaTuristico(nombre, rut, direccion, correo, telefono, atributoParticular);

            case "COLABORADOR":
                return new ColaboradorExterno(nombre, rut, direccion, correo, telefono, atributoParticular);

            default:
                throw new IllegalArgumentException("Tipo de guía o colaborador desconocido.");
        }
    }

    /**
     * Busca un cliente mediante su RUT, sin distinguir mayúsculas y minúsculas.
     *
     * @param rutBuscado RUT del cliente buscado
     * @return cliente encontrado o nulo si no existe
     */
    public Cliente buscarClientePorRut(String rutBuscado) {
        for (Persona persona : personas) {
            if (persona instanceof Cliente) {
                Cliente cliente = (Cliente) persona;
                if (cliente.getRut().getNumeroRut().equalsIgnoreCase(rutBuscado)) {
                    return cliente;
                }
            }
        }
        return null;
    }

    /**
     * Procesa las líneas de clientes y almacena los registros válidos.
     *
     * @param lineas líneas obtenidas desde el archivo de clientes
     */
    public void cargarClientes(List<String> lineas) {
        int numeroLinea = 1;
        for (String linea : lineas) {
            Cliente cliente = procesarClientes(linea, numeroLinea);

            if (cliente != null) {
                personas.add(cliente);
            }

            numeroLinea++;
        }
    }

    /**
     * Valida y transforma una línea del archivo en un cliente.
     *
     * @param linea línea con los ocho campos del cliente
     * @param numeroLinea posición de la línea dentro del archivo
     * @return cliente creado o nulo cuando la línea no es válida
     */
    public Cliente procesarClientes(String linea, int numeroLinea) {
        String datos[] = linea.split(";", -1);
        if (datos.length != 8) {
            System.out.println("Error de lectura: la línea número " + numeroLinea + " debe contener 8 campos.");
            return null;
        }

        String tipo = datos[0].trim().toUpperCase();
        String nombre = datos[1].trim();
        String rut = datos[2].trim();
        String direccionCalle = datos[3].trim();
        String direccionNumero = datos[4].trim();
        String direccionRegion = datos[5].trim();
        String correo = datos[6].trim();
        String telefono = datos[7].trim();

        if (verificarCampoVaciosCliente(tipo, nombre, rut, direccionCalle, direccionNumero, direccionRegion,
                correo, telefono, numeroLinea)) {
            return null;
        }
        try {
            Rut rutPersona = new Rut(rut);
            int numeroDireccion = convertirDireccionNumero(direccionNumero);
            Direccion direccion = new Direccion(direccionCalle, numeroDireccion, direccionRegion);

            return crearCliente(tipo, nombre, rutPersona, direccion, correo, telefono);
        } catch (IllegalArgumentException | RutInvalido | TelefonoInvalido e) {
            System.out.println("Línea " + numeroLinea + " omitida: " + e.getMessage());
            return null;
        }
    }

    /**
     * Comprueba que los campos obligatorios de un cliente tengan contenido.
     *
     * @param tipo tipo de persona
     * @param nombre nombre completo
     * @param rut RUT sin puntos
     * @param direccionCalle calle de la dirección
     * @param direccionNumero número de la dirección antes de su conversión
     * @param direccionRegion región de residencia
     * @param correo correo electrónico
     * @param telefono teléfono de contacto
     * @param numeroLinea posición de la línea dentro del archivo
     * @return verdadero si existe algún campo vacío; de lo contrario, devuelve falso
     */
    private boolean verificarCampoVaciosCliente(String tipo, String nombre, String rut, String direccionCalle,
                                                String direccionNumero, String direccionRegion, String correo,
                                                String telefono, int numeroLinea) {
        if (tipo.isEmpty() || nombre.isEmpty() || rut.isEmpty() || direccionCalle.isEmpty() || direccionNumero.isEmpty()
                || direccionRegion.isEmpty() || correo.isEmpty() || telefono.isEmpty()) {
            System.out.println("Línea " + numeroLinea + " omitida: contiene campos vacíos.");
            return true;
        }
        return false;
    }

    /**
     * Crea un cliente cuando el tipo de registro es válido.
     *
     * @param tipo tipo de persona esperado
     * @param nombre nombre completo
     * @param rutPersona RUT validado
     * @param direccion dirección del cliente
     * @param correo correo electrónico
     * @param telefono teléfono de contacto
     * @return cliente creado
     * @throws TelefonoInvalido si el teléfono no cumple el formato requerido
     * @throws IllegalArgumentException si el tipo no corresponde a un cliente
     */
    private Cliente crearCliente(String tipo, String nombre, Rut rutPersona, Direccion direccion, String correo,
                                 String telefono) throws TelefonoInvalido {
        if (!"CLIENTE".equals(tipo)) {
            throw new IllegalArgumentException(
                    "El tipo de persona debe ser CLIENTE.");
        }

        return new Cliente(
                nombre, rutPersona, direccion, correo, telefono);
    }

}
