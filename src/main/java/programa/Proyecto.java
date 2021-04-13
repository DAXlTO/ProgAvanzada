package programa;

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

    public void eliminarPersona(int persona) {
        personas.remove(persona);
    }


    public String añadirTarea(Tarea tarea){
        tareas.put(tarea.getTitulo(),tarea);
        return tarea.getTitulo();
    }

    public boolean añadirPersonaATarea(String nomTarea, String persona){
        for(int i = 0; i < personas.size(); i++){
            if (personas.get(i).nombre.equals(persona)){
                tareas.get(nomTarea).añadirPersona(personas.get(i));
                return true;
            }
        }
        return false;
    }

    public void añadirTareaAPersona(String persona, String tarea){
        for (Persona value : personas) {
            if (value.getNombre().equals(persona)) {
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

    public void finalizarTarea(String tarea, Resultado resultado){
        tareas.get(tarea).finalizarTarea(resultado);
    }

    public Map<String,Tarea> getTareas(){
        return new HashMap<>(tareas);
    }

    public List<Persona> getPersonas(){
        return new ArrayList<>(personas);
    }

    public Tarea getTarea(String tarea){
        return tareas.get(tarea);
    }

    public int getNumeroTareas(){return tareas.size();}

    public String getTipoTarea(String tarea){
       return tareas.get(tarea).tipo;
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

    public <T extends tieneLista> List<T> listasVacias(List<T> lista) {
        return UtilidadesParaLista.elementosConListaVacia(lista);
    }

    public List<Tarea> getTareasLista() {
        List<Tarea> solucion = new ArrayList<Tarea>();
        for (String key : tareas.keySet()) {
            solucion.add(tareas.get(key));
        }
        return solucion;
    }
}
