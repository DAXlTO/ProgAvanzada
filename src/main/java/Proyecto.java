import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Proyecto {
    String nombre;
    private Map<String,Tarea> tareas;
    private List<Persona> personas;

    public Proyecto(String nombre){
        this.nombre = nombre;
        tareas = new HashMap<>();
        personas = new ArrayList<>();
    }

    public String añadirPersona(Persona persona){
        personas.add(persona);
        return persona.getNombre();
    }

    public String añadirTarea(String nomTarea ,Tarea tarea){
        tareas.put(nomTarea,tarea);
        return tarea.titulo;
    }

    public boolean finalizarTarea(String tarea){
        tareas.get(tarea).finalizarTarea();
        return true;
    }

    public Map<String,Tarea> getTareas(){
        return new HashMap<>(tareas);
    }

    public List<Persona> getPersonas(){
        return new ArrayList<>(personas);
    }

    public List<String> getNombreTareas(){
        return new ArrayList<>(tareas.keySet());
    }

    public List<String> getTareasNoFinalizadas(){
        List<String>  noFinalizadas= new ArrayList<>();

        for(String key : tareas.keySet()){
            if(!tareas.get(key).getRealizada()){
                noFinalizadas.add(key);
            }
        }
        return noFinalizadas;
    }

}
