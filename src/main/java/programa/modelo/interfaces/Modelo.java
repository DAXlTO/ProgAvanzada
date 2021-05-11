package programa.modelo.interfaces;

import programa.modelo.clases.Persona;

import java.util.List;

public interface Modelo {
    void altaPersona(Persona persona);
    String[] personas();
    void eliminarPersona(int persona);
}
