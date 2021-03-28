package programa;

public class Menu {

    public enum OpcionesMenu{
        SALIR("Salir"),
        DAR_ALTA_PERSONA("Dar de alta a una persona que trabajan en el proyecto"),
        DAR_BAJA_PERSONA("Dar de baja a una persona que trabaja en el proyecto"),
        DAR_ALTA_TAREA("Dar de alta las tareas"),
        MARCAR_FINALIZADA("Marcar una tarea como finalizada"),
        AÑADIR_PERSONA("Añadir una persona a una tarea"),
        ELIMINAR_PERSONA("ELiminar una persona de una tarea"),
        LISTAR_PERSONAS("Listar las personas asignadas a un proyecto"),
        LISTAR_TAREAS("Listar las tareas de un proyecto"),
        LISTAR_PERSONAS_DE_TAREA("Listar las personas que hay en cada tarea");

        private final String descripcion;

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
}
