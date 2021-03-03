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
        System.out.println("4. Introducir o eliminar una persona de una tarea");
        System.out.println("5. Listar las personas asignadas a un proyecto");
        System.out.println("6. Listar las tareas de un proyecto");

        do {
            System.out.print("\nElige una opcion (0..7): ");
            opcion = teclado.nextInt();
        } while ( (opcion<0) || (opcion>7) );
        teclado.nextLine(); // Elimina retorno de carro del buffer de entrada
        return opcion;
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

                    break;

                case 1: {
                    System.out.print("Introduce tu nombre: ");
                    String nombrePersona = teclado.nextLine();
                    System.out.print("Introduce tu correo electronico: ");
                    String emailPersona = teclado.nextLine();
                    proyecto.añadirPersona(new Persona(nombrePersona, emailPersona));
                    System.out.println("Has añadido a " + nombrePersona + " al proyecto");
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

                case 5: {
                   listarPersonas(proyecto);
                    break;
                }

                case 6: {
                    Map<String,Tarea> tareas = proyecto.getTareas();
                    for(String key : tareas.keySet()){
                        System.out.println("Titulo: " + key);
                        System.out.println("Responsable: " + tareas.get(key).getResponsable().getNombre());
                        System.out.println("Realizada: " + tareas.get(key).getRealizada());
                        System.out.println("");

                    }

                    break;
                }
            } // fin switch

        } while (opcion != 0);

        System.exit(0);
    } // fin de main


    public static void listarPersonas(Proyecto proyecto){
        List<Persona> personas = proyecto.getPersonas();
        for(int i = 0; i < personas.size(); i++){
            System.out.println(i + ".- " + personas.get(i).getNombre());
        }
    }

} // fin class