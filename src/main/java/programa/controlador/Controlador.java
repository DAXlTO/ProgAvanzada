package programa.controlador;

import programa.modelo.clases.Modelo;
import programa.modelo.clases.Persona;
import programa.modelo.clases.Resultado;
import programa.modelo.clases.Tarea;

import javax.jws.WebParam;
import java.util.List;
import java.util.Map;

public interface Controlador {
    void altaPersona(String nombre,String email, Modelo modelo);
    List<Persona> getPersonas(Modelo modelo);
    Map<String, Tarea> getTareas1(Modelo modelo);
    String[] getTareas(Modelo modelo);
    void eliminarPersona(int persona, Modelo modelo);
    void finalizarTarea(String tarea, String tipo,String idem,String time, String internoCOmercial,String camp1,String camp2,String camp3, Modelo modelo);
    boolean añadirPersonaATarea(String nombreTarea, String nombrePersona, Modelo modelo);
    void altaTarea(Modelo modelo, String titulo, String descripcion, Persona responsable, int prioridad, String etiquetas, String tipo, Double coste, String importe, float variacion);
    String[] getPersonasTarea(String tarea,Modelo modelo);
    boolean darBajaPersonaTarea(String persona, String tarea, Modelo modelo);
    List<String> getTareasNoFinalizadas(Modelo modelo);
    Tarea getTarea(Modelo modelo, String tarea);
    void guardaSalir(Modelo modelo);
    Modelo cargarInformacion(Modelo modelo);
    void modificarCostes(String tarea, double var, double coste);
}
