import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Aplicacion {

    private static final Scanner atributos = new Scanner(System.in);

    public static void main(String[] args)  {

        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce el nombre del proyecto: ");
        String nombreProyecto = teclado.nextLine();
        Proyecto proyecto = new Proyecto(nombreProyecto);
        System.out.println("Has creado un nuevo proyecto llamado " + nombreProyecto);

        System.out.println(Menu.OpcionesMenu.getMenu());
        System.out.print("ELige una opcion (0..7): ");
        int opcion = teclado.nextInt();
        Menu.OpcionesMenu opcionMenu = Menu.OpcionesMenu.getOpcion(opcion);
        while (opcion != 0) {
            switch (opcionMenu) {
                case SALIR:
                    System.out.println("Has terminado de editar el proyecto " + nombreProyecto);
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


                    break;
                }
            }
            System.out.print("ELige una opcion(0..7): ");
            opcion = teclado.nextInt();
            opcionMenu = Menu.OpcionesMenu.getOpcion(opcion);
        }
    }

    public static void darAltaPersona(Proyecto proyecto){
        Persona personaAñadida = inputsPersona();
        proyecto.añadirPersona(personaAñadida);
        System.out.println("Has añadido a " + personaAñadida.getNombre() + " al proyecto");
    }

    public static void darBajaPersona(Proyecto proyecto){
        List<Persona> personas = proyecto.getPersonas();
        listarPersonas(proyecto);
        if(personas.size() == 0) {
            return;
        }
        System.out.println("¿Que persona quieres eliminar del proyecto?");
        int listaPersonas = Integer.parseInt(atributos.nextLine());
        Persona personaELiminada = proyecto.getPersonas().get(listaPersonas);
        proyecto.eliminarPersona(listaPersonas);
        System.out.println("Has eliminado a " + personaELiminada.getNombre() + " del proyecto");
    }

    public static void darAltaTarea(Proyecto proyecto){
        System.out.print("Introduce el nombre de la tarea: ");
        String nomTarea = atributos.nextLine();

        System.out.print("Introduce la descripcion de la tarea: ");
        String descripcion = atributos.nextLine();

        System.out.println("Elige el numero de la persona responsable: ");
        listarPersonas(proyecto);
        int persona = Integer.parseInt(atributos.nextLine());
        Persona responsable = proyecto.getPersonas().get(persona);

        System.out.print("Introduce la prioridad de la tarea (1-5): ");
        int prioridad = Integer.parseInt(atributos.nextLine());

        System.out.print("¿Quieres poner alguna etiqueta relacionada con el proyecto?");
        List<String> etiquetas = Collections.singletonList(atributos.nextLine());

        System.out.print("Introduce el tipo de tarea (Documento/PaginaWeb/Programa): ");
        String resultado = atributos.nextLine();

        Tarea tarea = new Tarea(nomTarea, descripcion, responsable, prioridad, etiquetas,resultado);
        proyecto.añadirTarea(nomTarea, tarea);

        System.out.println("La tarea " + nomTarea + " ha sido añadida correctamente el " + tarea.getFechaIni());
    }

    public static void marcarFinalizada(Proyecto proyecto){
        List<String> tareasNoFinalizadas = proyecto.getTareasNoFinalizadas();
        if (tareasNoFinalizadas.size() == 0){
            System.out.println("No hay tareas NO FINALIZADAS");
            return;
        }
        System.out.println("¿Que tarea quieres marcar como finalizada? (Introduce el nombre): ");
        for (int i = 0; i < tareasNoFinalizadas.size(); i++) {
            System.out.println(tareasNoFinalizadas.get(i));
        }
        String tarea = atributos.nextLine();
        String tipo = proyecto.getTipoTarea(tarea);

        System.out.println("Introduce un identificador del resultado");
        String identificador = atributos.nextLine();

        System.out.println("Introduce las horas ");
        int horas = Integer.parseInt(atributos.nextLine());

        System.out.println("Interno o comercial");
        String internoOcomercial = atributos.nextLine();


        if(tipo.equals("Documento")){
            System.out.println("¿Que formato tiene?");
            String formato = atributos.nextLine();

            System.out.println("¿Cuantas paginas tiene?");
            int numPag = Integer.parseInt(atributos.nextLine());

            System.out.println("¿Que espacio tiene?");
            Float espacio = Float.valueOf(atributos.nextLine());
            Resultado resultado = new ResultadoDocumento(identificador,horas,internoOcomercial,formato,numPag,espacio);
            proyecto.finalizarTarea(tarea,resultado);

        }else if(tipo.equals("PaginaWeb")){
            System.out.println("¿Es estatica o dinamica?");
            String estaticaOdinamica = atributos.nextLine();

            System.out.println("¿En que lenguaje esta desarrolada?");
            String lenguaje = atributos.nextLine();

            System.out.println("¿Que backend utiliza");
            String backend = atributos.nextLine();

            Resultado resultado = new ResultadoPaginaWeb(identificador, horas,internoOcomercial,estaticaOdinamica,lenguaje,backend);
            proyecto.finalizarTarea(tarea,resultado);

        }else{
            System.out.println("¿En que lenguaje esta?");
            String lenguaje = atributos.nextLine();

            System.out.println("¿Cuantas lineas tienes?");
            int numero_lineas = Integer.parseInt(atributos.nextLine());

            System.out.println("¿Que modulos utiliza?");
            int numero_modulos = Integer.parseInt(atributos.nextLine());

            Resultado resultado = new ResultadoPrograma(identificador,horas,internoOcomercial,lenguaje,numero_lineas,numero_modulos);
            proyecto.finalizarTarea(tarea,resultado);
        }

        System.out.println("Tarea finalizada el " + LocalDate.now());
    }

    public static void añadirPersona(Proyecto proyecto){
        List<Persona> personas = proyecto.getPersonas();
        listarPersonas(proyecto);
        if(personas.size() == 0) {
            return;
        }
        System.out.println("¿A que persona quieres añadir?");
        String persona = atributos.nextLine();
        Map<String, Tarea> tareas = proyecto.getTareas();
        listarNombreTareas(proyecto);
        if (tareas.size() == 0){
            System.out.println("No hay tareas en este proyecto");
            return;
        }
        System.out.println("¿A que tarea le quieres añadir?");
        String tarea = atributos.nextLine();
        System.out.println("Se ha agregado a " + proyecto.añadirPersonaATarea(tarea, persona) + "a la tarea " + tarea);
        proyecto.añadirTareaAPersona(persona, tarea);
    }

    public static void eliminarPersona(Proyecto proyecto){
        List<Persona> personas = proyecto.getPersonas();
        listarPersonas(proyecto);
        if(personas.size() == 0) {
            return;
        }
        System.out.println("Introduce el numero de la persona que quieres eliminar: ");
        String persona = atributos.nextLine();
        Map<String, Tarea> tareas = proyecto.getTareas();
        listarNombreTareas(proyecto);
        if (tareas.size() == 0){
            System.out.println("No hay tareas en este proyecto");
            return;
        }
        System.out.println("¿De que tarea le quieres eliminar?");
        String tarea = atributos.nextLine();
        proyecto.eliminarPersonaDeTarea(persona, tarea);
    }

    public static void listarPersonas(Proyecto proyecto){
        List<Persona> personas = proyecto.getPersonas();
        for(int i = 0; i < personas.size(); i++){
            System.out.println(i + ".- " + personas.get(i).getNombre());
        }
        if(personas.size() == 0) {
            System.out.println("No hay personas en el proyecto.");
        }
    }

    public static void listarTareas(Proyecto proyecto){
        Map<String, Tarea> tareas = proyecto.getTareas();
        for (String key : tareas.keySet()) {
            System.out.println("Titulo: " + key);
            System.out.println("Responsable: " + tareas.get(key).getResponsable().getNombre());
            System.out.println("Realizada: " + tareas.get(key).getRealizada());
            System.out.println("");
        }
        if (tareas.size() == 0){
            System.out.println("No hay tareas en este proyecto");
        }
    }

    public static void listarNombreTareas(Proyecto proyecto){
        List<String> tareas = proyecto.getNombreTareas();
        for(int i = 0; i < tareas.size(); i++){
            System.out.println(tareas.get(i));
        }
    }

    public static Persona inputsPersona(){
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce tu nombre: ");
        String nombrePersona = teclado.nextLine();
        System.out.print("Introduce tu correo electronico: ");
        String emailPersona = teclado.nextLine();
        return new Persona(nombrePersona, emailPersona);
    }
}