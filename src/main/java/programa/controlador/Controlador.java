package programa.controlador;

import programa.modelo.clases.Modelo;

public interface Controlador {
    void altaPersona(String nombre,String email, Modelo modelo);
    String[] getPersonas(Modelo modelo);
    void eliminarPersona(int persona, Modelo modelo);
}
