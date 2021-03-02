import java.util.List;

public class Tarea {
    String titulo;
    String descripcion;
    private List<Persona> personas;
    Persona responsable;
    int prioridad;
    private String fechaIni;
    private String fechaFin;
    Boolean realizada;
    Resultado resultado;
    List<String> etiquetas;

    public Tarea(String titulo, String descripcion, List<Persona> personas, Persona responsable, int prioridad, String fechaIni, List<String> etiquetas){
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.personas = personas;
        this.responsable = responsable;
        this.prioridad = prioridad;
        this.fechaIni = fechaIni;
        realizada = false;
        this.etiquetas = etiquetas;
    }


    public List<Persona> getPersonas(){
        return personas;
    }

    public Resultado getResultado() {
        return resultado;
    }
}
