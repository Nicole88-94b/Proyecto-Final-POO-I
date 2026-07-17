package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Lee los archivos de texto utilizados como fuente de datos por la aplicación.
 */
public class GestorArchivos {
    private final String archivoTours = "Resources/Tours.txt";
    private final String archivoClientes = "Resources/Clientes.txt";
    private final String archivoGuiascolaboradores = "Resources/Guias-Colaboradores.txt";

    /**
     * Lee todas las líneas de un archivo y las conserva en el mismo orden.
     * Si ocurre un error de lectura, informa el problema por consola y devuelve
     * las líneas que hayan podido leerse hasta ese momento.
     *
     * @param archivo ruta del archivo que se desea leer
     * @return lista con las líneas leídas
     */
    public List<String> leerArchivos(String archivo) {
        List<String> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))){
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.add(linea);
            }

        } catch (IOException e) {
            System.out.println("Error de lectura" + e.getMessage());
        }

        return lista;
    }
    /**
     * Obtiene las líneas del archivo de tours.
     *
     * @return contenido de Resources/Tours.txt
     */
    public List<String> listaTours() {
        return leerArchivos(archivoTours);
    }

    /**
     * Obtiene las líneas del archivo de guías y colaboradores.
     *
     * @return contenido de {@code Resources/Guias-Colaboradores.txt}
     */
    public List<String> listaGuiasColaboradores() {
        return leerArchivos(archivoGuiascolaboradores);
    }

    /**
     * Obtiene las líneas del archivo de clientes.
     *
     * @return contenido de {@code Resources/Clientes.txt}
     */
    public List<String> listaClientes(){
        return leerArchivos(archivoClientes);
    }
}
