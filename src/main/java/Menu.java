public class Menu {

    public enum OpcionesMenu{
        SALIR("Salir"),
        DAR_ALTA_PERSONA("Dar de a las personas que trabajan en el proyecto"),
        DAR_ALTA_TAREA("Dar de alta las tareas"),
        MARCAR_FINALIZADA("Marcar una tarea como finalizada"),
        AÑADIR_PERSONA("Añadir una persona a una tarea"),
        ELIMINAR_PERSONA("ELiminar una persona de una tarea"),
        LISTAR_PERSONAS("Listar las personas asignadas a un proyecto"),
        LISTAR_TAREAS("Listar las tareas de un proyecto");

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
