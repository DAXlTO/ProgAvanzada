package programa.modelo.interfaces;

import programa.modelo.clases.Persona;
import programa.modelo.clases.Resultado;
import programa.modelo.clases.Tarea;

import java.util.List;
import java.util.Map;

public interface Modelo {
    void altaPersona(Persona persona);
    List<Persona> getPersonas();
    Map<String, Tarea> getTareas();
    void eliminarPersona(int persona);
    void finalizarTarea(String tarea, Resultado resultado);
    boolean añadirPersonaATarea(String nombreTarea, String nombrePersona);
    Importe comprobarImporte(String importe);

}
