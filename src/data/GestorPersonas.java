package data;

import model.Persona.GuiaTuristico;
import model.Persona.Persona;

import java.util.ArrayList;
import java.util.List;

public class GestorPersonas {
    private List<Persona> personas;

    public GestorPersonas() {
        personas = new ArrayList<>();
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void agregarPersona(Persona persona) {
        personas.add(persona);
    }

    public GuiaTuristico buscarGuiaPorCodigo(String codigoBuscado){
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
}
