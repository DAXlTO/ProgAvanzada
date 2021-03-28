package programa;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProyectoTest {

    @Test
    void añadirTarea(){
        //Añadiendo tareas...
        Proyecto proyecto = new Proyecto("Prueba");
        Persona responsable = new Persona("Daniel","daniel@uji.es");
        List<String> etiquetas = new ArrayList<>();
        Tarea tarea = new Tarea("Cocina","Limpiar",responsable,3, etiquetas,"Documento");
        proyecto.añadirTarea(tarea.getTitulo(),tarea);

        Tarea tarea1 = new Tarea("Salon","Recoger",responsable,2,etiquetas,"PaginaWeb");
        proyecto.añadirTarea(tarea1.getTitulo(),tarea1);

        Map<String,Tarea> tareas = new HashMap<>();
        tareas.put(tarea.getTitulo(),tarea);
        tareas.put(tarea1.getTitulo(),tarea1);

        assertEquals(proyecto.getTareas(),tareas);
    }

    @Test
    void añadirPersona(){
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
    void añadirPersonaATarea() {
        Proyecto proyecto = new Proyecto("Prueba");
        Persona responsable = new Persona("Daniel","daniel@uji.es");
        List<String> etiquetas = new ArrayList<>();
        Tarea tarea = new Tarea("Cocina","Limpiar",responsable,3, etiquetas,"Documento");

        proyecto.añadirPersona(responsable);
        proyecto.añadirTarea(tarea.getTitulo(),tarea);
        proyecto.añadirPersonaATarea(tarea.getTitulo(),responsable.getNombre());

        tarea.añadirPersona(responsable);
        Map<String,Tarea> tareas = new HashMap<>();
        tareas.put(tarea.getTitulo(),tarea);
        assertEquals(proyecto.getTareas(),tareas);
    }

    @Test
    void eliminarPersonaDeTarea() {
        //Eliminamos a la persona del proyecto
        Proyecto proyecto = new Proyecto("Prueba");
        Persona responsable = new Persona("Daniel","daniel@uji.es");
        List<String> etiquetas = new ArrayList<>();
        Tarea tarea = new Tarea("Cocina","Limpiar",responsable,3, etiquetas,"Documento");

        proyecto.añadirPersona(responsable);
        proyecto.añadirTarea(tarea.getTitulo(),tarea);
        proyecto.añadirPersonaATarea(tarea.getTitulo(),responsable.getNombre());
        proyecto.eliminarPersonaDeTarea(responsable.getNombre(),tarea.getTitulo());


        assertEquals(proyecto.getTarea(tarea.getTitulo()).getPersonas(),etiquetas);
    }
}