package programa.controlador;

import programa.modelo.clases.Modelo;
import programa.modelo.clases.Persona;
import programa.modelo.clases.Resultado;
import programa.modelo.clases.Tarea;

import java.util.List;

public interface Controlador {
    void altaPersona(String nombre,String email, Modelo modelo);
    List<Persona> getPersonas(Modelo modelo);
    String[] getTareas(Modelo modelo);
    void eliminarPersona(int persona, Modelo modelo);
    void finalizarTarea(String tarea, Resultado resultado, Modelo modelo);
    boolean añadirPersonaATarea(String nombreTarea, String nombrePersona, Modelo modelo);
    void altaTarea(Modelo modelo, String titulo, String descripcion, Persona responsable, int prioridad, String etiquetas, String tipo, Double coste, String importe);
    String[] getPersonasTarea(String tarea);
    boolean darBajaPersonaTarea(String persona, String tarea, Modelo modelo);
    List<String> getTareasNoFinalizadas(Modelo modelo);
}
