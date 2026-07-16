package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestorArchivos {
    private final String archivoTours = "Resources/Tours.txt";
    private final String archivoClientes = "Resources/Clientes.txt";
    private final String archivoGuiascolaboradores = "Resources/Guias-Colaboradores.txt";

    public List<String> listaTours() {
        List<String> listaTours = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoTours))){
            String linea;
            while ((linea = br.readLine()) != null) {
                listaTours.add(linea);
            }

        } catch (IOException e) {
            System.out.println("Error de lectura" + e.getMessage());
        }

        return listaTours;
    }


}
