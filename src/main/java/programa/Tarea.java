package programa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tarea implements tieneLista{
    String titulo;
    String descripcion;
    private List<Persona> personas;
    Persona responsable;
    int prioridad;
    private final LocalDate fechaIni;
    private LocalDate fechaFin;
    Boolean realizada;
    Resultado resultado;
    List<String> etiquetas;
    String tipo;

    public Tarea(String titulo, String descripcion, Persona responsable, int prioridad, List<String> etiquetas, String tipo){
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.responsable = responsable;
        this.prioridad = prioridad;
        this.fechaIni = LocalDate.now();
        realizada = false;
        personas = new ArrayList<>();
        this.etiquetas = etiquetas;
        this.tipo = tipo;
    }

    public void finalizarTarea(Resultado resultado){
        realizada = true;
        fechaFin = LocalDate.now();
        this.resultado = resultado;
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
    public String getTitulo() {
        return titulo;
    }
    public List<Persona> getPersonas(){
        return personas;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public boolean getRealizada(){return realizada;}

    public LocalDate getFechaIni() {
        return fechaIni;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    @Override
    public String toString() {
        return "Tarea: " + titulo;
    }

    public List<Persona> getLista() {
        return personas;
    }
}
