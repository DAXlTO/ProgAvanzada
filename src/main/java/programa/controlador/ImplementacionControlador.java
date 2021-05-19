package programa.controlador;

import programa.modelo.clases.Persona;
import programa.modelo.clases.Modelo;
import programa.modelo.clases.Resultado;
import programa.modelo.clases.Tarea;
import programa.modelo.excepciones.TareaRepetidaException;
import programa.modelo.interfaces.Importe;
import programa.vista.Vista;

import java.util.List;
import java.util.Map;

public class ImplementacionControlador implements Controlador{
    private programa.modelo.interfaces.Modelo modelo;
    private Vista vista;

    public void altaPersona(String nombre, String email, Modelo modelo) {
        this.modelo = modelo;
        Persona persona = new Persona(nombre,email);
        this.modelo.altaPersona(persona);
    }

    public List<Persona> getPersonas(Modelo modelo){
        this.modelo = modelo;
        return this.modelo.getPersonas();
    }

    public Map<String, Tarea> getTareas(Modelo modelo){
        this.modelo = modelo;
        return this.modelo.getTareas();
    }

    public void eliminarPersona(int persona, Modelo modelo){
        this.modelo = modelo;
        this.modelo.eliminarPersona(persona);
    }

    public void finalizarTarea(String tarea, Resultado resultado, Modelo modelo){
        this.modelo = modelo;
        this.modelo.finalizarTarea(tarea,resultado);
    }

    public boolean añadirPersonaATarea(String tarea, String persona, Modelo modelo){
        this.modelo = modelo;
        this.modelo.añadirPersonaATarea(tarea, persona);
        return true;
    }

    public void altaTarea(Modelo modelo, String titulo, String descripcion, Persona responsable, int prioridad, String etiquetas, String tipo, Double coste, String importe){
        this.modelo = modelo;

        Importe impor = modelo.comprobarImporte(importe);
        Tarea tarea = new Tarea(titulo,descripcion,responsable,prioridad,etiquetas,tipo,coste,impor);
        try {
            System.out.println(titulo);
            modelo.añadirTarea(tarea);
        } catch (TareaRepetidaException e) {
            e.printStackTrace();
        }
    }

    public void setModelo(Modelo modelo){
        this.modelo=modelo;
    }
}
