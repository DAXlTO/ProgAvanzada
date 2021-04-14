package programa;

import org.junit.jupiter.api.Test;
import programa.Clases.Persona;
import programa.Clases.Proyecto;
import programa.Clases.Tarea;
import programa.Excepciones.PersonaRepetidaException;
import programa.Excepciones.TareaException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class ProyectoTest {

    @Test
    void añadirTarea() throws TareaException {
        //Añadiendo tareas...
        Proyecto proyecto = new Proyecto("Prueba");
        Persona responsable = new Persona("Daniel","daniel@uji.es");
        Persona responsable1 = new Persona("Sergio", "sergio@uji.es");

        List<String> etiquetas = new ArrayList<>();
        Tarea tarea = new Tarea("Cocina","Limpiar",responsable,3, etiquetas,"Documento");
        proyecto.añadirTarea(tarea);

        Tarea tarea1 = new Tarea("Salon","Recoger",responsable1,2,etiquetas,"PaginaWeb");
        proyecto.añadirTarea(tarea1);

        Tarea tarea2 = new Tarea("Comer","Desayuno",responsable,8, etiquetas,"Programa");
        proyecto.añadirTarea(tarea2);

        Map<String,Tarea> tareas = new HashMap<>();
        tareas.put(tarea.getTitulo(),tarea);
        tareas.put(tarea1.getTitulo(),tarea1);
        tareas.put(tarea2.getTitulo(),tarea2);

        assertEquals(proyecto.getTareas(),tareas);
    }

    @Test
    void añadirPersona() throws PersonaRepetidaException {
        //Con lista vacia
        Proyecto proyecto = new Proyecto("Prueba");
        assertEquals(proyecto.getPersonas(),new ArrayList<>());

        //Con una persona
        Persona responsable = new Persona("Daniel","daniel@uji.es");
        proyecto.añadirPersona(responsable);
        List<Persona> personas = new ArrayList<>();
        personas.add(responsable);
        assertEquals(proyecto.getPersonas(),personas);

        //Con dos personas
        Persona responsable1 = new Persona("Sergio","sergio@uji.es");
        proyecto.añadirPersona(responsable1);
        personas.add(responsable1);
        assertEquals(proyecto.getPersonas(),personas);
    }

    @Test
    void añadirPersonaATarea() throws PersonaRepetidaException, TareaException {
        Proyecto proyecto = new Proyecto("Prueba");
        Persona añadida = new Persona("Sergio", "sergio@uji.es");
        Persona añadida1 = new Persona("Daniel","daniel@uji.es");
        List<String> etiquetas = new ArrayList<>();
        Tarea tarea = new Tarea("Cocina","Limpiar",añadida,3, etiquetas,"Documento");

        proyecto.añadirPersona(añadida);
        proyecto.añadirPersona(añadida1);
        proyecto.añadirTarea(tarea);
        proyecto.añadirPersonaATarea(tarea.getTitulo(),añadida.getNombre());
        proyecto.añadirPersonaATarea(tarea.getTitulo(),añadida1.getNombre());

        tarea.añadirPersona(añadida);
        tarea.añadirPersona(añadida1);
        Map<String,Tarea> tareas = new HashMap<>();
        tareas.put(tarea.getTitulo(),tarea);
        assertEquals(proyecto.getTareas(),tareas);
    }

    @Test
    void eliminarPersonaDeTarea() throws PersonaRepetidaException, TareaException {
        //Eliminamos a la persona del proyecto
        Proyecto proyecto = new Proyecto("Prueba");
        Persona eliminada = new Persona("Daniel","daniel@uji.es");
        Persona eliminada1 = new Persona("Sergio", "sergio@uji.es");
        List<String> etiquetas = new ArrayList<>();
        Tarea tarea = new Tarea("Cocina","Limpiar",eliminada,3, etiquetas,"Documento");

        proyecto.añadirPersona(eliminada);
        proyecto.añadirPersona(eliminada1);
        proyecto.añadirTarea(tarea);
        proyecto.añadirPersonaATarea(tarea.getTitulo(),eliminada.getNombre());
        proyecto.eliminarPersonaDeTarea(eliminada.getNombre(),tarea.getTitulo());
        proyecto.añadirPersonaATarea(tarea.getTitulo(),eliminada1.getNombre());
        proyecto.eliminarPersonaDeTarea(eliminada1.getNombre(),tarea.getTitulo());

        assertEquals(proyecto.getTarea(tarea.getTitulo()).getPersonas(),etiquetas);
    }
}