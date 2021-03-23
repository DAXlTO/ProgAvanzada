import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Aplicacion {

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

                case DAR_ALTA_TAREA: {
                    darAltaTarea(proyecto);
                    break;
                }

                case MARCAR_FINALIZADA: {
                    System.out.println("¿Que tarea quieres marcar como finalizada? (Introduce el nombre): ");
                    List<String> tareas = proyecto.getTareasNoFinalizadas();
                    for (int i = 0; i < tareas.size(); i++) {
                        System.out.println(tareas.get(i));
                    }
                    proyecto.finalizarTarea(atributos.nextLine());
                    System.out.println("¿Que tipo de resultado es?");
                    System.out.println("Tarea finalizada");
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
            }
            System.out.print("ELige una opcion(0..7): ");
            opcion = teclado.nextInt();
            opcionMenu = Menu.OpcionesMenu.getOpcion(opcion);
        }
    }

    private static final Scanner atributos = new Scanner(System.in);

    public static void darAltaPersona(Proyecto proyecto){
        Persona persona = inputsPersona();
        proyecto.añadirPersona(persona);
        System.out.println("Has añadido a " + persona.getNombre() + " al proyecto");
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


        Tarea tarea = new Tarea(nomTarea, descripcion, responsable, prioridad, etiquetas, LocalDate.now());
        proyecto.añadirTarea(nomTarea, tarea);

        System.out.println("La tarea " + nomTarea + " ha sido añadida correctamente");
    }

    public static void añadirPersona(Proyecto proyecto){
        System.out.println("¿A que persona quieres añadir?");
        listarPersonas(proyecto);
        String persona = atributos.nextLine();
        System.out.println("¿A que tarea le quieres añadir?");
        listarNombreTareas(proyecto);
        String tarea = atributos.nextLine();
        System.out.println("Se ha agregado a " + proyecto.añadirPersonaATarea(tarea, persona) + "a la tarea " + tarea);
        proyecto.añadirTareaAPersona(persona, tarea);
    }

    public static void eliminarPersona(Proyecto proyecto){
        System.out.println("¿A que persona quieres eliminar?");
        List<Persona> personas = proyecto.getPersonas();
        for (int i = 0; i < personas.size(); i++) {
            System.out.println(personas.get(i).getNombre());
        }
        System.out.println("Introduce su nombre: ");
        String persona = atributos.nextLine();

        System.out.println("¿De que tarea le quieres eliminar?");
        listarNombreTareas(proyecto);
        String tarea = atributos.nextLine();

        proyecto.eliminarPersonaDeTarea(persona, tarea);
    }

    public static void listarPersonas(Proyecto proyecto){
        List<Persona> personas = proyecto.getPersonas();
        for(int i = 0; i < personas.size(); i++){
            System.out.println(i + ".- " + personas.get(i).getNombre());
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