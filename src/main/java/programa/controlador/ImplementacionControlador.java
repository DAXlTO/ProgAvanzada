package programa.controlador;

import programa.modelo.clases.Persona;
import programa.modelo.clases.Modelo;
import programa.modelo.clases.Resultado;
import programa.vista.Vista;

public class ImplementacionControlador implements Controlador{
    private programa.modelo.interfaces.Modelo modelo;
    private Vista vista;

    public void altaPersona(String nombre, String email, Modelo modelo) {
        this.modelo = modelo;
        Persona persona = new Persona(nombre,email);
        this.modelo.altaPersona(persona);
    }

    public String[] getPersonas(Modelo modelo){
        this.modelo = modelo;
        return this.modelo.personas();
    }

    public String[] getTareas(Modelo modelo){
        this.modelo = modelo;
        return this.modelo.tareas();
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
    }

    public void setModelo(Modelo modelo){
        this.modelo=modelo;
    }
}
