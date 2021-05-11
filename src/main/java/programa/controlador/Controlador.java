package programa.controlador;

import programa.modelo.clases.Proyecto;

import java.util.List;

public interface Controlador {
    void altaPersona(String nombre,String email, Proyecto proyecto);
    String[] getPersonas(Proyecto proyecto);
}
