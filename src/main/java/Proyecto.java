import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Proyecto {
    String nombre;
    private final Map<String,Tarea> tareas;
    private final List<Persona> personas;

    public Proyecto(String nombre){
        this.nombre = nombre;
        tareas = new HashMap<>();
        personas = new ArrayList<>();
    }

    public void añadirPersona(Persona persona){
        personas.add(persona);
    }


    public String añadirTarea(String nomTarea ,Tarea tarea){
        tareas.put(nomTarea,tarea);
        return tarea.titulo;
    }

    public String añadirPersonaATarea(String nomTarea, Persona persona){
        tareas.get(nomTarea).añadirPersona(persona);
        return persona.getNombre();
    }

    public void añadirTareaAPersona(Persona persona, String tarea){
        for (Persona value : personas) {
            if (value.equals(persona)) {
                value.añadirTarea(tareas.get(tarea));
                break;
            }
        }
    }

    public boolean eliminarPersonaDeTarea(String persona, String tarea){
        tareas.get(tarea).eliminarPersona(persona);
        for (Persona value : personas) {
            if (value.getNombre().equals(persona)) {
                return value.eliminarTarea(tarea);
            }
        }
        return false;
    }

    public void finalizarTarea(String tarea){
        tareas.get(tarea).finalizarTarea();
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
