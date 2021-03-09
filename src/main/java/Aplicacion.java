import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Aplicacion {

    /**
     * Muestra el menu de opciones y lee repetidamente de teclado hasta obtener una opcion valida
     * @param teclado
     * @return
     */
    public static int menu(Scanner teclado) {
        int opcion;
        System.out.println("\n\n");
        System.out.println("=====================================================");
        System.out.println("============            MENU        =================");
        System.out.println("=====================================================");
        System.out.println("0. Salir");
        System.out.println("1. Dar de a las personas que trabajan en el proyecto");
        System.out.println("2. Dar de alta las tareas");
        System.out.println("3. Marcar una tarea como finalizada");
        System.out.println("4. Introducir una persona en una tarea");
        System.out.println("5. Eliminar una persona de una tarea");
        System.out.println("6. Listar las personas asignadas a un proyecto");
        System.out.println("7. Listar las tareas de un proyecto");
        do {
            System.out.print("\nElige una opcion (0..7): ");
            opcion = teclado.nextInt();
        } while ( (opcion<0) || (opcion>7) );
        teclado.nextLine();
        return opcion;
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

    /**
     * Programa principal. Muestra el menú repetidamente y atiende las peticiones del cliente.
     *
     * @param args
     */
    public static void main(String[] args)  {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce el nombre del proyecto: ");
        String nombreProyecto = teclado.nextLine();
        Proyecto proyecto = new Proyecto(nombreProyecto);
        System.out.println("Has creado un nuevo proyecto llamado " + nombreProyecto);
        int opcion;
        do {
            opcion = menu(teclado);
            switch (opcion) {
                case 0:
                    System.out.println("Has terminado de editar el proyecto " + nombreProyecto);
                    System.exit(0);
                    break;

                case 1: {
                    Persona persona = inputsPersona();
                    proyecto.añadirPersona(persona);
                    System.out.println("Has añadido a " + persona.getNombre() + " al proyecto");
                    break;
                    }

                case 2: {
                    System.out.print("Introduce el nombre de la tarea: ");
                    String nomTarea = teclado.nextLine();

                    System.out.print("Introduce la descripcion de la tarea: ");
                    String descripcion = teclado.nextLine();

                    System.out.println("Persona responsable: ");
                    listarPersonas(proyecto);
                    int persona = Integer.parseInt(teclado.nextLine());
                    System.out.print("Elige el numero de la persona responsable");
                    Persona responsable = proyecto.getPersonas().get(persona);

                    System.out.print("Introduce la prioridad de la tarea (1-5): ");
                    int prioridad = Integer.parseInt(teclado.nextLine());

                    Tarea tarea = new Tarea(nomTarea,descripcion,responsable,prioridad, LocalDate.now());
                    proyecto.añadirTarea(nomTarea,tarea);

                    System.out.println("La tarea " + nomTarea + " ha sido añadida correctamente");
                    break;
                }

                case 3: {
                    System.out.println("¿Que tarea quieres marcar como finalizada? (Introduce el nombre): ");
                    List<String> tareas = proyecto.getTareasNoFinalizadas();
                    for(int i = 0; i < tareas.size(); i++){
                        System.out.println(tareas.get(i));
                    }
                    proyecto.finalizarTarea(teclado.nextLine());
                    System.out.println("Tarea finalizada");
                    break;
                }
                case 4: {
                    Persona persona = inputsPersona();
                    System.out.println("¿A que tarea le quieres añadir?");
                    listarTareas(proyecto);
                    String tarea = teclado.nextLine();
                    System.out.println("Se ha agregado a " + proyecto.añadirPersonaATarea(tarea,persona) + "a la tarea " + tarea);
                    proyecto.añadirTareaAPersona(persona,tarea);
                    break;
                }
                case 5: {
                    System.out.println("¿A que persona quieres eliminar?");
                    List<Persona> personas = proyecto.getPersonas();
                    for(int i = 0; i < personas.size();i++){
                        System.out.println(personas.get(i).getNombre());
                    }
                    System.out.println("Introduce su nombre: ");
                    String persona = teclado.nextLine();

                    System.out.println("¿De que tarea le quieres eliminar?");
                    listarTareas(proyecto);
                    String tarea = teclado.nextLine();

                    proyecto.eliminarPersonaDeTarea(persona,tarea);
                    break;
                }
                case 6: {
                   listarPersonas(proyecto);
                    break;
                }
                case 7: {
                    Map<String,Tarea> tareas = proyecto.getTareas();
                    for(String key : tareas.keySet()){
                        System.out.println("Titulo: " + key);
                        System.out.println("Responsable: " + tareas.get(key).getResponsable().getNombre());
                        System.out.println("Realizada: " + tareas.get(key).getRealizada());
                        System.out.println("");
                    }
                    break;
                }
            }
        }
        while (opcion != 0);
            System.exit(0);
    }
}