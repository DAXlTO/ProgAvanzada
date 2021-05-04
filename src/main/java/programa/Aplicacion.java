package programa;

import programa.modelo.clases.*;
import programa.modelo.excepciones.PersonaNullException;
import programa.modelo.excepciones.PersonaRepetidaException;
import programa.modelo.excepciones.TareaException;
import programa.modelo.excepciones.TareaRepetidaException;
import programa.modelo.interfaces.Importe;

import java.io.File;
import java.time.LocalDate;
import java.util.*;

public class Aplicacion {

    private static final Scanner atributos = new Scanner(System.in);

    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        Proyecto proyecto = inicializar(teclado);

        int opcion;
        do {
            System.out.println(Menu.OpcionesMenu.getMenu());
            System.out.print("ELige una opcion (0..7): ");
            opcion = teclado.nextInt();
            Menu.OpcionesMenu opcionMenu = Menu.OpcionesMenu.getOpcion(opcion);
            switch (opcionMenu) {
                case SALIR:
                    System.out.println("Has terminado de editar el proyecto " + proyecto.getNombre());
                    Proyecto.almacenarInformacion(proyecto);
                    System.exit(0);
                    break;

                case DAR_ALTA_PERSONA: {
                    darAltaPersona(proyecto);
                    break;
                }
                case DAR_BAJA_PERSONA:{
                    darBajaPersona(proyecto);
                    break;
                }

                case DAR_ALTA_TAREA: {
                    darAltaTarea(proyecto);
                    break;
                }

                case MARCAR_FINALIZADA: {
                    marcarFinalizada(proyecto);
                    break;
                }
                case AÑADIR_PERSONA: {
                    añadirPersona(proyecto);
                    break;
                }
                case ELIMINAR_PERSONA: {
                    eliminarPersona(proyecto);
                    break;
                }
                case LISTAR_PERSONAS: {
                    listarPersonas(proyecto);
                    break;
                }
                case LISTAR_TAREAS: {
                    listarTareas(proyecto);
                    break;
                }
                case LISTAR_PERSONAS_DE_TAREA: {
                    listarPersonasDeTarea(proyecto);
                    break;
                }
                case LISTAR_PERSONAS_NO_RESPONSABLES: {
                    listarPersonasNoResponsables(proyecto);
                    break;
                }
                case LISTAR_TAREAS_SIN_PERSONAS: {
                    listarTareasSinPersonas(proyecto);

                }
            }
        }while (opcion != 0);
    }

    public static void darAltaPersona(Proyecto proyecto) {
        try {
            Persona personaAñadida = inputsPersona();
            proyecto.añadirPersona(personaAñadida);
            System.out.println("Has añadido a " + personaAñadida.getNombre() + " al proyecto\n");
        }
        catch (PersonaRepetidaException e){
            System.out.println("La persona ya existe");
        }
    }

    public static void darBajaPersona(Proyecto proyecto) {
        try {
            List<Persona> personas = proyecto.getPersonas();
            if (personas.size() == 0) {
                return;
            }

            System.out.println("¿Que persona quieres eliminar?");
            int listaPersonas = elegirPersona(proyecto);
            Persona personaELiminada = personas.get(listaPersonas);

            proyecto.eliminarPersona(listaPersonas);
            System.out.println("Has eliminado a " + personaELiminada.getNombre() + " del proyecto\n");
        }
        catch (PersonaNullException e){
            System.out.println("No hay personas en este proyecto");
        }
    }

    public static void darAltaTarea(Proyecto proyecto){
        try{
        System.out.print("Introduce el nombre de la tarea: ");
        String nomTarea = atributos.nextLine();

        System.out.print("Introduce la descripcion de la tarea: ");
        String descripcion = atributos.nextLine();

        System.out.println("¿Que persona quieres que sea responsable?");
        int persona = elegirPersona(proyecto);

        Persona responsable = proyecto.getPersonas().get(persona);

        System.out.print("Introduce la prioridad de la tarea (1-5): ");
        int prioridad = Integer.parseInt(atributos.nextLine());

        System.out.print("¿Quieres poner alguna etiqueta relacionada con el proyecto? ");
        List<String> etiquetas = Collections.singletonList(atributos.nextLine());

        System.out.print("Introduce el tipo de tarea (Documento/PaginaWeb/Programa): ");
        String resultado = atributos.nextLine();

        System.out.print("Introduce el coste de la tarea ");
        double coste = Double.parseDouble(atributos.nextLine());

        System.out.println("Introduce el tipo de importe");
        System.out.println("0- Consumo Interno");
        System.out.println("1- Descuento");
        System.out.println("2- Urgente");
        int opcion = Integer.parseInt(atributos.nextLine());
        Importe importe = new ConsumoInterno();
        switch (opcion) {
            case 0:
                importe = new ConsumoInterno();
                break;
            case 1:
                importe = new Descuento();
                break;
            case 2:
                importe = new Urgente();
                break;
        }

        Tarea tarea = new Tarea(nomTarea, descripcion, responsable, prioridad, etiquetas,resultado,coste,importe);
            proyecto.añadirTarea(tarea);
            System.out.println("La tarea " + nomTarea + " ha sido añadida correctamente el " + tarea.getFechaIni() + " con coste " + tarea.calcularImporte() +"\n");
            proyecto.añadirTareaAPersona(responsable.getNombre(), tarea.getTitulo());
        } catch (TareaRepetidaException e) {
            System.out.println("El nombre de la tarea ya existe");
        } catch (PersonaNullException e){
            System.out.println("No hay personas en este proyecto");
        }
    }

    public static void marcarFinalizada(Proyecto proyecto){
        List<String> tareasNoFinalizadas = proyecto.getTareasNoFinalizadas();
        if (tareasNoFinalizadas.size() == 0){
            System.out.println("No hay tareas NO FINALIZADAS");
            return;
        }
        System.out.println("¿Que tarea quieres marcar como finalizada?");
        for (int i = 0; i < tareasNoFinalizadas.size(); i++) {
            System.out.println(i + ".- " + tareasNoFinalizadas.get(i));
        }
        System.out.print("Introduce el numero de la tarea: ");
        String tarea = tareasNoFinalizadas.get(Integer.parseInt(atributos.nextLine()));
        String tipo = proyecto.getTipoTarea(tarea);

        System.out.print("Introduce un identificador del resultado: ");
        String identificador = atributos.nextLine();

        System.out.print("Introduce las horas utilizadas en la tarea: ");
        int horas = Integer.parseInt(atributos.nextLine());

        System.out.print("Interno o Comercial: ");
        String internoOcomercial = atributos.nextLine();
                    
        if(tipo.equals("Documento")){
            System.out.print("Introduce el formato: ");
            String formato = atributos.nextLine();

            System.out.print("Introduce el numero de paginas: ");
            int numPag = Integer.parseInt(atributos.nextLine());

            System.out.print("Introduce el espacio utilizado: ");
            Float espacio = Float.valueOf(atributos.nextLine());
            Resultado resultado = new ResultadoDocumento(identificador,horas,internoOcomercial,formato,numPag,espacio);
            proyecto.finalizarTarea(tarea,resultado);

        }else if(tipo.equals("PaginaWeb")){
            System.out.print("¿Es estatica o dinamica?");
            String estaticaOdinamica = atributos.nextLine();

            System.out.print("¿En que lenguaje esta desarrolada?");
            String lenguaje = atributos.nextLine();

            System.out.print("¿Que backend utiliza");
            String backend = atributos.nextLine();

            Resultado resultado = new ResultadoPaginaWeb(identificador, horas,internoOcomercial,estaticaOdinamica,lenguaje,backend);
            proyecto.finalizarTarea(tarea,resultado);

        }else{
            System.out.print("Introduce el lenguaje del codigo: ");
            String lenguaje = atributos.nextLine();

            System.out.print("Introduce el numero de lineas: ");
            int numero_lineas = Integer.parseInt(atributos.nextLine());

            System.out.print("Introduce el numero de modulos utilizados: ");
            int numero_modulos = Integer.parseInt(atributos.nextLine());

            Resultado resultado = new ResultadoPrograma(identificador,horas,internoOcomercial,lenguaje,numero_lineas,numero_modulos);
            proyecto.finalizarTarea(tarea,resultado);
        }

        System.out.println("programa.Modelo.Clases.Tarea finalizada el " + LocalDate.now() + "\n");
    }

    public static void añadirPersona(Proyecto proyecto) {
        try {
            System.out.println("¿A que tarea le quieres añadir?");
            String tarea = elegirTarea(proyecto);

            List<Persona> personas = proyecto.getPersonas();

            System.out.println("¿A que persona quieres añadir a esta tarea?");
            String persona = personas.get(elegirPersona(proyecto)).getNombre();

            if (proyecto.añadirPersonaATarea(tarea, persona))
                System.out.println("Se ha agregado a " + persona + " a la tarea " + tarea + "\n");
        } catch (TareaException e){
            System.out.println("No hay tareas en este proyecto");
        } catch (PersonaNullException e){
            System.out.println("No hay personas en este proyecto");
        }
    }

    public static void eliminarPersona(Proyecto proyecto){
        try {
            Map<String, Tarea> tareas = proyecto.getTareas();
            System.out.println("¿De que tarea le quieres eliminar?");
            String tarea = elegirTarea(proyecto);

            List<Persona> personas = tareas.get(tarea).getPersonas();

            System.out.println("¿A que persona quieres eliminar? ");
            String persona = personas.get(elegirPersona(proyecto)).getNombre();

            proyecto.eliminarPersonaDeTarea(persona, tarea);
            System.out.println("Has eliminado a " + persona + " de " + tarea + "\n");
        } catch (TareaException e){
            System.out.println("No hay tareas en este proyecto");
        } catch (PersonaNullException e){
            System.out.println("No hay personas en este proyecto");
        }
    }

    public static void listarPersonas(Proyecto proyecto){
        List<Persona> personas = proyecto.getPersonas();
        if(personas.size() == 0) {
            System.out.println("No hay personas en el proyecto.");
        }
        for(int i = 0; i < personas.size(); i++){
            System.out.println(i + ".- " + personas.get(i).getNombre());
        }
        System.out.println();
    }

    public static void listarTareas(Proyecto proyecto){
        Map<String, Tarea> tareas = proyecto.getTareas();
        for (String key : tareas.keySet()) {
            System.out.println("Titulo: " + key);
            System.out.println("Responsable: " + tareas.get(key).getResponsable().getNombre());
            System.out.println("Realizada: " + tareas.get(key).getRealizada());
            System.out.println("Participantes: ");
            List<Persona> per = tareas.get(key).getPersonas();
            for (int i = 0; i < per.size(); i++)
                System.out.println(per.get(i));
        }
        if (tareas.size() == 0){
            System.out.println("No hay tareas en este proyecto");
        }
    }

    public static void listarPersonasDeTarea(Proyecto proyecto) {
        try {
            List<Persona> personas = proyecto.getPersonas();
            if (personas.size() == 0) {
                System.out.println("No hay personas en el proyecto.\n");
                return;
            }

            String tareaSeleccionada = elegirTarea(proyecto);

            List<Persona> personasTarea = proyecto.getTarea(tareaSeleccionada).getPersonas();
            System.out.println("Las personas que trabajan en esta tarea son: ");
            for (int i = 0; i < personasTarea.size(); i++) {
                System.out.println(personasTarea.get(i));
            }
            System.out.println();
        } catch (TareaException e){
            System.out.println("No hay tareas en este proyecto");
        }
    }

    public static void listarPersonasNoResponsables(Proyecto proyecto){
        List<Persona> listaPersonas = UtilidadesParaLista.elementosConListaVacia(proyecto.getPersonas());
        for (int i = 0; i < listaPersonas.size(); i ++){
            System.out.println(listaPersonas.get(i));
        }
    }

    public static void listarTareasSinPersonas(Proyecto proyecto){
        List<Tarea> listaTareas = UtilidadesParaLista.elementosConListaVacia(proyecto.getTareasLista());
        for (int i = 0; i < listaTareas.size(); i ++) {
            System.out.println(listaTareas.get(i));
        }
    }

    public static void listarNombreTareas(Proyecto proyecto){
        List<String> tareas = proyecto.getNombreTareas();
        for(int i = 0; i < tareas.size(); i++){
            System.out.println(i + ".- " + tareas.get(i));
        }
    }

    public static int elegirPersona(Proyecto proyecto) throws PersonaNullException{
        if (proyecto.getPersonas().size() == 0)
            throw new PersonaNullException();
        listarPersonas(proyecto);
        System.out.print("Introduce el numero de la persona: ");
        return Integer.parseInt(atributos.nextLine());
    }

    public static String elegirTarea(Proyecto proyecto) throws TareaException{
        if (proyecto.getTareasLista().size() == 0){
            throw new TareaException();
        }
        listarNombreTareas(proyecto);
        System.out.print("Elige el numero de la tarea: ");
        return proyecto.getNombreTareas().get(Integer.parseInt(atributos.nextLine()));
    }

    public static Proyecto inicializar(Scanner teclado){
        Proyecto proyecto = null;
        File in = new File("proyecto.bin");
        if(in.exists()){
            proyecto = Proyecto.cargarInformacion();
        }
        else{
            System.out.print("Introduce el nombre del proyecto: ");
            String nombreProyecto = teclado.nextLine();
            proyecto = new Proyecto(nombreProyecto);
            System.out.println("Has creado un nuevo proyecto llamado " + nombreProyecto + "\n");
        }
        return proyecto;
    }

    public static Persona inputsPersona(){
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce el nombre de la persona: ");
        String nombrePersona = teclado.nextLine();
        System.out.print("Introduce el correo electronico: ");
        String emailPersona = teclado.nextLine();
        return new Persona(nombrePersona, emailPersona);
    }
}