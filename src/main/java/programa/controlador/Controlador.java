package programa.controlador;

import programa.modelo.clases.Modelo;
import programa.modelo.clases.Resultado;

public interface Controlador {
    void altaPersona(String nombre,String email, Modelo modelo);
    String[] getPersonas(Modelo modelo);
    String[] getTareas(Modelo modelo);
    void eliminarPersona(int persona, Modelo modelo);
    void finalizarTarea(String tarea, Resultado resultado, Modelo modelo);
    boolean añadirPersonaATarea(String nombreTarea, String nombrePersona, Modelo modelo);

}
