package programa.Modelo.Clases;

import programa.Modelo.Excepciones.PersonaRepetidaException;
import programa.Modelo.Excepciones.TareaRepetidaException;
import programa.Modelo.Interfaces.tieneClave;
import programa.Modelo.Interfaces.tieneLista;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Proyecto implements Serializable, tieneClave {
    String nombre;
    private final Map<String,Tarea> tareas;
    private final List<Persona> personas;

    public Proyecto(String nombre){
        this.nombre = nombre;
        tareas = new HashMap<>();
        personas = new ArrayList<>();
    }

    public void añadirPersona(Persona persona) throws PersonaRepetidaException {
        if(UtilidadesParaLista.elementosNoRepetidos(personas,persona)){
            personas.add(persona);
        }else{
            throw new PersonaRepetidaException();

        }
    }

    public void eliminarPersona(int persona) {
        personas.remove(persona);
    }


    public String añadirTarea(Tarea tarea) throws TareaRepetidaException {
        if(UtilidadesParaLista.elementosNoRepetidos(getTareasLista(),tarea)){
            tareas.put(tarea.getTitulo(),tarea);
        }else{
            throw new TareaRepetidaException();

        }
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

    public String getNombre(){return nombre;}

    @Override
    public List getClave() {
        return personas;
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

    public static void almacenarInformacion(Proyecto proyecto){
        try{
            FileOutputStream fos = new FileOutputStream("proyecto.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(proyecto);
            oos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Proyecto cargarInformacion() {
        Proyecto proyecto = null;
        try {
            FileInputStream fis = new FileInputStream("proyecto.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            proyecto = (Proyecto) ois.readObject();
            ois.close();
            return proyecto;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return proyecto;
    }
}
