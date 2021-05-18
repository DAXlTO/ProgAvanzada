package programa.modelo.interfaces;

import programa.modelo.clases.Persona;
import programa.modelo.clases.Resultado;

import java.util.List;

public interface Modelo {
    void altaPersona(Persona persona);
    String[] personas();
    String[] tareas();
    void eliminarPersona(int persona);
    void finalizarTarea(String tarea, Resultado resultado);
    boolean añadirPersonaATarea(String nombreTarea, String nombrePersona);
}
