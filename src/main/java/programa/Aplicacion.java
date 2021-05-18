package programa;

import programa.modelo.clases.*;
import programa.modelo.excepciones.PersonaNullException;
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
        Modelo modelo = inicializar(teclado);

        int opcion;
        do {
            System.out.println(Menu.OpcionesMenu.getMenu());
            System.out.print("ELige una opcion (0..7): ");
            opcion = teclado.nextInt();
            Menu.OpcionesMenu opcionMenu = Menu.OpcionesMenu.getOpcion(opcion);
            switch (opcionMenu) {
                case SALIR:
                    System.out.println("Has terminado de editar el proyecto " + modelo.getNombre());
                    Modelo.almacenarInformacion(modelo);
                    System.exit(0);
                    break;

                case DAR_ALTA_PERSONA: {
                    darAltaPersona(modelo);
                    break;
                }
                case DAR_BAJA_PERSONA:{
                    darBajaPersona(modelo);
                    break;
                }

                case DAR_ALTA_TAREA: {
                    darAltaTarea(modelo);
                    break;
                }

                case MARCAR_FINALIZADA: {
                    marcarFinalizada(modelo);
                    break;
                }
                case AÑADIR_PERSONA: {
                    añadirPersona(modelo);
                    break;
                }
                case ELIMINAR_PERSONA: {
                    eliminarPersona(modelo);
                    break;
                }
                case LISTAR_PERSONAS: {
                    listarPersonas(modelo);
                    break;
                }
                case LISTAR_TAREAS: {
                    listarTareas(modelo);
                    break;
                }
                case LISTAR_PERSONAS_DE_TAREA: {
                    listarPersonasDeTarea(modelo);
                    break;
                }
                case LISTAR_PERSONAS_NO_RESPONSABLES: {
                    listarPersonasNoResponsables(modelo);
                    break;
                }
                case LISTAR_TAREAS_SIN_PERSONAS: {
                    listarTareasSinPersonas(modelo);

                }
            }
        }while (opcion != 0);
    }

    public static void darAltaPersona(Modelo modelo) {

    }

    public static void darBajaPersona(Modelo modelo) {
        try {
            List<Persona> personas = modelo.getPersonas();
            if (personas.size() == 0) {
                return;
            }

            System.out.println("¿Que persona quieres eliminar?");
            int listaPersonas = elegirPersona(modelo);
            Persona personaELiminada = personas.get(listaPersonas);

            modelo.eliminarPersona(listaPersonas);
            System.out.println("Has eliminado a " + personaELiminada.getNombre() + " del proyecto\n");
        }
        catch (PersonaNullException e){
            System.out.println("No hay personas en este proyecto");
        }
    }

    public static void darAltaTarea(Modelo modelo){
        try{
        System.out.print("Introduce el nombre de la tarea: ");
        String nomTarea = atributos.nextLine();

        System.out.print("Introduce la descripcion de la tarea: ");
        String descripcion = atributos.nextLine();

        System.out.println("¿Que persona quieres que sea responsable?");
        int persona = elegirPersona(modelo);

        Persona responsable = modelo.getPersonas().get(persona);

        System.out.print("Introduce la prioridad de la tarea (1-5): ");
        int prioridad = Integer.parseInt(atributos.nextLine());

        System.out.print("¿Quieres poner alguna etiqueta relacionada con el proyecto? ");
        String etiquetas = atributos.nextLine();

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
            modelo.añadirTarea(tarea);
            System.out.println("La tarea " + nomTarea + " ha sido añadida correctamente el " + tarea.getFechaIni() + " con coste " + tarea.calcularImporte() +"\n");
            modelo.añadirTareaAPersona(responsable.getNombre(), tarea.getTitulo());
        } catch (TareaRepetidaException e) {
            System.out.println("El nombre de la tarea ya existe");
        } catch (PersonaNullException e){
            System.out.println("No hay personas en este proyecto");
        }
    }

    public static void marcarFinalizada(Modelo modelo){
        List<String> tareasNoFinalizadas = modelo.getTareasNoFinalizadas();
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
        String tipo = modelo.getTipoTarea(tarea);

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
            modelo.finalizarTarea(tarea,resultado);

        }else if(tipo.equals("PaginaWeb")){
            System.out.print("¿Es estatica o dinamica?");
            String estaticaOdinamica = atributos.nextLine();

            System.out.print("¿En que lenguaje esta desarrolada?");
            String lenguaje = atributos.nextLine();

            System.out.print("¿Que backend utiliza");
            String backend = atributos.nextLine();

            Resultado resultado = new ResultadoPaginaWeb(identificador, horas,internoOcomercial,estaticaOdinamica,lenguaje,backend);
            modelo.finalizarTarea(tarea,resultado);

        }else{
            System.out.print("Introduce el lenguaje del codigo: ");
            String lenguaje = atributos.nextLine();

            System.out.print("Introduce el numero de lineas: ");
            int numero_lineas = Integer.parseInt(atributos.nextLine());

            System.out.print("Introduce el numero de modulos utilizados: ");
            int numero_modulos = Integer.parseInt(atributos.nextLine());

            Resultado resultado = new ResultadoPrograma(identificador,horas,internoOcomercial,lenguaje,numero_lineas,numero_modulos);
            modelo.finalizarTarea(tarea,resultado);
        }

        System.out.println("programa.Modelo.Clases.Tarea finalizada el " + LocalDate.now() + "\n");
    }

    public static void añadirPersona(Modelo modelo) {
        try {
            System.out.println("¿A que tarea le quieres añadir?");
            String tarea = elegirTarea(modelo);

            List<Persona> personas = modelo.getPersonas();

            System.out.println("¿A que persona quieres añadir a esta tarea?");
            String persona = personas.get(elegirPersona(modelo)).getNombre();

            if (modelo.añadirPersonaATarea(tarea, persona))
                System.out.println("Se ha agregado a " + persona + " a la tarea " + tarea + "\n");
        } catch (TareaException e){
            System.out.println("No hay tareas en este proyecto");
        } catch (PersonaNullException e){
            System.out.println("No hay personas en este proyecto");
        }
    }

    public static void eliminarPersona(Modelo modelo){
        try {
            Map<String, Tarea> tareas = modelo.getTareas();
            System.out.println("¿De que tarea le quieres eliminar?");
            String tarea = elegirTarea(modelo);

            List<Persona> personas = tareas.get(tarea).getPersonas();

            System.out.println("¿A que persona quieres eliminar? ");
            String persona = personas.get(elegirPersona(modelo)).getNombre();

            modelo.eliminarPersonaDeTarea(persona, tarea);
            System.out.println("Has eliminado a " + persona + " de " + tarea + "\n");
        } catch (TareaException e){
            System.out.println("No hay tareas en este proyecto");
        } catch (PersonaNullException e){
            System.out.println("No hay personas en este proyecto");
        }
    }

    public static void listarPersonas(Modelo modelo){
        List<Persona> personas = modelo.getPersonas();
        if(personas.size() == 0) {
            System.out.println("No hay personas en el proyecto.");
        }
        for(int i = 0; i < personas.size(); i++){
            System.out.println(i + ".- " + personas.get(i).getNombre());
        }
        System.out.println();
    }

    public static void listarTareas(Modelo modelo){
        Map<String, Tarea> tareas = modelo.getTareas();
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

    public static void listarPersonasDeTarea(Modelo modelo) {
        try {
            List<Persona> personas = modelo.getPersonas();
            if (personas.size() == 0) {
                System.out.println("No hay personas en el proyecto.\n");
                return;
            }

            String tareaSeleccionada = elegirTarea(modelo);

            List<Persona> personasTarea = modelo.getTarea(tareaSeleccionada).getPersonas();
            System.out.println("Las personas que trabajan en esta tarea son: ");
            for (int i = 0; i < personasTarea.size(); i++) {
                System.out.println(personasTarea.get(i));
            }
            System.out.println();
        } catch (TareaException e){
            System.out.println("No hay tareas en este proyecto");
        }
    }

    public static void listarPersonasNoResponsables(Modelo modelo){
        List<Persona> listaPersonas = UtilidadesParaLista.elementosConListaVacia(modelo.getPersonas());
        for (int i = 0; i < listaPersonas.size(); i ++){
            System.out.println(listaPersonas.get(i));
        }
    }

    public static void listarTareasSinPersonas(Modelo modelo){
        List<Tarea> listaTareas = UtilidadesParaLista.elementosConListaVacia(modelo.getTareasLista());
        for (int i = 0; i < listaTareas.size(); i ++) {
            System.out.println(listaTareas.get(i));
        }
    }

    public static void listarNombreTareas(Modelo modelo){
        List<String> tareas = modelo.getNombreTareas();
        for(int i = 0; i < tareas.size(); i++){
            System.out.println(i + ".- " + tareas.get(i));
        }
    }

    public static int elegirPersona(Modelo modelo) throws PersonaNullException{
        if (modelo.getPersonas().size() == 0)
            throw new PersonaNullException();
        listarPersonas(modelo);
        System.out.print("Introduce el numero de la persona: ");
        return Integer.parseInt(atributos.nextLine());
    }

    public static String elegirTarea(Modelo modelo) throws TareaException{
        if (modelo.getTareasLista().size() == 0){
            throw new TareaException();
        }
        listarNombreTareas(modelo);
        System.out.print("Elige el numero de la tarea: ");
        return modelo.getNombreTareas().get(Integer.parseInt(atributos.nextLine()));
    }

    public static Modelo inicializar(Scanner teclado){
        Modelo modelo = null;
        File in = new File("proyecto.bin");
        if(in.exists()){
            modelo = Modelo.cargarInformacion();
        }
        else{
            System.out.print("Introduce el nombre del proyecto: ");
            String nombreProyecto = teclado.nextLine();
            modelo = new Modelo(nombreProyecto);
            System.out.println("Has creado un nuevo proyecto llamado " + nombreProyecto + "\n");
        }
        return modelo;
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