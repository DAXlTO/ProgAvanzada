package programa;

import org.junit.jupiter.api.Test;
import programa.modelo.clases.*;
import programa.modelo.excepciones.PersonaRepetidaException;
import programa.modelo.excepciones.TareaException;
import programa.modelo.excepciones.TareaRepetidaException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class ProyectoTest {

    @Test
    void añadirTarea() throws TareaException, TareaRepetidaException {
        //Añadiendo tareas...
        Modelo proyecto = new Modelo("Prueba");
        Persona responsable = new Persona("Daniel","daniel@uji.es");
        Persona responsable1 = new Persona("Sergio", "sergio@uji.es");

        List<String> etiquetas = new ArrayList<>();
        Tarea tarea = new Tarea("Cocina","Limpiar",responsable,3, "etiquetas","Documento",new Urgente(12.5,10));
        proyecto.añadirTarea(tarea);

        Tarea tarea1 = new Tarea("Salon","Recoger",responsable1,2,"etiquetas","PaginaWeb",  new Urgente(12,10));
        proyecto.añadirTarea(tarea1);

        Tarea tarea2 = new Tarea("Comer","Desayuno",responsable,8, "etiquetas","Programa", new ConsumoInterno(10));
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
        Modelo proyecto = new Modelo("Prueba");
        assertEquals(proyecto.getPersonas(),new ArrayList<>());

        //Con una persona
        Persona responsable = new Persona("Daniel","daniel@uji.es");
        proyecto.altaPersona(responsable);
        List<Persona> personas = new ArrayList<>();
        personas.add(responsable);
        assertEquals(proyecto.getPersonas(),personas);

        //Con dos personas
        Persona responsable1 = new Persona("Sergio","sergio@uji.es");
        proyecto.altaPersona(responsable1);
        personas.add(responsable1);
        assertEquals(proyecto.getPersonas(),personas);
    }

    @Test
    void añadirPersonaATarea() throws PersonaRepetidaException, TareaException, TareaRepetidaException {
        Modelo proyecto = new Modelo("Prueba");
        Persona añadida = new Persona("Sergio", "sergio@uji.es");
        Persona añadida1 = new Persona("Daniel","daniel@uji.es");
        List<String> etiquetas = new ArrayList<>();
        Tarea tarea = new Tarea("Cocina","Limpiar",añadida,3, "etiquetas","Documento",  new Descuento(100,10));

        proyecto.altaPersona(añadida);
        proyecto.altaPersona(añadida1);
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
    void eliminarPersonaDeTarea() throws PersonaRepetidaException, TareaException, TareaRepetidaException {
        //Eliminamos a la persona del proyecto
        Modelo proyecto = new Modelo("Prueba");
        Persona eliminada = new Persona("Daniel","daniel@uji.es");
        Persona eliminada1 = new Persona("Sergio", "sergio@uji.es");
        List<String> etiquetas = new ArrayList<>();
        Tarea tarea = new Tarea("Cocina","Limpiar",eliminada,3, "etiquetas","Documento", new Urgente(100,5));

        proyecto.altaPersona(eliminada);
        proyecto.altaPersona(eliminada1);
        proyecto.añadirTarea(tarea);
        proyecto.añadirPersonaATarea(tarea.getTitulo(),eliminada.getNombre());
        proyecto.eliminarPersonaDeTarea(eliminada.getNombre(),tarea.getTitulo());
        proyecto.añadirPersonaATarea(tarea.getTitulo(),eliminada1.getNombre());
        proyecto.eliminarPersonaDeTarea(eliminada1.getNombre(),tarea.getTitulo());

        assertEquals(proyecto.getTarea(tarea.getTitulo()).getPersonas(),etiquetas);
    }

    @Test
    void listasVacias() {
        Persona personaje = new Persona("Darochiiiiita","daro@uji.es");
        List<Persona> aux = new ArrayList<>();
        aux.add(personaje);
        assertEquals(aux,aux);
        List<Persona> aux1 = new ArrayList<>();
        assertNotEquals(aux, aux1);

    }

    @Test
    void noRepetidos() {
        List<Persona> lista = new ArrayList<Persona>();
        Persona persona = new Persona("Sergio", "al386136@uji.es");
        Persona personaRepetida = new Persona("Sergio", "al386136@uji.es");
        Persona persona2 = new Persona("Dani", "al386166@uji.es");
        Persona persona3 = new Persona("Pepito", "pepito@uji.es");
        Persona persona4 = new Persona("Ana", "ana@uji.es");
        lista.add(persona);
        lista.add(persona3);

        assertFalse(UtilidadesParaLista.elementosNoRepetidos(lista, personaRepetida));
        assertTrue(UtilidadesParaLista.elementosNoRepetidos(lista, persona2));
        assertTrue(UtilidadesParaLista.elementosNoRepetidos(lista, persona4));

    }

    @Test
    void calcularImporte() throws TareaRepetidaException {
        Modelo proyecto = new Modelo("Prueba");
        Persona persona = new Persona("Sergio", "sergio@uji.es");
        Persona persona1 = new Persona("Daniel","daniel@uji.es");

        Tarea tareaConDescuento = new Tarea("Cocina","Limpiar",persona1,3, "probando","Documento",  new Descuento(5,5));
        Tarea tareaConsumoInterno = new Tarea("Lavar","Ropa",persona,1, "probando","Programa",  new ConsumoInterno(7.50));
        Tarea tareaUrgente = new Tarea("Programar","Codigo",persona,5, "probando","Programa",  new Urgente(10,25));
        Tarea tareaIncorrecta = new Tarea("Jugar","Rocket League",persona1,5, "probandi","Programa",  new Urgente(10,100));

        proyecto.añadirTarea(tareaConDescuento);
        proyecto.añadirTarea(tareaConsumoInterno);
        proyecto.añadirTarea(tareaUrgente);
        proyecto.añadirTarea(tareaIncorrecta);


        assertEquals(proyecto.calcularCosteProyecto(),149.75);

        assertEquals(tareaConDescuento.calcularImporte(), 4.75);
        assertEquals(tareaConsumoInterno.calcularImporte(), 7.50);
        assertEquals(tareaUrgente.calcularImporte(), 27.50);
        assertNotEquals(tareaIncorrecta.calcularImporte(), 100);
    }


}