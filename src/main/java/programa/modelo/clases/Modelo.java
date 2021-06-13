package programa.modelo.clases;

import programa.modelo.excepciones.PersonaRepetidaException;
import programa.modelo.excepciones.TareaRepetidaException;
import programa.modelo.interfaces.Importe;
import programa.modelo.interfaces.tieneClave;
import programa.modelo.interfaces.tieneLista;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Modelo implements Serializable, tieneClave {
    String nombre;
    private final Map<String,Tarea> tareas;
    private final List<Persona> personas;

    public Modelo(String nombre){
        this.nombre = nombre;
        tareas = new HashMap<>();
        personas = new ArrayList<>();
    }

    public void altaPersona(Persona persona) {
        try{
            if(UtilidadesParaLista.elementosNoRepetidos(personas,persona)){
                personas.add(persona);
                System.out.println(getPersonas());
                System.out.println("Todo ha ido bien");
            }else{
                throw new PersonaRepetidaException();

            }
        }catch (PersonaRepetidaException ex){
            ex.printStackTrace();
        }
    }

    public void eliminarPersona(int persona) {
        personas.remove(persona);
        System.out.println("Todo ok");
    }


    public String añadirTarea(Tarea tarea) throws TareaRepetidaException {
        if(UtilidadesParaLista.elementosNoRepetidos(getTareasLista(),tarea)){
            tareas.put(tarea.getTitulo(),tarea);
            añadirTareaAPersona(tarea.getResponsable().getNombre(),tarea.getTitulo());
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

    public List<Persona> listarPersonasNoResponsables(){
        return UtilidadesParaLista.elementosConListaVacia(getPersonas());
    }

    public List<Tarea> listarTareasSinPersonas(Modelo modelo){
        if(tareas.size() > 0)
            return  UtilidadesParaLista.elementosConListaVacia(modelo.getTareasLista());
        return new ArrayList<>();
    }

    public boolean eliminarPersonaDeTarea(String persona, String tarea){
        tareas.get(tarea).eliminarPersona(persona);
        for (Persona value : personas) {
            if (value.getNombre().equals(persona)) {
                System.out.println("true");
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


    public String[] tareas(){
        String[] aux = new String[tareas.size()];
        int i = 0;
        for (String key : tareas.keySet()) {
            aux[i] = key;
            i++;
        }
        return aux;
    }

    public String[] getPersonasTarea(String tarea){
        Tarea tar = tareas.get(tarea);
        List<Persona> perso = tar.getPersonas();
        String[] aux = new String[perso.size()];
        for(int i = 0; i < perso.size(); i++){
            aux[i] =perso.get(i).getNombre();
        }
        return aux;
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

    public void almacenarInformacion(Modelo modelo){
        try{
            FileOutputStream fos = new FileOutputStream("proyecto.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(modelo);
            oos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Importe comprobarImporte(float variacion, String importe, double coste){
        Importe importe1 = new ConsumoInterno(coste);
        if(importe.equals("Descuento"))
            importe1 = new Descuento(variacion,coste);
        else if(importe.equals("Urgente"))
            importe1 = new Urgente(variacion,coste);
        return importe1;
    }

    public Modelo cargarInformacion() {
        Modelo modelo = null;
        try {
            FileInputStream fis = new FileInputStream("proyecto.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            modelo = (Modelo) ois.readObject();
            ois.close();
            return modelo;
        }
        catch (Exception e) {
           return new Modelo("Prueba");
        }
    }
}
