import java.time.LocalDate;
import java.util.List;

public class Tarea {
    String titulo;
    String descripcion;
    private List<Persona> personas;
    Persona responsable;
    int prioridad;
    private LocalDate fechaIni;
    private LocalDate fechaFin;
    Boolean realizada;
    Resultado resultado;
    List<String> etiquetas;

    public Tarea(String titulo, String descripcion, Persona responsable, int prioridad, LocalDate fechaIni){
        this.titulo = titulo;
        this.descripcion = descripcion;

        this.responsable = responsable;
        this.prioridad = prioridad;
        this.fechaIni = fechaIni;
        realizada = false;
        this.etiquetas = etiquetas;
    }

    public void finalizarTarea(){
        realizada = true;
    }

    public List<Persona> getPersonas(){
        return personas;
    }

    public Resultado getResultado() {
        return resultado;
    }
}
