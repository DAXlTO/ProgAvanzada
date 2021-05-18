package programa.modelo.interfaces;

import programa.modelo.clases.Persona;
import programa.modelo.clases.Resultado;

import java.util.List;

public interface Modelo {
    void altaPersona(Persona persona);
    List<Persona> getPersonas();
    String[] tareas();
    void eliminarPersona(int persona);
    void finalizarTarea(String tarea, Resultado resultado);
    boolean añadirPersonaATarea(String nombreTarea, String nombrePersona);
    Importe comprobarImporte(String importe);

}
