import java.util.List;
import java.util.Map;

public class Proyecto {
    String nombre;
    private Map<String,List<Tarea>> tareas;
    private List<Persona> personas;

    public Proyecto(String nombre){
        this.nombre = nombre;
    }

    public String añadirPersona(Persona persona){
        personas.add(persona);
        return persona.getNombre();
    }

}
