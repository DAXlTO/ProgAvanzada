import java.time.LocalDate;
import java.util.ArrayList;
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
        personas = new ArrayList<>();
        this.etiquetas = new ArrayList<>();
    }

    public void finalizarTarea(){
        realizada = true;
    }

    public Persona getResponsable(){
        return responsable;
    }

    public void añadirPersona(Persona persona){
        personas.add(persona);
    }

    public void  eliminarPersona(String persona){
        for(int i = 0; i < personas.size();i++){
            if(personas.get(i).nombre.equals(persona)) {
                personas.remove(i);
                break;
            }
        }
    }

    public List<Persona> getPersonas(){
        return personas;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public boolean getRealizada(){return realizada;}
}
