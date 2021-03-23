import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Aplicacion {

    public enum OpcionesMenu{
        SALIR("Salir"),
        DAR_ALTA_PERSONA("Dar de a las personas que trabajan en el proyecto"),
        DAR_ALTA_TAREA("Dar de alta las tareas"),
        MARCAR_FINALIZADA("Marcar una tarea como finalizada"),
        AÑADIR_PERSONA("Añadir una persona a una tarea"),
        ELIMINAR_PERSONA("ELiminar una persona de una tarea"),
        LISTAR_PERSONAS("Listar las personas asignadas a un proyecto"),
        LISTAR_TAREAS("Listar las tareas de un proyecto");

        private String descripcion;

        private OpcionesMenu(String descripcion) {
            this.descripcion = descripcion;
        }
        public String getDescripcion() {
            return descripcion;
        }

        public static OpcionesMenu getOpcion(int posicion){
            return values()[posicion];
        }
        public static String getMenu(){
            StringBuilder sb = new StringBuilder();
            for (OpcionesMenu opcion : OpcionesMenu.values()) {
                sb.append(opcion.ordinal());
                sb.append(".-");
                sb.append(opcion.getDescripcion());
                sb.append("\n");
            }
            return sb.toString();
        }
    }

    public static void listarTareas(Proyecto proyecto){
        List<String> tareas = proyecto.getNombreTareas();
        for(int i = 0; i < tareas.size(); i++){
            System.out.println(tareas.get(i));
        }
    }
    public static void listarPersonas(Proyecto proyecto){
        List<Persona> personas = proyecto.getPersonas();
        for(int i = 0; i < personas.size(); i++){
            System.out.println(i + ".- " + personas.get(i).getNombre());
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

    public static void main(String[] args)  {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce el nombre del proyecto: ");
        String nombreProyecto = teclado.nextLine();
        Proyecto proyecto = new Proyecto(nombreProyecto);
        System.out.println("Has creado un nuevo proyecto llamado " + nombreProyecto);

        System.out.println(OpcionesMenu.getMenu());
        System.out.println("ELige una opcion (0..7)");
        int opcion = teclado.nextInt();
        OpcionesMenu opcionMenu = OpcionesMenu.getOpcion(opcion);
        while (opcion != 0) {
            Scanner atributos = new Scanner(System.in);
            switch (opcionMenu) {
                case SALIR:
                    System.out.println("Has terminado de editar el proyecto " + nombreProyecto);
                    System.exit(0);
                    break;

                case DAR_ALTA_PERSONA: {
                    Persona persona = inputsPersona();
                    proyecto.añadirPersona(persona);
                    System.out.println("Has añadido a " + persona.getNombre() + " al proyecto");
                    break;
                }

                case DAR_ALTA_TAREA: {
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

                    Tarea tarea = new Tarea(nomTarea, descripcion, responsable, prioridad, LocalDate.now());
                    proyecto.añadirTarea(nomTarea, tarea);

                    System.out.println("La tarea " + nomTarea + " ha sido añadida correctamente");
                    break;
                }

                case MARCAR_FINALIZADA: {
                    System.out.println("¿Que tarea quieres marcar como finalizada? (Introduce el nombre): ");
                    List<String> tareas = proyecto.getTareasNoFinalizadas();
                    for (int i = 0; i < tareas.size(); i++) {
                        System.out.println(tareas.get(i));
                    }
                    proyecto.finalizarTarea(atributos.nextLine());
                    System.out.println("Tarea finalizada");
                    break;
                }
                case AÑADIR_PERSONA: {
                    Persona persona = inputsPersona();
                    System.out.println("¿A que tarea le quieres añadir?");
                    listarTareas(proyecto);
                    String tarea = atributos.nextLine();
                    System.out.println("Se ha agregado a " + proyecto.añadirPersonaATarea(tarea, persona) + "a la tarea " + tarea);
                    proyecto.añadirTareaAPersona(persona, tarea);
                    break;
                }
                case ELIMINAR_PERSONA: {
                    System.out.println("¿A que persona quieres eliminar?");
                    List<Persona> personas = proyecto.getPersonas();
                    for (int i = 0; i < personas.size(); i++) {
                        System.out.println(personas.get(i).getNombre());
                    }
                    System.out.println("Introduce su nombre: ");
                    String persona = atributos.nextLine();

                    System.out.println("¿De que tarea le quieres eliminar?");
                    listarTareas(proyecto);
                    String tarea = atributos.nextLine();

                    proyecto.eliminarPersonaDeTarea(persona, tarea);
                    break;
                }
                case LISTAR_PERSONAS: {
                    listarPersonas(proyecto);
                    break;
                }
                case LISTAR_TAREAS: {
                    Map<String, Tarea> tareas = proyecto.getTareas();
                    for (String key : tareas.keySet()) {
                        System.out.println("Titulo: " + key);
                        System.out.println("Responsable: " + tareas.get(key).getResponsable().getNombre());
                        System.out.println("Realizada: " + tareas.get(key).getRealizada());
                        System.out.println("");
                    }
                    break;
                }
            }
            System.out.println("ELige una opcion(0..7)");
            opcion = teclado.nextInt();
            opcionMenu = OpcionesMenu.getOpcion(opcion);
        }
    }
}