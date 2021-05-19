package programa.controlador;

import programa.modelo.clases.Modelo;
import programa.modelo.clases.Persona;
import programa.modelo.clases.Resultado;
import programa.modelo.clases.Tarea;

import javax.swing.text.TabableView;
import java.util.List;
import java.util.Map;

public interface Controlador {
    void altaPersona(String nombre,String email, Modelo modelo);
    List<Persona> getPersonas(Modelo modelo);
    Map<String, Tarea> getTareas(Modelo modelo);
    void eliminarPersona(int persona, Modelo modelo);
    void finalizarTarea(String tarea, Resultado resultado, Modelo modelo);
    boolean añadirPersonaATarea(String nombreTarea, String nombrePersona, Modelo modelo);
    void altaTarea(Modelo modelo, String titulo, String descripcion, Persona responsable, int prioridad, String etiquetas, String tipo, Double coste, String importe);

}
